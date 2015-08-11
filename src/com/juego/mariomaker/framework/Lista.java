
package com.juego.mariomaker.framework;

import javax.swing.JOptionPane;

public class Lista {
    public Nodo inicio,fin;
    
    
    public Nodo aux;
    
    //crea la lista;
    public Lista(){
        inicio=fin=null;
    }
    
    //retornar si el nodo esta vacio
    public boolean estaVacia(){
        return inicio==null;
    }
    //agregar al final-----------------metodo:Cola------------------
    public void AgregaFinal(String id, String nombre, String imagen){
        if(!estaVacia())
        {
            //el puntero siguiente del fin anterior es fin
            fin=new Nodo(id,nombre,imagen,null,fin);
            fin.anterior.siguiente=fin;
            JOptionPane.showMessageDialog(null, "agregado correctamente, ya habian antes","exito",3);
            
        }else
        {
            aux=inicio=fin=new Nodo(id,nombre,imagen);
            JOptionPane.showMessageDialog(null, "agregado correctamente","exito",3);
            
        }
    }
    //agregar al final-----------------metodo:pila------------------
    public void AgregaInicio(String id, String nombre, String imagen){
        if(!estaVacia())
        {
            //el puntero siguiente del fin anterior es fin
            inicio=new Nodo(id,nombre,imagen,inicio,null);
            inicio.siguiente.anterior=inicio;
            JOptionPane.showMessageDialog(null, "agregado correctamente, ya habian antes","exito",3);
            
        }else
        {
            aux=inicio=fin=new Nodo(id,nombre,imagen);
            JOptionPane.showMessageDialog(null, "agregado correctamente","exito",3);
            
        }
    }
    
    
    
    
    public void ModificarDato(String id, String nombre,String nom){
        if(!estaVacia())
        {
            aux=inicio;
            while(aux!=null&&aux.ID!=id &&aux.Nombre!=nombre)
            {
                aux=aux.siguiente;
            }
            if(aux!=null)
            {
                if(aux==inicio)
                {
                    inicio.Nombre=nom;
                    aux=inicio;
                }
                else if(aux==fin){
                    fin.Nombre=nom;
                    aux=fin;
                }
                else
                {
                    aux.Nombre=nom;
                }
            }
        }
        JOptionPane.showMessageDialog(null,nombre+" ahora es "+aux.Nombre,"Personaje",3);
    }
  
    
    public Nodo EliminarDato(String id, String nombre) {
        if(!estaVacia())
        {
            aux=inicio;
            if(inicio==fin && id==inicio.ID && nombre==inicio.Nombre)
            {
                inicio=fin=aux=null;
            }
            else if(id==inicio.ID && nombre==inicio.Nombre)
            {
                inicio=inicio.siguiente;
                inicio.anterior=null;
                aux=inicio;
            }
            else
            {
                
                Nodo temporal;
                temporal=aux.siguiente;
                while(temporal!=null&&temporal.ID!=id &&temporal.Nombre!=nombre)
                {
                    aux=aux.siguiente;
                    temporal=temporal.siguiente;
                }
                if(temporal!=null)
                {
                    if(temporal.siguiente==null)
                    {
                        fin.anterior.siguiente=null;
                        fin=fin.anterior;
                        aux=fin;
                     
                    }
                    else
                    {
                        aux.siguiente=temporal.siguiente;
                        temporal.siguiente.anterior=aux;
                    }
                }/**/
            }
        }
        JOptionPane.showMessageDialog(null, nombre+"ha sido eliminado","Personaje",3);
        
        return aux;
    }
    //mostrar la lista
    public Nodo retornarValorSiguiente(){
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
    
    public Nodo retornarValorAnterior(){
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
    
    public String mostrarListaIF(){
        String datos="";
        if(!estaVacia()){
            datos="[label = \"{<n> ";
            Nodo nuevo = inicio;
            while(nuevo.siguiente!=null){
                datos=datos+nuevo.Nombre+"|";
                nuevo=nuevo.siguiente;
            }
            if(nuevo!=null)
            {
                datos=datos+nuevo.Nombre+"}\"];";
            }else
            {
                datos="[label=\"{}\"];";
            }
        }
        else{
            datos="[label=\"{}\"];";
        }
        return datos;
        
    }
   
    
    
    
    
}
