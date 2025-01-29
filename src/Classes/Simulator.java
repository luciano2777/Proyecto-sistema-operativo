/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import DataEstructures.List;

/**
 *
 * @author Juan
 */
public class Simulator {
    //Atributos 
    private CPU[] CPUarray;
    private List<MemoryEntity> mainMemory;   

   /***
    * Constructor: Crea el simulador una memoria principal, 3 CPU y habilita los que se especifique 
    * en el parametro numCPUenable, solo puede haber un minimo de 2 habilitados y un maximo de 3.
    * En memoria principal ya esta cargado el SO en el indice 0 por lo que se puede acceder a el con
    * mainMemory.get(0);
    * @param numCPUenable 
    */
    public Simulator(int numCPUenable) {
        if(numCPUenable == 2 || numCPUenable == 3){
            this.CPUarray = new CPU[3];
            this.mainMemory = new List(new OperativeSystem());  
            
            for (int i = 0; i < 3; i++) {
                CPU newCPU = new CPU(this.mainMemory);
                if(i < numCPUenable){
                    newCPU.setEnabled(true);
                }
                CPUarray[i] = newCPU;
            }
        }
        else{
            System.err.println("Error: Solo pueden haber entre 2 o 3 procesadores");
        }
    }
    
    
    //----------------------Getters y Setters-----------------------
    public CPU[] getCPUarray() {
        return CPUarray;
    }

    public void setCPUarray(CPU[] CPUarray) {
        this.CPUarray = CPUarray;
    }

    public List getMainMemory() {
        return mainMemory;
    }

    public void setMainMemory(List mainMemory) {
        this.mainMemory = mainMemory;
    }
    
    /***
     * Metodo para iniciar la ejecucion del simulador
     */
    public void startSimulation(){
        for(CPU cpu: CPUarray){
            if(cpu.isEnabled()){
                cpu.start();                
            }
        }
    }
    

    
    
  
    
    
    
}
