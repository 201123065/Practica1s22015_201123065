/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juego.mariomaker.ventana;

import com.juego.mariomaker.framework.KeyInput;
import com.juego.mariomaker.framework.ObjetoId;
import static com.juego.mariomaker.framework.ObjetoId.Jugador;
import com.juego.mariomaker.framework.ObjetoJuego;
import com.juego.mariomaker.objetos.Block;
import com.juego.mariomaker.objetos.Jugador;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

/**
 *
 * @author marcosmayen
 */
public class Juego extends Canvas implements Runnable{
   
    
    private float gravedad =0.05f;
    
    public static int ANCHO,ALTO;
    
    private boolean running = false;
    private Thread thread;
    
    Controlador manejador;
    
     private void init()
    {
        ANCHO= getWidth();
        ALTO = getHeight();
        manejador = new Controlador();
        manejador.addObjeto(new Jugador(100,100,manejador,ObjetoId.Jugador));
        manejador.crearNivel();
        
        this.addKeyListener(new KeyInput(manejador));
        
        
     
    }
    
    public synchronized void start(){
        if (running)
            return;
        
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    
    
    
    
   
    
    public void run()
    {
        init();
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000/amountOfTicks;
        double delta =0;
        long timer = System.currentTimeMillis();
        int updates=0;
        int frames =0;
        while(running)
        {
            long now = System.nanoTime();
            delta+=(now-lastTime)/ns;
            lastTime=now;
            while(delta>=1)
            {
                tick();
                updates++;
                delta--;
            }
            render();
            frames++;
            
            if(System.currentTimeMillis()-timer>1000)
            {
                timer+=1000;
                System.out.print("FPS: "+ frames + "TICKS" +updates);
                frames=0;
                updates=0;
            }
        }
        
    }
    
    
    private void tick()
    {
        manejador.tick();
    }
    
    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs==null)
        {
            this.createBufferStrategy(3);
            return;
        }
        
        
        //area de dibujo del juego
        Graphics g = bs.getDrawGraphics();
        
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        manejador.render(g);
        //fin dibujo
        
        g.dispose();
        bs.show();
        
    }
    
    public static void main(String Args[])
    {
        new Ventana(800,600,"Mario Maker", new Juego());
    }
    
}
