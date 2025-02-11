/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import DataStructures.List;
import java.util.concurrent.Semaphore;


/**
 *
 * @author Juan
 */
public class Clock extends Thread{
    //Atributos
    public static int tick;
    private int interval;      
    private int status;
    private List<ClockListener> clockListeners;
    private Semaphore semaphore;
    
    public static final int RUNNING = 0;
    public static final int PAUSED = 1;
    public static final int FINISHED = 2;

    /***
     * Contructor: Crea un reloj encargado de sincronizar los procesadores donde 
     * tick representa el tiempo de ejecucion, interval la duracion en ms del tick
     * y running el estado del reloj.
     * @param interval              
     */
    public Clock(int interval) {
        this.tick = 0;
        this.interval = interval;          
        this.status = RUNNING;
        this.clockListeners = new List();
        this.semaphore = new Semaphore(1);

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        if(status == 0 || status == 1 || status == 2){
            this.status = status;  
            if(this.status == RUNNING){
                semaphore.release();
            }
        }
    }

    public List<ClockListener> getClockListeners() {
        return clockListeners;
    }

    public void setClockListeners(List<ClockListener> clockListeners) {
        this.clockListeners = clockListeners;
    }

    
    
    
    //---------------------Procedimientos y Metodos--------------------
    
    /***
     * Metodo para avanzar un tick
     */
    public void tick(){
        try{
            Thread.sleep(this.interval);
            tick++; 
            notifyListeners();
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
    
    /***
     * Envia una señal a los objetos en la lista de clockListeners
     * por cada tick
     */
    public void notifyListeners(){
        for (int i = 0; i < this.clockListeners.getSize(); i++) {
            ClockListener listener = this.clockListeners.get(i);
            listener.onTick(this.tick);
        }
    }
    
    /***
     * Detiene el reloj y cambia su estado a PAUSED
     */
    public void stopClock(){        
        this.status = PAUSED;            
    }
    
    /***
     * Reanuda el reloj liberandolo del bloqueo y cambia su estado a RUNNING
     */
    public void resumeClock(){
        this.status = RUNNING;
        this.semaphore.release();
    }
    
    @Override
    public void run() {
    while (this.status != FINISHED) {
        if (this.status == RUNNING) {
            tick();                
        } else if (this.status == PAUSED) {
            try {
                // El hilo espera a que el semáforo se libere para continuar ejecutando
                this.semaphore.acquire();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }                                            
    }
}


    
    
}
