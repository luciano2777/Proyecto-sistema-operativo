/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author Juan
 */
public class ProcessIObound extends Process{
    //Atributos
    private int ticksForException;
    private int ticksForSuccess;
    private int ticksCountException = 0;
    private int ticksCountSatisfy = 0;
    private boolean operationDone = false; 
       
    /***
     * Constructor 1
     * Crea un proceso consumidor de entrada/salida dado el nombre, numero de ciclos para que
     * ocurra una excepcion y numero de ciclos para que termine. El ID se genera automaticamente
     * @param name
     * @param numInstructions
     * @param cyclesForException
     * @param cyclesForSuccess

     */
    public ProcessIObound(String name, int numInstructions, int cyclesForException, int cyclesForSuccess) {
        super(name, numInstructions);
        this.ticksForException = cyclesForException;
        this.ticksForSuccess = cyclesForSuccess;
    }   
    
    
    /***
     * Constructor 2
     * Crea un proceso consumidor de entrada/salida dado el nombre, el numero de instrucciones,
     * PC, MAR, la direccion de memoria, el numero ciclos para que ocurra una excepcion
     * y numero de ciclos para terminar el proceso. El ID se genera automaticamente
     * @param name
     * @param numInstructions
     * @param PC
     * @param MAR
     * @param memoryAdress
     * @param cyclesForException
     * @param cyclesForSuccess

     */
    public ProcessIObound(String name, int numInstructions, int PC, int MAR, 
            int memoryAdress, int cyclesForException, int cyclesForSuccess) {
        super(name, numInstructions, PC, MAR, memoryAdress);
        this.ticksForException = cyclesForException;
        this.ticksForSuccess = cyclesForSuccess;
    }
    
    
    /***
     * Constructor 3
     * Crea un proceso consumidor de entrada/salida dado el nombre, el numero de instrucciones,
     * la direccion de memoria, numero ciclos para que ocurra una excepcion y numero de ciclos para terminar el proceso.
     * El ID se genera automaticamente
     * @param name
     * @param numInstructions
     * @param memoryAdress
     * @param cyclesForException
     * @param cyclesForSuccess
     */
    public ProcessIObound(String name, int numInstructions,  int memoryAdress, int cyclesForException, int cyclesForSuccess) {
        super(name, numInstructions, memoryAdress);
        this.ticksForException = cyclesForException;
        this.ticksForSuccess = cyclesForSuccess;
    }

    public int getTicksForException() {
        return ticksForException;
    }

    public void setTicksForException(int ticksForException) {
        this.ticksForException = ticksForException;
    }

    public int getTicksForSuccess() {
        return ticksForSuccess;
    }

    public void setTicksForSuccess(int ticksForSuccess) {
        this.ticksForSuccess = ticksForSuccess;
    }

    public int getTicksCountException() {
        return ticksCountException;
    }

    public void setTicksCountException(int ticksCountException) {
        this.ticksCountException = ticksCountException;
    }

    public int getTicksCountSatisfy() {
        return ticksCountSatisfy;
    }

    public void setTicksCountSatisfy(int ticksCountSatisfy) {
        this.ticksCountSatisfy = ticksCountSatisfy;
    }
    
    
    public void increaseTicksCountException(){
        this.ticksCountException++;
    }
    
    public void decreaseTicksCountException(){
        this.ticksCountException--;
    }
    
    public void increaseTicksCountSatisfy(){
        this.ticksCountSatisfy++; 
    }
    
    public void decreaseTicksCountSatisfy(){
        this.ticksCountSatisfy--;
    }

    public boolean isOperationDone() {
        return operationDone;
    }

    public void setOperationDone(boolean operationDone) {
        this.operationDone = operationDone;
    }
    
    

    @Override
    public String toString() {
        return "ProcessIObound{" + "Nombre=" + getName() + ", PC=" + getPC() + ", MAR=" + getMAR() + ", Status=" + getStatus() + ", ticksCountExc=" + ticksCountException + ", ticksForExc=" + ticksForException + ", numInstructions=" + getNumInstructions() + '}';
    }
    
    
    
    
    
    
    
    
    
}
