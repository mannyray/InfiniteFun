//'Infinite Fun' by Braden, Dan and Stan.
package computersummative;

import java.awt.*;

public class Platforms {
    private int platformWidth;//varialbes used in class
    private int platformHeight;
    private int x;
    private int y;
    private int speed;
    private int arc;
    private int height;
    private int width;
    private int hHeight;
    private int hWidth;
    private int moving;
    private int addition;
    public int loser;

    private String platformTypeChoice;
    public String platformType[] = {"spiky","r","r","r","moving","spiky","r","r","r","r","moving","invisy","moving","moving","invisy"};//types of platforms (r is regular, moving is moving, invisy is fall through and spiky is spiked)
    private int[] sideSpeed={5,1,-2,-7,8,-5};//moving platform speed types
    
    public boolean GameOver;
    public boolean collision;

    

    public Platforms(Dimensions d,WallGenerator wg,int yStart, Hero h){//constructor --> defines the variables
        platformWidth = d.width/12;
        platformHeight = 10;//speed dimensions
        speed = wg.speed;//vertical speed of the platforms
        arc = 2;//curve of the platforms
        height = d.height;
        width = d.height;//dimensions of the screen
        arc = 3;
        y = yStart;//y coordinate
        x = (int)(Math.floor(Math.random()*width/2)+width/4);//x coordinate
        hHeight = h.HeroHeight;
        hWidth = h.HeroWidth;//hero dimensions
        platformTypeChoice= "r";//all platform types in the first moment are regular
       
    }
    public void paint(Graphics g){//painthing method
      if(platformTypeChoice.equals("moving")){//if the colour is moving, its colour is moving
        g.setColor(Color.MAGENTA);
      }
      else{
          g.setColor(Color.red);//all others are red
      }
      g.fillRoundRect(x,y,platformWidth,platformHeight,arc,arc);//draw platforms
      if(platformTypeChoice.equals("invisy")){//if its fall through - draw a white slash through it
          g.setColor(Color.white);
            g.drawLine(x,y+platformHeight/2,x+platformWidth,y+platformHeight/2);
      }
      if(platformTypeChoice.equals("spiky")){//if spiky draw spikes
          for(int i = 0; i < platformWidth; i += platformWidth/10){
              g.setColor(Color.white);
              g.drawLine(x+i, y, x+i, y-20);
          }/////////////////////////////////////////only the moving platforms, regular and fall through platforms and spiky platforms mix up their horizontal speeds to create a 'harder' aspect
      }
    }
      public void tracker(){
      y -= speed;
      addition += moving;
      if(addition>100||addition<-100){
          moving *=-1;
      }
      x -= moving;
      if(y+platformWidth<=0){
          y = height;
          x = (int)(Math.floor(Math.random()*width/2)+width/4);
          platformTypeChoice= platformType[(int)Math.floor(Math.random()*platformType.length)];
          if(platformTypeChoice.equals("moving")){
             moving = sideSpeed[(int)(Math.floor(Math.random()*sideSpeed.length))];
          }
      }
      }
      public boolean collision(Hero hh,boolean coll,int l){
          collision = false;
          if(!coll){//if the platforms hasn't collided already, check for collisions based on coordinates and dimensions
                    if(hh.x>=x-hWidth+1&&hh.x<=x+platformWidth&&hh.y<y&&hh.y+hHeight>=y+1&&!platformTypeChoice.equals("spiky")&&!platformTypeChoice.equals("invisy")){
                        collision = true;         //for regular platforms  and other except spiked and fall through
                     }
                    else if(hh.x>=x-hWidth+1&&hh.x<=x+platformWidth&&hh.y<y&&hh.y+hHeight>=y+1&&platformTypeChoice.equals("spiky")){

                            GameOver = true;//for spiked platforms
                            loser = l;
                     }
                    else{//for fall through platforms
                        collision = false;
                    }
          }
          else{//passes the value of the collision on if was already true
              collision = coll;
          }
       return(collision);
      }
      public int loser(int l){//loser determining method
          if(l!=0){
              loser = l;
          }
          return(loser);
      }
 }


