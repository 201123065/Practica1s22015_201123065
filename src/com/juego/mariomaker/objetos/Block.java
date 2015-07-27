/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juego.mariomaker.objetos;

import com.juego.mariomaker.framework.ObjetoJuego;
import com.juego.mariomaker.framework.ObjetoId;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;



public class Block extends ObjetoJuego {

    public Block(float x, float y, ObjetoId id) {
        super(x, y, id);
    }

    public void tick(LinkedList<ObjetoJuego> objeto) {
    
    
    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.drawRect((int)x,(int)y, 321, 322);
    
    }
    
    public Rectangle obtenTam() {
        return new Rectangle((int)x,(int)y,32,32);
    }
    
    
}
