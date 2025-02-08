/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import DataStructures.List;
import DataStructures.Node;

/**
 *
 * @author luciano
 */
public class MetodoPlanificacion extends MemoryEntity {
    private List<Process> ListFCS;
    private List<Process> ListSRT;
    private List<Process> ListRound;
   
    public MetodoPlanificacion() {
        this.ListFCS = new List();  
        this.ListSRT = new List();  
    }

    
    //El primer elemento añadido es el primero en la fila de operaciones
    public void AddFCS(Process process) {
           ListFCS.append(process);    
}
    public void AddSRT(Process process) {
           ListSRT.append(process);    
}
    public void ExecuteFCS(){
        int j;
        for(j = 0; j<ListFCS.getSize(); j++){
        System.out.println(ListFCS.get(j).getName()); //Ahora imprime, pero se cambiara para que ejecute del primer proceso anadido al ultimo.
        }
        
        
        
    }
    public void ExecuteSRT(){ //Usa un algoritmo para reordenar la lista del proceso mas pequeño al mas mayor.
    int size = ListSRT.getSize();
    
    for (int i = 0; i < size - 1; i++) { //Recorrer la lista
        for (int j = 0; j < size - i - 1; j++) {
            Process current = ListSRT.get(j);
            Process next = ListSRT.get(j + 1);
            
            if (current.getInstructions() > next.getInstructions()) { //CAMBIAR LO DE GET PC al Tiempo de ejecucion
                // Cambia elemntos
                ListSRT.pop( j);
                ListSRT.insert(next, j);
                ListSRT.pop( j+1);
                ListSRT.insert(current, j + 1);
                System.out.println("Swapping: " + current.getPC() + " > " + next.getPC());
            }
        }
    }

    // Imprimir elementos
//    System.out.println("\nProcesos ordenados:");
//    for (int i = 0; i < ListSRT.getSize(); i++) {
//        Process p = ListSRT.get(i);
//        System.out.println(p.getName() + " (PC: " + p.getPC() + ")");
//    }
}


        
    
    
    
    //PRUEBA
     public static void main(String[] args) {
        MetodoPlanificacion mem = new MetodoPlanificacion();
        Process a = new Process("A",5,1,1);
        Process b = new Process("B",3,2,2);
        Process c = new Process("C",2,3,3);
        Process d = new Process("D",6,3,5);
        Process f = new Process("E",9,10,4);
        
        mem.AddSRT(a);
        mem.AddSRT(b);
        mem.AddSRT(c);
        mem.AddSRT(d);
        mem.AddSRT(f);
        mem.ExecuteSRT();
        
        
        
    }
    
}



