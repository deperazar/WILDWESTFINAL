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

public class Mainmenu extends JPanel implements MouseListener{
    private boolean bstatus;
    private int bto;
    private int counter;
    private Clip intromusic;
    private Clip[] shoot;
    
    public Mainmenu(){
       this.addMouseListener(this);
       this.bstatus=true;
       this.bto=0;
       this.counter=0;
       
       this.shoot=new Clip[11];
       try {
            this.intromusic = AudioSystem.getClip();
            this.intromusic.open(AudioSystem.getAudioInputStream(new File("mmms.wav")));
            this.intromusic.start();
        } catch (Exception l) {
            System.out.println(" " + l);
        }
       
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
        Image mainmenu= loadImage("Mainmenu.gif");
        Image soundbttn= loadImage("Sonido_1.gif");
        g.drawImage(mainmenu,  -180, 0, null);
        if(bstatus){
            g.drawImage(soundbttn, 950, 770, 1130, 870, 0, 0, 1302, 740, null);
        }else{
             g.drawImage(soundbttn, 950, 770, 1130, 870, 0, 740, 1302, 1497, null);
        }
       
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        Point pnt=e.getPoint();
        
        Rectangle start = new Rectangle(725, 510, 445, 105);
        Rectangle highscores = new Rectangle(725, 645, 445, 105);
        Rectangle soundswitch = new Rectangle(950, 770, 180, 100);
        
        if(soundswitch.contains(pnt)){
            if(bstatus){
                intromusic.stop();
                bstatus=false;
            }else{
                intromusic.start();
                bstatus=true;
            }
        }
        else if(start.contains(pnt)){
            shoot[counter].start();
            this.bto=1;
            counter+=1;
        }
        else if(highscores.contains(pnt)){
             shoot[counter].start();
            this.bto=1;
            counter+=1;
        }
        
    }
    
    public int getbto(){
        
        return this.bto;
    }
    public void setbto(int ct){
        this.bto=ct;
    }
    
    public void setbsatust(boolean bs){
        this.bstatus=bs;
    }
    public Boolean detbsatust(){
        return this.bstatus;
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
    /*@Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }*/
    
    
}
