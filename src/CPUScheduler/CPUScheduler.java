/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CPUScheduler;

import DataStructures.Queue;
import GUI.CreateProcessView;
import java.util.concurrent.TimeUnit;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author E04269
 */
public class CPUScheduler {
    
    Job[] jobBatch;
    
    JTextArea textArea;
    JTextField textField;
    JProgressBar[] pbars;
    JLabel[] burstTimes;
    ComputationThread[] myThreads = new ComputationThread[CreateProcessView.NumInstructions];
    JLabel[] waitingTimes, priorities;
    static int statusSum = 0;
    
    // Constructor to initialize the CPU scheduler
    public CPUScheduler(Job[] jobBatch, JTextArea textArea, JTextField textField, JProgressBar[] pbars,
            JLabel[] burstTimes, JLabel[] waitingTimes, JLabel[] priorities) {
        this.jobBatch = jobBatch;
        this.textArea = textArea;
        this.textField = textField;
        this.pbars = pbars;
        this.burstTimes = burstTimes;
        this.waitingTimes = waitingTimes;
        this.priorities = priorities;
    }
    
    
    public void run() {    
        if(CalcSimulation.algo.equals("FCFS")) {
            Job arrivedJob;
            Queue<Job> policy = new Queue();
            for(int i = 0; i < jobBatch.length; i++) {
                arrivedJob = jobBatch[i];
                
                policy.enqueue(arrivedJob);
            }
            
            int i = 0;
            while(!policy.isEmpty()) {
                JProgressBar pbar = pbars[i];
                JLabel burstTime = burstTimes[i];
                Job job = (Job) policy.getFirst().getData();
                long arrivalTime = job.getArribalTime();

                try {
                    Thread.sleep(arrivalTime);
                } catch(Exception e) {}

                Job newJob = policy.dequeue();
                int durationInS = (int) TimeUnit.NANOSECONDS.toSeconds(newJob.getWaitTime()); //Implementar el metodo que ya esta
                waitingTimes[i].setText(String.valueOf(durationInS) + "s");
                myThreads[i] = new ComputationThread(newJob, policy, textArea, textField, pbar, burstTime);
                myThreads[i].t.start(); // Start the computation thread
                i++;
           }
        }
    }
    
}
