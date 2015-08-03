
package com.juego.mariomaker.framework;

/**
 *
 * @author marcosmayen
 */
public class NodoD {

    public Object dato;
    NodoD siguiente,anterior;
    //nodo ya cargado
    
    public NodoD(Object dato)
    {
        this(dato,null,null);
    }
    
    public NodoD(Object dato,NodoD sig, NodoD ant){
        this.dato=dato;
        this.siguiente=sig;
        this.anterior=ant;
    }
    
    
    
}
