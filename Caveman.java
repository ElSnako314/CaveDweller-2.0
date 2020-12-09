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
public class Caveman {
    //Caveman's Fields/Instance variables
    private String name;
    private int HP, x, y;
    private int vx, vy; 
    private boolean cavemanHasKey;
    
    //Caveman's Constructor
    public Caveman(String name, int x, int y) {
        this.HP = 100;
        this.cavemanHasKey = false;
        this.name = name;
        this.x = x;
        this.y = y;
        this.vx = 1;
        this.vy = 1;
    }
    //Caveman's Methods (how an interaction happens)
    public void speak() {
        System.out.println("Hello I'm " + name);
    }
    
    public String toString() {
        return "x: " + x + ", y: " + y;
    }
        //Methods of Caveman's movement
        public void moveUp() {
            // this means that y is decreased by one (could have used other ways to decrease/increase as well)
            y -= 1 * vy;
            // y tracks how far down (as opposed to how far up)
        }
        public void moveDown() {
            y += 1 * vy;
        }
        public void moveLeft() {
            x -= 1 * vx;
        }
        public void moveRight() {
            x += 1 * vx;
        }
    
    public void eat(Fruit fruit) {
        HP += fruit.getHealthBoost();
        fruit.setIsFoodEaten(true);
        System.out.println("Me eat the " + fruit.getName() + "!!");
        if (fruit.isFruitType()) {
            this.vx = 2;
            this.vy = 2;
        }
    }
    
    public void findKey(Key key, Door door) {
        key.setCavemanHasKey(true);
        key.keyClue(door);
    }
    
    //Accessors - getters & setters
    public int getHP() {
        return setHP(HP);
    }
    
        //A setter that makes sure that the HP is never set to anything above 100 for some odd reason, and if HP reaches 0, the caveman is dead
        public int setHP(int HP) {
            if (HP <= 100 && HP > 0) {
                return this.HP = HP;
            }
            else if (HP <= 0) {
                System.out.println("You dead");
                return this.HP = 0;
            }
            else {
                System.out.println("Don't eat too much, your HP is already full");
                return this.HP = 100;
            }
        }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getVx() {
        return vx;
    }

    public int getVy() {
        return vy;
    }

    public boolean isCavemanHasKey() {
        return cavemanHasKey;
    }
        
        //A setter that can change the boolean isCavemanHasKey()
        public void setCavemanHasKey(boolean cavemanHasKey) {
            this.cavemanHasKey = cavemanHasKey;
        }
}