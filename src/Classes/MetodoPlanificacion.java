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
 public void ExecuteSRT() {
    int size = ListSRT.getSize();
    List<Process> tempList = new List<>();  // Crear una lista temporal
    
    // Copiar todos los elementos al tempList
    for (int i = 0; i < size; i++) {
        tempList.append(ListSRT.get(i));
    }
    
    // Limpiar la lista original
    ListSRT.delete();
    
    // Ordenar mientras se inserta devuelva a ListaSRT
    while (tempList.getSize() > 0) {
        int minIndex = 0;
        Process minProcess = tempList.get(0);
        
        // Encontrar minimos
        for (int i = 0; i < tempList.getSize(); i++) {
            Process current = tempList.get(i);
            if (current.getInstructions() < minProcess.getInstructions()) {
                minProcess = current;
                minIndex = i;
            }
        }
        
        // Remover de tempList y añadir to ListSRT
        tempList.pop(minIndex);
        ListSRT.append(minProcess);
    }

    System.out.println("\nProcesos ordenados:"); //Cambiar imprimir procesos ordenados a ejecutar procesos
    for (int i = 0; i < ListSRT.getSize(); i++) {
        Process p = ListSRT.get(i);
        System.out.println(p.getName() + " (Instructions: " + p.getInstructions() + ")");
    }
}


        
    
    
    
//    //PRUEBA
//     public static void main(String[] args) {
//        MetodoPlanificacion mem = new MetodoPlanificacion();
//        Process a = new Process("A",1, 5,1);
//        Process b = new Process("B",1,3,2);
//        Process c = new Process("C",1,2,3);
//        Process d = new Process("D",1,6,3);
//        Process f = new Process("E",1,9,10);
//        mem.AddSRT(a);
//        mem.AddSRT(b);
//        mem.AddSRT(c);
//        mem.AddSRT(d);
//        mem.AddSRT(f);
//        mem.ExecuteSRT();
//        
//        
//        
//    }
    
}



