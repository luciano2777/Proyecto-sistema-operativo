/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import DataStructures.List;

/**
 *
 * @author Juan
 */
public class Simulator {
    //Atributos 
    private CPU[] CPUarray;
    private MemoryEntity[] mainMemory;   
    private OperatingSystem operatingSystem;    
    private Clock clock;
    private int numCPUenable;
    private int interval;
    private int ticksPerInstruction;
    

   /***
    * Constructor: Crea el simulador una memoria principal, 3 CPU y habilita los que se especifique 
    * en el parametro numCPUenable, solo puede haber un minimo de 2 habilitados y un maximo de 3.
    * @param numCPUenable 
    * @param interval 
     * @param ticksPerInstruction 
    */
    public Simulator(int numCPUenable, int interval, int ticksPerInstruction) {
        this.numCPUenable = numCPUenable;
        this.interval = interval;
        this.ticksPerInstruction = ticksPerInstruction;
        if(numCPUenable == 2 || numCPUenable == 3){
            this.CPUarray = new CPU[3];
            this.mainMemory = new MemoryEntity[1000];  
            this.clock = new Clock(interval);
            this.operatingSystem = new OperatingSystem(this.CPUarray, this.mainMemory);            
            
            for (int i = 0; i < 3; i++) {
                CPU newCPU = new CPU(i, this.mainMemory, this.clock, ticksPerInstruction);
                if(i < numCPUenable){
                    newCPU.setEnabled(true);
                }
                CPUarray[i] = newCPU;
                this.clock.getClockListeners().append(newCPU);
            }               
            this.clock.getClockListeners().append(this.operatingSystem.getScheduler());
        }
        else{
            System.err.println("Error: Solo pueden haber entre 2 o 3 procesadores");
        }
    }
    
    
    //----------------------Getters y Setters-----------------------
    public CPU[] getCPUarray() {
        return CPUarray;
    }

    public void setCPUarray(CPU[] CPUarray) {
        this.CPUarray = CPUarray;
    }

    public MemoryEntity[] getMainMemory() {
        return mainMemory;
    }

    public void setMainMemory(MemoryEntity[] mainMemory) {
        this.mainMemory = mainMemory;
    }  

    public OperatingSystem getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(OperatingSystem operatingSystem) {
        this.operatingSystem = operatingSystem;
    }                
    
    public void setPlanningPolicy(int planningPolicy){
        this.operatingSystem.setPlanningPolicy(planningPolicy);
    }

    public Clock getClock() {
        return clock;
    }

    public void setClock(Clock clock) {
        this.clock = clock;
    }

    public int getNumCPUenable() {
        return numCPUenable;
    }

    public void setNumCPUenable(int numCPUenable) {
        this.numCPUenable = numCPUenable;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public int getTicksPerInstruction() {
        return ticksPerInstruction;
    }

    public void setTicksPerInstruction(int ticksPerInstruction) {
        this.ticksPerInstruction = ticksPerInstruction;
    }
    
    
    
    public void setSettings(int cpuEnable, int interval, int ticksPerInstruction){
        if(cpuEnable == 2 || cpuEnable == 3){
            if(cpuEnable == 2){
                this.CPUarray[0].setEnabled(true);                
                this.CPUarray[1].setEnabled(true);                                
                this.CPUarray[2].setEnabled(false);                                
            }
            else if(cpuEnable == 3){
                this.CPUarray[2].setEnabled(true);
            }
            for (int i = 0; i < cpuEnable; i++) {                
                this.CPUarray[i].setTicksPerInstruction(ticksPerInstruction);
            }
            Clock.setInterval(interval);            
        }
        this.numCPUenable = cpuEnable;
        this.interval = interval;
        this.ticksPerInstruction = ticksPerInstruction;
    }
    
    //--------------------Procedimientos y Metodos----------------------
    
    
    /***
     * Carga inicialmente el sistema operativo
     */
    public void bootLoader(){
        this.mainMemory[0] = operatingSystem;
    }
    
    /***
     * Metodo para cambiar la velocidad de ejecucion
     * @param interval 
     */
    public void changeInterval(int interval){
        if(interval > 0){
            this.clock.setInterval(interval);            
        }
    }
    
        
    public void stopSimulation(){
        if(this.clock.getStatus() == Clock.RUNNING){
            System.out.println("Pause");
            this.clock.stopClock();                      
        }
    }
    
    public void resumeSimulation(){
        if(this.clock.getStatus() == Clock.PAUSED){
            this.clock.resumeClock();              
        }
    }
    
    public void finishSimulation(){
        this.clock.setStatus(Clock.FINISHED);
        System.out.println("Simulacion terminada");
    }
    
    
    
    
    /***
     * Metodo para iniciar la ejecucion del simulador
     */
    public void startSimulation(){
        boolean processInCPU = false;
        for (int i = 0; i < 3; i++) {
            CPU cpuAux = this.CPUarray[0];
            if(cpuAux.getCurrentProcess() != null){
                processInCPU = true;
            }
        }
        
        if(!this.operatingSystem.getScheduler().getReadyQueue().isEmpty() || processInCPU){
            if(this.clock.getStatus() == Clock.READY){
                System.out.println("start");
                this.clock.setStatus(Clock.RUNNING);
                clock.start();
                bootLoader();                                        
            }
            else if(this.clock.getStatus() == Clock.PAUSED){
                System.out.println("reanudar");
                resumeSimulation();
            }
        }
        else{
            System.err.println("No hay procesos para ejecutarse");
        }
    }
    
    
    public void createProcessCPUbound(String processName, int numInstructions, int memoryAdress){
        if(mainMemory[memoryAdress] != null || memoryAdress != 0){
            this.operatingSystem.createProcessCPUbound(processName, numInstructions, memoryAdress);                    
        }
        else{
            System.err.println("Area de memoria no disponible");
        }
    }
    
    
    
    public void createProcessIObound(String processName, int numInstructions, int memoryAdress,
            int ticksToInterrupt, int ticksToSuccess){        
        if(mainMemory[memoryAdress] != null || memoryAdress != 0){
            this.operatingSystem.createProcessIObound(processName, numInstructions, memoryAdress, 
                    ticksToInterrupt, ticksToSuccess);                   
        }
        else{
            System.err.println("Area de memoria no disponible");
        }
    }
    
    
    public void connectSimulatorView(ClockListener simulationView){
        this.clock.getClockListeners().append(simulationView);
    }
    
    

    
    
  
    
    
    
}
