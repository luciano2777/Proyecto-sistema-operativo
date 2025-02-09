/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.UUID;

/**
 * 
 * @author Juan
 */
public class Process extends MemoryEntity{
    //Atributos
    private static int processCount = 0;
    private int ID;
    private int status;
    private String name;
    private int PC;
    private int MAR;
    private int numInstructions;
    
    //Constantes
    private static final int RUNNING = 0;
    private static final int BLOCKED = 1;
    private static final int READY = 2;
    
    /***
     * Constructor 1
     * Crea un proceso solo con el nombre, el PC y el MAR inician en 0
     * y el ID es generado automaticamente
     * @param name 
     * @param numInstructions 
     */
    public Process(String name, int numInstructions) {
        this.ID = processCount;
        this.status = READY;
        this.name = name;
        this.PC = 0;
        this.MAR = 0;
        this.numInstructions = numInstructions;
        processCount++;
    }
    
    /***
     * Constructor 2
     * Crea un proceso dando el nombre, el Program counter (PC) y 
     * el Memory Adress Register (MAR), el ID se genera automaticamente 
     * @param name
     * @param PC
     * @param MAR 
     */
    public Process(String name, int numInstructions, int PC, int MAR) {
        this.ID = processCount;
        this.status = READY;
        this.name = name;
        this.PC = PC;
        this.MAR = MAR;
        this.numInstructions = numInstructions;
        processCount++;
    }

    //--------------------Getters y Setters--------------------
    public int getID() {
        return ID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
    
    //-------------------Procedimientos y Metodos-----------------------
    
    
    
    
    
    
    
    
}
