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
public class Character  {
    protected int life;
    protected int ID;
    protected int bullets;
    public Character(int life, int ID){
        this.life=life;
        
        switch (ID) {
            case 1:
               // forajido
                break;
            case 2:
                //mujer
                break;
            case 3:
                //indio
                break;
            default:
                break;
        }

        this.ID=ID;
        this.bullets=6;
        
    }
    
    
    public int getid(){
        return this.ID;
    }
    protected int getlife(){
        return this.life;
    }
    protected void hurt(int damage){
        this.life-=damage;
    }
    protected int getbullets(){
        return this.bullets;
    }
    protected void setid(int ID){
        this.ID=ID;
    }
    protected void setdamage(int damage){
        this.life=life-damage;
    }

    
}
