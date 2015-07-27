/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juego.mariomaker.framework;

import java.awt.Graphics;
import java.util.LinkedList;

/**
 *
 * @author marcosmayen
 */
public abstract class ObjetoJuego {
    
    protected float x,y;
    protected ObjetoId id;
    
    protected float velX=0,velY=0;
    
    public ObjetoJuego(float x, float y, ObjetoId id)
    {
        this.x =x;
        this.y = y;
        this.id = id;
       
    }
    public abstract void tick(LinkedList<ObjetoJuego> objeto);
    public abstract void render(Graphics g);
    
    public abstract float getX();
    public abstract float getY();
    public abstract void setX(float x);
    public abstract void setY(float y);
    
    public abstract float getvelX();
    public abstract float getvelY();
    public abstract void setvelX(float x);
    public abstract void setvelY(float y);
    
    
    public abstract ObjetoId getId();
    
    
    
}
