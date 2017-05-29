/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zwest;


import java.util.ArrayList;

/**
 *
 * @author PERSONAL
 */
public class Player extends Character{
    private int baccuracy;
    private int bspeed;
    private int bhealth;
    private int balas;
    private int i;
    private int[] score;
   

    public Player(int lif, int Id){
        super(100,Id);
        this.baccuracy=0;
        this.bspeed=0;
        this.bhealth=0;
        this.i=0;
       
        this.balas=6;
        this.score=new int[10];
        for (int i = 0; i < 10; i++) {
            this.score[i]=0;
        }
        
    }
    
    
    public void setiplayer(int i){
        this.i=i;
    }
    public int getiplayer(){
        return this.i;
    }

    public void shootb(){
        this.balas-=1;
    }
    public int getbalas(){
        return this.balas;
    }
    public void setbullets(){
        this.balas=6;
    }
        
    public void setaccuracyb(int ac){
        this.baccuracy=ac;
    }
    public void setspeedb(int sp){
        this.bspeed=sp;
    }
    public void sethealthb(int health){
        this.bhealth=health;
    }
    public int getaccuracyb(){
        return this.baccuracy;
    }
    
    public int getspeedb(){
        return this.bspeed;
    }
    public int gethealthb(){
        return this.bhealth;
    }
    public void setscore(int i){
        this.score[i]=this.baccuracy+this.bhealth+this.bspeed;
       
    }
    
    
    
    @Override
    public int getlife(){
        return this.life;
    }
    @Override
    public void setdamage(int damage){
        this.life=life-damage;
    }
    public int gettotalsc(){
        int total=0;
        for (int j = 0; j < 10; j++) {
            total=total+this.score[j];
            
        }
        return total;
    }
    public void setlife(){
        this.life=100;
    }
    
    
}
