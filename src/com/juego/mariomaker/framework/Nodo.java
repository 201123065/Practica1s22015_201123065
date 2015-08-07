
package com.juego.mariomaker.framework;


public class Nodo {

    public String Nombre,Imagen,ID;
    Nodo siguiente,anterior;
    //nodo ya cargado
    
    public Nodo(String id, String Nombre,String Imagen)
    {
        this(id,Nombre,Imagen,null,null);
    }
    
    public Nodo(String id,String Nombre,String Imagen,Nodo sig, Nodo ant){
        //identificador
        this.ID=id;
        //Nombre
        this.Nombre=Nombre;
        //ruta de la imagen
        this.Imagen=Imagen;
        //siguiente Nodo
        this.siguiente=sig;
        //previo Nodo
        this.anterior=ant;
    }
    
    
            
}