/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures;

/**
 *
 * @author Juan
 */
public class Node<T> {
    //Atributos
    private T data;
    private Node<T> next;

    //Constructor 1: Solo acepta un dato para la creacion del nodo
    public Node(T data) {
        this.data = data;
        this.next = null;
    }
    
    //Constructor 2: Acepta el dato que contiene el nodo, y el nodo siguiente
    public Node(T data, Node next) {
        this.data = data;
        this.next = next;
    }
    
    //----------------------Getters y Setters-----------------------
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    
    
}
