//'Infinite Fun' by Braden, Dan and Stan.
package computersummative;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Dimensions {
    public int height;//declares the height of the screen
    public int width;//declares the width of the screen
    private Color color;//initializes the color fo the background
     public Image img;
    public Dimensions( int WIDTH, int HEIGHT, Color COLOR){
       width = WIDTH;//initializes the width for the dimensions of the game
       height = HEIGHT;//initializes the height for the dimensions of the game
       color = COLOR;//initializes color to equal COLOR
        img= Toolkit.getDefaultToolkit().getImage("ill.png");
    }
    public void paint(Graphics g){
        g.setColor(color);//sets the background color to be black
        g.fillRect(0,0,width, height);//fils the background
        g.drawImage(img,width/2+100,0,null);
        //http://blogs.nature.com/news/files/ross%20earth.PNG - picture
    }
}