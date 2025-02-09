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
    //Agregar numero de instrucciones
   
    
    /**
     * Constructor 1
     * Crea un proceso consumidor de CPU con solo el nombre
     * el PC y el MAR se inicializan en 0 y el ID se genera automaticamente
     * @param name 
     * @param numInstructions 
     */
    public ProcessCPUbound(String name, int numInstructions) {
        super(name, numInstructions);
    }
    
    /***
     * Constructor 2
     * Crea un proceso consumidor de CPU dado el nombre, PC y MAR,
     * el ID se genera automaticamente
     * @param name
     * @param numInstructions
     * @param PC
     * @param MAR 
     */
    public ProcessCPUbound(String name, int numInstructions, int PC, int MAR) {
        super(name, numInstructions, PC, MAR);
    }


    
    
    
}
