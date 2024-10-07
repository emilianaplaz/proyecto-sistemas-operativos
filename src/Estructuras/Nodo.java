/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import Entes.Trabajador;

/**
 *
 * @author emilianaplaz
 */
public class Nodo {
    private Trabajador element;
    private Nodo next;
    private Nodo previous;

    public Nodo(Trabajador element) {
        this.element = element;
        this.next = null;
        this.previous = null;
    }

    
    public Trabajador getElement() {
        return element;
    }

    
    public void setElement(Trabajador element) {
        this.element = element;
    }

    
    public Nodo getNext() {
        return next;
    }

    
    public void setNext(Nodo next) {
        this.next = next;
    }

    
    public Nodo getPrevious() {
        return previous;
    }

    
    public void setPrevious(Nodo previous) {
        this.previous = previous;
    }  
}
