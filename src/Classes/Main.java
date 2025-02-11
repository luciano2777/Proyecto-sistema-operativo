/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Classes;

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
        
        Simulator sim = new Simulator(2, 3000, 1);
        
        sim.getOperatingSystem().createProcessIObound("P1", 6, 1, 2, 2);
        sim.getOperatingSystem().createProcessCPUbound("P2", 6, 2);
        sim.getOperatingSystem().createProcessCPUbound("P3", 6, 3);
        sim.getOperatingSystem().createProcessCPUbound("P4", 6, 4);
        sim.getOperatingSystem().createProcessCPUbound("P5", 6, 5);
        
        sim.startSimulation();
        
        
    }
    
}
