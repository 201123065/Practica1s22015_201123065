/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juego.mariomaker.ventana;

import com.juego.mariomaker.framework.Lista;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;

/**
 *
 * @author marcosmayen
 */
public class mOrtogonal extends JFrame implements ActionListener{
    Lista Piso,Pared, Goomba,Koopa,Ficha, Hongo;
    String Mario,Castillo;
    Boolean Tipo;
    
    
    String cadena="";
    int valor=0;
    
    ButtonGroup group;
    public void constructor(Lista Piso,Lista Pared,Lista Goomba,
            Lista Koopa,Lista Ficha,Lista Hongo,
            String Mario,String Castillo){
        this.Piso=Piso;
        this.Pared=Pared;
        this.Goomba=Goomba;
        this.Koopa=Koopa;
        this.Ficha=Ficha;
        this.Hongo=Hongo;
        this.Mario=Mario;
        this.Castillo=Castillo;
    }
    
    public mOrtogonal(Lista Piso,Lista Pared,Lista Goomba,Lista Koopa,
            Lista Ficha,Lista Hongo,String Mario,String Castillo)
    {
        constructor(Piso,Pared, Goomba,Koopa,Ficha, Hongo,Mario,Castillo);
        JToolBar barraHerramientas = new JToolBar();
        
        
       btnFila = new JButton();
        btnColumna = new JButton();
	panel = new JPanel( null );
	//Para que el JFrame cierre la aplicacion
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //elementos del juego
        juegoBotones();
        
        //JRadioButton de pila/Cola 
        
        Pila=new JRadioButton("Pila",true);
        Cola = new JRadioButton("Cola",false);
        Pila.addActionListener(this);
        Pila.setSelected(true);
        Cola.addActionListener(this);
        
        Pila.addActionListener(this);
        
        group = new ButtonGroup();
        group.add(Pila);
        group.add(Cola);
        
        //fin JRadioButton
        Seleccionado = new JLabel("");
	barraHerramientas.add(Pila);
	barraHerramientas.add(Cola);
	barraHerramientas.add(BPiso);
	barraHerramientas.add(BPared);
	barraHerramientas.add(BGoomba);
	barraHerramientas.add(BKoopa);
	barraHerramientas.add(BFicha);
	barraHerramientas.add(BHongo);
	barraHerramientas.add(BMario);
	barraHerramientas.add(BCastillo);
        
        JButton juega = new JButton("INICIA EL JUEGO");
        juega.addActionListener(this);
        
	barraHerramientas.add(juega);
        
        
        
	btnFila.setText("fila");
        btnColumna.setText("columna");
	btnFila.addActionListener(this);
        btnColumna.addActionListener(this);
	barraHerramientas.add(btnFila);
        barraHerramientas.add(btnColumna);
        barraHerramientas.add(Seleccionado);
	//Colocamos el JToolBar en la parte de arriba del JFrame
	this.add(barraHerramientas, BorderLayout.PAGE_START);
	//Se agrega el panel a boton
        this.add(panel, BorderLayout.CENTER);
        this.setSize(410, 330);
	//Permite que la ventana se coloque al centro de la pantalla
	this.setLocationRelativeTo(null);
        botonMat();
        tablaCreciente= new String[columnas+1][filas+1];
        tablaAux=new String [columnas+2][filas+2];
        for(int i=0;i<filas;i++)
        {
            for(int j=0;j<columnas;j++)
            {
                 tablaCreciente[i][j]="-";
                tablaAux[i][j]="-";
            }
        }

    }
    

