/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import DataStructures.List;
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
    private boolean enabled;  
    private MemoryEntity[] mainMemory;
    private Clock clock;
    private Semaphore semaphore;   
    private Process currentProcess;
    private OperatingSystem operatingSystem;
    private int ticksPerInstruction;
    private int ticksCounter = 0;
       
    
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
        this.operatingSystem = null;
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
        this.enabled = false;
        this.mainMemory = mainMemory;
        this.clock = clock;
        this.semaphore = new Semaphore(1);
        this.currentProcess = null;
        this.operatingSystem = null;
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

    public OperatingSystem getOperativeSystem() {
        return operatingSystem;
    }

    public void setOperativeSystem(OperatingSystem operativeSystem) {
        this.operatingSystem = operativeSystem;
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

    
    
    
    
    //----------------procedimientos y Metodos---------------
    @Override
    public void onTick(int tick){
        this.ticksCounter++;
        if(this.enabled && (this.ticksCounter == this.ticksPerInstruction)){            
            if(this.operatingSystem != null){
                System.out.println("CPU" + this.ID + " | Corrinedo SO");            
                runOperativeSystem();
            }
            else if(this.currentProcess != null){
                System.out.println(this + "   " + this.currentProcess);            
                runProcess();
            }
            if(this.currentProcess == null && this.operatingSystem == null){
                runOperativeSystem();
            }
            this.ticksCounter = 0;
        }
    }
    
    public void runOperativeSystem(){
        try {
            this.semaphore.acquire();
            
            OperatingSystem OS = (OperatingSystem) this.mainMemory[0];
            this.operatingSystem = OS;
            this.currentProcess = this.operatingSystem.assignNextProcess();
            if(this.currentProcess != null){
                this.PC = this.currentProcess.getPC();
                this.MAR = this.currentProcess.getMAR();
                this.operatingSystem = null;                
            }
            else{
                this.clock.stopClock();
            }
            
            this.semaphore.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(CPU.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void runProcess(){
        if((this.MAR < this.currentProcess.getNumInstructions()) && !isInterrupted()){            
            this.currentProcess.setStatus(Process.RUNNING);
            this.PC = this.currentProcess.getPC();
            this.MAR = this.currentProcess.getMAR();

            this.MAR = this.PC;
            this.PC++;     
            
            this.currentProcess.setPC(this.PC);
            this.currentProcess.setMAR(this.MAR);
        }
        else{
            this.operatingSystem = (OperatingSystem) this.mainMemory[0];
            this.currentProcess = null;
        }
    }

    @Override
    public String toString() {
        return "CPU{" + "ID=" + ID + ", PC=" + PC + ", MAR=" + MAR + '}';
    }
    
    
    
    
    
    
    
    
}
