
package com.juego.mariomaker.framework;


public class Nodo {
    public int valor;
    public Nodo Siguiente;
    
    public Nodo(int valor)
    {
        this.valor=valor;
        this.Siguiente=null;
    }
    
    public Nodo(int valor, Nodo n)
    {
        this.valor = valor;
        Siguiente = n;
        
    }
    
    
}
