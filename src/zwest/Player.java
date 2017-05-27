/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zwest;

/**
 *
 * @author PERSONAL
 */
public class Player extends Character{
    private int baccuracy;
    private int bspeed;
    private int bhealth;
    private int score;

    public Player(int lif, int Id){
        super(lif,Id);
        this.baccuracy=0;
        this.bspeed=0;
        this.bhealth=0;
        this.score=0;
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
    public int getscore(){
        this.score=this.score+this.baccuracy+this.bhealth+this.bspeed;
        return this.score;
    }
}
