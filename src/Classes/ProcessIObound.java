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
    private int ciclesForException;
    private int ciclesForSuccess;
       
    /***
     * Constructor 1
     * Crea un proceso consumidor de entrada/salida dado el nombre, numero de ciclos para que
     * ocurra una excepcion y numero de ciclos para que termine. El ID se genera automaticamente
     * @param name
     * @param numInstructions
     * @param ciclesForException
     * @param ciclesForSuccess 
     */
    public ProcessIObound(String name, int numInstructions, int ciclesForException, int ciclesForSuccess) {
        super(name, numInstructions);
        this.ciclesForException = ciclesForException;
        this.ciclesForSuccess = ciclesForSuccess;
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
     * @param ciclesForException
     * @param memoryAdress
     * @param ciclesForSuccess 
     */
    public ProcessIObound(String name, int numInstructions, int PC, int MAR, 
            int memoryAdress, int ciclesForException, int ciclesForSuccess) {
        super(name, numInstructions, PC, MAR, memoryAdress);
        this.ciclesForException = ciclesForException;
        this.ciclesForSuccess = ciclesForSuccess;
    }
    
    
    /***
     * Constructor 3
     * Crea un proceso consumidor de entrada/salida dado el nombre, el numero de instrucciones,
     * la direccion de memoria, numero ciclos para que ocurra una excepcion y numero de ciclos para terminar el proceso.
     * El ID se genera automaticamente
     * @param name
     * @param numInstructions
     * @param ciclesForException
     * @param memoryAdress
     * @param ciclesForSuccess 
     */
    public ProcessIObound(String name, int numInstructions,  int memoryAdress, int ciclesForException, int ciclesForSuccess) {
        super(name, numInstructions, memoryAdress);
        this.ciclesForException = ciclesForException;
        this.ciclesForSuccess = ciclesForSuccess;
    }
    
    
    
    
    
    
}
