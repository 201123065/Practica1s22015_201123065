
package com.juego.mariomaker.framework;

import javax.swing.JOptionPane;

public class Lista {
    private Nodo inicio,fin;
    
    
    public Nodo aux;
    
    //crea la lista;
    public Lista(){
        inicio=fin=null;
    }
    
    //retornar si el nodo esta vacio
    public boolean estaVacia(){
        return inicio==null;
    }
    //agregar al final
    public void AgregaFinal(String id, String nombre, String imagen)
    {
        if(!estaVacia())
        {
            fin=new Nodo(id,nombre,imagen,null,fin);
            fin.anterior.siguiente=fin;
            JOptionPane.showMessageDialog(null, "agregado correctamente, ya habian antes","exito",3);
            
        }else
        {
            aux=inicio=fin=new Nodo(id,nombre,imagen);
            JOptionPane.showMessageDialog(null, "agregado correctamente","exito",3);
            
        }
    }
    
    //mostrar la lista
    public Nodo retornarValorSiguiente()
    {
        Nodo temp;
        if(!estaVacia())
        {
            if(aux.siguiente==null)
            {
                JOptionPane.showMessageDialog(null, "Este es el ultimo dato de esta lista","Informacion",3);
                return aux;
            }
            else
            {
                temp =aux;
                aux=aux.siguiente;
                return temp;
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Esta lista esta vacia","Informacion",3);
            return null;
        }
    }
    
    
    public Nodo retornarValorAnterior()
    {
        Nodo temp;
        if(!estaVacia())
        {
            if(aux.anterior==null)
            {
                JOptionPane.showMessageDialog(null, "Este es el Primer dato de esta lista","Informacion",3);
                return aux;
            }
            else
            {
                temp =aux;
                aux=aux.anterior;
                return temp;
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Esta lista esta vacia","Informacion",3);
            return null;
        }
    }
    
    
    
    
    
    public void mostrarListaIF()
    {
        Nodo temp;
        if(!estaVacia())
        {
            if(aux.siguiente!=null)
            {
                aux=aux.siguiente;
            JOptionPane.showMessageDialog(null,aux.Nombre,"ERROR", 3);
            }
            else
            {
            JOptionPane.showMessageDialog(null,"Fin de la lista","ERROR", 3);
                        
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"la lista esta vacia","ERROR", 3);
        }
            
        /*
        if(!estaVacia())
        {
            String datos="<=>";
            Nodo aux=inicio;
            while(aux!=null)
            {
                datos=datos+"["+aux.dato+"]<=>";
                aux=aux.siguiente;
            }
            JOptionPane.showMessageDialog(null, datos, "lista",
                    JOptionPane.INFORMATION_MESSAGE);
        }*/
    }
    public void mostrarListaFI(){
        if(!estaVacia())
            {
                String datos="<=>";
                Nodo aux=fin;
                while(aux!=null)
                {
                    //datos=datos+"["+aux.dato+"]<=>";
                    aux=aux.anterior;
                }
                JOptionPane.showMessageDialog(null, datos, "lista",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    /*eliminar del inicio
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
    */
    
    
    
    
}
