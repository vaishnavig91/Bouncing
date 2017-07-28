/*
 * Bouncing.java
 *
 * Created on June 5, 2007, 2:09 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package bouncing;

/**
 *
 * @author KinberE
 */

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;

public class Bouncing extends JApplet implements
ActionListener
{

private  JButton start, stop;
private JPanel panel;
private Ball ball;

public void init()
{
  start = new JButton("start");
  stop= new JButton("stop");
  panel = new JPanel();
  panel.add(start);
  panel.add(stop);
  start.addActionListener(this);
  stop.addActionListener(this);
  getContentPane().add(panel, BorderLayout.SOUTH);

  getContentPane().setBackground(Color.white);


}
public void actionPerformed(ActionEvent e)
{
if (e.getSource() == start)
   {
     Graphics g = getGraphics();
     ball = new Ball(g);
     ball.start();
   }
else
 System.exit(0);
 }
}

class Ball extends Thread
{
private Graphics g;
private int xIncr, yIncr, radius;
private int x = 200;
private int y = 125;
private int colorCase;
private int sleep;
private int left = 3;
private int right = 320;
private int top = 3;
private int bottom = 250;

public Ball(Graphics graphics)
{
g = graphics;
}
public void run()
{
 colorCase = (int)(Math.random()*10);
 sleep = (int)(Math.random()*30);
 xIncr = ((int)(Math.random()*8))-4;
 yIncr = ((int)(Math.random()*8))-4;
 radius = 5+(int)(Math.random()*20);



     while(true)
     {
     g.setColor(Color.white);
     g.fillOval(x,y,2*radius,2*radius);
     if(x+xIncr <= left+radius)
              xIncr = -xIncr;
     if(x+xIncr >= right-2*radius)
              xIncr = -xIncr;
     if(y+yIncr <= top+radius)
               yIncr = -yIncr;
     if(y+yIncr >= bottom-2*radius)
               yIncr = -yIncr;

     x += xIncr;
     y += yIncr;
      switch(colorCase)
   {
     case 0:
           g.setColor(Color.black);
           break;
     case 1:
           g.setColor(Color.blue);
           break;
     case 2:
           g.setColor(Color.cyan);
           break;
     case 3:
           g.setColor(Color.green);
           break;
     case 4:
           g.setColor(Color.magenta);
           break;
     case 5:
           g.setColor(Color.orange);
           break;
     case 6:
           g.setColor(Color.pink);
           break;
     case 7:
           g.setColor(Color.red);
           break;
     case 8:
              g.setColor(Color.yellow);
           break;
     case 9:
           g.setColor(Color.gray);
           break;
     case 10:
          g.setColor(Color.darkGray);
          break;
     }
     g.fillOval(x,y,2*radius,2*radius);
     try
     {
     Thread.sleep(100+sleep);
     }
     catch(InterruptedException e)
     {
       System.err.println("sleep exception");
     }
     }
      }
}




