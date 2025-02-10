/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CPUScheduler;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

/**
 *
 * @author E04269
 */
public class Job {
    long burstTime;
    long arrivalTime;
    String processID;
    long startTime;
    long endTime;
    long waitTime;
    JProgressBar progressBar;
    JLabel burstTimeLabel;
    int lastRemainingBurst;
    JLabel waitTimeLabel;
    int pBarValue = 0;
    int priority;
    
    public Job(String processID, long arrivalTime, long burstTime, long startTime) {
        this.processID = processID;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.startTime = startTime;
        lastRemainingBurst = (int) burstTime;
}
    
    public long getArribalTime() {
        return arrivalTime;
    }
    
    public long getStartTime(){
        return burstTime;
    }
    
    public long getWaitTime() {
        return waitTime;
    }
    
    public long getBurstTime(){
        return burstTime;
    }
    public String getProcessID(){
        return processID;
    }
}