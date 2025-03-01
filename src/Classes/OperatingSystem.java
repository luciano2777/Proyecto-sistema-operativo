/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import DataStructures.List;
import DataStructures.Queue;
import GUI.ejemplo;

/**
 *
 * @author Juan
 */
public class OperatingSystem extends MemoryEntity {
    private Scheduler schealuder;    
    private int planningPolicy;
    private CPU[] CPUarray;
    private MemoryEntity[] mainMemory;
    
    public final static int FCFS = 0;    
    public final static int roundRobin = 1;
    public final static int SPN = 2;
    public final static int SRT = 3;
    public final static int HRRN = 4;
    public final static int feeback = 5;
    
    

    public OperatingSystem(CPU[] CPUarray, MemoryEntity[] mainMemory) {    
        this.schealuder = new Scheduler(CPUarray, mainMemory);  
        this.planningPolicy = FCFS;
        this.CPUarray = CPUarray;
        this.mainMemory = mainMemory;
    }

    public Scheduler getScheduler() {
        return schealuder;
    }

    public void setScheduler(Scheduler schealuder) {
        this.schealuder = schealuder;
    }

    public int getPlanningPolicy() {
        return planningPolicy;
    }

    public void setPlanningPolicy(int planningPolicy) {
        this.planningPolicy = planningPolicy;
    }

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

    
    public void createProcessCPUbound(int ID, String processName, int numInstructions, int memoryAdress){  
        ProcessCPUbound process = new ProcessCPUbound(ID, processName, numInstructions, memoryAdress);
        this.schealuder.getReadyQueue().enqueue(process.getMemoryAdress());        
        this.mainMemory[process.getMemoryAdress()] = process;                             
    }
    
    public void createProcessIObound(int ID, String processName, int numInstructions, int memoryAdress, 
            int cyclesForException, int cyclesForSuccess){
        ProcessIObound process = new ProcessIObound(ID, processName, numInstructions, memoryAdress, 
                cyclesForException, cyclesForSuccess);
        this.schealuder.getReadyQueue().enqueue(process.getMemoryAdress());          
        this.mainMemory[process.getMemoryAdress()] = process;                           
    }
        
    
    public Process assignNextProcess(int numCPU){  
        Integer memoryAdress = null;
        
        switch(this.planningPolicy){            
            case FCFS -> {                                  
                memoryAdress = this.schealuder.FIFO();
            }
            
            case roundRobin -> {
                memoryAdress = this.schealuder.RoundRobin();
            }
            
            case SPN -> {
                memoryAdress = this.schealuder.SPN();
            }
            
            case SRT -> {
                memoryAdress = this.schealuder.SRT(numCPU);
            }
            
            case HRRN -> {
                memoryAdress = this.schealuder.HRRN();
            }                       
        }
        
        if(memoryAdress == null || memoryAdress == 0){
            return null;
        }
        Process process = (Process) this.mainMemory[memoryAdress];
        return process;
    }  
    
    public void enqueueInReadyQueue(Integer memoryAdress){
        this.schealuder.getReadyQueue().enqueue(memoryAdress);
    }
    
    public void enqueueInBlockedQueue(Integer memoryAdress){
        this.schealuder.getBlockedQueue().enqueue(memoryAdress);
    }
    
    
    
    
    
   
    

    
}
