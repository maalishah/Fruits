import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 

/**
 * Write a description of class FlappyViewer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Viewer
{
    private JFrame frame;
    private Component component;
    
    /**
     * Default constructor for objects of class FlappyViewer
     */
    public Viewer()
    {
        component = new Component();
        frame = new JFrame();
        frame.add(component);
        frame.addMouseListener(component);
        frame.setTitle("Fruits!");
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        component.repaint();
    }
    
    public static void main(String[] args)
    {
        Viewer view = new Viewer();
    }

}