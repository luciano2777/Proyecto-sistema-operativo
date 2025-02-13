/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan
 */
public class IOHandlerThread extends Thread{
    
    private ProcessIObound process;
    private MemoryEntity[] mainMemory;
    private int counter = 0;    

    public IOHandlerThread(ProcessIObound process, MemoryEntity[] mainMemory) {
        this.process = process;
        this.mainMemory = mainMemory;        
    }    
   
    @Override
    public void run() {    
        boolean running = true;
        while(running){
            try {
                if(this.counter == this.process.getTicksForSuccess()){
                    OperatingSystem OS = (OperatingSystem) mainMemory[0];            
                    process.setStatus(Process.READY);
                    process.setTicksCountException(0);
                    OS.getScheduler().getBlockedQueue().dequeue();
                    OS.getScheduler().getReadyQueue().enqueue(process.getMemoryAdress());
                    running = false;
                }
                this.counter++;
                Thread.sleep(Clock.interval);
            } catch (InterruptedException ex) {
                Logger.getLogger(IOHandlerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
    
    
}
