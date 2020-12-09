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
public class Key {
    //Key's Fields/Instance variables
    private int x, y;
    private boolean cavemanHasKey;
    
    public Key(int x, int y) {
        this.x = x;
        this.y = y;
        this.cavemanHasKey = false;
    }
    
    public String toString() {
        return "A shiny object appears at (" + this.x + ", " + this.y + ")";
    }
    
    public void keyClue(Door door) {
        System.out.println("Congratulations! You found the key!");
        System.out.println("Now, to find the exit of this cave, solve this puzzle");
        System.out.println("The exit is at coordinates x and y");
        int keySum;
        keySum = 4 * door.getX() + 3 * door.getY();
        System.out.print("Four times the value of x plus 3 times the value of y is " + keySum);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isCavemanHasKey() {
        return cavemanHasKey;
    }

        public void setCavemanHasKey(boolean cavemanHasKey) {
            this.cavemanHasKey = cavemanHasKey;
        }
}
