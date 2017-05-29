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
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.Random;
import javax.sound.sampled.AudioSystem;
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
    private int x;//COORDENADAS DISPARO X
    private int y;//COORDENADAS DISPARO Y
    private double teta;//ANGULO BRAZO JUGADOR
    private double alpha;//ANGULO BRAZO ENEMIGO
    private int chambercount;//CONTADOR DE CUENTA REGRESIVA
    private int shootcounter;//CONTADOR DE DISPAROS REALIZADOS
    private int t;//tiempo
    private double m0;//numero de disparo del enemigo
    private double h;//numero de disparos enemigo
    private Timer time;//tiempo
    private int bto;//numero de panel
    private Clip []shoot;
    
    private int o1;//(dx)Velocidad disparo jugador
    private int o2;
    private int o3;
    private int o4;
    private int o5;
    private int o6;
    
    private int g1;//(dx)Velocidad disparo enemigo
    private int g2;
    private int g3;
    private int g4;
    private int g5;
    private int g6;
    
    private int xd1;//COORDENADAS DISPARO COLISIÓN JUGADOR
    private int yd1;
    private int xd2;//
    private int yd2;
    private int xd3;//
    private int yd3;
    private int xd4;//
    private int yd4;
    private int xd5;//
    private int yd5;
    private int xd6;//
    private int yd6;
    
    private int xc1;//COORDENADAS DISPARO COLISIÓN ENEMIGO
    private int yc1;
    private int xc2;//
    private int yc2;
    private int xc3;//
    private int yc3;
    private int xc4;//
    private int yc4;
    private int xc5;//
    private int yc5;
    private int xc6;//
    private int yc6;
    
    private int accuracy;//punteria
    private int difficulty;//punteria
    private int i;//contador de nivel
   
    public Game(int dif){
        addMouseListener(this);
        
        this.difficulty=dif;
        
        this.bto=2;
        this.x=0;
        this.y=0;
        this.t=0;
        this.h=0;
        this.m0=0;
        this.teta=0;
        this.alpha=0;
        this.chambercount=0;
        
        
        this.o1 = 0;
        this.o2 = 0;
        this.o3 = 0;
        this.o4 = 0;
        this.o5 = 0;
        this.o6 = 0;
        
        this.g1=0;
        this.g2=0;
        this.g3=0;
        this.g4=0;
        this.g5=0;
        this.g6=0;
        
        this.xd1=0;
        this.yd1=0;
        this.xd2=0;
        this.yd2=0;
        this.xd3=0;
        this.yd3=0;
        this.xd4=0;
        this.yd4=0;
        this.xd5=0;
        this.yd5=0;
        this.xd6=0;
        this.yd6=0;
        
        this.xc1=0;
        this.yc1=0;
        this.xc2=0;
        this.yc2=0;
        this.xc3=0;
        this.yc3=0;
        this.xc4=0;
        this.yc4=0;
        this.xc5=0;
        this.yc5=0;
        this.xc6=0;
        this.yc6=0;
        
        this.accuracy=0;
   
        this.i=0;

        this.time=new Timer(25,this);  
        this.time.start();
        
        this.shoot=new Clip[30];
        
        this.player=new Player(100,1);//DEFAULT CHARACTERS
        enemy=new Character(100,1);
        this.difficulty=0;
        setenemy();

        try {
            for (int i = 0; i < 30; i++) {
                this.shoot[i] = AudioSystem.getClip();
                this.shoot[i].open(AudioSystem.getAudioInputStream(new File("shoot.wav")));
            }
            
        } catch (Exception l) {
            System.out.println(" " + l);
        }
    }
    
    public void setdifficulty(int h){
        this.difficulty=h;
        
    }
    public int getdifficulty(){
        return this.difficulty;
    }
            
    public void setplayer(Player player){
        this.player=player;
    }
    
    public void setenemy(){//ESCOGER ALEATORIAMENTE AL ADVERSARIO
        Random w=new Random();
        int a=1+(int)(w.nextDouble()*3); 
        enemy=new Character(100,a);
    }

   @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g); 
        Image background=loadImage("FONDO.png");
        Image life=loadImage("life.png");
        Image chamber=loadImage("chamber.png");
        
        g.drawImage(background, 0, -200, 2000,1200,this);
        g.drawImage(life, 50, 50,50+5*this.player.getlife(),100,0,0,19*this.player.getlife(),214, this);//PINTANDO SALUD AL JUGADOR
        g.drawImage(chamber, 80, 750, 200, 200, this);//recamara jugador
        g.drawImage(chamber, 1580, 750, 200, 200, this);//recamara enemigo
         
        switch (player.getid()){//PINTANDO AL JUGADOR
            case 1://FORAJIDO
                Image outlaw=loadImage("Sprite 1.png");
                g.drawImage(outlaw, 100, 200, 120, 500, this);
                break;
            case 2://MUJER
                Image outlawwoman=loadImage("sprite2.png");
                g.drawImage(outlawwoman, 100, 250, 160, 450, this);
                break;
            case 3://INDIO
                Image redindian=loadImage("sprite3.png");
                g.drawImage(redindian, 200, 200, 120, 500, this);
                break;
        }
        g.drawImage(life, 1800-5*enemy.getlife(), 50,1800, 100,19*enemy.getlife(),0,0,214,this);//PINTANDO SALUD AL ENEMIGO
        switch(enemy.getid()){//PINTANDO AL ENEMIGO
            case 1://FORAJIDO
                Image outlaw=loadImage("Sprite 1.png");
                g.drawImage(outlaw, 1600, 210, 1790, 700, 789, 0, 0, 2234, this);
                break;
            case 2://MUJER
                Image outlawwoman=loadImage("sprite2.png");
                g.drawImage(outlawwoman, 1600, 250, 1760, 700, 789, 0, 0, 2234, this);
                break;
            case 3://INDIO
                Image redindian=loadImage("sprite3.png");
                g.drawImage(redindian, 1600, 210, 1790, 700, 789, 0, 0, 2234, this);
                break;
        }
        
        drawplayerarm(g);
        drawenemyarm(g);
        drawbulletscamera(g);
        drawbulletsplayer(g);
        drawcount(g);
    }
    
    public void drawplayerarm(Graphics g){//PINTAR BRAZO DEL JUGADOR
        Graphics2D g2d = (Graphics2D) g.create();
        switch (player.getid()){
            case 1://forajido
                double a=this.x-139;
                double b=this.y-349;
                Image arm1= loadImage("arm1.png");
                if(this.chambercount>3){
                    if(b<=0){
                        b=349-y;
                        teta= Math.PI/2+Math.atan(b/a);
                    }else{
                        teta= Math.atan(a/b);
                    }
                }
               
                g2d.rotate(-teta,139, 349);
                g2d.drawImage(arm1, 80, 325,80,220, this);
                if(player.getbalas()<6){
                   
                    this.xd1=(int)(139+101*o1*Math.sin(teta));
                    this.yd1=(int)(349+101*o1*Math.cos(teta));
                    
                    if(player.getbalas()<5){
                       
                        this.xd2=(int)(139+101*o2*Math.sin(teta));
                        this.yd2=(int)(349+101*o2*Math.cos(teta));
                    }
                    if(player.getbalas()<4){
                       
                        this.xd3=(int)(139+101*o3*Math.sin(teta));
                        this.yd3=(int)(349+101*o3*Math.cos(teta));
                    }
                    if(player.getbalas()<3){
                        
                        this.xd4=(int)(139+101*o4*Math.sin(teta));
                        this.yd4=(int)(349+101*o4*Math.cos(teta));
                    }
                    if(player.getbalas()<2){
                       
                        this.xd5=(int)(139+101*o5*Math.sin(teta));
                        this.yd5=(int)(349+101*o5*Math.cos(teta));
                    }
                    if(player.getbalas()<1){
                        
                        this.xd6=(int)(139+101*o6*Math.sin(teta));
                        this.yd6=(int)(349+101*o6*Math.cos(teta));
                       
                    }
                    
                }  
                break;
        
            case 2://mujer
                a=x-173;
                b=y-372;
                if(b<=0){
                    b=372-y;
                    teta= Math.PI/2+Math.atan(b/a);
                }else{
                    teta= Math.atan(a/b);
                }

                Image arm2= loadImage("arm2.png");
                g2d.rotate(-teta,173, 372);//
                g2d.drawImage(arm2, 115, 355,70,200, this);
                if(player.getbalas()<6){
                   
                this.xd1=(int)(173+101*o1*Math.sin(teta));
                this.yd1=(int)(372+101*o1*Math.cos(teta));

                if(player.getbalas()<5){
                    
                    this.xd2=(int)(173+101*o2*Math.sin(teta));
                    this.yd2=(int)(372+101*o2*Math.cos(teta));
                }
                if(player.getbalas()<4){
                    
                    this.xd3=(int)(173+101*o3*Math.sin(teta));
                    this.yd3=(int)(372+101*o3*Math.cos(teta));
                }
                if(player.getbalas()<3){
                    
                    this.xd4=(int)(139+101*o4*Math.sin(teta));
                    this.yd4=(int)(372+101*o4*Math.cos(teta));
                }
                if(player.getbalas()<2){
                    
                    this.xd5=(int)(173+101*o5*Math.sin(teta));
                    this.yd5=(int)(372+101*o5*Math.cos(teta));
                }
                if(player.getbalas()<1){
                    
                    this.xd6=(int)(173+101*o6*Math.sin(teta));
                    this.yd6=(int)(372+101*o6*Math.cos(teta));
                }
                    //
                }
                break;
            
            case 3://indio
                a=x-253;
                b=y-347;
                if(b<=0){
                    b=347-y;
                    teta= Math.PI/2+Math.atan(b/a);
                }else{
                    teta= Math.atan(a/b);
                }

                Image arm3= loadImage("arm3.png");
                g2d.rotate(-teta,253, 347);//
                g2d.drawImage(arm3, 206, 328,70,200, this);
                if(player.getbalas()<6){
                    
                  
                    this.xd1=(int)(253+101*o1*Math.sin(teta));
                    this.yd1=(int)(347+101*o1*Math.cos(teta));
                    
                    if(player.getbalas()<5){
                       
                        this.xd2=(int)(253+101*o2*Math.sin(teta));
                        this.yd2=(int)(347+101*o2*Math.cos(teta));
                        
                    }
                    if(player.getbalas()<4){
                       
                        this.xd3=(int)(253+101*o3*Math.sin(teta));
                        this.yd3=(int)(347+101*o3*Math.cos(teta));
                    }
                    if(player.getbalas()<3){
                        
                        this.xd4=(int)(253+101*o4*Math.sin(teta));
                        this.yd4=(int)(347+101*o4*Math.cos(teta));
                    }
                    if(player.getbalas()<2){
                        
                        this.xd5=(int)(253+101*o5*Math.sin(teta));
                        this.yd5=(int)(347+101*o5*Math.cos(teta));
                    }
                    if(player.getbalas()<1){
                        
                        this.xd6=(int)(253+101*o6*Math.sin(teta));
                        this.yd6=(int)(347+101*o6*Math.cos(teta));
                    }
                }
                break;

        }
    }
    
    public void drawcount(Graphics g){//DIBUJAR SECUENCIA DE NUMEROS
        Graphics2D g2d = (Graphics2D) g.create();
        Image count=loadImage("count.png");
        Image message=loadImage("message.png");
        if(chambercount==0){
             g.drawImage(message, 550, 800, 800, 100, this);
        }
        switch(chambercount){//APARECE SECUENCIA DE NÚMEROS
                case 1:
                    g.drawImage(count, 870, 100, 1070, 350, 0, 0, 402, 665,  this);
                    break;
                case 2:
                    g.drawImage(count, 870, 100, 1070, 350, 0, 665, 402, 1330,  this);
                    break;
                case 3:
                    g.drawImage(count, 870, 100, 1070, 350, 0, 1330, 402, 1995,  this);
                    break;
            }
    }
    
    
    public void drawenemyarm(Graphics g){//DIBUJAR BRAZO ENEMIGO
        Graphics2D g2d = (Graphics2D) g.create();
        setdifficulty(i+1);
        
        switch(enemy.getid()){
            case 1://enemigo forajido
  
                Image earm1=loadImage("arm1.png");
                int b=0;
                Random r1=new Random();
                b=(int)(r1.nextDouble()*6);
                double [] b1= {0.1421,0.2025,0.2654,0.1647,0.281,0.3074};
                if(player.getid()==2){//JUGADOR ESCOGIO PERSONAJE MUJER
                    b1[0]=0.256;
                    b1[1]=0.157;
                    b1[2]=0.1845;
                    b1[3]=0.198;
                    b1[4]=0.213;
                    b1[5]=0.2542;
                }
                g2d.rotate(alpha,1742,346);// 
                
               
                if(t>(5*(6-getdifficulty()))&&t%12==1&&h<6.5){
                    this.alpha=1.3603+Math.atan(b1[b]);
                    m0+=0.5;
                    h+=0.5;  
                }
               
                g2d.drawImage(earm1, 1650,326, 1790, 770, 789, 0, 0, 2234, this);
                if(m0>0){
                    shoot[1].start();
                    this.xc1=(int)(1742-101*g1*Math.sin(alpha));
                    this.yc1=(int)(346+101*g1*Math.cos(alpha));
                }
                if(m0>1){
                    shoot[3].start();
                    this.xc2=(int)(1742-101*g2*Math.sin(alpha));
                    this.yc2=(int)(346+101*g2*Math.cos(alpha));   
                }
                if(m0>2){
                    shoot[5].start();
                    this.xc3=(int)(1742-101*g3*Math.sin(alpha));
                    this.yc3=(int)(346+101*g3*Math.cos(alpha));
                }
                if(m0>3){
                    shoot[7].start();
                    this.xc4=(int)(1742-101*g4*Math.sin(alpha));
                    this.yc4=(int)(346+101*g4*Math.cos(alpha));
                }
                if(m0>4){
                    shoot[9].start();
                    this.xc5=(int)(1742-101*g5*Math.sin(alpha));
                    this.yc5=(int)(346+101*g5*Math.cos(alpha));
                }
                if(m0>5){  
                    shoot[11].start();
                    this.xc6=(int)(1742-101*g5*Math.sin(alpha));
                    this.yc6=(int)(346+101*g5*Math.cos(alpha));
                }
                break;
                
            case 2://enemigo mujer
                Image earm2=loadImage("arm2.png");
                b=0;
                Random r2=new Random();
                b=(int)(r2.nextDouble()*6);
               
                
                double [] b2= {0.2767,0.2567,0.3209,0.1514,0.2002,0.1921};
                if(player.getid()==2){//JUGADOR ESCOGIO PERSONAJE MUJER
                    b2[0]=0.256;
                    b2[1]=0.157;
                    b2[2]=0.1845;
                    b2[3]=0.198;
                    b2[4]=0.213;
                    b2[5]=0.2542;
                }
                g2d.rotate(alpha,1689,375); 
                if(t>(5*(6-getdifficulty()))&&t%12==1&&h<6.5){
                    this.alpha=1.3603+Math.atan(b2[b]);
                    m0+=0.5;
                    h+=0.5;
                }
               
                g2d.drawImage(earm2, 1590, 360, 1750, 760, 789, 0, 0, 2234, this);
                if(m0>0){
                    shoot[1].start();
                        this.xc1=(int)(1698-101*g1*Math.sin(alpha));
                        this.yc1=(int)(375+101*g1*Math.cos(alpha));
                } 
                if(m0>1){
                    shoot[3].start();
                    this.xc2=(int)(1689-101*g2*Math.sin(alpha));
                    this.yc2=(int)(375+101*g2*Math.cos(alpha));
                }
                if(m0>2){ 
                    shoot[5].start();
                    this.xc3=(int)(1689-101*g3*Math.sin(alpha));
                    this.yc3=(int)(375+101*g3*Math.cos(alpha));
                }
                if(m0>3){
                    shoot[7].start();
                    this.xc4=(int)(1689-101*g4*Math.sin(alpha));
                    this.yc4=(int)(375+101*g4*Math.cos(alpha));
                }
                if(m0>4){
                    shoot[9].start();
                    this.xc5=(int)(1689-101*g5*Math.sin(alpha));
                    this.yc5=(int)(375+101*g5*Math.cos(alpha));
                }
                if(m0>5){
                    shoot[11].start();
                    this.xc6=(int)(1689-101*g6*Math.sin(alpha));
                    this.yc6=(int)(375+101*g6*Math.cos(alpha));
                }
                break;
            case 3://enemigo indio
                Image earm3=loadImage("arm3.png");
                b=0;
                Random r3 =new Random();
                b=(int)(r3.nextDouble()*6);
                double [] b3= {0.1421,0.2025,0.2654,0.1647,0.281,0.3074};
                if(player.getid()==2){//JUGADOR ESCOGIO PERSONAJE MUJER
                    b3[0]=0.256;
                    b3[1]=0.157;
                    b3[2]=0.1845;
                    b3[3]=0.198;
                    b3[4]=0.213;
                    b3[5]=0.2542;
                }
               g2d.rotate(alpha,1742,346);// 
                if(t>(5*(6-getdifficulty()))&&t%12==1&&h<6.5){
                    this.alpha=1.3603+Math.atan(b3[b]);
                    m0+=0.5;
                    h+=0.5;
                }
                
                g2d.drawImage(earm3, 1650,326, 1790, 770, 789, 0, 0, 2234, this);
                if(m0>0){
                        shoot[1].start();
                        this.xc1=(int)(1742-101*g1*Math.sin(alpha));
                        this.yc1=(int)(346+101*g1*Math.cos(alpha));
                    }
                    if(m0>1){
                        shoot[3].start();
                        this.xc2=(int)(1742-101*g2*Math.sin(alpha));
                        this.yc2=(int)(346+101*g2*Math.cos(alpha)); 
                    }
                    if(m0>2){
                        shoot[5].start();
                        this.xc3=(int)(1742-101*g3*Math.sin(alpha));
                        this.yc3=(int)(346+101*g3*Math.cos(alpha));
                    }
                    if(m0>3){
                        shoot[7].start();
                        this.xc4=(int)(1742-101*g4*Math.sin(alpha));
                        this.yc4=(int)(346+101*g4*Math.cos(alpha));
                    }
                    if(m0>4){
                        shoot[9].start();
                        this.xc5=(int)(1742-101*g5*Math.sin(alpha));
                        this.yc5=(int)(346+101*g5*Math.cos(alpha));
                    }
                    if(m0>5){
                        shoot[1].start();
                        this.xc6=(int)(1742-101*g5*Math.sin(alpha));
                        this.yc6=(int)(346+101*g5*Math.cos(alpha));
                    }
                break;
                
        }
        
    }
    
    public void drawbulletscamera(Graphics g){//DIBUJAR BALAS EN LA RECAMARA
        Image bullet=loadImage("Bullet.png");
        
        if(player.getbalas()>0){  
            g.drawImage(bullet, 152, 762, 55, 55, this);
            if(player.getbalas()>1){
                g.drawImage(bullet, 100, 792, 55, 55, this);
                if(player.getbalas()>2){
                    g.drawImage(bullet, 100, 853, 55, 55, this);
                    if(player.getbalas()>3){
                        g.drawImage(bullet, 152, 884, 55, 55, this);
                        if(player.getbalas()>4){
                           g.drawImage(bullet, 205, 853, 55, 55, this);
                           if(player.getbalas()>5){
                               g.drawImage(bullet, 205, 792, 55, 55, this);
                            }
                        }
                    }
                }
            }     
        }
        if(m0<6){    
            g.drawImage(bullet, 1652, 762, 55, 55, this);
            if(m0<5){
                g.drawImage(bullet, 1600, 792, 55, 55, this);
                if(m0<4){
                   g.drawImage(bullet, 1600, 853, 55, 55, this);
                    if(m0<3){
                        g.drawImage(bullet, 1652, 884, 55, 55, this);
                        if(m0<2){
                          g.drawImage(bullet, 1705, 853, 55, 55, this);
                            if(m0<1){
                                g.drawImage(bullet, 1705, 792, 55, 55, this);
                            }
                        }
                    }
                }
            }
        }
        
        
    }
    
    public void drawbulletsplayer(Graphics g){
        Graphics2D g2d = (Graphics2D) g.create();
        
        Image bullethead=loadImage("Bullethead.gif");
        
        
        g.drawImage(bullethead, xd1, yd1, 10,5,this);//VISUALIZACION DE BALAS JUGADOR
        g.drawImage(bullethead, xd2, yd2, 10,5,this);
        g.drawImage(bullethead, xd3, yd3, 10,5,this);
        g.drawImage(bullethead, xd4, yd4, 10,5,this);
        g.drawImage(bullethead, xd5, yd5, 10,5,this);
        g.drawImage(bullethead, xd6, yd6, 10,5,this);
        
        g.drawImage(bullethead, xc1, yc1, 10,5,this);//VISUALIZACION DE BALAS ENEMIGO
        g.drawImage(bullethead, xc2, yc2, 10,5,this);
        g.drawImage(bullethead, xc3, yc3, 10,5,this);
        g.drawImage(bullethead, xc4, yc4, 10,5,this);
        g.drawImage(bullethead, xc5, yc5, 10,5,this);
        g.drawImage(bullethead, xc6, yc6, 10,5,this);
        
    }
    
    public void collision(){
            Rectangle a1=new Rectangle (xd1, yd1, 5, 5);//BALAS
            Rectangle a2=new Rectangle (xd2, yd2, 5, 5);
            Rectangle a3=new Rectangle (xd3, yd3, 5, 5);
            Rectangle a4=new Rectangle (xd4, yd4, 5, 5);
            Rectangle a5=new Rectangle (xd5, yd5, 5, 5);
            Rectangle a6=new Rectangle (xd6, yd6, 5, 5);
            
            Rectangle c1=new Rectangle (xc1, yc1, 5, 5);//BALAS ENEMIGO
            Rectangle c2=new Rectangle (xc2, yc2, 5, 5);
            Rectangle c3=new Rectangle (xc3, yc3, 5, 5);
            Rectangle c4=new Rectangle (xc4, yc4, 5, 5);
            Rectangle c5=new Rectangle (xc5, yc5, 5, 5);
            Rectangle c6=new Rectangle (xc6, yc6, 5, 5);
            
            Rectangle b1=new Rectangle ();//sectores de daño enemigo
            Rectangle b2=new Rectangle ();
            Rectangle b3=new Rectangle ();
            Rectangle b4=new Rectangle ();
            
            Rectangle b11=new Rectangle ();//sectores de daño jugador
            Rectangle b22=new Rectangle ();
            Rectangle b33=new Rectangle ();
            Rectangle b44=new Rectangle ();
            
            if(enemy.getid()==2){//Mujer tiene diferentes sectores                 
                b1=new Rectangle (1630,250,200,90);//sectores de daño enemigo mujer
                b2=new Rectangle (1625,340,200,80);
                b3=new Rectangle (1645,420,200,70);
                b4=new Rectangle (1645,490,200,210);
                
            }else{
                b1=new Rectangle (1680,205,200,100);//sectores de daño enemigo
                b2=new Rectangle (1675,305,200,100);
                b3=new Rectangle (1687,405,200,100);
                b4=new Rectangle (1695,505,20,200);
            }
            if(player.getid()==2){
                b11=new Rectangle (19, 251, 200, 80);//sectores de daño jugador mujer
                b22=new Rectangle (19, 331, 115, 90);
                b33=new Rectangle (19, 421, 200, 90);
                b44=new Rectangle (19, 511, 200, 200);   
                
            }else{
           
                b11=new Rectangle (0,200,200,100);//sectores de daño jugador
                b22=new Rectangle (0,300,200,100);
                b33=new Rectangle (0,400,200,100);
                b44=new Rectangle (0,500,200,200);
            }
                
 
            if(c1.intersects(b11)||c2.intersects(b11)||c3.intersects(b11)||c4.intersects(b11)||c5.intersects(b11)||c6.intersects(b11)){  
                this.player.setdamage(50);
               
            }
            if(c1.intersects(b22)||c2.intersects(b22)||c3.intersects(b22)||c4.intersects(b22)||c5.intersects(b22)||c6.intersects(b22)){
                this.player.setdamage(30);
                
            }
            if(c1.intersects(b33)||c2.intersects(b33)||c3.intersects(b33)||c4.intersects(b33)||c5.intersects(b33)||c6.intersects(b33)){
                this.player.setdamage(20);
    
            }
            if(c1.intersects(b44)||c2.intersects(b44)||c3.intersects(b44)||c4.intersects(b44)||c5.intersects(b44)||c6.intersects(b44)){
                this.player.setdamage(10);
            }
            
            if(a1.intersects(b1)||a2.intersects(b1)||a3.intersects(b1)||a4.intersects(b1)||a5.intersects(b1)||a6.intersects(b1)){  
                this.accuracy+=1;
                this.enemy.setdamage(50);
               
            }
            else if(a1.intersects(b2)||a2.intersects(b2)||a3.intersects(b2)||a4.intersects(b2)||a5.intersects(b2)||a6.intersects(b2)){
                this.accuracy+=1;
                this.enemy.setdamage(30);
                
            }
            else if(a1.intersects(b3)||a2.intersects(b3)||a3.intersects(b3)||a4.intersects(b3)||a5.intersects(b3)||a6.intersects(b3)){
                this.accuracy+=1;
                this.enemy.setdamage(20);
               
                
            }
            else if(a1.intersects(b4)||a2.intersects(b4)||a3.intersects(b4)||a4.intersects(b4)||a5.intersects(b4)||a6.intersects(b4)){
                this.accuracy+=1;
                this.enemy.setdamage(10);
            }
             
            if(this.player.getlife()<=0){//MUERES
               
                setdifficulty(1);
                this.setbto(4);
                
                time.stop();
            }
            if(this.enemy.getlife()<=0){//VIVES
                accb();
                hlthb();
                spdb();
                
                this.i+=1;
                this.player.setiplayer(i);
                this.player.setscore(i);
                setdifficulty(this.player.getiplayer());
               
               
                if(i>4){
                    this.setbto(5);
                }else{
                    this.setbto(3);
                }
                
               
                time.stop();  
            }
             
        }

    public int geti(){
        return this.i;
    }
    public void seti(int i){
        this.i=i;
    }

    public void accb(){
        if(player.getbalas()==6){
            
        }else{
            double a=this.accuracy;
            double b=6-this.player.getbalas();
            
            double accb= 10*a/b;
            int c=(int) Math.round(accb);
            this.player.setaccuracyb(c);
        }  
    }
    public void spdb(){
        
       
        if(this.t<80){
            player.setspeedb(2);
            if(this.t<70){
                player.setspeedb(4);
                if(this.t<60){
                    player.setspeedb(6);
                    if(this.t<50){
                        player.setspeedb(8);
                        if(this.t<40){
                            player.setspeedb(10);
                        }
                    }
                }
            }
            
        } 
    }
    
    public void hlthb(){
        this.player.sethealthb(this.player.getlife()/10);
    }
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        this.x=e.getX();
        this.y=e.getY();
        Point p=e.getPoint();
       
        Rectangle cchamber= new Rectangle(154, 825, 50, 50);
        
        if(cchamber.contains(p)){
            this.chambercount+=1;
        }
        else if(chambercount>3){
            shootcounter+=1;
            if(player.getbalas()>0){
                player.shootb();
                shoot[2*shootcounter].start();
               
            }
            
        }
        
    }
    
        
    public int getbto(){
        return this.bto;
    }
    public void setbto(int ct){
        this.bto=ct;
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
        if(chambercount>3){
            t+=1;  
            
        }
        
        if(player.getbalas()<6){//DISPARO DE BALAS
            o1+=2;
            if(player.getbalas()<5){
                o2+=2;
                if(player.getbalas()<4){
                    o3+=2;
                    if(player.getbalas()<3){
                        o4+=2;
                        if(player.getbalas()<2){
                            o5+=2;
                            if(player.getbalas()<1){
                                o6+=2;
                            }
                        }
                    }
                } 
            }
        }
        if(m0>0){
            g1+=2;
            if(m0>1){
                g2+=2;
                if(m0>2){
                    g3+=2;
                    if(m0>3){
                        g4+=2;
                        if(m0>4){
                            g5+=2;
                            if(m0>5){
                                g6+=2;
                            }
                        }
                    }
                }

            }
        }
        
        collision();
        repaint();
    }
    
}
