/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataEstructures;

/**
 *
 * @author Juan
 * @param <T>
 */
public class Queue<T> {
    //Atributos
    private Node<T> first;
    private Node<T> last;
    private int size;

    /***
     * Constructor: Crea una cola con ninguno elemento en ella
     */
    public Queue() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }
    
    //---------------------Getters y Setters--------------------
    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public Node getLast() {
        return last;
    }

    public void setLast(Node last) {
        this.last = last;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    
    //---------------------Procedimientos y Metodos----------------------
    
    /***
     * Retorna si la cola esta vacia
     * @return 
     */
    public boolean isEmpty(){
        return this.first == null;
    }
    
    /***
     * Agrega un elemento de ultimo a la cola 
     * @param data 
     */
    public void enqueue(T data){
        Node<T> newNode = new Node(data);
        if(isEmpty()){
            this.first = this.last = newNode;
        }
        else{
            this.last.setNext(newNode);
            this.last = newNode;
        }
        this.size++;
    }
    
    /***
     * Saca al primer elemento de la cola y devuelve su valor
     * @return 
     */
    public T dequeue(){
        if(isEmpty()){
            System.err.println("Error: empty queue");
        }
        else{
            Node<T> newFirst = this.first.getNext();
            T data = this.first.getData();
            this.first.setNext(null);
            this.first = newFirst;
            this.size--;
            return data;
        }
        return null;
    }
    
    /***
     * Permite imprimir la cola en consola con System.out.println("");
     * @return 
     */
    @Override
    public String toString() {
        String queue = null;
        if(isEmpty()){
            System.err.println("Error: empty queue");
        }
        else{
            queue = "";
            Node pointer = this.first;
            for (int i = 0; i < this.size; i++) {
                if(i == this.size-1){
                    queue += pointer.getData();
                }
                else{
                    queue += pointer.getData() + " -> ";
                }
                pointer = pointer.getNext();
            }
        }
        return queue;
    }
    
    
    
    
}
