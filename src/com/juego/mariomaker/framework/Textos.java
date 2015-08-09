
package com.juego.mariomaker.framework;
import java.io.*;
/**
 *
 * @author marcosmayen
 */
public class Textos {
    public void leer(String nombreA){
        try
        {
            FileReader r = new FileReader(nombreA);
            BufferedReader buffer = new BufferedReader(r);
            String temp="";
            String cat="";
            while(temp!=null)
            {
                temp=buffer.readLine();
                if(temp==null)
                    break;
                cat=cat+temp;
                System.out.println(temp);
            }
            System.out.println(cat);
        }
        catch(Exception e)
        {
            
        }
    }
    
    public void escribir(String nombreA,String texto){
        File f;
        FileWriter escribir;
        try{
            f=new File(nombreA);
            escribir=new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(escribir);
            PrintWriter salida = new PrintWriter(bw);
            salida.write(texto+"\n");
            salida.close();
            bw.close();
            
            
        }catch(IOException e){}
        
    }
    
}
