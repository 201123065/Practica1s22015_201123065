/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juego.mariomaker.ventana;

import com.juego.mariomaker.framework.Lista;
import com.juego.mariomaker.framework.Textos;
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
    JButton ploteo;
    
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
        
        
        
        ploteo = new JButton("Graficar");
        ploteo.addActionListener(this);
	btnFila.setText("fila");
        btnColumna.setText("columna");
	btnFila.addActionListener(this);
        btnColumna.addActionListener(this);
        
	barraHerramientas.add(btnFila);
        barraHerramientas.add(btnColumna);
        barraHerramientas.add(ploteo);
	barraHerramientas.add(juega);
        barraHerramientas.add(Seleccionado);
	//Colocamos el JToolBar en la parte de arriba del JFrame
	this.add(barraHerramientas, BorderLayout.PAGE_START);
	//Se agrega el panel a boton
        this.add(panel, BorderLayout.CENTER);
        this.setSize(410, 330);
	//Permite que la ventana se coloque al centro de la pantalla
	this.setLocationRelativeTo(null);
        
        tablaCreciente= new String[columnas][filas];
        tablaAux=new String [columnas][filas];
        for(int i=0;i<filas;i++)
        {
            for(int j=0;j<columnas;j++)
            {
                tablaCreciente[j][i]="-";
                tablaAux[j][i]="-";
            }
        }
        botonMat(valor);

    }
    
	public void actionPerformed( ActionEvent evt ) {
            
            try{
            String objeto = evt.getSource().toString();
            
            String subCadena=objeto.substring(21,objeto.length()-408);
            String SubS[]=subCadena.split(",");
            //posicion X::= SubS[0]
            
                if(objeto.contains("fila")||objeto.contains("columna")){
                    for(int i=0;i<filas;i++){
                        for(int j=0;j<columnas;j++){
                            tablaAux[j][i]=tablaCreciente[j][i];
                        }
                    }
                    if(objeto.contains("fila"))filas++;
                    if(objeto.contains("columna"))columnas++;
                    botonMat(valor);
                    tablaCreciente=new String[columnas][filas];
                    for(int i=0;i<filas;i++){
                        for(int j=0;j<columnas;j++){
                            tablaCreciente[j][i]="-";
                        }
                    }
                    if(filas>f){
                        for(int i=0;i<f;i++){
                            for(int j=0;j<columnas;j++){
                                tablaCreciente[j][i]=tablaAux[j][i];
                            }
                        }
                    }
                    else{
                        for(int i=0;i<filas;i++){
                            for(int j=0;j<c;j++){
                                tablaCreciente[j][i]=tablaAux[j][i];
                            }
                        }
                    }
                     c=columnas;
                     f=filas;

                    tablaAux=new String[columnas][filas];
                }
                else if(objeto.contains("Graficar")){
                    GraficarDOT();
                }
                //Piso
                else if(objeto.contains(",126,2,")){
                    valor=0;
                    if(Pila.isSelected())
                        Seleccionado.setText(Piso.inicio.Nombre);
                    else
                        Seleccionado.setText(Piso.fin.Nombre);
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
                            tablaCreciente[x][y]=Seleccionado.getText().toString()+","+valor;
                            Seleccionado.setText("");
                            for(int i=0;i<filas;i++)
                            {
                                for(int j=0;j<columnas;j++){
                                    System.out.print(tablaCreciente[j][i]);
                                }
                                System.out.print("\n");
                            }
                            botonMat(valor);
                        }
                        else
                            Seleccionado.setText("carita triste");
                        
                        vaciarPilaCola(valor);

                    }

                }
            }catch(Exception e){}
          
	} 
        
        
        
        public ImageIcon icono(int i)
        {
            ImageIcon icon = new ImageIcon(getClass().getResource("/com/juego/mariomaker/personajes/"+retornaNombre(i)));
            Image refac = icon.getImage();
            Image Ima = refac.getScaledInstance(50, 50, java.awt.Image.SCALE_DEFAULT);
            ImageIcon ico = new ImageIcon(Ima);
            return ico;
        }
        
        public void botonMat(int i){
            panel.removeAll();
            if(filas>f){
                for( int fila = 0 ; fila < filas; fila++ )
                {
                    for( int columna = 0 ; columna < columnas; columna++ )
                    {
                        if(fila==filas-1){
                            JButton temp = Boton ( 50 * columna, 50 * fila, 50, 50 ,false,10);
                            temp.addActionListener(this);
                            panel.add(temp);
                        }else{
                            if(tablaCreciente[columna][fila]=="-"){
                                JButton temp = Boton ( 50 * columna, 50 * fila, 50, 50 ,false,10);
                                temp.addActionListener(this);
                                panel.add(temp);
                            }
                            else{
                                String []cadena= new String[2];
                                cadena=tablaCreciente[columna][fila].split(",");
                                
                                System.out.println("+++"+cadena[0]+"+++"+cadena[1]);
                                int v= Integer.parseInt(cadena[1]);
                                JButton temp = Boton ( 50 * columna, 50 * fila, 50, 50 ,true,v);
                                temp.addActionListener(this);
                                panel.add(temp);
                            }
                        }
                    }
                }
            }
            else if(columnas >c){
                for( int fila = 0 ; fila < filas; fila++ )
                {
                    for( int columna = 0 ; columna < columnas; columna++ )
                    {
                        if(columna==columnas-1){
                            JButton temp = Boton ( 50 * columna, 50 * fila, 50, 50 ,false,10);
                            temp.addActionListener(this);
                            panel.add(temp);
                        }else{
                            if(tablaCreciente[columna][fila]=="-"){
                                JButton temp = Boton ( 50 * columna, 50 * fila, 50, 50 ,false,10);
                                temp.addActionListener(this);
                                panel.add(temp);
                            }
                            else{
                                 String []cadena= new String[2];
                                cadena=tablaCreciente[columna][fila].split(",");                                
                                int v= Integer.parseInt(cadena[1]);
                                JButton temp = Boton ( 50 * columna, 50 * fila, 50, 50 ,true,v);
                                temp.addActionListener(this);
                                panel.add(temp);
                            }
                        }
                    }
                }
                
            }
            else{
                for( int fila = 0 ; fila < filas; fila++ )
                {
                    for( int columna = 0 ; columna < columnas; columna++ )
                    {
                        if(tablaCreciente[columna][fila]=="-"){
                                JButton temp = Boton ( 50 * columna, 50 * fila, 50, 50 ,false,10);
                                temp.addActionListener(this);
                                panel.add(temp);
                            }
                            else{
                                String []cadena= new String[2];
                                cadena=tablaCreciente[columna][fila].split(",");
                                
                                int v= Integer.parseInt(cadena[1]);
                                JButton temp = Boton ( 50 * columna, 50 * fila, 50, 50 ,true,v);
                                temp.addActionListener(this);
                                panel.add(temp);
                            }
                    }
                }
                
            }
            panel.updateUI();
        }

        public void vaciarPilaCola(int i){
            if(Pila.isSelected()){
                System.out.print("este es pila "+valor);
                switch (valor){
                    case 0:
                        Piso.EliminarInicio();
                        break;
                    case 1:
                        Pared.EliminarInicio();
                        break;
                    case 3:
                        Koopa.EliminarInicio();
                        break;
                    case 4:
                        Ficha.EliminarInicio();
                        break;
                    case 5:
                        Hongo.EliminarInicio();
                        break;
                    case 6:
                        Mario="";
                        break;
                    case 7:
                        Castillo="";
                        break;
                    case 2:
                        Goomba.EliminarInicio();
                        break;
                }
            }else{
                switch (valor){
                    case 0:
                        Piso.EliminarFin();
                        break;
                    case 1:
                        Pared.EliminarFin();
                        break;
                    case 2:
                        Goomba.EliminarFin();
                        break;
                    case 3:
                        Koopa.EliminarFin();
                        break;
                    case 4:
                        Ficha.EliminarFin();
                        break;
                    case 5:
                        Hongo.EliminarFin();
                        break;
                    case 6:
                        Mario="";
                        break;
                    case 7:
                        Castillo="";
                        break;
                }
            }
        }
        
        
        
        public JButton  Boton( int pos_x, int pos_y, int ancho, int alto,boolean imagen ,int i)
        { 
            JButton boton = new JButton();
            boton.setBounds(pos_x, pos_y, ancho, alto);
            if(imagen){
                boton.setIcon(icono(i));
            }
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
                return "marioR.gif";
            case 7:
                return "castillo.png";
            default:
                System.out.print("llegamos");
                return null;
              
        }
        
        
    }
        public void GraficarDOT(){
            String texto="digraph G {\n";
            String conecta="";
            for(int i=0;i<filas-1;i++){
                for(int j=0;j<columnas-1;j++){
                    conecta=conecta+tablaCreciente[j][i]+"->"+tablaCreciente[j+1][i]+";\n";
                    conecta=conecta+tablaCreciente[j+1][i]+"->"+tablaCreciente[j][i]+";\n";
                }
                for(int j=0;j<columnas-1;j++){
                    conecta=conecta+tablaCreciente[j][i]+"->"+tablaCreciente[j][i+1]+";\n";
                    conecta=conecta+tablaCreciente[j][i+1]+"->"+tablaCreciente[j][i]+";\n";
                }
            }
            texto=texto+conecta+"}";
        
        String ruta = getClass().getResource("/com/juego/mariomaker/objetos/")+"ortogonal.dot";
        Textos op = new Textos();
        op.escribir("src/com/juego/mariomaker/objetos/ortogonal.dot", texto);
        PloteoGraphviz ploteo = new PloteoGraphviz();
        ploteo.GraficarJugadores("ortogonal.dot");
            
        }
        int filas=3,columnas=4;
        int c=columnas, f=filas;
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