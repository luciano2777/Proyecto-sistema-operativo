/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luciano
 */
public class Planificador {
        private List<Proceso> procesos;
    private int duracionCiclo;
    private int numeroProcesadoresActivos;

    public Planificador(int duracionCiclo, int numeroProcesadoresActivos) {
        this.procesos = new ArrayList<>();
        this.duracionCiclo = duracionCiclo;
        this.numeroProcesadoresActivos = numeroProcesadoresActivos;
    }

    // Métodos para agregar y eliminar procesos
    public void agregarProceso(Proceso proceso) {
        procesos.add(proceso);
    }

    public void eliminarProceso(Proceso proceso) {
        procesos.remove(proceso);
    }

    // Métodos para gestionar la planificación
    public void planificar() {
        // Implementar políticas de planificación
    }

    // Métodos para manejar excepciones
    public void manejarExcepcion(Proceso proceso) {
        // Implementar manejo de excepciones
    }

    // Métodos para visualizar el estado de los procesos
    public void visualizarEstado() {
        for (Proceso proceso : procesos) {
            System.out.println("Proceso: " + proceso.getNombre() + " - Instrucciones restantes: " + proceso.getNumeroInstrucciones());
        }
    }

    // Métodos para generar gráficas de rendimiento
    public void generarGraficas() {
        // Implementar generación de gráficas
    }
}
    

