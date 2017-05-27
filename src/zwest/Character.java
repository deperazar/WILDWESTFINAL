/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zwest;

import java.awt.Graphics;

/**
 *
 * @author PERSONAL
 */
public class Character {
    protected int life;
    protected int ID;
    protected int bullets;
    public Character(int life, int ID){
        this.life=life;
        
        switch (ID) {
            case 1:
               // System.out.println("forajido");
                break;
            case 2:
                //System.out.println("mujer");
                break;
            case 3:
                //System.out.println("indio");
                break;
            default:
                break;
        }
        this.ID=ID;
        this.bullets=6;
        
    }
    
    public void shoot(){
        bullets-=1;
    }
    public int getid(){
        return this.ID;
    }
    public int getlife(){
        return this.life;
    }
    public void hurt(int damage){
        this.life-=damage;
    }
    public int getbullets(){
        return this.bullets;
    }
    public void setid(int ID){
        this.ID=ID;
    }
     public void setlife(int life){
        this.life=life;
    }

    
}
