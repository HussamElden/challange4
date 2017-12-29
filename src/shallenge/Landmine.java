/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shallenge;

import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author ASUS
 */
public class Landmine {
     public int x,y;
    public int speedx;
    public int type;
    Point pos=new Point();
    public Landmine(int x,int y,int speedx)
    {
        this.x=x;
        this.pos.x=x;
        this.y=y;
        this.pos.y=y;
        this.speedx=speedx;
        type=0;
    }
    public Landmine()
    {
    x=0;
        y=0;
        speedx=10;
        type=0;
    }
    public  void move(int hight)
    {
        if (y>hight)
        {
          y=-1000;
          pos.y=-1000;
        }else{
                y+=speedx;
                pos.y+=speedx;
               // System.out.println(y);        
        }
//        if (y<0)
//        {
//            speedx= -speedx;
//        }
    }
    
}