	public void actionPerformed( ActionEvent evt ) {
            
            
            String objeto = evt.getSource().toString();
            
            String subCadena=objeto.substring(21,objeto.length()-408);
            String SubS[]=subCadena.split(",");
            //posicion X::= SubS[0]
            System.out.println(SubS[1]);
            //Posicion Y::= SubS[1]
            if(objeto.contains("fila")||objeto.contains("columna")){
                if(objeto.contains("fila"))filas++;
                if(objeto.contains("columna"))columnas++;
                panel.removeAll();
                botonMat();
                tablaAux=tablaCreciente;
                tablaCreciente=new String[filas][columnas];
                tablaCreciente=tablaAux;
                tablaAux=new String[filas+1][columnas+1];
                panel.updateUI();
                
            }
            //Piso
            else if(objeto.contains(",126,2,")){
                if(Pila.isSelected())
                    Seleccionado.setText(Piso.inicio.Nombre);
                else
                    Seleccionado.setText(Piso.fin.Nombre);
                valor=0;
            }
            //pared
            else if(objeto.contains(",188,2,")){
            if(Pila.isSelected())
                    Seleccionado.setText(Pared.inicio.Nombre);
                else
                    Seleccionado.setText(Pared.fin.Nombre);
                valor=1;
            }
            //goomba
            else if(objeto.contains(",250,2,")){
            if(Pila.isSelected())
                    Seleccionado.setText(Goomba.inicio.Nombre);
                else
                    Seleccionado.setText(Goomba.fin.Nombre);
                valor=2;
            }
            //koopa
            else if(objeto.contains(",312,2,")){
            if(Pila.isSelected())
                    Seleccionado.setText(Koopa.inicio.Nombre);
                else
                    Seleccionado.setText(Koopa.fin.Nombre);
                valor=3;
            }
            //ficha
            else if(objeto.contains(",374,2,")){
            if(Pila.isSelected())
                    Seleccionado.setText(Ficha.inicio.Nombre);
                else
                    Seleccionado.setText(Ficha.fin.Nombre);
                valor=4;
            }
            //hongo
            else if(objeto.contains(",436,2,")){
            if(Pila.isSelected())
                    Seleccionado.setText(Hongo.inicio.Nombre);
                else
                    Seleccionado.setText(Hongo.fin.Nombre);
                valor=5;
            }
            //mario
            else if(objeto.contains(",498,2,")){
                Seleccionado.setText(Mario);
                valor=6;
            }
            //castillo
            else if(objeto.contains(",560,2,")){
                Seleccionado.setText(Castillo);
                valor=7;
            }
            else if(objeto.contains("INICIA EL JUEGO")){
                this.dispose();
                new Ventana(800,600,"Mario Maker", new Juego());
            }
            else {
                if(Pila.isSelected()){
                    Tipo=true;
                }else
                {
                    Tipo=false;
                }
                if (Seleccionado.getText().equals("")){
                    JOptionPane.showMessageDialog(null,SubS[0]+","+SubS[1]+"no carga porque no \n"
                            + "se le ha asignado ningun dato","advertencia", 2);
                }
                else{
                    int x=Integer.parseInt(SubS[0])/50,y=Integer.parseInt(SubS[1])/50;
                    System.out.println(objeto);
                    if(objeto.contains(SubS[0]+","+SubS[1]))
                    {
                        JOptionPane.showMessageDialog(null,Seleccionado.getText().toString()+"  "+x+","+y,"",2);
                        JButton nuevo= new JButton(evt.getActionCommand());
                        tablaCreciente[y][x]=Seleccionado.getText().toString();
                        Seleccionado.setText("");
                        
                        
                    }
                    else
                        Seleccionado.setText("carita triste");
                   
                }
                
            }
          
	} 
        
        
        
        public ImageIcon icono(int i)
        {
            ImageIcon icon = new ImageIcon(getClass().getResource("/com/juego/mariomaker/personajes/"+retornaNombre(i)));
            Image refac = icon.getImage();
            Image Ima = refac.getScaledInstance(50, 50, java.awt.Image.SCALE_DEFAULT);
            ImageIcon ico = new ImageIcon(Ima);
            return ico;
        }
        
        public void botonMat(){
            for( int fila = 0 ; fila < filas; fila++ )
                {
                    for( int columna = 0 ; columna < columnas; columna++ )
                    {
                        JButton temp = Boton ( 50 * columna, 50 * fila, 50, 50 );
                        temp.addActionListener(this);
                        panel.add(temp);
                    }
                }
        }

        public JButton  Boton( int pos_x, int pos_y, int ancho, int alto )
        { 
            JButton boton = new JButton();
            boton.setBounds(pos_x, pos_y, ancho, alto);
            return boton;
        
        }
        
        
        
        public void juegoBotones(){
            
            
            BPiso = new JButton();
            BPiso.setIcon(icono(0));
            BPiso.addActionListener(this);
            BPared = new JButton();
            BPared.setIcon(icono(1));
            BPared.addActionListener(this);
            BGoomba = new JButton();
            BGoomba.setIcon(icono(2));
            BGoomba.addActionListener(this);
            BKoopa = new JButton();
            BKoopa.setIcon(icono(3));
            BKoopa.addActionListener(this);
            BFicha = new JButton();
            BFicha.setIcon(icono(4));
            BFicha.addActionListener(this);
            BHongo = new JButton();
            BHongo.setIcon(icono(5));
            BHongo.addActionListener(this);
            BMario = new JButton();
            BMario.setIcon(icono(6));
            BMario.addActionListener(this);
            BCastillo = new JButton();
            BCastillo.setIcon(icono(7));
            BCastillo.addActionListener(this);
            
            
            BPiso.setPreferredSize(new Dimension(50, 50));
            BPared.setPreferredSize(new Dimension(50, 50));
            BGoomba.setPreferredSize(new Dimension(50, 50));
            BKoopa.setPreferredSize(new Dimension(50, 50));
            BFicha.setPreferredSize(new Dimension(50, 50));
            BHongo.setPreferredSize(new Dimension(50, 50));
            BMario.setPreferredSize(new Dimension(50, 50));
            BCastillo.setPreferredSize(new Dimension(50, 50));

            
	
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
        
        int filas=3,columnas=4;
	JButton btnFila;
        JButton btnColumna;
	JPanel panel;
        JButton BPiso,BPared,BGoomba,BKoopa,BFicha,BHongo,BMario,BCastillo;
        String temporal;
        JLabel Seleccionado;
        JRadioButton Pila,Cola;
        
        String[][] tablaCreciente;
        String[][] tablaAux;
}