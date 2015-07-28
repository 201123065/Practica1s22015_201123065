
package com.juego.mariomaker.objetos;

import com.juego.mariomaker.framework.ObjetoId;
import com.juego.mariomaker.framework.ObjetoJuego;
import com.juego.mariomaker.ventana.Manejador;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;


public class Jugador extends ObjetoJuego{

    
    private float ancho=32, alto=64;
    
    private Manejador manejador;
    
    private float gravedad=0.1f;
    public Jugador(float x, float y,Manejador manejador, ObjetoId id) {
        super(x, y, id);
        this.manejador = manejador;
    }
    public void tick(LinkedList<ObjetoJuego> objeto) {
        x+=velX;
        y+=velY;
        if(salto|| caida)
        {
            velY+=gravedad;
        }
        choque(objeto);
    }
    private void choque(LinkedList<ObjetoJuego> objeto){
        for(int i=0;i<manejador.objeto.size();i++)
        {
            ObjetoJuego temp = manejador.objeto.get(i);
            
            if(temp.getId()==ObjetoId.Block)
            {
                if(obtenTam().intersects(temp.obtenTam()))
                {
                    
                    velY=0;
                    salto=false;
                    caida=false;
                }
                else
                {
                    caida=true;
                }
            }
            
        }
        
    }
    
    
    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect((int)x,(int) y, (int)ancho,(int)alto);
        Graphics2D g2d = (Graphics2D)g;
        g.setColor(Color.red);
        g2d.draw(obtenTam());
        g2d.draw(obtenTop());
        g2d.draw(obtenIzq());
        g2d.draw(obtenDer());
    }

    public Rectangle obtenTam() {
        return new Rectangle((int)x+5,(int)y,(int)ancho-10,(int)alto/2);
    }
    public Rectangle obtenTop() {
        return new Rectangle((int)x+5, (int) ((int)y+alto/2),(int)ancho-10,(int)alto/2);
    }
    
    public Rectangle obtenIzq() {
        return new Rectangle((int)x,(int)y+3,5,(int)alto-6);
    }
    public Rectangle obtenDer() {
        return new Rectangle((int) ((int)x+ancho-5),(int)y+3,5,(int)alto-6);
    }
    
    
}
