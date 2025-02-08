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
    private int NumInstructions;
    private int ciclesForException;
    private int ciclesForSuccess;
       
    /***
     * Constructor 1
     * Crea un proceso consumidor de entrada/salida dado el nombre, numero de ciclos para que
     * ocurra una excepcion y numero de ciclos para que termine. El ID se genera automaticamente
     * @param name
     * @param ciclesForException
     * @param ciclesForSuccess 
     */
    public ProcessIObound(String name, int ciclesForException, int ciclesForSuccess) {
        super(name);
        this.ciclesForException = ciclesForException;
        this.ciclesForSuccess = ciclesForSuccess;
    }   
    
    
    /***
     * Constructor 2
     * Crea un proceso consumidor de entrada/salida dado el nombre, PC, MAR,
     * numero ciclos para que ocurra una excepcion, y numero de ciclos para terminar el proceso.
     * El ID se genera automaticamente
     * @param name
     * @param PC
     * @param MAR
     * @param NumInstructions
     * @param ciclesForException
     * @param ciclesForSuccess 
     */
    public ProcessIObound(String name, int PC, int MAR, int NumInstructions, int ciclesForException, int ciclesForSuccess) {
        super(name, PC, MAR,NumInstructions);
        this.ciclesForException = ciclesForException;
        this.ciclesForSuccess = ciclesForSuccess;
    }
    
    
    
    
    
    
}
