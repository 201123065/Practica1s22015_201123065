
package com.juego.mariomaker.framework;

public class ListaObjetos {
    Nodo cabeza;
    int tam;
    public ListaObjetos()
    {
        cabeza=null;
        tam=0;
    }
    
    
    public Object obtenerVal(int indice){
        int cont=0;
        Nodo temp = cabeza;
        while(cont<indice)
        {
            temp=temp.getSiguiente();
            cont++;
        }
        return temp.ObtenerValor();
    }
    
    public void addPrimero(Object obj){
        if(cabeza==null)
        {
            cabeza = new Nodo(obj);
        }
        else{
            Nodo temp =  cabeza;
            Nodo nuevo = new Nodo(obj);
            nuevo.Siguiente(temp);
            cabeza=nuevo;
        }
        tam++;
    }
    public void eliminarPrimero()
    {
        cabeza=cabeza.getSiguiente();
        tam--;
    }
    
    public void eliminar(int indice)
    {
        if(indice==0)
        {
            cabeza=cabeza.getSiguiente();
        }
        else{
            int contador=0;
            Nodo temp= cabeza;
            while(contador<indice-1)
            {
                temp=temp.getSiguiente();
                contador++;
            }
            temp.Siguiente(temp
                    .getSiguiente()
                    .getSiguiente());
        }
    }
    
    
    
    public int tam()
    {
        return tam;
    }
    public boolean Vacia(){
        return(cabeza==null)?true:false;
    }
    
    
    
}
