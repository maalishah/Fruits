import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score
{
    private int current = 0;
    /**
     * Constructor for objects of class Score
     */
    public Score()
    {
    }
    
    public void update(int increment)
    {
        current += increment;
    }
    
    public void drawGameOver(Graphics g)
    {
        g.setFont(new Font("Times New Roman", Font.PLAIN, 100));
        g.setColor(Color.BLUE);
        g.drawString("Score: " + current, 150, 300);
    }

    public void draw(Graphics g)
    {
        g.setFont(new Font(null, Font.BOLD, 12));
        g.setColor(Color.BLUE);
        g.drawString("Score: " + current, 10, 20);
    }
}
