
package com.juego.mariomaker.ventana;

import com.juego.mariomaker.framework.KeyInput;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import com.juego.mariomaker.framework.Lista;

public class Personaje  implements ActionListener,FocusListener {
    String Listado[][]= new String[8][4];
    int ID=0;
    Lista Piso,Pared,Goomba,Koopa,Ficha,Hongo;
    
    String Mario,Castillo;
    JLabel etiqueta;
    JTextField editor;
    
    
    void init()
    {
        for (int i=0;i<8;i++)
        {
            for(int j=0;j<4;j++)
            {
                Listado[i][j]="";
            }
        }
        Piso = new Lista();
        Pared = new Lista();
        Goomba = new Lista();
        Koopa = new Lista();
        Ficha = new Lista();
        Hongo = new Lista();
        
        
        
    }
    
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
        panel.add(JLabelDinamico(0));
        pantalla.add(panel);
        pantalla.setVisible(true);
    }
    /*este JLABELDINAMICO lo que hace es que muestra los objetos que se tienen en la lista*/
   public JLabel JLabelDinamico(int i){
       ImageIcon icon = new ImageIcon(getClass().getResource("/com/juego/mariomaker/personajes/"+retornaNombre(i)));
        Image refac = icon.getImage();
        Image Ima = refac.getScaledInstance(50, 50, java.awt.Image.SCALE_DEFAULT);
        ImageIcon ico = new ImageIcon(Ima);
            /**/
           
       etiqueta = new JLabel();
       etiqueta.setBounds(800, 50, 500, 500);
       return etiqueta;
   }
   
   
   
    
    public JTextField texto(int i)
    {
        JTextField nuevo= new JTextField();
        nuevo.setBounds(100, i*70+50, 500, 50);
        nuevo.addFocusListener(this);
        return nuevo;
        
    }
    
    //menu de imagenes
    public JLabel llenarMenu(int i){
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
    
    //nombre para el menu de imagenes
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
    
    //listado de botones agregar
    public Button boton(int i){
        Button boton= new Button("+");
        boton.setBounds(630, i*70+50, 50, 50);
        boton.addActionListener(this);
        return boton;
    }
    
    //listado de botones ojito/visualizar
    public JButton anterior(int i){
        
        JButton boton= new JButton("<<");
        
        boton.setBounds(690, i*70+50, 50, 50);
        boton.addActionListener(this);
        return boton;
    }
    public JButton Siguiente(int i)
    {
        JButton boton= new JButton(">>"); 
        boton.setBounds(740, i*70+50, 50, 50);
        boton.addActionListener(this);
        return boton;
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
        if(!campo.getText().equals("")){
            String guarda = campo.getText();

            int i=-1;
                  if(e.toString().contains("100,50,")) i=0;
            else if(e.toString().contains("100,120,")) i=1;
            else if(e.toString().contains("100,190,")) i=2;
            else if(e.toString().contains("100,260,")) i=3;
            else if(e.toString().contains("100,330,")) i=4;
            else if(e.toString().contains("100,400,")) i=5;
            else if(e.toString().contains("100,470,")) i=6;
            else if(e.toString().contains("100,540,")) i=7;
            Listado[i][0]=ID+"";
            Listado[i][1]=guarda;
            Listado[i][2]=getClass().getResource("/com/juego/mariomaker/personajes/"+retornaNombre(i)).toString();
            Listado[i][3]=retornaNombre(i).toString();
            ID++;
            //System.out.println(Listado[i][0]+Listado[i][1]+Listado[i][2]+Listado[i][3]);
        }
    }
    
    
     @Override
     //accion de boton
    public void actionPerformed(ActionEvent e) {
        String objeto = e.getSource().toString();
        int i=-1;
        //agregar 
              if(objeto.contains("630,50,")) i=0;  //pared
        else if(objeto.contains("630,120,")) i=1;  //suelo
        else if(objeto.contains("630,190,")) i=2;  //goomba
        else if(objeto.contains("630,260,")) i=3;  //koopa
        else if(objeto.contains("630,330,")) i=4;  //ficha
        else if(objeto.contains("630,400,")) i=5;  //hongo
        else if(objeto.contains("630,470,")) i=6;  //mario
        else if(objeto.contains("630,540,")) i=7;  //castillo
        
        //<<
        else if(objeto.contains("690,50,"))  i=8;  //verPared
        else if(objeto.contains("690,120,")) i=9;  //verSuelo
        else if(objeto.contains("690,190,")) i=10; //verGoomba
        else if(objeto.contains("690,260,")) i=11; //verKoopa
        else if(objeto.contains("690,330,")) i=12; //verFicha
        else if(objeto.contains("690,400,")) i=13; //verHongo
        else if(objeto.contains("690,470,")) i=14; //verMario
        else if(objeto.contains("690,540,")) i=15; //verCastillo
        //>>
        
        else if(objeto.contains("740,50,"))  i=16;  //verPared
        else if(objeto.contains("740,120,")) i=17;  //verSuelo
        else if(objeto.contains("740,190,")) i=18; //verGoomba
        else if(objeto.contains("740,260,")) i=19; //verKoopa
        else if(objeto.contains("740,330,")) i=20; //verFicha
        else if(objeto.contains("740,400,")) i=21; //verHongo
        else if(objeto.contains("740,470,")) i=22; //verMario
        else if(objeto.contains("740,540,")) i=23; //verCastillo
        
        
        //funcion siguiente
        //modificar
        else if(objeto.contains("modificar"))i=24; //Modificar del nodo
        //eliminar
        else if(objeto.contains("eliminar")) i=25; //Eliminar  del nodo
        //cargar escenario
        else if(objeto.contains("cargar"))   i=26; //sigueinte pantalla
        
        accion(i);
         //----------------------------retorno de valor del carro--------------     
        
    }
    Lista valor=new Lista();
    
    public void accion(int i){
        if(i<8)
        {
            if(Listado[i][1].equals(""))
            {
                JOptionPane.showMessageDialog(null,"la casilla esta vacia", "casilla", 3);
            }
            else
            {
                System.out.println(Listado[i][1]);
                try{
                    
                    if (RegistrarNodo(Listado[i][0],Listado[i][1],Listado[i][2],Listado[i][3])){
                    }
                }catch(Exception e){}
            }
        }else if(i<16){
            
            verificarA(i-8);
        }
        else if(i<24)
        {
            verificarS(i-16);
        }
    }
    
    
    public void verificarA(int i)
    {
        String cadena="";
        //Piso,Pared,Goomba,Koopa,Ficha,Hongo;
        String imagen = getClass().getResource("/com/juego/mariomaker/personajes/"+retornaNombre(i)).toString();
        try{
            switch(i)
            { 
                case 0:
                    cadena=Piso.retornarValorAnterior().Nombre;
                    break;
                case 1:
                    cadena=Pared.retornarValorAnterior().Nombre;
                    break;
                case 2:
                    cadena=Goomba.retornarValorAnterior().Nombre;
                    break;
                case 3:
                    cadena=Koopa.retornarValorAnterior().Nombre;
                    break;
                case 4:
                    cadena=Ficha.retornarValorAnterior().Nombre;
                    break;
                case 5:
                    cadena=Hongo.retornarValorAnterior().Nombre;
                    break;
                case 6:
                    cadena=Mario;
                    JOptionPane.showMessageDialog(null, Mario+"ha sido agregado con exito","Personaje",3);
                    
                    break;
                case 7:
                    cadena=Castillo;
                    JOptionPane.showMessageDialog(null,  Castillo+"ha sido agregado con exito","Informacion",3);
                    break;
                default: 
                    JOptionPane.showMessageDialog(null, "error","error",3);
                    break;
            }      
            ImageIcon icon = new ImageIcon(getClass().getResource("/com/juego/mariomaker/personajes/"+retornaNombre(i)));
            Image refac = icon.getImage();
            Image Ima = refac.getScaledInstance(500, 500, java.awt.Image.SCALE_DEFAULT);
            ImageIcon ico = new ImageIcon(Ima);
                /**/
           etiqueta.setIcon(ico);
           etiqueta.setBounds(800, 50, 500, 500);
           editor.setText(cadena);
           
        }catch(Exception e){}
    }
    
    public void verificarS(int i)
    {
        String cadena="";
        //Piso,Pared,Goomba,Koopa,Ficha,Hongo;
        String imagen = getClass().getResource("/com/juego/mariomaker/personajes/"+retornaNombre(i)).toString();
        try{
            switch(i)
            { 
                case 0:
                    cadena=Piso.retornarValorSiguiente().Nombre;
                    break;
                case 1:
                    cadena=Pared.retornarValorSiguiente().Nombre;
                    break;
                case 2:
                    cadena=Goomba.retornarValorSiguiente().Nombre;
                    break;
                case 3:
                    cadena=Koopa.retornarValorSiguiente().Nombre;
                    break;
                case 4:
                    cadena=Ficha.retornarValorSiguiente().Nombre;
                    break;
                case 5:
                    cadena=Hongo.retornarValorSiguiente().Nombre;
                    break;
                case 6:
                    cadena=Mario;
                    JOptionPane.showMessageDialog(null, Mario+"ha sido agregado con exito","Personaje",3);
                    
                    break;
                case 7:
                    cadena=Castillo;
                    JOptionPane.showMessageDialog(null,  Castillo+"ha sido agregado con exito","Informacion",3);
                    break;
                default: 
                    JOptionPane.showMessageDialog(null, "error","error",3);
                    break;
            }
            ImageIcon icon = new ImageIcon(getClass().getResource("/com/juego/mariomaker/personajes/"+retornaNombre(i)));
            Image refac = icon.getImage();
            Image Ima = refac.getScaledInstance(500, 500, java.awt.Image.SCALE_DEFAULT);
            ImageIcon ico = new ImageIcon(Ima);
                /**/
           etiqueta.setIcon(ico);
           etiqueta.setBounds(800, 50, 500, 500);
           editor.setText(cadena);
            
            
        }catch(Exception e){}
    }
    
    public void PaintComponent()
    {
        
    }
    
    
    
    
    public boolean RegistrarNodo(String id,String nombre, String imagen,String tipo)
    {
        if(tipo== "piso.png")
            Piso.AgregaFinal(id, nombre, imagen);
        else if(tipo== "pared.png")
            Pared.AgregaFinal(id, nombre, imagen);
        else if(tipo== "goomba.png")
            Goomba.AgregaFinal(id, nombre, imagen);
        else if(tipo== "koopa.gif")
            Koopa.AgregaFinal(id, nombre, imagen);
        else if(tipo== "moneda.png")
            Ficha.AgregaFinal(id, nombre, imagen);
        else if(tipo== "hongo.png")
            Hongo.AgregaFinal(id, nombre, imagen);
        else if(tipo== "marior.gif")
             Mario=nombre;
        else if(tipo== "castillo.png")
            Castillo=nombre;
        else 
        {   
            JOptionPane.showMessageDialog(null, "que pedo, error :=","exito",3);
            return false;
        }
        return true;
    }
    
    public String [] RevisarNodo(int tipo)
    {
        
        String id, nombre, imagen;
        switch (tipo){
            case 0:
                System.out.print(Piso.retornarValorSiguiente().Nombre);
                break;
            case 1:
                System.out.print(Pared.retornarValorSiguiente().Nombre);
                break;
            case 2:
                System.out.print(Goomba.retornarValorSiguiente().Nombre);
                break;
            case 3:
                System.out.print(Koopa.retornarValorSiguiente().Nombre);
                break;
            case 4:
                System.out.print(Ficha.retornarValorSiguiente().Nombre);
                break;
            case 5:
                System.out.print(Hongo.retornarValorSiguiente().Nombre);
                break;
            case 6:
                System.out.print(Mario);
                break;
            case 7:
                System.out.print(Castillo);
                break;
            
        }
         
        return new String []{""};
    }
    
    
    
    /*
    
    ojo, me quede verificando los returns, por si se me olvida!!!...
    
    
    
    */
    
}
