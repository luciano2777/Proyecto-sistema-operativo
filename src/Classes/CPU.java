/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import DataStructures.List;
import DataStructures.Queue;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Juan
 */
public class CPU extends Thread implements ClockListener{
    //Atributos
    private int ID;
    private int PC;
    private int MAR;
    private int cpuStatus;
    private boolean enabled;  
    private MemoryEntity[] mainMemory;
    private Clock clock;
    private Semaphore semaphore;   
    private Process currentProcess;
    private Integer currentPlanningPolicy;    
    private int ticksPerInstruction;
    private int ticksCounter = 0;
    private boolean isTimeTrackingRunning = false; //Para el metodo que no imprima varias veces.
    private Queue<Integer> ExecTimes =new Queue();
    

    
    //Constantes
    public final static int RUN_OS = 0;
    public final static int RUN_PROCESS = 1;
    public final static int BLOCK_PROCESS = 2;
    public final static int RUN_IDLE_PROCESS = 3;
    
    /***
     * Constructor 1: Crea un CPU con los valores de PC y MAR en 0
     * @param ID
     * @param mainMemory
     * @param clock
     * @param ticksPerInstruction
     */
    public CPU(int ID, MemoryEntity[] mainMemory, Clock clock, int ticksPerInstruction) {
        this.ID = ID;
        this.PC = 0;
        this.MAR = 0;
        this.enabled = false;
        this.mainMemory = mainMemory;
        this.clock = clock;
        this.semaphore = new Semaphore(1);
        this.currentProcess = null;
        this.currentPlanningPolicy = null;        
        this.ticksPerInstruction = ticksPerInstruction;
    }
    
    /***
     * Constructor 2: Crea un CPU dando valores iniciales al PC y al MAR
     * @param ID
     * @param mainMemory
     * @param PC
     * @param MAR
     * @param clock
     * @param ticksPerInstruction
     */
    public CPU(int ID, MemoryEntity[] mainMemory, int PC, int MAR, Clock clock, int ticksPerInstruction) {
        this.ID = ID;
        this.PC = PC;
        this.MAR = MAR;
        this.cpuStatus = 0;
        this.enabled = false;
        this.mainMemory = mainMemory;
        this.clock = clock;
        this.semaphore = new Semaphore(1);
        this.currentProcess = null;  
        this.currentPlanningPolicy = null;
        this.ticksPerInstruction = ticksPerInstruction;
    }
    
    //-------------------Getters y Setters------------------
    public int getPC() {
        return PC;
    }

    public void setPC(int PC) {
        this.PC = PC;
    }

    public int getMAR() {
        return MAR;
    }

