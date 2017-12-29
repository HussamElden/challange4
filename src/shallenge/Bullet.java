/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shallenge;

import java.awt.Color;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class Bullet implements Runnable{
    public Point pos=new Point(-100,-100);
    
   public Point p=new Point(-100,-100);
   public Point tankp=new Point(0,0);
   public Boolean Shot=true;
    public Color CurrentColor;
    public int Speed;
    public String imgPath;
    public Bullet()
    {
        Speed=1;
    }
    
    public  void  move()
    {
        pos.y-=Speed;
         tankp.y-=Speed;
    }

    @Override
    public void run() {
        while (pos.y!=-10)
        {
             
            if(pos.equals(p)||pos.y<0||pos.equals(tankp)){
                 move();
            }else{
            break;
            }
            
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                
            }
            
        }
        pos.x=-100;
    }
}
//int i=0;i<400;i++