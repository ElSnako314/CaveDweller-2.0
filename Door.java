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
public class Door {
    //Door's Fields/Instance variables
    private int x, y;
    private boolean doorUnlocked;
    
    public Door(int x, int y) {
        this.x = x;
        this.y = y;
        this.doorUnlocked = false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isDoorUnlocked() {
        return doorUnlocked;
    }

        public void setDoorUnlocked(boolean doorUnlocked) {
            this.doorUnlocked = doorUnlocked;
        }   
}
