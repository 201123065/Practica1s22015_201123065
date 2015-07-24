
package practica1s22015_201123065;



public class Nodo {
    
    Object valor;
    Nodo siguiente;
    
    public Nodo(Object valor)
    {
        this.valor=valor;
        siguiente=null;
    }
    public Object obtenerValor()
    {
        return valor;
    }
    
    public void enlazarSiguiente(Nodo n)
    {
        siguiente=n;
    }
    
    public Nodo obtenerSiguiente()
    {
        return siguiente;
    }
            
    
}
