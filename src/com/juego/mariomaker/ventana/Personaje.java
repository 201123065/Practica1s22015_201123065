
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
import com.juego.mariomaker.framework.Textos;

public class Personaje  implements ActionListener,FocusListener {
    String Listado[][]= new String[8][4];
    int ID=0;
    int dato=0;
    Lista Piso,Pared,Goomba,Koopa,Ficha,Hongo;
    String TextoTemp, Mario="",Castillo="";
    JLabel etiqueta;
    JTextField editor;
    String cadena="";
    JFrame pantalla;
    
    
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
        pantalla = new JFrame("Mario Maker/Personajes");
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
  
    public JTextField texto(int i){
        JTextField nuevo= new JTextField("prueba");
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
    public JButton Siguiente(int i){
        JButton boton= new JButton(">>"); 
        boton.setBounds(740, i*70+50, 50, 50);
        boton.addActionListener(this);
        return boton;
    }
    
    @Override
    public void focusGained(FocusEvent e) {
        
    }
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
            Listado[i][0]=dato+"";
            Listado[i][1]=guarda;
            Listado[i][2]=getClass().getResource("/com/juego/mariomaker/personajes/"+retornaNombre(i)).toString();
            Listado[i][3]=retornaNombre(i).toString();
            dato++;
        }
    }
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
        
        //modificar
        else if(objeto.contains("modificar"))i=24; //Modificar del nodo
        //eliminar
        else if(objeto.contains("eliminar")) i=25; //Eliminar  del nodo
        //cargar escenario
        else if(objeto.contains("cargar"))   i=27; //sigueinte pantalla
        else if(objeto.contains("ver nodo")) i=26;
        accion(i);
         //----------------------------retorno de valor del carro--------------     
        
    }
    Lista valor=new Lista();
    
    
     /*
    ------------------------------------------------------------------------ 
    |                                                                      |
    |    esta seccion es para delimitar que estoy aca haciendo pruebas     | 
    |                                                                      |
    |______________________________________________________________________|
    */
    
    
    public void accion(int i){
        if(i<8)
        {
            if(Listado[i][1].equals(""))
            {
                JOptionPane.showMessageDialog(null,"la casilla esta vacia", "casilla", 3);
            }
            else
            {
                try{
                    
                    if (RegistrarNodo(Listado[i][0],Listado[i][1],Listado[i][2],Listado[i][3])){
                    }
                }catch(Exception e){}
            }
        }else if(i<16){
            verificarA(i-8);
            TextoTemp=editor.getText();
        }
        else if(i<24)
        {
            verificarS(i-16);
            TextoTemp=editor.getText();
        }
        else if(i==24)
        {
            modificar(editor.getText());
        }else if(i==25)
        {
            eliminar();
        }
        else if(i==26)
        {
            verPLOT();
        }
        else if(i==27){
            if(Piso!=null && Pared!=null && Goomba!=null && Koopa!=null && Ficha!=null && Hongo!=null && Mario!="" && Castillo!=""  ){
                mOrtogonal ventanaN = new mOrtogonal(Piso,Pared,Goomba,Koopa,Ficha,Hongo,Mario,Castillo);
                ventanaN.setBounds(100, 50, 1500, 700);
                ventanaN.setVisible(true);
                
                
                this.pantalla.dispose();
            }else{JOptionPane.showMessageDialog(null, "por favor revise que cada nodo contenga al menos 1 objeto","error",2);}
        }
    }
     /*
    ------------------------------------------------------------------------ 
    |                                                                      |
    |    esta seccion es para delimitar que estoy aca haciendo pruebas     | 
    |                                                                      |
    |______________________________________________________________________|
    */
    
    
    public void verPLOT(){
        String texto="digraph G {\n" +
        "nodesep=.05;\n" +
        "rankdir=LR;\n" +
        " node [shape=record,width=.1,height=.1];\n" +
        "\n" +
        " node0 [label = \"<f0> Piso|<f1> Pared|<f2>Goomba |<f3> Koopa|<f4> Ficha|<f5>Hongo |<f6>Mario |<f7>Castillo| \",height=2.5];\n" +
        " node [width = 1.5];";
        String floor,wall,gom,koo,coin,toad,player,flag;
        floor = "node1 "+Piso.mostrarListaIF()+"\n";
        wall = "node2 "+Pared.mostrarListaIF()+"\n";
        gom = "node3 "+Goomba.mostrarListaIF()+"\n";
        koo = "node4 "+Koopa.mostrarListaIF()+"\n";
        coin = "node5 "+Ficha.mostrarListaIF()+"\n";
        toad="node6 "+Hongo.mostrarListaIF()+"\n";
        player="node7 [label=\"{ "+Mario+" }\"];\n";
        flag="node8 [label=\"{ "+Castillo+" }\"];\n";
        texto=texto+floor+wall+gom+koo+coin+toad+player+flag+"\n";
        texto = texto +"node0:f0 -> node1:n;\n" +
        " node0:f1 -> node1:n;\n" +
        " node0:f2 -> node2:n;\n" +
        " node0:f3 -> node3:n;\n" +
        " node0:f4 -> node4:n;\n" +
        " node0:f5 -> node5:n;\n" +
        " node0:f6 -> node6:n;\n" +
        " node0:f7 -> node7:n;\n" +
        " node0:f8 -> node8:n;\n}";
        System.out.print(texto);
        String ruta = getClass().getResource("/com/juego/mariomaker/objetos/")+"ploteo.dot";
        Textos op = new Textos();
        op.escribir("src/com/juego/mariomaker/objetos/plot.dot", texto);
        PloteoGraphviz ploteo = new PloteoGraphviz();
        ploteo.GraficarJugadores("plot.dot");
    }
    
    public void verificarA(int i){
        //Piso,Pared,Goomba,Koopa,Ficha,Hongo;
        String imagen = getClass().getResource("/com/juego/mariomaker/personajes/"+retornaNombre(i)).toString();
        try{
            switch(i)
            { 
                case 0:
                    if(Piso.retornarValorAnterior()!=null)
                        cadena=Piso.aux.Nombre;
                    ID=0;
                    break;
                case 1:
                    if(Pared.retornarValorAnterior()!=null)
                        cadena=Pared.aux.Nombre;
                    ID=1;
                    break;
                case 2:
                    if(Goomba.retornarValorAnterior()!=null)
                        cadena=Goomba.aux.Nombre;
                    ID=2;
                    break;
                case 3:
                    if(Koopa.retornarValorAnterior()!=null)
                        cadena=Koopa.aux.Nombre;
                    ID=3;
                    break;
                case 4:
                    if(Ficha.retornarValorAnterior()!=null)
                        cadena=Ficha.aux.Nombre;
                    ID=4;
                    break;
                case 5:
                    if(Hongo.retornarValorAnterior()!=null)
                        cadena=Hongo.aux.Nombre;
                    ID=5;
                    break;
                case 6:
                    cadena=Mario;
                    ID=6;
                    JOptionPane.showMessageDialog(null, Mario+"ha sido agregado con exito","Personaje",3);
                    break;
                case 7:
                    ID=7;
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
    
    public void verificarS(int i){
        String imagen = getClass().getResource("/com/juego/mariomaker/personajes/"+retornaNombre(i)).toString();
        try{
            switch(i)
            { 
                case 0:
                    if(Piso.retornarValorSiguiente()!=null)
                        cadena=Piso.aux.Nombre;
                    ID=0;
                    break;
                case 1:
                    if(Pared.retornarValorSiguiente()!=null)
                        cadena=Pared.aux.Nombre;
                    ID=1;
                    break;
                case 2:
                    if(Goomba.retornarValorSiguiente()!=null)
                        cadena=Goomba.aux.Nombre;
                    ID=2;
                    break;
                case 3:
                    if(Koopa.retornarValorSiguiente()!=null)
                        cadena=Koopa.aux.Nombre;
                    ID=3;
                    break;
                case 4:
                    if(Ficha.retornarValorSiguiente()!=null)
                        cadena=Ficha.aux.Nombre;
                    ID=4;
                    break;
                case 5:
                    if(Hongo.retornarValorSiguiente()!=null)
                    ID=5;
                    break;
                case 6:
                    cadena=Mario;
                    JOptionPane.showMessageDialog(null, Mario+"ha sido agregado con exito","Personaje",3);
                    ID=6;
                    break;
                case 7:
                    cadena=Castillo;
                    JOptionPane.showMessageDialog(null,  Castillo+"ha sido agregado con exito","Informacion",3);
                    ID=7;
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
    
    public void modificar(String cadenas){
        try{
        switch (ID)
        {
             case 0:
                    Piso.ModificarDato(Piso.aux.ID,Piso.aux.Nombre, cadenas);
                    break;
                case 1:
                    Pared.ModificarDato(Pared.aux.ID, Pared.aux.Nombre,cadenas);
                    break;
                case 2:
                    Goomba.ModificarDato(Goomba.aux.ID,Goomba.aux.Nombre, cadenas);
                    break;
                case 3:
                    Koopa.ModificarDato(Koopa.aux.ID, Koopa.aux.Nombre,cadenas);
                    break;
                case 4:
                    Ficha.ModificarDato(Ficha.aux.ID,Ficha.aux.Nombre, cadenas);
                    break;
                case 5:
                    Hongo.ModificarDato(Hongo.aux.ID,Hongo.aux.Nombre, cadenas);
                    break;
                case 6:
                    cadena=Mario;
                    JOptionPane.showMessageDialog(null, Mario+"ha sido agregado con exito","Personaje",3);
                    break;
                case 7:
                    Mario=cadena;
                    break;
        }
        
        }catch(Exception e){}
    }
    
    public void eliminar(){
        try{
        switch (ID)
        {
             case 0:
                    Piso.EliminarDato(Piso.aux.ID, Piso.aux.Nombre);
                    break;
                case 1:
                    Pared.EliminarDato(Pared.aux.ID, Pared.aux.Nombre);
                    break;
                case 2:
                    Goomba.EliminarDato(Goomba.aux.ID,Goomba.aux.Nombre);
                    break;
                case 3:
                    Koopa.EliminarDato(Koopa.aux.ID, Koopa.aux.Nombre);
                    break;
                case 4:
                    Ficha.EliminarDato(Ficha.aux.ID,Ficha.aux.Nombre);
                    break;
                case 5:
                    Hongo.EliminarDato(Hongo.aux.ID,Hongo.aux.Nombre);
                    break;
                case 6:
                    Mario="";
                    JOptionPane.showMessageDialog(null, Mario+"ha sido Eliminado con exito","Personaje",3);
                    break;
                case 7:
                    Castillo="";
                    break;
        }
        
        }catch(Exception e){}
    }
    
    public boolean RegistrarNodo(String id,String nombre, String imagen,String tipo){
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
    
    
    
    
}
