
package com.juego.mariomaker.framework;


public class Nodo {
    Object valor;
    Nodo Siguiente;
    
    public Nodo(Object valor)
    {
        this.valor=valor;
    }
    
    public void Siguiente(Nodo n)
    {
        Siguiente =n;
    }
    public Object ObtenerValor(){
        return valor;
    }
    
    public Nodo getSiguiente(){
        return Siguiente;
    }
}
