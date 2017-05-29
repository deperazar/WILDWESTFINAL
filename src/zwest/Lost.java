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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 *
 * @author PERSONAL
 */
public class Lost extends JPanel implements MouseListener, ActionListener {
    private Player player;
    private int bto;

    private int ngms;//NUMERO DE JUEGOS
    private int entername;//NUMERO DE JUEGOS
    
    public Lost(){
        addMouseListener(this);
        setLayout( null );
        this.bto=4;
        this.ngms=0;
        this.entername=0;

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
        Image fondo=loadImage("fail.png");
       
        
        g.setFont(new Font("Agency FB", Font.BOLD, 80));
        g.drawImage(fondo, 0, -100,2000,1200, this);
        
        g.drawString(""+player.gettotalsc(), 1180,570);
      
        
        
    }
    
    public void showspace(){
        JTextField name=new JTextField();
        name.setBounds(730, 439, 577, 80);
        add(name);
    }
    
    public Image loadImage(String imageName){
           ImageIcon ii= new ImageIcon(imageName);
           Image image =ii.getImage();
           return image;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("X:"+e.getX()+" Y: "+e.getY());
        Point p=e.getPoint();
        Rectangle mainm=new Rectangle(629,638,690,143);
        if(mainm.contains(p)){
            this.bto=0;
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

    @Override
    public void actionPerformed(ActionEvent e) {
       
    }

}
