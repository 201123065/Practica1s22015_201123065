
package com.juego.mariomaker.ventana;

import com.juego.mariomaker.framework.ObjetoId;
import static com.juego.mariomaker.framework.ObjetoId.Block;
import com.juego.mariomaker.framework.ObjetoJuego;
import com.juego.mariomaker.objetos.Block;
import java.awt.Graphics;
import java.util.LinkedList;


public class Manejador {
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
        for(int xx=0;xx<Juego.ANCHO+32;xx+=32)
        {
            addObjeto(new Block(xx,Juego.ALTO-32,ObjetoId.Block));
        }
    }
    
    
    
    
}
