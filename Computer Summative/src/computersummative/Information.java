//'Infinite Fun' by Braden, Dan and Stan.
package computersummative;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Information {
    private long time = System.currentTimeMillis()+100;//initializes time as the current time in milliseconds +100
    private float scoreTime = 0;//initializes the score time to 0
    public float showScoreTime;
    private boolean alreadySeen;//initializes variables
    private String info = "0 s";//sets info to start off at 0 seconds
    private Font f = new Font("serif", Font.PLAIN, 40);//sets font f as serif, plain, and size 40
    private int height;//declares height
    public Information(Dimensions d,WallGenerator wg){
        height = d.height;//initializes height to be the height of the screen
    }
    public void paint(Graphics g){
        g.setColor(Color.BLACK);//sets the color of the font to black
        g.setFont(f);//sets the font to f
        g.drawString(info,20,height-100);//prints out the current score (time) in the bottom left corner
    }
    public void infoGather(boolean GameOver,boolean restart){
    if(restart||GameOver){
        if(!alreadySeen){
            showScoreTime = scoreTime/10;
        }
        alreadySeen = true;//if the game was restarted or user has died, set already seen to true
        scoreTime = 0;//resets score time to 0
    }
    else{
        alreadySeen = false;//otherwise, already seen is still false
        if(System.currentTimeMillis()>time){//if the system time is greater than
            scoreTime += 1;//if the system time is greater than the time displayed, add 1 (second) to the score time
            showScoreTime = scoreTime/10;//converts the scoretime to tenth of seconds
            info =((scoreTime/10))+"s";//prints out the current time (score)
            time += 100;
        }
    }
    }
}