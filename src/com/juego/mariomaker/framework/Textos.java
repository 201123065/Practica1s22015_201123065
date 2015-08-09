
package com.juego.mariomaker.framework;
import java.io.*;
/**
 *
 * @author marcosmayen
 */
public class Textos {
    public void leer(String nombreA)
    {
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
    
    
}
