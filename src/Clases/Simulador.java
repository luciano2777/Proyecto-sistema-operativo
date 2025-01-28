/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author luciano
 */
public class Simulador {
    private Planificador planificador;

    public Simulador(int duracionCiclo, int numeroProcesadoresActivos) {
        this.planificador = new Planificador(duracionCiclo, numeroProcesadoresActivos);
    }

    public void iniciarSimulacion() {
        // Implementar lógica para iniciar la simulación
        System.out.println("Simulación iniciada.");
    }

    public void detenerSimulacion() {
        // Implementar lógica para detener la simulación
        System.out.println("Simulación detenida.");
    }

    public static void main(String[] args) {
        Simulador simulador = new Simulador(100, 4);
        simulador.iniciarSimulacion();

        // Ejemplo de creación y adición de procesos
        Proceso p1 = new Proceso("Proceso1", 1000, true, false, 0, 0);
        Proceso p2 = new Proceso("Proceso2", 500, false, true, 5, 10);

        simulador.planificador.agregarProceso(p1);
        simulador.planificador.agregarProceso(p2);

        simulador.planificador.visualizarEstado();
        simulador.detenerSimulacion();
    }
}