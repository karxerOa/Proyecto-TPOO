/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author apnil
 */
public class ListaCircularDoble <T> {
    private Nodo<T> head;
    private Nodo<T> tail;
    
    public boolean estaVacia() {
        return head == null;
    }
    
    public void agregarFinal(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (estaVacia()) {
            head = nuevoNodo;
            tail = nuevoNodo;
            head.setNext(head);
            head.setPrev(head);
        } else {
            tail.setNext(nuevoNodo);
            nuevoNodo.setPrev(tail);
            tail.setNext(head);
            nuevoNodo.setNext(head);
            head.setPrev(tail);
        }
    }

    public Nodo<T> getHead() {
        return head;
    }

    public Nodo<T> getTail() {
        return tail;
    }
    
    
    
}
