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
public class OperatingSystem extends MemoryEntity implements ClockListener{
    private Scheduler schealuder;    
    private int planningPolicy;
    private CPU[] CPUarray;
    private MemoryEntity[] mainMemory;
    
    private final static int FIFO = 0;
    private final static int FCFS = 1;
    private final static int roundRobin = 2;
    private final static int SPN = 3;
    private final static int SRT = 4;
    private final static int HRRN = 5;
    private final static int feeback = 6;
    
    

    public OperatingSystem(CPU[] CPUarray, MemoryEntity[] mainMemory) {    
        this.schealuder = new Scheduler(CPUarray, mainMemory);  
        this.planningPolicy = 0;
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

    
    public void createProcessCPUbound(String processName, int numInstructions, int memoryAdress){  
        ProcessCPUbound process = new ProcessCPUbound(processName, numInstructions, memoryAdress);
        this.schealuder.getReadyQueue().enqueue(process.getMemoryAdress());
        this.mainMemory[process.getMemoryAdress()] = process;                             
    }
    
    public void createProcessIObound(String processName, int numInstructions, int memoryAdress, 
            int cyclesForException, int cyclesForSuccess){
        ProcessIObound process = new ProcessIObound(processName, numInstructions, memoryAdress, 
                cyclesForException, cyclesForSuccess);
        this.schealuder.getReadyQueue().enqueue(process.getMemoryAdress());        
        this.mainMemory[process.getMemoryAdress()] = process;                           
    }
        
    
    public Integer assignNextProcess(){                    
        switch(this.planningPolicy){
            case 0:                  
                return this.schealuder.FIFO();
            default:
                return null;
        }                                    
    }   
    
    
    

    @Override
    public void onTick(int tick) {
        switch(this.planningPolicy){
            case 0 -> this.schealuder.InOutFIFO();            
        }
        System.out.println("");
        
        boolean finished = true;
        for(CPU cpu: CPUarray){
            if(cpu.isEnabled()){
                finished = false;
            }
        }
        
        if(finished){
            
        }
    }
    

    
}
