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
    private int cyclesForException;
    private int cyclesForSuccess;
       
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
        this.cyclesForException = cyclesForException;
        this.cyclesForSuccess = cyclesForSuccess;
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
     * @param cyclesForException
     * @param memoryAdress
     * @param cyclesForSuccess 
     */
    public ProcessIObound(String name, int numInstructions, int PC, int MAR, 
            int memoryAdress, int cyclesForException, int cyclesForSuccess) {
        super(name, numInstructions, PC, MAR, memoryAdress);
        this.cyclesForException = cyclesForException;
        this.cyclesForSuccess = cyclesForSuccess;
    }
    
    
    /***
     * Constructor 3
     * Crea un proceso consumidor de entrada/salida dado el nombre, el numero de instrucciones,
     * la direccion de memoria, numero ciclos para que ocurra una excepcion y numero de ciclos para terminar el proceso.
     * El ID se genera automaticamente
     * @param name
     * @param numInstructions
     * @param cyclesForException
     * @param memoryAdress
     * @param cyclesForSuccess 
     */
    public ProcessIObound(String name, int numInstructions,  int memoryAdress, int cyclesForException, int cyclesForSuccess) {
        super(name, numInstructions, memoryAdress);
        this.cyclesForException = cyclesForException;
        this.cyclesForSuccess = cyclesForSuccess;
    }

    public int getCyclesForException() {
        return cyclesForException;
    }

    public void setCyclesForException(int cyclesForException) {
        this.cyclesForException = cyclesForException;
    }

    public int getCyclesForSuccess() {
        return cyclesForSuccess;
    }

    public void setCyclesForSuccess(int cyclesForSuccess) {
        this.cyclesForSuccess = cyclesForSuccess;
    }
    
    
    
    
    
    
    
    
}
