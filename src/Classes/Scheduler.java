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
public class Scheduler {
    private List<Process> processList;
    private List<Process> completedProcessList;
    private Queue<Integer> readyQueue;
    private Queue<Integer> blockedQueue;    
    private CPU[] CPUarray;
    private MemoryEntity[] mainMemory;

    public Scheduler(CPU[] CPUarray, MemoryEntity[] mainMemory) {
        this.processList = new List();
        this.completedProcessList = new List();
        this.readyQueue = new Queue();
        this.blockedQueue = new Queue();
        this.CPUarray = CPUarray;
        this.mainMemory = mainMemory;
    }

    public List<Process> getProcessList() {
        return processList;
    }

    public void setProcessList(List<Process> processList) {
        this.processList = processList;
    }

    public Queue<Integer> getReadyQueue() {
        return readyQueue;
    }

    public void setReadyQueue(Queue<Integer> readyQueue) {
        this.readyQueue = readyQueue;
    }

    public Queue<Integer> getBlockedQueue() {
        return blockedQueue;
    }

    public void setBlockedQueue(Queue<Integer> blockedQueue) {
        this.blockedQueue = blockedQueue;
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

    public List<Process> getCompletedProcessList() {
        return completedProcessList;
    }

    public void setCompletedProcessList(List<Process> completedProcessList) {
        this.completedProcessList = completedProcessList;
    }      
    
    
    
    
    public Integer FIFO(){
        Integer memoryAdress = readyQueue.dequeue();
        
        //No hay procesos en la cola de listos pero si hay en la cola de bloqueados
        if(memoryAdress == null && !this.blockedQueue.isEmpty()){ 
            return 0;
        }
        else{
            return memoryAdress;
        }
    }
    
    public void InOutFIFO(){
        if(this.blockedQueue.getFirst() != null){
            Integer processMemoryAdress = (Integer) this.blockedQueue.getFirst().getData();            
            ProcessIObound process = (ProcessIObound) this.mainMemory[processMemoryAdress];
            process.increaseTicksCountSatisfy();
            if(process.getTicksCountSatisfy() == process.getTicksForSuccess()){
                process.setOperationDone(true);
                this.blockedQueue.dequeue();
                this.readyQueue.enqueue(processMemoryAdress);
            }
        }
    }


    
    
}
