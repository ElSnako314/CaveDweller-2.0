package cavedweller;

import java.util.Scanner;

/**
 *
 * @author ElSnako
 */

public class CaveDweller {
    public static void main(String[] args) {
        Scanner keyBoard = new Scanner(System.in);
        
        //Creating a new cave; gives a bit of information about the cave
        Cave cave = new Cave();
        System.out.println("The cave is " + cave.toString() + " units large");
        
        //Making a loop for movement around the cave (loop only ends when the user types in "close")
        String input = keyBoard.nextLine();
        while (!input.equals("close")) {
            input = keyBoard.nextLine();
            cave.handleInput(input);
        } 
    }
}
