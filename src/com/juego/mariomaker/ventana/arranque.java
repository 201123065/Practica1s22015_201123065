
package com.juego.mariomaker.ventana;

import com.juego.mariomaker.framework.Lista;
import javax.swing.JOptionPane;


public class arranque {
    
    
    
    public static void main(String Args[])
    {
        Personaje arranca = new Personaje();
    }
    
}

/*

int op=0,e1;
        Object obj;
        Lista lista = new Lista();
        do{
            try{
                op=Integer.parseInt(JOptionPane.showInputDialog(null, 
                        "1.-inicio"+
                        "\n2.-final"+
                        "\n3.-mostrar inicio/fin"+
                        "\n4,mostrarfin/inicio"+
                        "\n5,salir"+
                        "\n6, eliminar inicio"+
                        "7,\neliminar fin",3));
                switch(op)
                {
                    case 1:
                        obj=JOptionPane.showInputDialog(null,"agregar al inicio","inicio",3);
                        lista.NodoInicio(obj);
                        break;
                    case 2:
                        obj=JOptionPane.showInputDialog(null,"agregar al inicio","inicio",3);
                        lista.NodoFinal(obj);
                        break;
                    case 3:
                        if(!lista.estaVacia())
                        {
                            lista.mostrarListaIF();
                        }
                        else
                        {
                             JOptionPane.showMessageDialog(null,"vacia","vacio",3);
                       
                        }
                        break;
                    case 4:
                        if(!lista.estaVacia()){
                            lista.mostrarListaFI();
                        }else{
                             JOptionPane.showMessageDialog(null,"vacia","vacio",3);
                        }
                        break;
                    case 5:
                        break;
                    case 6:
                        if(!lista.estaVacia())
                        {
                            lista.eliminarInicio();
                        }
                        break;
                    case 7:
                        
                        if(!lista.estaVacia())
                        {
                            lista.eliminarFinal();
                        }
                        break;
                        
                }
            }catch(Exception e)
            {
                
            }
            
        }while(op!=5);
    }




*/