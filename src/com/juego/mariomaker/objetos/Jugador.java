
package com.juego.mariomaker.objetos;

import com.juego.mariomaker.framework.ObjetoId;
import com.juego.mariomaker.framework.ObjetoJuego;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;


public class Jugador extends ObjetoJuego{

    
    private float ancho=34, alto=64;
    
    private float gravedad=0.5f;
    public Jugador(float x, float y, ObjetoId id) {
        super(x, y, id);
    }
    public void tick(LinkedList<ObjetoJuego> objeto) {
        x+=velX;
        y+=velY;
        if(salto|| caida)
        {
            velY+=gravedad;
        }
    }
    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect((int)x,(int) y, (int)ancho,(int)alto);
    }

    public Rectangle obtenTam() {
        return new Rectangle((int)x,(int)y,(int)ancho,(int)alto);
    }
    
    
    
}
