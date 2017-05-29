/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zwest;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 *
 * @author PERSONAL
 */
public class Win extends JPanel implements MouseListener{
    private Player player;
    private int bto;
    private int ngms;//NUMERO DE JUEGOS
    
    public Win(){
        addMouseListener(this);
        this.bto=3;
        this.ngms=0;
       
    }
    
    public int getngms(){
        return this.ngms;
    }
    
    public int getbto(){
        return this.bto;
    }
    public void setbto(int bto){
        this.bto=bto;
    }
    public void setplayer(Player player){
        this.player=player;
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g); 
        Image fondo=loadImage("win.png");
        g.setFont(new Font("Agency FB", Font.BOLD, 40));
        g.drawImage(fondo, 10, -125,2000,1200, this);
        g.drawString(""+this.player.getaccuracyb(), 1200, 335);
        g.drawString(""+this.player.gethealthb(), 1200, 415);
        g.drawString(""+this.player.getspeedb(), 1200, 495);
        g.drawString(""+(player.gettotalsc()), 1190, 605);
        
        
       
    }
    public Image loadImage(String imageName){
           ImageIcon ii= new ImageIcon(imageName);
           Image image =ii.getImage();
           return image;
    }
    public int totalscore(){
        return 4;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("X:"+e.getX()+" Y: "+e.getY());
        
        Point p=e.getPoint();
        Rectangle mainm=new Rectangle(1021,683,326,79);
        Rectangle next=new Rectangle(682,683,326,79);    
        if(mainm.contains(p)){
            this.bto=0;
            this.ngms+=1;
        }
        if(next.contains(p)){
            this.bto=2;
            this.ngms+=1;
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
}
