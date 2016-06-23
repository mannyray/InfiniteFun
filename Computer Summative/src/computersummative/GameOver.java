//'Infinite Fun' by Braden, Dan and Stan.
package computersummative;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class GameOver {
    private int width,height;//declares the width and height of the game over screen
    private int font;//declares the size of the font
    private Font large,medium;//initializes the 2 font sizes, large and medium
    private Color Colorr[] = {Color.RED,Color.YELLOW,Color.ORANGE};//sets the different colors that the words will be displayed in
    public GameOver(Dimensions d){
        height = d.height;//sets the height of the screen to the entire height
        width = d.width;//sets the width of the screen to the entire width
        font = width/5;//sets the word so that it'll be 1/5th of the screen
        large = new Font("serif", Font.PLAIN, font);//sets large to serif style font, plain, 1/5th of the screen
        medium = new Font("serif", Font.TRUETYPE_FONT,font/5 );//sets medium to be serif style font, plain, and 1/25th of the screen

    }
    public void paint(Graphics g, float score,int loser, boolean exist){

        g.setFont(large);//sets the font to large
        g.setColor(Color.black);//sets the background color to black
        g.fillRect(0, 0, width, height);//fills the background
        g.setColor(Colorr[(int)Math.floor(Math.random()*Colorr.length)]);//sets the font color to random
        g.drawString("GAME",(int) (width / 2 - font * 1.5), height/2);//prints out the "GAME" in the middle of the screen
        g.drawString("OVER",(int) (width / 2 - font * 1.5), height/2+font);//prints out "OVER" in the middle of the screen
        g.setFont(medium);//changes the font to medium
        g.setColor(Color.DARK_GRAY);//changes the font color to dark gray
        g.drawString("'1' for single",0,font/8);
        g.drawString("'2' for two player",0,font/8+font/5);
        g.drawString("'r' to play",0,font/8+font/5+font/5);
        g.drawString("'ESC' to quit",0,font/8+font/5+font/5+font/5);//prints out instructions for the game
        g.setColor(Color.GREEN);//changes the color to gray
        if(exist){
            g.drawString("Player "+loser+" lost!",0,height-font/4);//if the game was in 2 player mode, then displays "player __ lost"
        }
        else{
            g.drawString("Your score was "+score+" seconds!",0,height-font/4);//if the game was in 1 player mode, then displays the score (in seconds)
        }

}}