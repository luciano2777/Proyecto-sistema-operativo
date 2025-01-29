/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import DataEstructures.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * La clase CPU sera un hilo
 * @author Juan
 */
public class CPU extends Thread{
    //Atributos
    private int PC;
    private int MAR;
    private boolean enabled;  
    private List<MemoryEntity> mainMemory;
       
    
    /***
     * Constructor 1: Crea un CPU con los valores de PC y MAR en 0
     * @param mainMemory
     */
    public CPU(List<MemoryEntity> mainMemory) {
        this.PC = 0;
        this.MAR = 0;
        this.enabled = false;
        this.mainMemory = mainMemory;
    }
    
    /***
     * Constructor 2: Crea un CPU dando valores iniciales al PC y al MAR
     * @param mainMemory
     * @param PC
     * @param MAR
     */
    public CPU(List<MemoryEntity> mainMemory, int PC, int MAR) {
        this.PC = PC;
        this.MAR = MAR;
        this.enabled = false;
        this.mainMemory = mainMemory;
    }
    
    //-------------------Getters y Setters------------------
    public int getPC() {
        return PC;
    }

    public void setPC(int PC) {
        this.PC = PC;
    }

    public int getMAR() {
        return MAR;
    }

    public void setMAR(int MAR) {
        this.MAR = MAR;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<MemoryEntity> getMainMemory() {
        return mainMemory;
    }

    
    
    
    
    //----------------Procedimientos y Metodos----------------
    
    @Override
    public void run(){
        boolean run = true;
        while(run){
            try {
                System.out.println("Hilo en ejecucion " + getId());   
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(CPU.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
