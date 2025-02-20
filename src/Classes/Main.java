/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Classes;

import DataStructures.Queue;
import GUI.MainView;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;

/**
 *
 * @author Juan
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws javax.swing.UnsupportedLookAndFeelException
     */
    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        
        UIManager.setLookAndFeel(new MetalLookAndFeel());               
        MainView mainView = new MainView();                        
        
        Simulator sim = new Simulator(3, 2000, 1);
        sim.setPlanningPolicy(OperatingSystem.SRT);
        

//        sim.createProcessCPUbound("P1", 5, 1);
//        sim.createProcessCPUbound("P2", 4, 2);
//        sim.createProcessCPUbound("P3", 3, 3); //corto
//        sim.createProcessCPUbound("P4", 4, 4);
//        sim.createProcessCPUbound("P5", 2, 5); //corto
//        sim.createProcessCPUbound("P6", 5, 6);
//        
//        Queue queue = sim.getOperatingSystem().getScheduler().getReadyQueue();
//        System.out.println(queue.dequeueSPN(sim.getMainMemory()));
//        System.out.println(queue.dequeueSPN(sim.getMainMemory()));
//        System.out.println(queue.dequeueSPN(sim.getMainMemory()));
//        System.out.println(queue.dequeueSPN(sim.getMainMemory()));
//        System.out.println(queue.dequeueSPN(sim.getMainMemory()));
//        System.out.println(queue.dequeueSPN(sim.getMainMemory()));        
        
//        System.out.println(sim.getOperatingSystem().getScheduler().getReadyQueue());
//        System.out.println(sim.getOperatingSystem().getScheduler().getReadyQueue());
       
        
        
        
    }
    
}
