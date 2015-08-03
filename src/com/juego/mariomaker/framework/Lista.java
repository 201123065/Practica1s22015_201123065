
package com.juego.mariomaker.framework;

public class Lista {
    protected Nodo inicio,fin;
    public Lista()
    {
        inicio=null;
        fin=null;
    }
    
    //agrega al inicio
    public void agregarAlInicio(int elemento)
    {
        inicio = new Nodo(elemento,inicio);
        if(fin==null)
        {
            fin=inicio;
        }
    }
    //agrega al final
    public void agregarAlFinal(int elemento)
    {
        if(estaVacia())
        {
            inicio=fin=new Nodo(elemento);
        }
        else
        {
            fin.Siguiente=new Nodo(elemento);
            fin= fin.Siguiente;
        }
    }
    
    
    //verificar si esta vacia
    public boolean estaVacia(){
        return (inicio==null)?true:false;
    }
    
    //muestra la lista de datos
    public void MostrarLista()
    {
        Nodo recorrer = inicio;
        while(recorrer!=null)
        {
            System.out.print("["+recorrer.valor+"]--≥");
            recorrer=recorrer.Siguiente;
        }
    }
    
}
