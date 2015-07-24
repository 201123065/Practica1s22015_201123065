package practica1s22015_201123065;

import java.awt.Toolkit;

public class Dimensiones {
    
        Toolkit tk = Toolkit.getDefaultToolkit();
    public int largo()
    {
        return ((int) tk.getScreenSize().getWidth());
    }
    
    public int ancho()
    {
        
        return ((int)tk.getScreenSize().getHeight());
        
    }
    
}
