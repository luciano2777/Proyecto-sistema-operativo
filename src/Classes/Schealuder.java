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
public class Schealuder {
    private List<Process> processList;
    private Queue<Process> readyQueue;
    private Queue<Process> blockedQueue;
    private CPU[] CPUarray;

    public Schealuder(CPU[] CPUarray) {
       this.processList = new List();
        this.readyQueue = new Queue();
        this.blockedQueue = new Queue();
        this.CPUarray = CPUarray;
    }

    public List<Process> getProcessList() {
        return processList;
    }

    public void setProcessList(List<Process> processList) {
        this.processList = processList;
    }

    public Queue<Process> getReadyQueue() {
        return readyQueue;
    }

    public void setReadyQueue(Queue<Process> readyQueue) {
        this.readyQueue = readyQueue;
    }

    public Queue<Process> getBlockedQueue() {
        return blockedQueue;
    }

    public void setBlockedQueue(Queue<Process> blockedQueue) {
        this.blockedQueue = blockedQueue;
    }

    public CPU[] getCPUarray() {
        return CPUarray;
    }

    public void setCPUarray(CPU[] CPUarray) {
        this.CPUarray = CPUarray;
    }
    
    
    
    
    public Process FIFO(){
        return readyQueue.dequeue();
    }
    
    
}
