/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cavedweller;

import java.util.Set;

/**
 *
 * @author ElSnako
 */
public class Cave {

    /*Defines all of the variables, preceded by their class (variable type; capitalized)
      Also sets all of the variables to "private"
    */
    private double temperature;
    private int sizeOfCave;
    private Bat[] bats = new Bat[4];  
    private Caveman caveman;
    private Key key;
    private Fruit[] fruits = new Fruit[2]; Fruit[] speedfruit = new Fruit[1];
    private Door door;
    
    public Cave() {
        this.temperature = Math.random() * 100;
        this.sizeOfCave = 10 + (int) (11 * Math.random());

        this.caveman = new Caveman("Harvey", (int) (this.sizeOfCave * Math.random()), (int) (this.sizeOfCave * Math.random()));
            //Gives you the location of the newly made caveman  
            System.out.println("You spawn in a cave at at " + caveman.toString());
        
        for (int i = 0; i < fruits.length; i++) {
            fruits[i] = new Fruit("apple", (int) (this.sizeOfCave * Math.random()), (int) (this.sizeOfCave * Math.random()), false, false);
            System.out.println("An " + fruits[i].getName() + " appears at x: " + fruits[i].getX() + " y: " + fruits[i].getY());
        }
        for (int i = 0; i < speedfruit.length; i++) {
            speedfruit[i] = new Fruit("special pomegranate", (int) (this.sizeOfCave * Math.random()), (int) (this.sizeOfCave * Math.random()), false, true);
            System.out.println("A " + speedfruit[i].getName() + " appears at x: " + speedfruit[i].getX() + " y: " + speedfruit[i].getY());
        }

        for (int i = 0; i < bats.length; i++) {
            bats[i] = new Bat((int) (this.sizeOfCave * Math.random()), (int) (this.sizeOfCave * Math.random()));
            System.out.println("A bat appears at x: " + bats[i].getX() + " y: " + bats[i].getY());
        }
        
        this.key = new Key((int) (this.sizeOfCave * Math.random()), (int) (this.sizeOfCave * Math.random()));
        System.out.println("" + key.toString());
        
        int doorDirection;
        this.door = new Door(0, 0);
        doorDirection = (int) (4 * Math.random()); 
        switch (doorDirection) {
            case 0:
                this.door = new Door(0, (int) (this.sizeOfCave * Math.random()));
                break;
            case 1:
                this.door = new Door(this.sizeOfCave, (int) (this.sizeOfCave * Math.random()));
                break;
            case 2:
                this.door = new Door((int) (this.sizeOfCave * Math.random()), 0);
                break;
            case 3:
                this.door = new Door((int) (this.sizeOfCave * Math.random()), this.sizeOfCave);
                break;
            default:
                break;
        }
    }

    //A method that checks collisions between different objects
    private void checkCollisions() {
        
        for (Fruit fruit : fruits) {
            if (caveman.getX() == fruit.getX() && caveman.getY() == fruit.getY()) {
                caveman.eat(fruit);
                System.out.println("You've eaten an " + fruit.getName() + " and your health has increased to " + caveman.getHP());
            }
            System.out.println("An apple is at x: " + fruit.getX() + ", y: " + fruit.getY());
        }
        
        for (Fruit fruit: speedfruit) {
            if (caveman.getX() == fruit.getX() && caveman.getY() == fruit.getY()) {
                caveman.eat(fruit);
                System.out.println("You've eaten an " + fruit.getName() + " and your speed has increased to " + caveman.getVx());
            }
            System.out.println("A special pomogranate is at x: " + fruit.getX() + ", y: " + fruit.getY());
        }
        
        for (Bat bat: bats) {
            if (caveman.getX() == bat.getX() && caveman.getY() == bat.getY()) {
                bat.bite(caveman);
            }
            System.out.println("A bat is at x: " + bat.getX() + ", y: " + bat.getY());
            bat.moveAround(this);
        }
        
        if (caveman.getX() == key.getX() && caveman.getY() == key.getY()) {
            caveman.findKey(key, door);
            door.setDoorUnlocked(true);
        }
        
        if (caveman.getX() == door.getX() && caveman.getY() == door.getY()) {
            if (door.isDoorUnlocked()) {
                System.out.println("Congrats! You finished the game!");
            }
            else {
                System.out.println("Hmm, this door is locked");
            }
        }
    }


    //A method that handles the directional inputs of the user
    public void handleInput(String input) {
        if (input.trim().equalsIgnoreCase("up")) {
            this.caveman.moveUp();
            System.out.println("You're now at " + this.caveman.toString());
        }
        else if (input.trim().equalsIgnoreCase("down")) {
            this.caveman.moveDown();
            System.out.println("You're now at " + this.caveman.toString());
        }
        else if (input.trim().equalsIgnoreCase("left")) {
            this.caveman.moveLeft();
            System.out.println("You're now at " + this.caveman.toString());
        }
        else if (input.trim().equalsIgnoreCase("right")) {
            this.caveman.moveRight();
            System.out.println("You're now at " + this.caveman.toString());
        }
        else if (input.trim().equalsIgnoreCase("close")) {
            System.exit(0);
        }
        else {
            System.out.println("Sorry, I don't understand");
            System.out.println("Please use the words: up, down, left, and right");
        }
        
        checkCollisions();
    }

    //Methods (regular getter and toString) that return size of cave
    public int getSizeOfCave() {
        return sizeOfCave;
    }
    
    public String toString() {
        return "" + sizeOfCave;
    }
}
