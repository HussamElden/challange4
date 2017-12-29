/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shallenge;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author al 7asob
 */
public class Shallenge {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       JFrame jf=new JFrame();
        jf.setSize(600, 600);
        
        LeGame mb=new LeGame();
      Landmine hole =new Landmine(300,-1000,5);
      hole.type=1;
      mb.Targets.add(hole);
       Landmine hole1 =new Landmine(100,-500,5);
      hole1.type=1;
      mb.Targets.add(hole1);
        mb.Targets.add(new Landmine(555,-2000,3));
        mb.Targets.add(new Landmine(500,-2000,6));
        mb.Targets.add(new Landmine(490,-2000,7));
        mb.Targets.add(new Landmine(15,-2000,8));
        mb.Targets.add(new Landmine(490,-2000,9));
        mb.Targets.add(new Landmine(350,-2000,4));
        
        mb.Targets.add(new Landmine(20,-1000,3));
        mb.Targets.add(new Landmine(250,-1000,6));
        mb.Targets.add(new Landmine(200,-1000,7));
        mb.Targets.add(new Landmine(150,-1000,8));
        mb.Targets.add(new Landmine(100,-1000,9));
        mb.Targets.add(new Landmine(300,-1000,4));
        mb.Targets.add(new Landmine(450,-1000,2));
        mb.Targets.add(new Landmine(500,-1000,10));
        mb.Targets.add(new Landmine(400,-1000,11));
        mb.Targets.add(new Landmine(50,-1000,5));
        mb.setLocation(0, 0);
        jf.setLayout(null);
        jf.add(mb);
        mb.setFocusable(true);
        Thread t1=new Thread(mb);
        t1.start();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }
    
}
