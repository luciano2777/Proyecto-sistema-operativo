/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Juan
 */
public class Clock extends Thread{
    //Atributos
    private int tick;
    private int interval;      
    private boolean running;

    /***
     * Contructor: Crea un reloj encargado de sincronizar los procesadores donde 
     * tick representa el tiempo de ejecucion, interval la duracion en ms del tick
     * y running el estado del reloj.
     * @param interval 
     */
    public Clock(int interval) {
        this.tick = 0;
        this.interval = interval;          
        this.running = true;
    }        
    
    //------------------------Getters y Setters----------------------
    public int getTick() {
        return tick;
    }

    public void setTick(int tick) {
        this.tick = tick;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
    
    
    //---------------------Procedimientos y Metodos--------------------
    
    /***
     * Metodo para avanzar un tick
     */
    public void tick(){
        try{
            Thread.sleep(this.interval);
            tick++;            
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
    


    
    
}
