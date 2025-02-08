/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import DataStructures.List;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * La clase CPU sera un hilo
 * @author Juan
 */
public class CPU extends Thread implements ClockListener{
    //Atributos
    private int ID;
    private int PC;
    private int MAR;
    private boolean enabled;  
    private List<MemoryEntity> mainMemory;
    private Clock clock;
    private Semaphore semaphore;
       
    
    /***
     * Constructor 1: Crea un CPU con los valores de PC y MAR en 0
     * @param ID
     * @param mainMemory
     * @param clock
     */
    public CPU(int ID, List<MemoryEntity> mainMemory, Clock clock) {
        this.ID = ID;
        this.PC = 0;
        this.MAR = 0;
        this.enabled = false;
        this.mainMemory = mainMemory;
        this.clock = clock;
        this.semaphore = new Semaphore(1);
    }
    
    /***
     * Constructor 2: Crea un CPU dando valores iniciales al PC y al MAR
     * @param ID
     * @param mainMemory
     * @param PC
     * @param MAR
     */
    public CPU(int ID, List<MemoryEntity> mainMemory, int PC, int MAR, Clock clock) {
        this.ID = ID;
        this.PC = PC;
        this.MAR = MAR;
        this.enabled = false;
        this.mainMemory = mainMemory;
        this.clock = clock;
        this.semaphore = new Semaphore(1);
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

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Clock getClock() {
        return clock;
    }

    public void setClock(Clock clock) {
        this.clock = clock;
    }  
    
    //----------------Metodos de ClockListeners---------------
    @Override
    public void onTick(int tick){
        if(this.enabled){
            System.out.println("Procesador " + this.ID + " en tick " + tick + "| RelojStatus: " + clock.getStatus());            
        }
    }
    
    
    
    
    
    
    
}
