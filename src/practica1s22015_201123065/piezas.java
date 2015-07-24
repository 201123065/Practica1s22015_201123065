
package practica1s22015_201123065;

public class piezas extends Thread{
    
    public piezas(String msg)
    {
        super(msg);
    }
    
    public void run(){
        for(int i=0;i<=20;i++)
        {
            System.out.print(this.getName()+"\n");
        }
        
    }
    
}