    public void setMAR(int MAR) {
        this.MAR = MAR;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public MemoryEntity[] getMainMemory() {
        return mainMemory;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Clock getClock() {
        return clock;
    }

    public void setClock(Clock clock) {
        this.clock = clock;
    }  

    public Process getCurrentProcess() {
        return currentProcess;
    }

    public void setCurrentProcess(Process currentProcess) {
        this.currentProcess = currentProcess;
    }       

    public int getTicksPerInstruction() {
        return ticksPerInstruction;
    }

    public void setTicksPerInstruction(int ticksPerInstruction) {
        this.ticksPerInstruction = ticksPerInstruction;
    }

    public int getTicksCounter() {
        return ticksCounter;
    }

    public void setTicksCounter(int ticksCounter) {
        this.ticksCounter = ticksCounter;
    }

    public int getCpuStatus() {
        return cpuStatus;
    }

    public void setCpuStatus(int cpuStatus) {
        this.cpuStatus = cpuStatus;
    }
    
    public Queue<Integer> getExecTimes() {
        return ExecTimes;
    }
    
    public void SetExecTimes(Queue<Integer>  ExecTimes) {
        this.ExecTimes = ExecTimes;
    }

    
    
    
    
    
    //----------------procedimientos y Metodos---------------
    @Override
    public void onTick(int tick){
        if(this.enabled){                    
            this.ticksCounter++;       
            
            if(this.ticksCounter == this.ticksPerInstruction){                           

                switch(cpuStatus){

                    case RUN_OS -> {
                        //System.out.println(this + "   Corrinedo SO");            
                        runOperativeSystem();                    
                    }
                    case RUN_PROCESS -> {            
                        //System.out.println(this + "   " + this.currentProcess);
                        runProcess();                    
                    }
                    case RUN_IDLE_PROCESS -> {
                        runIdleProcess();
                    }
                }            
                this.ticksCounter = 0;            
            }        
        }
    }
    
    
    /***
     * Ejecuta el SO en el procesador
     */
    public void runOperativeSystem(){
        try {
            this.semaphore.acquire();                        
            
            //Carga SO
            OperatingSystem OS = (OperatingSystem) this.mainMemory[0];
            this.currentPlanningPolicy = OS.getPlanningPolicy();
            
            //Elige el siguiente proceso segun la planificacion
            this.currentProcess = OS.assignNextProcess(this.ID);            
            if(this.currentProcess == null){
                this.cpuStatus = RUN_IDLE_PROCESS;                
                return;
            }            
            
            //Carga el contexto del PCB y lo pone en estado de ready
            this.PC = this.currentProcess.getPC();
            this.MAR = this.currentProcess.getMAR();       
            this.currentProcess.setStatus(Process.RUNNING);
            this.cpuStatus = RUN_PROCESS;                                       
            
        } catch (InterruptedException ex) {
            Logger.getLogger(CPU.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            this.semaphore.release();            
        }
    }
    
    
    /***
     * Ejecuta un proceso cargado en memoria principal en el procesador
     */
    public void runProcess(){  
        trackProcessTime();
        //Si el proceso no ha terminado y no ha sido interrumpido -> seguir ejecutando
        boolean processEnded = this.MAR < this.currentProcess.getNumInstructions();
        boolean processRunningStatus = this.currentProcess.getStatus() == Process.RUNNING;        
        
        if(processEnded && processRunningStatus){             
            
            //Si la planificacion es RR verificar el quantum de tiempo
            if(this.currentPlanningPolicy == OperatingSystem.roundRobin){                
                if(this.currentProcess.getRemainingTime() == 0){
                    this.currentProcess.setRemainingTime(5);
                    OperatingSystem OS = (OperatingSystem) this.mainMemory[0];
                    OS.enqueueInReadyQueue(this.currentProcess.getMemoryAdress());
                    this.currentProcess = null;
                    this.cpuStatus = RUN_OS;
                    return;
                }
                this.currentProcess.decreaseRemainingTime();
            }
            
            //Si el procesos es I/O bound
            if(this.currentProcess.getClass().getSimpleName().equals("ProcessIObound")){
                ProcessIObound process = (ProcessIObound) this.currentProcess;
                
                if(process.getTicksCountException() == process.getTicksForException()){                    
                    this.cpuStatus = BLOCK_PROCESS; //Bloquear proceso
                    blockProcess();
                    return;
                }              
                process.increaseTicksCountException();                                    
            }
                        
            this.PC = this.currentProcess.getPC();
            this.MAR = this.currentProcess.getMAR();

            this.MAR = this.PC;
            this.PC++;     
            
            this.currentProcess.setPC(this.PC);
            this.currentProcess.setMAR(this.MAR);
        }
        
        //Si el proceso termino o fue interrumpido -> Llamar al SO
        else{
            if(this.MAR >= this.currentProcess.getNumInstructions()){
                try {
                    this.semaphore.acquire();
                                        
                    this.currentProcess.setStatus(Process.TERMINATED);
                    OperatingSystem OS = (OperatingSystem) this.mainMemory[0];
                    OS.getScheduler().getCompletedProcessList().append(this.currentProcess);
                    
                    List<Process> processList = OS.getScheduler().getProcessList();                    
                    for (int i = 0; i < processList.getSize(); i++) {
                        Process process = processList.get(i);
                        if(process.getID() == this.currentProcess.getID()){
                            processList.pop(i);
                        }
                    }
                    
                } catch (InterruptedException ex) {
                    Logger.getLogger(CPU.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    this.semaphore.release();                    
                }
            }
            this.currentProcess = null;
            this.cpuStatus = RUN_OS;
        }
    }
    
    
    /***
     * Bloquea un proceso por medio del SO
     */
    public void blockProcess(){        
        try {
            this.semaphore.acquire();
            
            this.currentProcess.setStatus(Process.BLOCKED);
            OperatingSystem OS = (OperatingSystem) this.mainMemory[0];            
            OS.getScheduler().getBlockedQueue().enqueue(this.currentProcess.getMemoryAdress()); //Bloquea el proceso
            
            IOHandlerThread thread = new IOHandlerThread((ProcessIObound) this.currentProcess, this.mainMemory);
            thread.start(); //Hilo para el manejo de la excepcion
            
            this.currentProcess = null;
            this.cpuStatus = RUN_OS;
            
            this.semaphore.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(CPU.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            this.semaphore.release();            
        }
    }
    
    public void runIdleProcess(){
        try {
            this.semaphore.acquire();
            
            //System.out.println(this + "   Corriendo proceso de espera");
            
            OperatingSystem OS = (OperatingSystem) this.mainMemory[0];            
            if(!OS.getScheduler().getReadyQueue().isEmpty()){
                this.currentProcess = null;
                this.cpuStatus = RUN_OS;
            }
            
        } catch (InterruptedException ex) {
            Logger.getLogger(CPU.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            this.semaphore.release();            
        }
    }

    
    @Override
    public String toString() {
        return "CPU{" + "ID=" + ID + ", PC=" + PC + ", MAR=" + MAR + '}';
    }
    
    
    public void trackProcessTime() {
    if (!isTimeTrackingRunning) {
        isTimeTrackingRunning = true;
        Thread timeTrackerThread = new Thread(() -> {
            int time = 0;
            boolean processRunning = true;

            while (processRunning) {
                time += 1;
                if (this.currentProcess == null || this.currentProcess.getStatus() == Process.TERMINATED) {
                    processRunning = false;
                    break;
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //System.out.println("TIEMPO EJECUCION: " + time + " s");
            ExecTimes.enqueue(time);
            isTimeTrackingRunning = false; // Resetea el flag cuando termina el thread
        });
        timeTrackerThread.start();
    }
}
    
    
    
    
    
}
