
package com.juego.mariomaker.ventana;

import com.juego.mariomaker.framework.ObjetoId;
import static com.juego.mariomaker.framework.ObjetoId.Block;
import com.juego.mariomaker.framework.ObjetoJuego;
import com.juego.mariomaker.objetos.Block;
import java.awt.Graphics;
import java.util.LinkedList;


public class Controlador {
    public LinkedList<ObjetoJuego> objeto = new LinkedList<ObjetoJuego>();
    
    private ObjetoJuego tempObjeto;
    
    public void tick()
    {
        for(int i=0;i<objeto.size();i++)
        {
            tempObjeto = objeto.get(i);
            
            tempObjeto.tick(objeto);
                    
        }
    }
    
    public void render(Graphics g)
    {
        for(int i=0;i<objeto.size();i++)
        {
            tempObjeto = objeto.get(i);
             
            tempObjeto.render(g);
                    
        }
    }
    
    public void addObjeto(ObjetoJuego objeto)
    {
        this.objeto.add(objeto);
    }
    
    public void quitaObjeto(ObjetoJuego objeto)
    {
        this.objeto.remove(objeto);
    }
    
    public void crearNivel()
    {
        for(int xx=0;xx<Juego.ANCHO+40;xx+=40)
        {
            addObjeto(new Block(xx,Juego.ALTO-40,ObjetoId.Block));
        }
        for(int i=Juego.ALTO;i>40;i-=40)
        {
            addObjeto(new Block(0,i,ObjetoId.Block));
        }
        
        for(int i=0;i<5;i++)
        {
            addObjeto(new Block(i*40+100,450,ObjetoId.Block));
        }
    }
    
    
    
    
}
