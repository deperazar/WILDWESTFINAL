/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zwest;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author PERSONAL
 */
public class Pslctn extends JPanel implements MouseListener{
    private int bto;//numero de panel
    private int selected;//hightlight
    private int counter;
    private Boolean displaystart;//mostrar boton start
    private Clip []shoot;
    
    public Pslctn(){
        addMouseListener(this);    
        this.bto=1;
        this.selected=0;
        this.counter=0;
        this.displaystart=false;
        this.shoot=new Clip[11];
        try {
             for (int i = 0; i < 10; i++) {
                 this.shoot[i] = AudioSystem.getClip();
                 this.shoot[i].open(AudioSystem.getAudioInputStream(new File("shoot.wav")));
             }

         } catch (Exception l) {
             System.out.println(" " + l);
         }
        
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g); 
        Image selectionpanel=loadImage("Roast.png");
        Image buttons=loadImage("Botones.png");
        Image highlight=loadImage("highlights.gif");
        
        g.drawImage(selectionpanel, 0, 0, 2000, 1000, this);
        g.drawRect(130, 345, 290, 410);
        g.drawRect(420, 345, 290, 410);
        g.drawRect(710, 345, 290, 410);
        g.drawImage(buttons, 50, 800, 350, 900, 0, 731, 1229, 1092, this);
        
        switch(selected){
            case 1:
                g.drawImage(highlight, 85, 300, 370, 500, this);
                break;

            case 2:
                g.drawImage(highlight, 380, 300, 370, 500, this);
                break;
            case 3:
                g.drawImage(highlight, 660, 300, 370, 500, this);
                break;
            default:
            break;
        } 
        if(displaystart){
            g.drawImage(buttons, 1500, 800, 1800, 900, 8, 1110, 1229, 1463, this);
        }
       
    }
    public int getbto(){

        return this.bto;
    }
    public void setbto(int ct){
        this.bto=ct;
    }
    public int getselc(){
        return this.selected;
    }
    

    @Override
    public void mouseClicked(MouseEvent e) {
        Point p=e.getPoint();
        Rectangle back = new Rectangle(50, 800, 300, 100);
        Rectangle play = new Rectangle(1500, 800, 300, 100);
        Rectangle p1 = new Rectangle(130, 345, 290, 410);
        Rectangle p2 = new Rectangle(420, 345, 290, 410);
        Rectangle p3 = new Rectangle(710, 345, 290, 410); 
        if(back.contains(p)){
            this.bto=0;
            this.selected=0;
        }
        if(p1.contains(p)){
            this.selected=1;
            this.displaystart=true;
        }
        if(p2.contains(p)){
            this.selected=2;
            this.displaystart=true;
        }
        if(p3.contains(p)){
            this.selected=3;
            this.displaystart=true;
        }
        if(play.contains(p)){
            this.shoot[counter].start();
            this.bto=2;
            counter+=1;
        }
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
    
}
