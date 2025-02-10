/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CPUScheduler;

import DataStructures.Queue;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author E04269
 */
public class ComputationThread implements Runnable {
    // Scheduler policy to manage job execution
    Queue<Job> policy;
    // Thread to handle the execution of this computation
    Thread t;
    // Job to be processed by this thread
    Job job;
    // Text field to display the currently executing job
    JTextField textField;
    // Text area to display the ready queue of processes
    JTextArea readyQueue;
    // Progress bar to visually represent the job's progress
    JProgressBar pbar;
    // Label to display the remaining burst time of the job
    JLabel burstTime;
    
    // Constructor to initialize the computation thread
    ComputationThread(Job job, Queue<Job> policy, JTextArea readyQueue, JTextField textField, 
            JProgressBar pbar, JLabel burstTime) {
        this.policy = policy;
        // Create a new thread for this computation
        t = new Thread(this);
        this.job = job;
        this.readyQueue = readyQueue;
        this.textField = textField;
        this.pbar = pbar;
        this.burstTime = burstTime;
    }
    
    // Method to assign a new job to this thread
    public void assignJob(Job job) {
        this.job = job;
    }
    
    // The main execution logic for the computation thread
    public void run() {
        // Allocate CPU to the job using the scheduling policy
        
        boolean status = true;
        
        // Check the selected scheduling algorithm
        if(CalcSimulation.algo.equals("FCFS") || CalcSimulation.algo.equals("Priority Scheduling")
                || CalcSimulation.algo.equals("Shortest Job First")) {
            // Set the minimum and maximum values for the progress bar
            int min = 0;
            int max = (int) job.getBurstTime();
            
            pbar.setMinimum(min);
            pbar.setMaximum(max);
            pbar.setValue(0);
            
            // Get the remaining processes in the ready queue and update the GUI
            String remProcesses = policy.toString();
            readyQueue.setText(remProcesses);

            // Track the remaining burst time of the job
            int remainingBurstTime = (int) job.getBurstTime(); 

            // Simulate the execution of the job
            for(int i = 0; i < max; i++) {
                pbar.setValue(i); // Update the progress bar
                try {
                    Thread.sleep(50); // Simulate time progression
                    synchronized(this) {
                        // Update the text field to show the currently executing job
                        textField.setText("");
                        textField.setText(job.getProcessID());
                    }
                } catch(InterruptedException ex) {}
                remainingBurstTime--; // Decrement the remaining burst time
                burstTime.setText(String.valueOf(remainingBurstTime) + "ms"); // Update the burst time label
            }
            
            // Track the completion status of the job
            if(status) {
                CPUScheduler.statusSum++;
                System.out.println(CPUScheduler.statusSum);
            }
        } 
        
        // Record the end time of the job
        job.endTime = System.nanoTime() - job.getStartTime(); //Cambiar nano al metodo que implementamos
        //remProcesses = policy.getRemainingProcesses();
       // readyQueue.setText(remProcesses);
    }
}
