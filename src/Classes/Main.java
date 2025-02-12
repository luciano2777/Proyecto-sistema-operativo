/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Classes;

import DataStructures.Queue;
import GUI.MainView;
import GUI.ejemplo;


/**
 *
 * @author Juan
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //MainView mainView = new MainView();                        
        
        Simulator sim = new Simulator(2, 2000, 1);
        sim.setPlanningPolicy(OperatingSystem.SPN);
        
        sim.createProcessIObound("P0", 3, 1, 2, 2);
        sim.createProcessIObound("P1", 4, 2, 2, 2);
        sim.createProcessCPUbound("P2", 5, 3);
        sim.createProcessCPUbound("P3", 4, 4);
        sim.createProcessCPUbound("P4", 3, 5);
        sim.createProcessCPUbound("P5", 4, 6);
        sim.createProcessIObound("P6", 6, 7, 2, 2);
                   
        
        //System.out.println(sim.getOperatingSystem().getScheduler().getReadyQueue());
       
        
        sim.startSimulation();


//        ejemplo e = new ejemplo();
//        e.setVisible(true);
        
        
    }
    
}
