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
    private Integer memoryAdress;
    private int numInstructions;
    
    //Constantes
    public static final int RUNNING = 0;
    public static final int BLOCKED = 1;
    public static final int READY = 2;
    public static final int TERMINATED = 3;
    
    /***
     * Constructor 1
     * Crea un proceso solo con el nombre, el PC y el MAR inician en 0.
     * El ID es generado automaticamente
     * @param name 
     * @param numInstructions 
     */
    public Process(String name, int numInstructions) {
        this.ID = processCount;
        this.status = READY;
        this.name = name;
        this.PC = 1;
        this.MAR = 0;
        this.memoryAdress = null;
        this.numInstructions = numInstructions;
        processCount++;
    }
    
    /***
     * Constructor 2
     * Crea un proceso dando el nombre, el Program counter (PC),
     * el Memory Adress Register (MAR) y la direccion de memoria. El ID se genera automaticamente 
     * @param name
     * @param numInstructions
     * @param PC
     * @param MAR 
     * @param memoryAdress 
     */
    public Process(String name, int numInstructions, int PC, int MAR, int memoryAdress) {
        this.ID = processCount;
        this.status = READY;
        this.name = name;
        this.PC = PC;
        this.MAR = MAR;
        this.memoryAdress = memoryAdress;
        this.numInstructions = numInstructions;
        processCount++;
    }
    
    
    /***
     * Constructor 3
     * Crea un proceso dando el nombre, el numero de instrucciones y la direccion
     * de memoria. El ID se genera automaticamente 
     * @param name
     * @param numInstructions
     * @param memoryAdress
     */
    public Process(String name, int numInstructions, int memoryAdress) {
        this.ID = processCount;
        this.status = READY;
        this.name = name;
        this.PC = 1;
        this.MAR = 0;
        this.memoryAdress = memoryAdress;
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
    
    public int getNumInstructions() {
        return numInstructions;
    }

    public void setNumInstructions(int numInstructions) {
        this.numInstructions = numInstructions;
    }
    
    public Integer getMemoryAdress() {
        return memoryAdress;
    }

    public void setMemoryAdress(Integer memoryAdress) {
        this.memoryAdress = memoryAdress;
    }
    
    
    
    //-------------------Procedimientos y Metodos-----------------------

    @Override
    public String toString() {
        return "Process{" + "ID=" + ID + ", status=" + status + ", name=" + name + ", PC=" + PC + ", MAR=" + MAR + ", memoryAdress=" + memoryAdress + ", numInstructions=" + numInstructions + '}';
    }


    
    
    
    
    
    
    
    
}
