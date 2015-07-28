
package com.juego.mariomaker.framework;

import com.juego.mariomaker.ventana.Manejador;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class KeyInput extends KeyAdapter{
    
    Manejador manejador;
    public KeyInput(Manejador manejador){
        this.manejador = manejador;
    }
    
    public void keyPressed(KeyEvent e)
    {
      int key = e.getKeyCode();
      for(int i=0;i<manejador.objeto.size();i++)
      {
          ObjetoJuego temp = manejador.objeto.get(i);
          if(temp.getId()==ObjetoId.Jugador)
          {
              if(key==KeyEvent.VK_A)temp.setvelX(-5);
              if(key==KeyEvent.VK_D)temp.setvelX(5);
              if(key==KeyEvent.VK_SPACE)temp.setvelY(-3);
          }
          
      }
      
      if(key == KeyEvent.VK_ESCAPE)
      {
        System.exit(1);
      }
    }
    public void keyReleased(KeyEvent e)
    {
        int key = e.getKeyCode();
      for(int i=0;i<manejador.objeto.size();i++)
      {
          ObjetoJuego temp = manejador.objeto.get(i);
          if(temp.getId()==ObjetoId.Jugador)
          {
              if(key==KeyEvent.VK_A)temp.setvelX(0);
              if(key==KeyEvent.VK_D)temp.setvelX(0);
               
              
          }
          
      }
      
    }
}
