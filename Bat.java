/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cavedweller;
/**
 *
 * @author ElSnako
 */
public class Bat {
    //Bat's Fields/Instance variables
    private boolean isBatDefeated;
    private int x, y, batDamage, batHP;

    //Bat's Constructor
    public Bat(int x, int y) {
        this.batDamage = -5;
        this.batHP = 10;
        this.isBatDefeated = false;
        this.x = x;
        this.y = y;
    }

    public void moveAround(Cave cave) {
        //increase/decrease x by random number
        this.x += (int) (cave.getSizeOfCave() * Math.random()) - (int) (cave.getSizeOfCave() * Math.random());
        //increase/decrease y by random number
        this.y += (int) (cave.getSizeOfCave() * Math.random()) - (int) (cave.getSizeOfCave() * Math.random());
        if (this.x < 0) {
            this.x = 0;
        }
        if (this.x > cave.getSizeOfCave()) {
            this.x = cave.getSizeOfCave();
        }
        if (this.y < 0) {
            this.y = 0;
        }
        if (this.y > cave.getSizeOfCave()) {
            this.y = cave.getSizeOfCave();
        }        
    }

    public void bite(Caveman caveman) {
        //reduces HP of the caveman
        int newHP = caveman.getHP() + batDamage;
        caveman.setHP(newHP);
        System.out.println("Youch! I've been bit by a bat! My health is now " + caveman.getHP());
    }
    
    public String toString() {
        return "A bat is at x: " + this.x + ", y: " + this.y;
    }
    
    //Accessors
    public boolean isIsBatDefeated() {
        return isBatDefeated;
    }

    public void setIsBatDefeated(boolean isBatDefeated) {
        this.isBatDefeated = isBatDefeated;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getBatDamage() {
        return batDamage;
    }

    public void setBatDamage(int batDamage) {
        this.batDamage = batDamage;
    }
}