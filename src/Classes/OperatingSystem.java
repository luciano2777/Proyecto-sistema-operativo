/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import DataStructures.List;
import DataStructures.Queue;

/**
 *
 * @author Juan
 */
public class OperatingSystem extends MemoryEntity{
    private Schealuder schealuder;    
    private int planningPolicy;
    private CPU[] CPUarray;
    
    private final static int FIFO = 0;
    private final static int FCFS = 1;
    private final static int roundRobin = 2;
    private final static int SPN = 3;
    private final static int SRT = 4;
    private final static int HRRN = 5;
    private final static int feeback = 6;
    
    

    public OperatingSystem(CPU[] CPUarray) {    
        this.schealuder = new Schealuder(CPUarray);  
        this.planningPolicy = 0;
        this.CPUarray = CPUarray;
    }

    public Schealuder getSchealuder() {
        return schealuder;
    }

    public void setSchealuder(Schealuder schealuder) {
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
    
    
    

    
    public void enableCPU(int numCPU){
        
    }
    
    public ProcessCPUbound createProcessCPUbound(String processName, int numInstructions, int memoryAdress){
        if(memoryAdress == 0){
            System.err.println("Area de memoria no disponible");
            return null;
        }
        else{
            ProcessCPUbound process = new ProcessCPUbound(processName, numInstructions, memoryAdress);
            this.schealuder.getReadyQueue().enqueue(process);
            return process;            
        }
        
    }
    
    public ProcessIObound createProcessIObound(String processName, int numInstructions, int memoryAdress, 
            int cyclesForException, int cyclesForSuccess){
        if(memoryAdress == 0){
            System.err.println("Area de memoria no disponible");
            return null;
        }
        else{
            ProcessIObound process = new ProcessIObound(processName, numInstructions, memoryAdress, 
                    cyclesForException, cyclesForSuccess);
            this.schealuder.getReadyQueue().enqueue(process);
            return process;            
        }
    }
        
    
    public Process assignNextProcess(){                    
        switch(this.planningPolicy){
            case 0: 
                return this.schealuder.FIFO();
            default:
                return null;
        }                                    
    }
    

    
}
