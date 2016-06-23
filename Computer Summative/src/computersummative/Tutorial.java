//'Infinite Fun' by Braden, Dan and Stan.
package computersummative;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Tutorial {
    private int width,height;//declares the width and heigt
    private Font large,medium,small;//declares the 3 sizes of fonts
    private int font;//declares the font size
    public Tutorial(Dimensions d){
        height = d.height;//sets the height as the height of the screen
        width = d.width;//sets the width as the width of the screen
        font = width/5;//sets the font size
        medium = new Font("serif", Font.TRUETYPE_FONT,font/5 );//initializes medium as serif font style, truetype, and 1/25th of the screen
        large = new Font("serif", Font.PLAIN, font/3);//sets large font to serif font style, plain, and 1/15th of the screen
        small = new Font("serif", Font.TRUETYPE_FONT,font/12 );//sets small font to serif font style, truetype, and 1/60th of the screen
    }

    public void paint(Graphics g){

        g.setColor(Color.black);//sets the color as black
        g.fillRect(0,0,width, height);//fills the background
        g.setColor(Color.DARK_GRAY);//sets the color as dark gray
        g.setFont(medium);//sets the font as medium
        g.drawString("'1' for single",0,font/8);
        g.drawString("'2' for two player",0,font/8+font/5);
        g.drawString("'r' to play",0,font/8+font/5+font/5);
        g.drawString("'ESC' to quit",0,font/8+font/5+font/5+font/5);//shows instructions for the game
        g.setColor(Color.CYAN);//sets the color as cyan
        g.setFont(large);//sets the font size as large
        g.drawString("INFINITE FUN",width/2-font/2,font/2 );//shows the title of the game
        g.setFont(small);//sets the size of the font to small
        g.setColor(Color.YELLOW);//sets the color as yellow
        g.drawString("You are the HERO--->",0,height/4);
        g.drawString("Your mission is to survive the fall through eternity by slowing your fall with platforms.",0,height/4+font/8);//shows instructions for the game
        g.setColor(Color.red);//sets the color as red
        g.fillRect(width/5,height/5+height/60,width/50,height/30);//fills the hero
        g.setColor(Color.WHITE);//sets the color as white
        g.setFont(medium);//sets the font to medium
        g.drawString("Platform Types",0,height/2-font/4);//shows the subtitle, Platform Types
        g.setColor(Color.red);//sets the color to red
        g.fillRect(0, height/2,width/12 , 10);//fills a platform
        g.fillRect(0, height/2+100,width/12 , 10);//fills another platform below the previous
        g.fillRect(0, height/2+200,width/12 , 10);//fills another platform below the previous
        g.setColor(Color.magenta);//sets the color to magenta
        g.fillRect(0, height/2+300,width/12 , 10);//fills another platform at the bottom
        g.setColor(Color.white);//sets the color to white
        g.drawLine(0,height/2+105,width/12,height/2+105);//draws a line through the second platform
        for(int i = 0; i < width/12; i += width/120){

              g.setColor(Color.white);//sets the color to white
              g.drawLine(i, height/2+200, i, height/2+180);//draws spikes on top of the third platform
          }
        g.setFont(small);//sets the font to small
        g.setColor(Color.GREEN);//sets the color to green
        g.drawString("--->Stationary platform",width/12,height/2+10);//prints out discription of the first platform
        g.drawString("--->Fall-through platform",width/12,height/2+110);//prints out discription of the second platform
        g.drawString("--->Spiky platfrom (do not land on!)",width/12,height/2+210);//prints out discription of the third platform
        g.drawString("--->Moving platfrom",width/12,height/2+310);//prints out discription of the last platform 
        g.drawString("*The platforms can fuse together to create hybrid platforms",0,height/2+330);//prints out more information about the game

        g.setFont(medium);//sets the font to medium
        g.setColor(Color.white);//sets the color to white
        g.drawString("Hero Controls",width*5/12,height/2-font/4);//prints out Hero Controls
        g.setFont(small);//sets the font to small
        g.setColor(Color.GREEN);//sets the color to green
        g.drawString("Left arrow key for moving left and right arrow key for moving right.",width*5/12,height/2);//prints out controls for the hero
        g.drawString("In two player mode - 'a' to go left and 'd' to go right.",width*5/12,height/2+font/4);//prints out controls for the hero
    }
}