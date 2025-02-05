/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import DataStructures.Queue;

/**
 *
 * @author Juan
 */
public class OperativeSystem extends MemoryEntity{
    private Queue readyQueue;
    private Queue blockedQueue;

    public OperativeSystem() {        
        this.readyQueue = null;
        this.blockedQueue = null;        
    }

    public Queue getReadyQueue() {
        return readyQueue;
    }

    public void setReadyQueue(Queue readyQueue) {
        this.readyQueue = readyQueue;
    }

    public Queue getBlockedQueue() {
        return blockedQueue;
    }

    public void setBlockedQueue(Queue blockedQueue) {
        this.blockedQueue = blockedQueue;
    }
    
    public void createProcessCPUbound(String processName){
        ProcessCPUbound process = new ProcessCPUbound(processName);
        
        
    }
    
    public void enableCPU(int numCPU){
        
    }
    
    public void createProcessIObound(String processName){
        
    }
    
    
}
