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
    private MemoryEntity[] mainMemory;   
    private Clock clock;
    private OperatingSystem operatingSystem;    
    

   /***
    * Constructor: Crea el simulador una memoria principal, 3 CPU y habilita los que se especifique 
    * en el parametro numCPUenable, solo puede haber un minimo de 2 habilitados y un maximo de 3.
    * @param numCPUenable 
    * @param interval 
    */
    public Simulator(int numCPUenable, int interval, int ticksPerInstruction) {
        if(numCPUenable == 2 || numCPUenable == 3){
            this.CPUarray = new CPU[3];
            this.mainMemory = new MemoryEntity[1000];  
            this.clock = new Clock(interval);
            this.operatingSystem = new OperatingSystem(CPUarray);            
            
            for (int i = 0; i < 3; i++) {
                CPU newCPU = new CPU(i, this.mainMemory, this.clock, ticksPerInstruction);
                if(i < numCPUenable){
                    newCPU.setEnabled(true);
                }
                CPUarray[i] = newCPU;
                this.clock.getClockListeners().append(newCPU);
            }    
            this.clock.getClockListeners().append(this.operatingSystem);
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

    public MemoryEntity[] getMainMemory() {
        return mainMemory;
    }

    public void setMainMemory(MemoryEntity[] mainMemory) {
        this.mainMemory = mainMemory;
    }  

    public OperatingSystem getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(OperatingSystem operatingSystem) {
        this.operatingSystem = operatingSystem;
    }                
    
    
    //--------------------Procedimientos y Metodos----------------------
    
    
    /***
     * Carga inicialmente el sistema operativo
     */
    public void bootLoader(){
        this.mainMemory[0] = operatingSystem;
    }
    
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
        if(!this.operatingSystem.getSchealuder().getReadyQueue().isEmpty()){
            clock.start();
            bootLoader();        
        }
        else{
            System.err.println("No hay procesos para ejecutarse");
        }
    }
    
    
    public void createProcessCPUbound(String processName, int numInstructions, int memoryAdress){
        ProcessCPUbound process = this.operatingSystem.createProcessCPUbound(processName, numInstructions, memoryAdress);
        mainMemory[process.getMemoryAdress()] = process;        
    }
    
    
    
    public void createProcessIObound(String processName, int numInstructions, int memoryAdress,
            int ticksToInterrupt, int ticksToSuccess){
        ProcessIObound process = this.operatingSystem.createProcessIObound(processName, numInstructions, memoryAdress, 
                ticksToInterrupt, ticksToSuccess);
        mainMemory[process.getMemoryAdress()] = process;        
    }
    
    

    
    
  
    
    
    
}
