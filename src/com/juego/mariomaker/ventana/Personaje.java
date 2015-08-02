
package com.juego.mariomaker.ventana;

import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Personaje implements ActionListener,FocusListener{
    String Listado[]= new String[8];
    
    
    void init()
    {
        for (int i=0;i<8;i++)
        {
            Listado[i]="";
        }
    }
    
    public Personaje()
    {
        JFrame pantalla = new JFrame("Mario Maker/Personajes");
        pantalla.setSize(1000,700);
        pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.white);
        
        //agrego matriz de JLabels
        
        for (int i=0;i<8;i++){
            panel.add(llenarMenu(i));
            panel.add(texto(i));
            panel.add(boton(i));
            panel.add(visualizar(i));
        }
        
        //agregar campos textfield
       
        //boton para cargar 
        JButton cargarP = new JButton("cargar pantalla");
        cargarP.addActionListener(this);
        cargarP.setBounds(800, 500, 100, 100);
        panel.add(cargarP);
        
        pantalla.add(panel);
        pantalla.setVisible(true);
    }
    
    
    public JTextField texto(int i)
    {
        JTextField nuevo= new JTextField();
        nuevo.setBounds(100, i*70+50, 500, 50);
        nuevo.addFocusListener(this);
        return nuevo;
        
    }
    public JLabel llenarMenu(int i)
    {
        JLabel nuevo = new JLabel();
        if(i<8){
            ImageIcon icon = new ImageIcon(getClass().getResource("/com/juego/mariomaker/personajes/"+retornaNombre(i)));
            

            Image refac = icon.getImage();
            Image Ima = refac.getScaledInstance(50, 50, java.awt.Image.SCALE_DEFAULT);
            ImageIcon ico = new ImageIcon(Ima);
            /**/
            nuevo.setIcon(ico);
            nuevo.setBounds(20, i*70+50, 50, 50);
            
         }
        return nuevo;
    }
    
    public String retornaNombre(int valor){
        switch (valor){
            case 0:
                return "piso.png";
            case 1:
                return "pared.png";
            case 2:
                return "goomba.png";
            case 3:
                return "koopa.gif";
            case 4:
                return "moneda.png";
            case 5:
                return "hongo.png";
            case 6:
                return "marior.gif";
            case 7:
                return "castillo.png";
            default:
                System.out.print("llegamos");
                return null;
              
        }
    }
    
    public Button boton(int i)
    {
        Button boton= new Button("+");
        boton.setBounds(630, i*70+50, 50, 50);
        boton.addActionListener(this);
        return boton;
    }
    public JButton visualizar(int i)
    {
        ImageIcon icon = new ImageIcon(getClass().getResource("/com/juego/mariomaker/personajes/eye.png"));
        Image refac = icon.getImage();
        Image Ima = refac.getScaledInstance(40, 40, java.awt.Image.SCALE_DEFAULT);
        Icon ico = new ImageIcon(Ima);
        
        
        JButton boton= new JButton(ico);
        
        boton.setBounds(690, i*70+50, 50, 50);
        boton.addActionListener(this);
        return boton;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String objeto = e.getSource().toString();
        int i=0;
              if(objeto.contains("630,50,")) i=0;
        else if(objeto.contains("630,120,")) i=1;
        else if(objeto.contains("630,190,")) i=2;
        else if(objeto.contains("630,260,")) i=3;
        else if(objeto.contains("630,330,")) i=4;
        else if(objeto.contains("630,400,")) i=5;
        else if(objeto.contains("630,470,")) i=6;
        else if(objeto.contains("630,540,")) i=7;
         //----------------------------retorno de valor del carro--------------     
        
        System.out.println(objeto);
        
    }
    public void retornaC(int i){
        switch (i){
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            
        }
                
    }
    
    @Override
    public void focusGained(FocusEvent e) {
        
    }
    @Override
    public void focusLost(FocusEvent e) {
        JTextField campo =(JTextField)e.getSource();
        if(campo.getText().equals("")||campo.getText().equals(null)){
            
        }else{
            String guarda = campo.getText();

            int i=7;
                  if(e.paramString().contains("100,50,"))   i=0;
            else if(e.paramString().contains("100,120,"))   i=1;
            else if(e.paramString().contains("100,190,"))   i=2;
            else if(e.paramString().contains("100,260,"))   i=3;
            else if(e.paramString().contains("100,330,"))   i=4;
            else if(e.paramString().contains("100,400,"))   i=5;
            else if(e.paramString().contains("100,470,"))   i=6;
            else if(e.paramString().contains("100,540,"))   i=7;
            Listado[i]=guarda;
            System.out.println(guarda);
        }
    }
    
}
