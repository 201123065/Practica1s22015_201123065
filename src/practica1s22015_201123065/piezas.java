
package practica1s22015_201123065;

public class piezas {
    
    String nombre;
    Object imagen;
    
    piezas siguiente;
    
    public piezas(String nombre, Object imagen)
    {
        this.nombre=nombre;
        this.imagen=imagen;
        siguiente=null;
    }
    public Object obtenerNombre()
    {
        return nombre;
    }
    
    public void enlazarSiguiente(piezas n)
    {
        siguiente=n;
    }
    
    public piezas obtenerSiguiente()
    {
        return siguiente;
    }
    
    
    
}
