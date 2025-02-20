/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 * 
 * @author Juan
 */
public class ProcessCPUbound extends Process {
    
    /**
     * Constructor 1
     * Crea un proceso consumidor de CPU con solo el nombre, el numero de instrucciones.El PC y el MAR se inicializan en 0 y el ID se genera automaticamente
     * @param ID
     * @param name 
     * @param numInstructions 
     */
    public ProcessCPUbound(int ID, String name, int numInstructions) {
        super(ID, name, numInstructions);
    }
    
    /***
     * Constructor 2
     * Crea un proceso consumidor de CPU dado el numero de instruccion, el nombre, 
     * PC, MAR y la direccion de memoria.El ID se genera automaticamente     
     * @param ID
     * @param name
     * @param numInstructions
     * @param PC
     * @param MAR 
     * @param memoryAdress 
     */
    public ProcessCPUbound(int ID, String name, int numInstructions, int PC, int MAR, int memoryAdress) {
        super(ID, name, numInstructions, PC, MAR, memoryAdress);
    }
    
    /***
     * Constructor 3
     * Crea un proceso consumidor de CPU dado el nombre, el numero de instrucciones y la direccion de memoria.El ID se genera automaticamente
     * @param ID
     * @param name
     * @param numInstructions
     * @param memoryAdress 
     */
    public ProcessCPUbound(int ID, String name, int numInstructions, int memoryAdress) {
        super(ID, name, numInstructions, memoryAdress);
    }
    
    


    
    
    
}
