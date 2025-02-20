/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 * 
 * @author Juan
 */
public class Process extends MemoryEntity{
    //Atributos    
    private int ID;
    private int status;
    private String name;
    private int PC;
    private int MAR;       
    private Integer memoryAdress;
    private int remainingTime; //para RR
    private int timeInQueue = 0; //para HRRN
    private int numInstructions;
    private int ExecutionTime = 0;
//    private Clock clock = new Clock(1);
    //Constantes
    public static final int RUNNING = 0;
    public static final int BLOCKED = 1;
    public static final int READY = 2;
    public static final int TERMINATED = 3;
    
    /***
     * Constructor 1
     * Crea un proceso solo con el nombre, el PC y el MAR inician en 0.El ID es generado automaticamente
     * @param ID
     * @param name 
     * @param numInstructions 
     */
    public Process(int ID, String name, int numInstructions) {
        this.ID = ID;
        this.status = READY;
        this.name = name;
        this.PC = 1;
        this.MAR = 0;        
        this.memoryAdress = null;
        this.remainingTime = 5;
        this.numInstructions = numInstructions;
                
    }
    
    /***
     * Constructor 2
     * Crea un proceso dando el nombre, el Program counter (PC),
     * el Memory Adress Register (MAR) y la direccion de memoria.El ID se genera automaticamente 
     * @param ID
     * @param name
     * @param numInstructions
     * @param PC
     * @param MAR 
     * @param memoryAdress 
     */
    public Process(int ID, String name, int numInstructions, int PC, int MAR, int memoryAdress) {
        this.ID = ID;
        this.status = READY;
        this.name = name;
        this.PC = PC;
        this.MAR = MAR;        
        this.memoryAdress = memoryAdress;
        this.remainingTime = 5;
        this.numInstructions = numInstructions;        
    }
    
    
    /***
     * Constructor 3
     * Crea un proceso dando el nombre, el numero de instrucciones y la direccion
     * de memoria.El ID se genera automaticamente 
     * @param ID
     * @param name
     * @param numInstructions
     * @param memoryAdress
     */
    public Process(int ID, String name, int numInstructions, int memoryAdress) {
        this.ID = ID;
        this.status = READY;
        this.name = name;
        this.PC = 1;
        this.MAR = 0;        
        this.memoryAdress = memoryAdress;
        this.remainingTime = 5;
        this.numInstructions = numInstructions;        
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

    public int getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }
    
    public void decreaseRemainingTime(){
        this.remainingTime -= 1;
    }

    public int getTimeInQueue() {
        return timeInQueue;
    }

    public void setTimeInQueue(int timeInQueue) {
        this.timeInQueue = timeInQueue;
    }
    
    public void increaseTimeInQueue(){ 
        this.timeInQueue++;
    }
    
    public int GetExecutionTime(){ //ExecutionTime
        return this.ExecutionTime;
    }
    
    public void SetExecutionTime(int ExecutionTime){ //ExecutionTime
         this.ExecutionTime = ExecutionTime;
    }

    //-------------------Procedimientos y Metodos-----------------------

    @Override
    public String toString() {
        return "CPU -> ID=" + getID() + ", Nombre=" + getName() + ", Estado=" + getStatus() + ", PC=" + getPC() + ", MAR=" + getMAR();
    }


    
    
    
    
    
    
    
    
}
