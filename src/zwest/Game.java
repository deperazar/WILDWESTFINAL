/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zwest;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author PERSONAL
 */
public class Game extends JPanel implements ActionListener,MouseListener{
    private Player player;
    private Character enemy;
    private int x;
    private int y;
    private double teta;
    private Timer t;
    
    private int bto;//numero de panel
    private Clip []shoot;
    public Game(){
        addMouseListener(this);
        this.bto=0;
        this.x=0;
        this.y=0;
        this.teta=0;
        player=new Player(100,1);//DEFAULT CHARACTERS
        enemy=new Character(100,1);
        setenemy();
        
        this.t=new Timer(25,this);  
        this.t.start();
    }
    
    public void setplayer(int ID){
        this.player=new Player(100,ID);
    }
    public void setenemy(){//ESCOGER ALEATORIAMENTE AL ADVERSARIO
        Random w=new Random();
        int a=1+(int)(w.nextDouble()*3); 
        enemy=new Character(100,a);
    }

   @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g); 
        Image background=loadImage("FONDO.gif");
        Image life=loadImage("life.png");
        Image chamber=loadImage("chamber.png");
        
        //System.out.println("x: "+x);
        //System.out.println("y: "+y);
        
        g.drawImage(background, 0, -500, this);
        g.drawImage(life, 50, 50,50+5*this.player.getlife(),100,0,0,19*this.player.getlife(),214, this);//PINTANDO SALUD AL JUGADOR
        g.drawImage(chamber, 80, 750, 200, 200, this);//recamara jugador
        g.drawImage(chamber, 1580, 750, 200, 200, this);//recamara enemigo
        
       
        switch (player.getid()){//PINTANDO AL JUGADOR
            case 1:
                Image outlaw=loadImage("Sprite 1.png");
                g.drawImage(outlaw, 100, 200, 120, 500, this);
                break;
            case 2:
                Image outlawwoman=loadImage("sprite2.png");
                g.drawImage(outlawwoman, 100, 250, 160, 450, this);
                break;
            case 3:
                Image redindian=loadImage("sprite3.png");
                g.drawImage(redindian, 200, 200, 120, 500, this);
                break;
        }
        g.drawImage(life, 1800-5*enemy.getlife(), 50,1800, 100,19*enemy.getlife(),0,0,214,this);//PINTANDO SALUD AL ENEMIGO
        switch(enemy.getid()){//PINTANDO AL ENEMIGO
            case 1:
                Image outlaw=loadImage("Sprite 1.png");
                g.drawImage(outlaw, 1600, 210, 1790, 700, 789, 0, 0, 2234, this);
                break;
            case 2:
                Image outlawwoman=loadImage("sprite2.png");
                g.drawImage(outlawwoman, 1600, 250, 1760, 700, 789, 0, 0, 2234, this);
                break;
            case 3:
                Image redindian=loadImage("sprite3.png");
                g.drawImage(redindian, 1600, 210, 1790, 700, 789, 0, 0, 2234, this);
                break;
        }
        drawplayerarm(g);
    }
    
    public void drawplayerarm(Graphics g){
        Graphics2D g2d = (Graphics2D) g.create();
        switch (player.getid()){
            case 1:
                double a=this.x-139;
                double b=this.y-349;
                
                if(b<=0){
                    b=349-y;
                    teta= Math.PI/2+Math.atan(b/a);
                }else{
                    teta= Math.atan(a/b);
                }
                Image arm1= loadImage("arm1.png");
                g2d.rotate(-teta,139, 349);
                g2d.drawImage(arm1, 80, 325,80,220, this);
                //System.out.println("teta: "+teta);
        }
        
    }
    
    public int getbto(){
        return this.bto;
    }
    public void setbto(int ct){
        this.bto=ct;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        this.x=e.getX();
        this.y=e.getY();
        System.out.println("yooo");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {        
    }
    public Image loadImage(String imageName){
           ImageIcon ii= new ImageIcon(imageName);
           Image image =ii.getImage();
           return image;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        repaint();
    }
    
}
