/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zwest;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author PERSONAL
 */
public class Frames extends JFrame implements ActionListener{
    private Pslctn p;
    private Mainmenu m;
    private Game g;
    private int idpanel;
    private Timer time;
    public Frames(){
        
        this.idpanel=0;
        JPanel panel= new JPanel(); 
        m=new Mainmenu();
        p=new Pslctn();
        g=new Game();
        this.time=new Timer(25,this);  
        this.time.start();

        //this.changepanel();
        
    }
    
    public void changepanel(){
        switch(idpanel){
            case 0:
                remove(p);
                add(m);
                revalidate();
                repaint();
                idpanel=m.getbto();
                m.setbto(0);
                break;
            case 1:
                remove(m);
                add(p);
                revalidate();
                repaint();
                idpanel=p.getbto();
                p.setbto(1);
                break;
            case 2:
                remove(p);
                g.setplayer(p.getselc());
                
                add(g);
                revalidate();
                repaint();
                
                break;
                
        }
        
                
    }
    public void setidp(int idp){
        this.idpanel=idp;
    }

    public static void main(String [] args){
        Frames s=new Frames();
        s.changepanel();
        s.setTitle("TestPaintComponent");
        s.setSize(2000, 1000);
        s.setLocationRelativeTo(null);
        s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        s.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        changepanel();
        repaint();
        
    }




   
}
