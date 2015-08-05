
package com.juego.mariomaker.framework;

/**
 *
 * @author marcosmayen
 */
public class NodoD {

    public Object dato;
    public int num;
    NodoD siguiente,anterior;
    //nodo ya cargado
    
    public NodoD(Object dato,int num)
    {
        this(dato,num,null,null);
    }
    
    public NodoD(Object dato,int num,NodoD sig, NodoD ant){
        this.dato=dato;
        this.num=num;
        this.siguiente=sig;
        this.anterior=ant;
    }
    
    
    
}
