package cavedweller;

import java.util.Scanner;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 *
 * @author ElSnako
 */

public class CaveDweller extends JPanel implements KeyListener, MouseListener {

    private Timer timer;
    private int frameCount = 0;
    
    public CaveDweller() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 100, 1000/12);
    }
    
     @Override
     public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        frameCount++;
        
        this.setBackground(Color.BLACK);
	
    }
     
    private class ScheduleTask extends TimerTask {

        @Override
        public void run() {
            repaint();
        }
    }
    
    public static void main(String[] args) {
        JFrame j = new JFrame("Cave");
        Container c = new CaveDweller();
        j.add(c);
        j.pack();
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setSize(1000, 1000);
        j.setVisible(true);
        j.setLocationRelativeTo(null);
        j.addKeyListener((KeyListener) c);
        j.addMouseListener((MouseListener) c);
        
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
    
     @Override
    public void keyPressed(KeyEvent e) {
        System.out.printf("" + e.getKeyCode());
    }
    
     @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.printf("\nMouse Clicked at (%d,%d)",e.getX(), e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
