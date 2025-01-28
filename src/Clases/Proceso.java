/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author luciano
 */
public class Proceso {
    private String nombre;
    private int numeroInstrucciones;
    private boolean cpuBound;
    private boolean ioBound;
    private int ciclosEsperaExcepcion;
    private int ciclosSatisfaccionExcepcion;

    public Proceso(String nombre, int numeroInstrucciones, boolean cpuBound, boolean ioBound, int ciclosEsperaExcepcion, int ciclosSatisfaccionExcepcion) {
        this.nombre = nombre;
        this.numeroInstrucciones = numeroInstrucciones;
        this.cpuBound = cpuBound;
        this.ioBound = ioBound;
        this.ciclosEsperaExcepcion = ciclosEsperaExcepcion;
        this.ciclosSatisfaccionExcepcion = ciclosSatisfaccionExcepcion;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroInstrucciones() {
        return numeroInstrucciones;
    }

    public void setNumeroInstrucciones(int numeroInstrucciones) {
        this.numeroInstrucciones = numeroInstrucciones;
    }

    public boolean isCpuBound() {
        return cpuBound;
    }

    public void setCpuBound(boolean cpuBound) {
        this.cpuBound = cpuBound;
    }

    public boolean isIoBound() {
        return ioBound;
    }

    public void setIoBound(boolean ioBound) {
        this.ioBound = ioBound;
    }

    public int getCiclosEsperaExcepcion() {
        return ciclosEsperaExcepcion;
    }

    public void setCiclosEsperaExcepcion(int ciclosEsperaExcepcion) {
        this.ciclosEsperaExcepcion = ciclosEsperaExcepcion;
    }

    public int getCiclosSatisfaccionExcepcion() {
        return ciclosSatisfaccionExcepcion;
    }

    public void setCiclosSatisfaccionExcepcion(int ciclosSatisfaccionExcepcion) {
        this.ciclosSatisfaccionExcepcion = ciclosSatisfaccionExcepcion;
    }
}
