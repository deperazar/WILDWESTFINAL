/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zwest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 *
 * @author PERSONAL
 */
public class Panels extends JFrame implements ActionListener{
    private Pslctn p;//pantalla de seleccion
    private Mainmenu m;//menu principal
    private Game[] g;//pantalla de juego
    private Player player;//jugador
    private Win w;//pantalla de victoria
    private Lost l;//pantalla de pérdida
    private Final f;//pantalla final
    private int idpanel;//# panel
    private int gnumber;//#numero de pantalla de juego
    private Timer time;//tiempo
    
    public void setgnum(){
        this.gnumber=this.l.getngms()+this.w.getngms();
    }
 
    public Panels(){
        this.idpanel=0;
        m=new Mainmenu();
        p=new Pslctn(); 
        g=new Game[10];
        w=new Win();
        l=new Lost();
        f=new Final();
        
        for (int j = 0; j < 10; j++) {
            g[j]=new Game(1);
        }
        
        this.time=new Timer(25,this);  
        this.time.start();
        
    }
   
    public void changepanel(){
        switch(idpanel){
            case 0://MAIN MENU
                remove(p);
                remove(w);
                remove(l);
                add(m);
                revalidate();
                repaint();
                idpanel=m.getbto();
                m.setbto(0);    
                p.setselect();
                break;
                
            case 1://SELECCION DE PERSONAJES
                remove(m);
                add(p);
                player=new Player(100,p.getselc());
                revalidate();
                repaint();
                idpanel=p.getbto();
                p.setbto(1);
                break;
                
            case 2://JUEGO  
                remove(p);
                remove(w);
                setgnum();
                switch (gnumber) {
                    case 0:
                        g[0].setplayer(this.player);
                        add(g[0]);
                        revalidate();
                        repaint();
                        idpanel=g[0].getbto();
                        g[0].setbto(2);
                        break;
                    case 1:
                        g[1].seti(this.player.getiplayer());
                        g[1].setplayer(this.player);
                        
                        add(g[1]);
                        revalidate();
                        repaint();
                        idpanel=g[1].getbto();
                        g[1].setbto(2);
                        break;
                    case 2:
                        
                        g[2].seti(this.player.getiplayer());
                        g[2].setplayer(this.player);
                        add(g[2]);
                        revalidate();
                        repaint();
                        idpanel=g[2].getbto();          
                        g[2].setbto(2);
                        break;
                    case 3:
                        
                        g[3].seti(this.player.getiplayer());
                        g[3].setplayer(this.player);
                        add(g[3]);
                        revalidate();
                        repaint();
                        idpanel=g[3].getbto();          
                        g[2].setbto(2);
                        break;
                    case 4:
                        
                        g[4].seti(this.player.getiplayer());
                        g[4].setplayer(this.player);
                        add(g[4]);
                        revalidate();
                        repaint();
                        idpanel=g[4].getbto();          
                        g[4].setbto(2);
                        break;
                    case 5:
                        
                        g[5].seti(this.player.getiplayer());
                        g[5].setplayer(this.player);
                        add(g[5]);
                        revalidate();
                        repaint();
                        idpanel=g[5].getbto();          
                        g[5].setbto(2);
                        break;
                    case 6:
                        
                        g[6].seti(this.player.getiplayer());
                        g[6].setplayer(this.player);
                        add(g[6]);
                        revalidate();
                        repaint();
                        idpanel=g[6].getbto();          
                        g[6].setbto(2);
                        break;
                    case 7:  
                        g[7].seti(this.player.getiplayer());
                        g[7].setplayer(this.player);
                        add(g[7]);
                        revalidate();
                        repaint();
                        idpanel=g[7].getbto();          
                        g[7].setbto(2);
                        break;
                    default:
                        break;
                }
                
                break;
            case 3://GANO
                this.player.setlife();
                this.player.setbullets();
                switch (gnumber) {
                    case 0:
                        remove(g[0]);
                        break;
                    case 1:
                        remove(g[1]);
                        break;
                    case 2:
                        remove(g[2]);
                        break;
                    case 3:
                        remove(g[3]);
                        break;
                    case 4:
                        remove(g[4]);
                        break;
                    case 5:
                        remove(g[5]);
                        break;
                    case 6:
                        remove(g[6]);
                        break;
                    default:
                        break;
                }
                w.setplayer(this.player);
                add(w);
                revalidate();
                repaint();
                idpanel=w.getbto();
                w.setbto(3);
                break;
            case 4: //PERDIO
                switch (gnumber) {
                    case 0:
                        remove(g[0]);
                        break;
                    case 1:
                        remove(g[1]);
                        break;
                    case 2:
                        remove(g[2]);
                        break;
                    case 3:
                        remove(g[3]);
                        break;
                    case 4:
                        remove(g[4]);
                        break;
                    case 5:
                        remove(g[5]);
                        break;
                    case 6:
                        remove(g[6]);
                        break;
                    default:
                        break;
                }
                l.setplayer(this.player);
                add(l);
                revalidate();
                repaint();
                idpanel=l.getbto();
                l.setbto(4);
                break; 
                
            case 5:
                
                remove(g[gnumber]);
                f.setplayer(player);
                add(f);
                revalidate();
                repaint();
                idpanel=f.getbto();
                f.setbto(5);
                break;
                
            default:
                break;
        }
    }
    public void setidp(int idp){
        this.idpanel=idp;
    }

    public static void main(String [] args){
        Panels s=new Panels();
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
