
package com.juego.mariomaker.ventana;

import com.juego.mariomaker.framework.Lista;
import javax.swing.JFrame;


public class mOrtogonal {
    
    public mOrtogonal(Lista Piso, Lista Pared,Lista Goomba,Lista Koopa,Lista Ficha, Lista Hongo,String Mario, String Castillo){
        JFrame pantalla = new JFrame("Mario Maker/Creador de mundo");
    }
    
    
    /*
    public Personaje()
    {
        init();
        //constructor para crea la pantalla
        JFrame pantalla = new JFrame("Mario Maker/Personajes");
        //tamaño 
        pantalla.setSize(1350,700);
        //opcion de cerrar
        pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //panel para colocar botones/labels sin tener problemas con el tamaño
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.white);
        
        //agrego matriz de JLabels
        for (int i=0;i<8;i++){
            //imagenes de los personajes
            panel.add(llenarMenu(i));
            //jtextfields para agregar datos
            panel.add(texto(i));
            //botones de carga
            panel.add(boton(i));
            
            /*------------------inicio------------------------*/
            panel.add(anterior(i));
            panel.add(Siguiente(i));
            /*----------------fin--------------------------*/
            
        }
        
        //agregar campos textfield
       //boton de siguiente/anterior
       
       //jtexfield para modificar personaje.
       editor = new JTextField();
       editor.setBounds(900, 570, 200, 30);
       
       //boton permite editar
       JButton editaB= new JButton("modificar");
       editaB.setBounds(800, 570, 100, 30);
       editaB.addActionListener(this);
       
       //boton eliminar nodo
       JButton eliminar = new JButton("eliminar");
       eliminar.setBounds(1120, 570, 100, 30);
       eliminar.addActionListener(this);
       panel.add(eliminar);
       panel.add(editaB);
       panel.add(editor);
       
       
        //boton para cargar 
        JButton cargarP = new JButton("cargar pantalla");
        cargarP.addActionListener(this);
        cargarP.setBounds(1050, 600, 150, 50);
        panel.add(cargarP);
        
        JButton verNodo = new JButton("ver nodo");
        verNodo.addActionListener(this);
        verNodo.setBounds(900, 600, 150, 50);
        panel.add(verNodo);
                
        panel.add(JLabelDinamico(0));
        pantalla.add(panel);
        pantalla.setVisible(true);
    }
    
    */
    
}
