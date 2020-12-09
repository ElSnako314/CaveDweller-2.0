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
public class Fruit {
    //Food's Fields/Instance variables
    private String fruitName;
    private int healthBoost = 10, x, y;
    private double healthMultiplier = 0.5; 
    private boolean isFoodEaten, isFoodRotten, fruitType;
    
    //Constructor for Fruit
    public Fruit(String name, int x, int y, boolean isFoodRotten, boolean fruitType) {
        //FruitType = false is equivalent to "regular fruit"
        if (fruitType = false) {
            this.x = x;
            this.y = y;
            this.fruitName = name;
            this.isFoodEaten = false; 
            if (isFoodRotten = true) {
                this.healthBoost *= healthMultiplier;
            }
        }
        //FruitType = true, so this is the special speed-boosting fruit
        else {
            this.x = x;
            this.y = y;
            this.fruitName = name;
            this.isFoodRotten = false;
            this.isFoodEaten = false;
        }
    }
    //Fruit Methods
    public String toString() {
        return "An " + this.fruitName + " appears at" + "x: "+x+", y: "+y;
    }
    
    //Accessors
    public String getName() {
        return fruitName;
    }

    public int getHealthBoost() {
        return healthBoost;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isIsFoodEaten() {
        return isFoodEaten;
    }
        //A setter that changes the boolean "isFoodEaten"
        public void setIsFoodEaten(boolean isFoodEaten) {
            this.isFoodEaten = isFoodEaten;
        }

    public boolean isFruitType() {
        return fruitType;
    }
}