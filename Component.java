import java.util.ArrayList;
import java.util.Random;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Write a description of class Component here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Component extends JComponent implements ActionListener,MouseListener
{
    // instance variables - replace the example below with your own
    private ArrayList<Fruit> fruits;
    private Score score;
    private Timer time;
    private Graphics g;
    private Random gen = new Random();
    
    private ImageIcon iconApple;
    private ImageIcon iconBanana;
    private ImageIcon iconMelon;
    private ImageIcon iconPear;
    private ImageIcon iconStrawberry;
    private ImageIcon iconBombFruit;
    
    private Image imgApple;
    private Image imgBanana;
    private Image imgMelon;
    private Image imgPear;
    private Image imgStrawberry;
    private Image imgBombFruit;
    private Image background;
    
    private int wA,hA,wB,hB,wM,hM,wP,hP,wS,hS,wF,hF;
    
    private int fps;
    private int fruitCount;
    
    private boolean gameOver = false;
    /**
     * Constructor for objects of class Component
     */
    public Component()
    {
        super.paintComponent(g);
        fruits = new ArrayList<Fruit>();
        fruits.add(randFruit());
        gen = new Random();
        score = new Score();
        fps = 20;
        time = new Timer(fps,this);
        iconApple = new ImageIcon("apple.png");
        imgApple = iconApple.getImage();
        wA = imgApple.getWidth(null);
        hA = imgApple.getHeight(null);
        iconBanana = new ImageIcon("banana.png");
        imgBanana = iconBanana.getImage();
        wB = imgBanana.getWidth(null);
        hB = imgBanana.getHeight(null);
        iconMelon = new ImageIcon("melon.png");
        imgMelon = iconMelon.getImage();
        wM = imgMelon.getWidth(null);
        hM = imgMelon.getHeight(null);
        iconPear = new ImageIcon("pear.png");
        imgPear = iconPear.getImage();
        wP = imgPear.getWidth(null);
        hP = imgPear.getHeight(null);
        iconStrawberry = new ImageIcon("strawberry.png");
        imgStrawberry = iconStrawberry.getImage();
        wS = imgStrawberry.getWidth(null);
        hS = imgStrawberry.getHeight(null);
        iconBombFruit = new ImageIcon("bombfruit.png");
        imgBombFruit = iconBombFruit.getImage();
        wF = imgBombFruit.getWidth(null);
        hF = imgBombFruit.getHeight(null);
        ImageIcon icon = new ImageIcon("back.jpg");
        background = icon.getImage();
    }

    public void paintComponent(Graphics g)
    {
        g.drawImage(background,0,0,this);
        if (!gameOver)
        {
            for (int i = 0; i < fruits.size(); i++)
                fruits.get(i).draw(g);
            score.draw(g);
            time.start();
        }
        else
            score.drawGameOver(g);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if (!gameOver)
        {
            fruitCount++;
            for (int i = 0; i < fruits.size(); i++)
                fruits.get(i).move();
            if (fruitCount % (fps*2) == 0)
            {
                fruits.add(randFruit());
            }
        }
        repaint();
    }
    
    public void mouse(MouseEvent e)
    {
        for (int i = 0; i < fruits.size(); i++)
        {
            if (fruits.get(i).getRect().contains(new Point(e.getX(),e.getY())))
                if (fruits.get(i).getScore() == -1)
                    gameOver = true;
                else
                {
                    score.update(fruits.get(i).getScore());
                    fruits.remove(i);
                }
        }
    }
    
    public void mouseClicked(MouseEvent e){mouse(e);}
    public void mousePressed(MouseEvent e){mouse(e);}
    public void mouseReleased(MouseEvent e){mouse(e);}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    
    public Fruit randFruit()
    {
        int num = gen.nextInt(7);
        if (num == 0)
            return new Fruit(5,20,800,600,imgApple,wA,hA);
        else if (num == 1)
            return new Fruit(5,30,800,600,imgBanana,wB,hB);
        else if (num == 2)
            return new Fruit(3,15,800,600,imgMelon,wM,hP);
        else if (num == 3)
            return new Fruit(7,25,800,600,imgPear,wP,hP);
        else if (num == 4)
            return new Fruit(7,35,800,600,imgStrawberry,wS,hS);
        return new Fruit(5,-1,800,600,imgBombFruit,wF,hF);
    }
}
