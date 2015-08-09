/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juego.mariomaker.ventana;


public class PloteoGraphviz {
    public void GraficarJugadores(String ruta)
    {
        try {

          String dotPath = "/Applications/Graphviz.app/Contents/MacOS/Graphviz";

          String fileInputPath = getClass().getResource("/com/juego/mariomaker/objetos/")+ruta;
          System.out.print(fileInputPath);
          String fileOutputPath = getClass().getResource("/com/juego/mariomaker/objetos/")+"grafo1.jpg";

          String tParam = "-Tjpg";
          String tOParam = "-o";

          String[] cmd = new String[5];
          cmd[0] = dotPath;
          cmd[1] = tParam;
          cmd[2] = fileInputPath;
          cmd[3] = tOParam;
          cmd[4] = fileOutputPath;

          Runtime rt = Runtime.getRuntime();

          rt.exec( cmd );

        } catch (Exception ex) {
          ex.printStackTrace();
        }
        
    }
}
