/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juego.mariomaker.framework;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

/**
 *
 * @author marcosmayen
 */
public abstract class ObjetoJuego {
    
    protected float x,y;
    protected ObjetoId id;
    
    protected boolean caida = true;
    protected boolean salto = false;

    public void setCaida(boolean caida) {
        this.caida = caida;
    }

    public void setSalto(boolean salto) {
        this.salto = salto;
    }
    

    
    public boolean isCaida() {
        return caida;
    }

    public boolean isSalto() {
        return salto;
    }
    
    protected float velX=0,velY=0;
    
    public ObjetoJuego(float x, float y, ObjetoId id)
    {
        this.x =x;
        this.y = y;
        this.id = id;
       
    }
    public abstract void tick(LinkedList<ObjetoJuego> objeto);
    public abstract void render(Graphics g);
    
    public abstract Rectangle obtenTam();
    
    public float getX(){
        return x;
    }
    public float getY(){
        return y;
    }
    public void setX(float x){
        this.x = x;
    }
    public  void setY(float y){
        this.y=y;
    }
    
    public float getvelX(){
        return velX;
    }
    public float getvelY(){
        return velY;
    }
    public void setvelX(float velX){
        this.velX=velX;
    }
    public void setvelY(float velY){
        this.velY=velY;
    }
    public ObjetoId getId(){
        return id;
    }
    
}
