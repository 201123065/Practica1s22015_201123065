/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juego.mariomaker.objetos;

import com.juego.mariomaker.framework.ObjetoJuego;
import com.juego.mariomaker.framework.ObjetoId;
import java.awt.Graphics;
import java.util.LinkedList;



public class Test extends ObjetoJuego {

    public Test(float x, float y, ObjetoId id) {
        super(x, y, id);
    }

    @Override
    public void tick(LinkedList<ObjetoJuego> objeto) {
    
    
    }

    public void render(Graphics g) {
    
    
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }


    public void setX(float x) {
        this.x=x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getvelX() {
        return velX;
    }

    public float getvelY() {
        return velY;
    }

    public void setvelX(float velX) {
        this.velX = velX;
    }

    public void setvelY(float velY) {
        this.velY = velY;
    }

    @Override
    public ObjetoId getId() {
        return id;
    }
    
}
