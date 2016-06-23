//'Infinite Fun' by Braden, Dan and Stan.
package computersummative;

import java.awt.Graphics;

public class WallGenerator {
    private final int wallAmount;//define used variables
    private int widthOfLayer;
    private int adder = 0;
    private int tracker;
    private int Order;
    public int speed = 5;
    public boolean GameOver=false;
    private int loser;
    private int width;
    private int Level[] = {30,30,30,30,20,20,20,20,10,10,10,10,0,0,0,0,-10,-10,-10,-10,-20,-20,-20,-20,-30,-30,-30,-30,-30,-20,-20,-20,-20,-10,-10,-10,-10,0,0,0,0,10,10,10,10,20,20,20,20,30,30,30,30};//the array in charge of the variation of the side walls indentation

    public WallGenerator(Dimensions d,int order){//constuctor
        Order = order;//order of the wall 
        wallAmount = 25;//how many walls there are
        width = d.width;//width of the screen
        widthOfLayer = d.width / wallAmount;//width of layer
        tracker = width - widthOfLayer*(order-1);
        Order = order - 26;//made so that the first few segments of the game have flat walls
    }
    public void paint(Graphics g){//painting method
        g.fillRect(width/8*7+adder,tracker,width/8-adder, widthOfLayer+speed*2);//right wall
        g.fillRect(0,tracker,(int)(width/8)+adder,widthOfLayer+speed*2);//left wall
    }
    public void tracker(Hero hero, Hero hero2, boolean existance){//tracking method
        tracker -=speed;//updating y coordinate
        if(tracker <= -widthOfLayer)
        {
            tracker = width;
            Order += 26;
            if(Order>Level.length-1)//if the wall reaches the top then give a new indentation based on the array and reset its position
            {
                Order = Order%26;
            }
            adder = Level[Order];
        }
        if(hero.x<=((width/8)+adder)||(hero.x+hero.HeroWidth)>=(width/8*7+adder)){//collision with walls of hero 1
            GameOver = true;//sets game condition to true
            loser = 1;//loser is 1
        }
        else if(hero2.x<=((width/8)+adder)||(hero2.x+hero2.HeroWidth)>=(width/8*7+adder)){//collision with walls of hero 2
                GameOver = true;//sets game condition to true
                loser = 2;//loser is 2
        }
        else
        {
            GameOver = false;
        }
    }
    public int GameOver(int l){//loser determining method
        if(l!=0){
            loser = l;
        }
        return(loser);
    }
}
