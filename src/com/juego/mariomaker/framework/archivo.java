
package com.juego.mariomaker.framework;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class archivo {
    
   public void crearTxt(String nombre, String texto)
   {
       File f;
       FileWriter escribir;
       try{
            f= new File(nombre);
            escribir = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(escribir);
            PrintWriter salida = new PrintWriter(bw);
            
            salida.write(texto+"\n");
            salida.close();
            bw.close();
       }
       catch(IOException e)
       {
           
       }
   }
   public void concatenar(String nombre,String texto)
   {
       String temp = this.leer(nombre);
       temp=temp+texto;
       this.crearTxt(nombre, temp);
       
   }
   public String leer(String nombre) 
   {
       File f;
       FileReader lectura;
       try{
           f=new File(nombre);
           lectura= new FileReader(f);
           BufferedReader br = new BufferedReader(lectura);
           String l="";
           String aux = "" ;
           while(true)
           {
               aux=br.readLine();
               if(aux!=null)
                   l=l+aux+"\n";
               else
                   break;
           }
           br.close();
           lectura.close();
           return l;
       }catch(IOException e)
       {
           return null;
       }
   }
   
}
