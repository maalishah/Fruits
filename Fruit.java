import java.util.Random;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Image;
/**
 * Write a description of class Fruits here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fruit
{
    private int dir,x,y,speed,score,width,height,imgWidth,imgHeight;
    private Random gen = new Random();
    private Image img;
    /**
     * Constructor for objects of class Fruits
     */
    public Fruit(int speed, int score, int width, int height, Image img, int imgWidth,int imgHeight)
    {
        dir = gen.nextInt(8);
        this.speed = speed;
        this.score = score;
        this.width = width;
        this.height = height;
        this.img = img;
        this.imgWidth = imgWidth;
        this.imgHeight = imgHeight;
        x = gen.nextInt(Math.abs(width));
        y = gen.nextInt(Math.abs(height));
    }

    public void move()
    {
        if (dir == 0)
        {
            x += speed;
        }
        else if (dir == 1)
        {
            x += speed;
            y -= speed;
        }
        else if (dir == 2)
        {
            y -= speed;
        }
        else if (dir == 3)
        {
            x -= speed;
            y -= speed;
        }
        else if (dir == 4)
        {
            x -= speed;
        }
        else if (dir == 5)
        {
            x -= speed;
            y += speed;
        }
        else if (dir == 6)
        {
            y += speed;
        }
        else if (dir == 7)
        {
            x += speed;
            y += speed;
        }

        if (x < 0)
        {
            if (dir == 3)
                dir = 5;
            else if (dir == 4)
                dir = 0;
            else if (dir == 5)
                dir = 7;
        }
        else if (y < 0)
        {
            if (dir == 3)
                dir = 5;
            else if (dir == 2)
                dir = 6;
            else if (dir == 1)
                dir = 7;
        }
        else if (x > width - imgWidth)
        {
            if (dir == 1)
                dir = 3;
            else if (dir == 0)
                dir = 4;
            else if (dir == 7)
                dir = 5;
        }
        else if (y > height - imgHeight)
        {
            if (dir == 7)
                dir = 1;
            else if (dir == 6)
                dir = 2;
            else if (dir == 5)
                dir = 3;
        }
    }
    
    public int getScore()
    {
        return score;
    }

    public Rectangle getRect()
    {
        return new Rectangle(x,y,imgWidth,imgHeight);
    }
    
    public void draw(Graphics g)
    {
        g.drawImage(img,x,y,null);
    }
}
