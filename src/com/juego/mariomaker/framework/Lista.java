
package com.juego.mariomaker.framework;

import javax.swing.JOptionPane;

public class Lista {
    private NodoD inicio,fin;
    
    public Lista(){
        inicio=fin=null;
    }
    public boolean estaVacia(){
        return inicio==null;
    }
    //agregar al final
    public void NodoFinal(Object o,int num)
    {
        if(!estaVacia())
        {
            fin=new NodoD(o,num,null, fin);
            fin.anterior.siguiente=fin;
        }else
        {
            inicio=fin=new NodoD(o,num);
        }
    }
    //agregar al inicio
    public void NodoInicio(Object o,int num)
    {
        if(!estaVacia())
        {
            inicio=new NodoD(o,num,inicio, null);
            inicio.siguiente.anterior=inicio;
        }else
        {
            inicio=fin=new NodoD(o,num);
        }
    }
    //mostrar la lista
    public Object retornarValorEspecifico(Object o)
    {
        Object retorna=null;
        
        if(!estaVacia())
        {
            
        }
        return retorna;
    }
    
    
    public void mostrarListaIF()
    {
        if(!estaVacia())
        {
            String datos="<=>";
            NodoD aux=inicio;
            while(aux!=null)
            {
                datos=datos+"["+aux.dato+"]<=>";
                aux=aux.siguiente;
            }
            JOptionPane.showMessageDialog(null, datos, "lista",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void mostrarListaFI(){
        if(!estaVacia())
            {
                String datos="<=>";
                NodoD aux=fin;
                while(aux!=null)
                {
                    datos=datos+"["+aux.dato+"]<=>";
                    aux=aux.anterior;
                }
                JOptionPane.showMessageDialog(null, datos, "lista",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    //eliminar del inicio
    public Object eliminarInicio()
    {
        Object elemento = inicio.dato;
        if(inicio==fin){
            inicio=fin=null;
        }else
        {
            inicio=inicio.siguiente;
            inicio.anterior=null;
        }
        return elemento;
    }
    public Object eliminarFinal()
    {
        Object elemento = fin.dato;
        if(inicio==fin){
            inicio=fin=null;
        }else
        {
            fin=fin.anterior;
            fin.siguiente=null;
            
        }
        return elemento;
    }
    //eliminar uno en especifico
    public Object ExisteVal(int val){
        NodoD temporal = inicio;
        
        while(temporal!=null && temporal.num!=val)
        {
            temporal=temporal.siguiente;
        }
        return temporal;
    }
    
}
