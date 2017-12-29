/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shallenge;

import shallenge.Bullet;
import java.awt.Point;

/**
 *
 * @author ASUS
 */
public class Tank {
    public Point pos=new Point();
    public String ImagePath;
    public Bullet Rocket=new Bullet();
    public int speed;
    public Tank (String ImagePath)
    {
        speed=5;
        this.ImagePath=ImagePath;
        Rocket.imgPath="saro5.png";
    }

    void mover() {
        this.pos.x+=speed;
    }
      void movel() {
        this.pos.x-=speed;
    }

    public void fireBullet() {
        Rocket.pos.x=this.pos.x+10;
        Rocket.pos.y=this.pos.y;
        Rocket.tankp.x=this.pos.x+10;
        Rocket.tankp.y=this.pos.y;
        Thread t1=new Thread (Rocket);
        t1.start();
    }
}
