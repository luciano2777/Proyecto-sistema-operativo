/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import DataStructures.List;

/**
 *
 * @author Juan
 */
public class Simulator {
    //Atributos 
    private CPU[] CPUarray;
    private List<MemoryEntity> mainMemory;   
    private Clock clock;

   /***
    * Constructor: Crea el simulador una memoria principal, 3 CPU y habilita los que se especifique 
    * en el parametro numCPUenable, solo puede haber un minimo de 2 habilitados y un maximo de 3.
    * En memoria principal ya esta cargado el SO en el indice 0 por lo que se puede acceder a el con
    * mainMemory.get(0);
    * @param numCPUenable 
    * @param interval 
    */
    public Simulator(int numCPUenable, int interval) {
        if(numCPUenable == 2 || numCPUenable == 3){
            this.CPUarray = new CPU[3];
            this.mainMemory = new List(new OperativeSystem());  
            this.clock = new Clock(interval);
            
            for (int i = 0; i < 3; i++) {
                CPU newCPU = new CPU(i, this.mainMemory, this.clock);
                if(i < numCPUenable){
                    newCPU.setEnabled(true);
                }
                CPUarray[i] = newCPU;
                this.clock.getClockListeners().append(newCPU);
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
    
    
    //--------------------Procedimientos y Metodos----------------------
    
    /***
     * Metodo para cambiar la velocidad de ejecucion
     * @param interval 
     */
    public void changeInterval(int interval){
        if(interval > 0){
            this.clock.setInterval(interval);            
        }
    }
        
    public void stopSimulation(){
        if(this.clock.getStatus() == Clock.RUNNING){
            this.clock.stopClock();                      
        }
    }
    
    public void resumeSimulation(){
        if(this.clock.getStatus() == Clock.PAUSED){
            this.clock.resumeClock();              
        }
    }
    
    public void finishSimulation(){
        this.clock.setStatus(Clock.FINISHED);
        System.out.println("Simulacion terminada");
    }
    
    /***
     * Metodo para iniciar la ejecucion del simulador
     */
    public void startSimulation(){
        clock.start();
    }
    

    
    
  
    
    
    
}
