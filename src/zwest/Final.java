/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zwest;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author PERSONAL
 */
public class Final extends JPanel{
    private int bto;
    private Player player;
    public Final(){
        this.bto=5;
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
        Image trophy=loadImage("trophy.png");
        g.setFont(new Font("Agency FB", Font.BOLD, 80));
        g.setColor(Color.red);
        g.drawImage(trophy, 0, 0,2000,1000, this);
        g.drawString(""+(player.gettotalsc()), 1685, 788);
    }
    public Image loadImage(String imageName){
           ImageIcon ii= new ImageIcon(imageName);
           Image image =ii.getImage();
           return image;
    }
}
