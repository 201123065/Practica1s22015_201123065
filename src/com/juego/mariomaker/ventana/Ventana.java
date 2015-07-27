
package com.juego.mariomaker.ventana;

import java.awt.Dimension;
import java.util.Locale;
import javax.swing.JFrame;

public class Ventana {
    
    
    //pantalla principal del juego
    public Ventana(int w, int h , String titulo, Juego juego)
    {
        juego.setPreferredSize(new Dimension(w,h));
        juego.setMaximumSize(new Dimension(w,h));
        juego.setMinimumSize(new Dimension(w,h));
        
        
        JFrame frame = new JFrame(titulo);
        frame.add(juego);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        juego.start();
        
        
    }


}
