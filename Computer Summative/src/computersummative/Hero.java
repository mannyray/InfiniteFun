//'Infinite Fun' by Braden, Dan and Stan.
package computersummative;

import java.awt.Color;
import java.awt.Graphics;

public class Hero{
    public int HeroHeight;//declares the hero's height
    public int HeroWidth;//declares the hero's width
    public int x;//declares the hero's x position
    public int y;//declares the hero's y position
    public Color c;//declares the color of the hero
    public Hero(Dimensions d,Color cc)
    {
        HeroHeight = d.height/30;//initializes the hero's height as 1/30th of the screen height
        HeroWidth = d.width/50;//initializes the hero's width as 1/50th of the screen width
        x = d.width/2;//initializes the hero's x starting position to the middle of the screen
        y = d.height/3*2-HeroHeight;//initializes the hero's y starting position
        c=cc;//initializes c to be cc 
    }
    public void HeroUpdate(int Hx, int Hy){
       x = Hx;//updates the hero's x position
       y = Hy;//updates the hero's y position
    }
    public void paint(Graphics g){
        g.setColor(c);//sets the hero's color to c (red)
        g.fillRect(x,y,HeroWidth,HeroHeight);//fills the hero
    }

}