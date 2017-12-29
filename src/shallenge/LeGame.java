/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shallenge;

import shallenge.Landmine;
import shallenge.Tank;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ASUS
 */
public class LeGame extends JPanel implements Runnable{

   public ArrayList<Landmine>Targets=new ArrayList<Landmine>();
   
   BufferedImage mineimg;
   BufferedImage hole;
   JLabel Score=new JLabel();
   int CTR=0;
   public Tank Dababti=new Tank("Tank.png");
   private Boolean GameEnd=true;
    public LeGame()
    {
        setSize(600,600);
        setBackground(Color.red);
        Score.setBounds(0, 0, 50, 50);
       // Score.setBackground(Color.BLACK);
        Score.setForeground(Color.BLUE);
        Score.setFont(new Font("Courier", Font.BOLD,75));
        Score.setText(Integer.toString(CTR));
        Dababti.pos.x=220;
        Dababti.pos.y=450;
        this.add(Score);
        this.addKeyListener(new keylist());
        
    }
    private class keylist implements KeyListener
    {

        @Override
        public void keyTyped(KeyEvent e) {
           
        }

        @Override
        public void keyPressed(KeyEvent e) {
            //System.out.println("Test");
            if (e.getKeyCode()==KeyEvent.VK_RIGHT)
            {
                
                Dababti.mover();
                
            }
            if (e.getKeyCode()==KeyEvent.VK_LEFT)
            {
                
                Dababti.movel();
                //repaint();
            }
            if (e.getKeyCode()==KeyEvent.VK_SPACE)
            {
               
                Dababti.fireBullet();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
           
        }
    }
    public void  paintComponent(Graphics g)
    {
        g.clearRect(0, 0, 600, 600);
        
        try
        {
            BufferedImage bg = ImageIO.read(new File("5alfia.jpg"));
        g.drawImage(bg,0,0,null);
        BufferedImage imgtank = ImageIO.read(new File(Dababti.ImagePath));
        BufferedImage imgrocket = ImageIO.read(new File(Dababti.Rocket.imgPath));
        mineimg = ImageIO.read(new File("Mine.png"));
        hole=ImageIO.read(new File("hole.png"));
        g.drawImage(imgtank, Dababti.pos.x, Dababti.pos.y,null);
        g.drawImage(imgrocket, Dababti.Rocket.pos.x, Dababti.Rocket.pos.y,null);
        
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
        
        
        for (Landmine mine: Targets)
        
        {
            if(mine.type==0){
            g.drawImage(mineimg,mine.x,mine.y, null);
            }else if(mine.type==1){
             //   System.out.println("hole here");
            g.drawImage(hole,mine.x,mine.y, null);
            }
            if (Dababti.Rocket.pos.distance(mine.x, mine.y)<=40)
            {if(mine.type==0){
                mine.y=-1000;
                mine.pos.y=-1000;
                 Dababti.Rocket.Shot=false;
                Dababti.Rocket.pos.x=-1000;
               
                CTR++;
                  Score.setText(Integer.toString(CTR));
                  if(CTR%10==0){
                  for(Landmine Amine:Targets){
                  Amine.speedx++;
                  }
                  }
                break;
            }
            }
            
        }
          for (Landmine mine: Targets)
        
        {

            if (mine.pos.distance(Dababti.pos.x+50, Dababti.pos.y)<=40)
            {   
                
                System.out.println("Tank died");
                Dababti.pos.x=-1000;
                Dababti.pos.y=-1000;
                GameEnd=false;
                JOptionPane.showMessageDialog(null,"You lost. ", " Game Over.",JOptionPane.ERROR_MESSAGE);
               // Balls.remove(OneBall);
                break;
                
            }
            
        }
        
    }
    @Override
    public void run() {
    try
    {
    while(GameEnd)
    {
        for (Landmine mine: Targets)
        {
            mine.move(this.getHeight());
        }    
        
        //y+=10;
        Thread.sleep(50);
        repaint();
    }
    }
    catch (InterruptedException e)
    {}
    }
    
}
