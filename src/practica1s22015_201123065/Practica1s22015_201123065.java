package practica1s22015_201123065;

import java.awt.Toolkit;

public class Practica1s22015_201123065 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       
        Nodo primer = new Nodo("ejemplo uno");
        Nodo segundo = new Nodo(45);
        Nodo tercero = new Nodo("hai");
        
        
        primer.enlazarSiguiente(segundo);
        segundo.enlazarSiguiente(tercero);
        tercero.enlazarSiguiente(primer);
        
        primer.obtenerSiguiente();
        
        
        /*Thread hilo = new piezas("proceso 1");
        Thread hilo2 = new piezas("proceso 2");
        
        hilo.start();
        hilo2.start();
        
        Pizarra op = new Pizarra();
        Dimensiones dim = new Dimensiones();
        
        op.setSize(dim.largo(),dim.ancho());
        op.setVisible(true);*/
        
        
    }
    
}
