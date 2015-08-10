
package com.juego.mariomaker.ventana;

import com.juego.mariomaker.framework.Lista;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

 

public class mOrtogonal implements ActionListener{
    private JPanel panel1;
    private JPanel panel2;
    private JScrollPane panelS;
    JFrame pantalla;
    
    public mOrtogonal(Lista Piso, Lista Pared,Lista Goomba,Lista Koopa,Lista Ficha, Lista Hongo,String Mario, String Castillo)
    {
        pantalla = new JFrame("mariomaker pantalla");
        panel1=new JPanel();
        panel2=new JPanel();
        
        JButton agregarC = new JButton("columna");
        agregarC.addActionListener(this);
        panel1.add(agregarC);
        
        panel2.setLayout(new GridLayout(4,3,0,0));
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<4;j++)
            {
                panel2.add(boton());
            }
        }
        panelS= new JScrollPane(panel2);
        panelS.createVerticalScrollBar();
        panelS.createHorizontalScrollBar();
        
        this.pantalla.add(panel1,BorderLayout.NORTH);
        this.pantalla.add(panelS,BorderLayout.SOUTH);
        this.pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pantalla.setBounds(50, 50, 1300,700);
        this.pantalla.setVisible(true);
        
    }
    
    JButton boton ()
    {
        JButton b = new JButton();
        return b;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String objeto = e.getSource().toString();
        
        if(objeto.contains("columna")){
            System.out.print("sipirili");
        }
    }
}