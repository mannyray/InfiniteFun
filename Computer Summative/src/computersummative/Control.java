//'Infinite Fun' by Braden, Dan and Stan.

package computersummative;
/*This is the 'MASTER' class. This class cannot run on its own and therefore is run by the Main class.
 It is responsible for implementing all of the other classes such as Dimensions, Hero, Wall
 Generator, Information, Music into one unit. This class has a painting, updating and a keylistener
 function.
*/
import java.awt.*;//imports
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;

public class Control extends JPanel{

    private draw draw;//class for visuals
    public Dimensions d;//for the dimensions of the screen
    public Hero hero,hero2;//the heros
    private Music music;//for music playing
    public Information info;//display time on screen
    public Tutorial tutu;//tutorial
    public GameOver KO;//GameOver Screen

    public WallGenerator wg0;//Generates the side walls
    public WallGenerator wg1;
    public WallGenerator wg2;
    public WallGenerator wg3;
    public WallGenerator wg4;
    public WallGenerator wg5;
    public WallGenerator wg6;
    public WallGenerator wg7;
    public WallGenerator wg8;
    public WallGenerator wg9;
    public WallGenerator wg10;
    public WallGenerator wg11;
    public WallGenerator wg12;
    public WallGenerator wg13;
    public WallGenerator wg14;
    public WallGenerator wg15;
    public WallGenerator wg16;
    public WallGenerator wg17;
    public WallGenerator wg18;
    public WallGenerator wg19;
    public WallGenerator wg20;
    public WallGenerator wg21;
    public WallGenerator wg22;
    public WallGenerator wg23;
    public WallGenerator wg24;
    public WallGenerator wg25;

    public Platforms pl;//Generate the platforms
    public Platforms pl2;
    public Platforms pl3;
    public Platforms pl4;
    public Platforms pl5;
    public Platforms pl6;
    public Platforms pl7;
    public Platforms pl8;
    public Platforms pl9;
    public Platforms pl10;
    public Platforms pl11;
    public Platforms pl12;
    public Platforms pl13;
    public Platforms pl14;
    public Platforms pl15;

    private int ScreenHeight,ScreenWidth;//the dimensions of the screen
    private int HeroX,HeroY;//first hero
    private int HeroX2, HeroY2;//second hero
    private int gravity, gravity2,left,right;//moving values of the hero
    public double time,updateColourTimeMili = 3000;//used in updating the colour of the screen
    private int ColorChoice;
    private Color Colorr[] = {Color.BLUE,Color.CYAN, Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.WHITE, Color.YELLOW};//array with all the possible colours that could be used
    private float score;//calculating score
    private int loser;//used for finding loser
    
    private boolean leftt, rightt,leftt2,rightt2;//booleans used in combination with keylistener and keyreleased methods to provide a smooth moving hero
    private boolean collision1, collision2;//for catching the collision of the hero with the platform
    public boolean GameOver,restart,hero2EXISTS,intro=true;//game condition states Gameover when someone losess, restart when user presses r, heroExists for 2nd player mode and intro for tutorial


    public Control(int width, int height){

        ScreenHeight = height;//initializing what height and width variables equals
        ScreenWidth = width;

        d = new Dimensions(ScreenWidth,ScreenHeight, Color.BLACK);//setting the background     a lot of classes depend on the values of this class to make everything proportional
        KO = new GameOver(d);//constructing gameover screen
        tutu = new Tutorial(d);//constructing the tutorial screen
        hero = new Hero(d, Color.blue);//setting hero 1
        hero2 = new Hero(d, Color.green);//setting hero 2
        draw = new draw();//for drawing clas
        music = new Music("Night_theme.wav");//constucting music class
        music.play();//starting to play music

       

        wg0 = new WallGenerator(d,0);//constructing wallGenerators classes (side walls)
        wg1 = new WallGenerator(d,1);//the integer is for setting the order of the wall in the beggining, 0 being the very top (
        wg2 = new WallGenerator(d,2);
        wg3 = new WallGenerator(d,3);
        wg4 = new WallGenerator(d,4);
        wg5 = new WallGenerator(d,5);
        wg6 = new WallGenerator(d,6);
        wg7 = new WallGenerator(d,7);
        wg8 = new WallGenerator(d,8);
        wg9 = new WallGenerator(d,9);
        wg10 = new WallGenerator(d,10);
        wg11 = new WallGenerator(d,11);
        wg12 = new WallGenerator(d,12);
        wg13 = new WallGenerator(d,13);
        wg14 = new WallGenerator(d,14);
        wg15 = new WallGenerator(d,15);
        wg16 = new WallGenerator(d,16);
        wg17 = new WallGenerator(d,17);
        wg18 = new WallGenerator(d,18);
        wg19 = new WallGenerator(d,19);
        wg20 = new WallGenerator(d,20);
        wg21 = new WallGenerator(d,21);
        wg22 = new WallGenerator(d,22);
        wg23 = new WallGenerator(d,23);
        wg24 = new WallGenerator(d,24);
        wg25 = new WallGenerator(d,25);

        pl = new Platforms(d,wg0,d.height/12*1,hero);//constructing platform classes(for platforms)
        pl2 = new Platforms(d,wg0,d.height/12*2,hero);//the integer is for setting the platform order
        pl3 = new Platforms(d,wg0,d.height/12*3,hero);//wg0 is for getting the speed of the platforms moving up to match the speed of the walls
        pl4 = new Platforms(d,wg0,d.height/12*4,hero);//hero is for being able to do collision testing later on based on dimensions
        pl5 = new Platforms(d,wg0,d.height/12*5,hero);
        pl6 = new Platforms(d,wg0,d.height/12*5,hero);
        pl7 = new Platforms(d,wg0,d.height/12*7,hero);
        pl8 = new Platforms(d,wg0,d.height/12*8,hero);
        pl9 = new Platforms(d,wg0,d.height/12*9,hero);
        pl10 = new Platforms(d,wg0,d.height/12*10,hero);
        pl11 = new Platforms(d,wg0,d.height/12*11,hero);
        pl12 = new Platforms(d,wg0,d.height/12*12,hero);
        pl13 = new Platforms(d,wg0,d.height/12*2,hero);
        pl14 = new Platforms(d,wg0,d.height/12*7,hero);
        pl15 = new Platforms(d,wg0,d.height/12*5,hero);

        info = new Information(d, wg25);//score udpate component

        HeroX = d.width/2;//hero coordinates
        HeroY = d.height/2-hero.HeroHeight;//hero coordinates
        HeroX2 = d.width/2+20;//hero 2 coordinates
        HeroY2 = d.height/2-hero.HeroHeight;//hero 2 coordinates
        
        gravity = 7;//falling down and moving right/left values
        gravity2 = 7;
        left = -20;
        right = 20;


        
        
        this.setLayout(new BorderLayout());
        this.add(draw, BorderLayout.CENTER);//adding the visual component to the screen


        this.addKeyListener(new KeyAdapter() {//key pressed key listener
        @Override
         public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
            case KeyEvent.VK_ESCAPE://escape to quit
               System.exit(0);
               break;
             case KeyEvent.VK_LEFT://for hero 1 (left to go left and right to go right)
                 leftt = true;
                 break;
             case KeyEvent.VK_RIGHT:
                 rightt = true;
                 break;
             case KeyEvent.VK_R:
                 intro = false;
                 restart = true;
                 break;
                case KeyEvent.VK_A://for hero 2 (a to go left and d to go right)
                    leftt2 = true;
                    break;
                case KeyEvent.VK_D:
                    rightt2 = true;
                    break;
                case KeyEvent.VK_2://key sets multiplayer mode
                    hero2EXISTS = true;//sets that the second player is now in the game
                    HeroX2 = d.width/2+20;//hero 2 coordinates
                    HeroY2 = d.height/2-hero.HeroHeight;//hero 2 coordinates
                    break;
                case KeyEvent.VK_1:

                    hero2EXISTS = false;
                    break;
            }
         }
      });
      /////////////////////////////////////
      //boolean affect with the motion of the hero keys allows the heros to have a more instantaneous and smoother movement on the screen
      ///////////////////////////////////
      this.setFocusable(true);//add keylistner to the window
      
      this.addKeyListener(new KeyAdapter() {
        @Override
         public void keyReleased(KeyEvent e) {//key listener for
            int keyCode = e.getKeyCode();
            switch (keyCode) {
             case KeyEvent.VK_LEFT://for hero 1 (left to go left and right to go right)
                 leftt = false;
                 break;
             case KeyEvent.VK_RIGHT:
                 rightt = false;
                 break;
             case KeyEvent.VK_R:
                 time =  System.currentTimeMillis()+updateColourTimeMili;//restart the colour changing (if no included, the colours would flash for a while after restart)
                 intro = false;
                 restart = true;
                 break;
             case KeyEvent.VK_A://for hero 2 (a to go left and d to go right)
                leftt2 = false;
                break;
            case KeyEvent.VK_D:
                rightt2 = false;
                break;
            }
         }
      });
      this.setFocusable(true);//add keylistner to the window
  
        Start();//start game 
    }
    
    public void Start(){//start game
      Thread t = new Thread() {//define thread
         public void run() {//run method --> constantly running
            while (true) {
                update();//update mainly for coordinates of game components
                repaint();//for visual aspect
                try {
                  Thread.sleep(1000 /30);//sleep rate
               } catch (InterruptedException ex) {}

            }
         }
      };
      t.start();//start thread
    }
    public void update(){
        //In charge of changing colour of walls
        if(GameOver== false&&restart== false&&intro== false){//if the tutorial, the gameover and restart are all false then run the game loginc.
            if(System.currentTimeMillis()>time)//updating colour every certain period of time
            {
                time += updateColourTimeMili;
                ColorChoice += 1;
                if(ColorChoice > Colorr.length-1)
                {
                    ColorChoice = 0;
                }
            }
            GameOver = false;
            wg0.tracker(hero,hero2, hero2EXISTS);//tracking the y position of the wall and checking for collisions
            wg1.tracker(hero,hero2, hero2EXISTS);
            wg2.tracker(hero,hero2, hero2EXISTS);
            wg3.tracker(hero,hero2, hero2EXISTS);
            wg4.tracker(hero,hero2, hero2EXISTS);
            wg5.tracker(hero,hero2, hero2EXISTS);
            wg6.tracker(hero,hero2, hero2EXISTS);
            wg7.tracker(hero,hero2, hero2EXISTS);
            wg8.tracker(hero,hero2, hero2EXISTS);
            wg9.tracker(hero,hero2, hero2EXISTS);
            wg10.tracker(hero,hero2, hero2EXISTS);
            wg11.tracker(hero,hero2, hero2EXISTS);
            wg12.tracker(hero,hero2, hero2EXISTS);
            wg13.tracker(hero,hero2, hero2EXISTS);
            wg14.tracker(hero,hero2, hero2EXISTS);
            wg15.tracker(hero,hero2, hero2EXISTS);
            wg16.tracker(hero,hero2, hero2EXISTS);
            wg17.tracker(hero,hero2, hero2EXISTS);
            wg18.tracker(hero,hero2, hero2EXISTS);
            wg19.tracker(hero,hero2, hero2EXISTS);
            wg20.tracker(hero,hero2, hero2EXISTS);
            wg21.tracker(hero,hero2, hero2EXISTS);
            wg22.tracker(hero,hero2, hero2EXISTS);
            wg23.tracker(hero,hero2, hero2EXISTS);
            wg24.tracker(hero,hero2, hero2EXISTS);
            wg25.tracker(hero,hero2, hero2EXISTS);

            pl.tracker();//tracking platforms location (updating)
            pl2.tracker();
            pl3.tracker();
            pl4.tracker();
            pl5.tracker();
            pl6.tracker();
            pl7.tracker();
            pl8.tracker();
            pl9.tracker();
            pl10.tracker();
            pl11.tracker();
            pl12.tracker();
            pl13.tracker();
            pl14.tracker();
            pl15.tracker();

            collision1 = pl.collision(hero,collision1,1);//collision tester designed that if one of the collision booleans is true, it carries on all the way through
            collision1 = pl2.collision(hero,collision1,1);//collision is for platform
            collision1 = pl3.collision(hero,collision1,1);
            collision1 = pl4.collision(hero,collision1,1);
            collision1 = pl5.collision(hero,collision1,1);
            collision1 = pl6.collision(hero,collision1,1);
            collision1 = pl7.collision(hero,collision1,1);
            collision1 = pl8.collision(hero,collision1,1);
            collision1 = pl9.collision(hero,collision1,1);
            collision1 = pl10.collision(hero,collision1,1);
            collision1 = pl11.collision(hero,collision1,1);
            collision1 = pl12.collision(hero,collision1,1);
            collision1 = pl13.collision(hero,collision1,1);
            collision1 = pl14.collision(hero,collision1,1);
            collision1 = pl15.collision(hero,collision1,1);

            if(hero2EXISTS){//if the second hero do the same type of collision
                collision2 = pl.collision(hero2,collision2,2);
                collision2 = pl2.collision(hero2,collision2,2);
                collision2 = pl3.collision(hero2,collision2,2);
                collision2 = pl4.collision(hero2,collision2,2);
                collision2 = pl5.collision(hero2,collision2,2);
                collision2 = pl6.collision(hero2,collision2,2);
                collision2 = pl7.collision(hero2,collision2,2);
                collision2 = pl8.collision(hero2,collision2,2);
                collision2 = pl9.collision(hero2,collision2,2);
                collision2 = pl10.collision(hero2,collision2,2);
                collision2 = pl11.collision(hero2,collision2,2);
                collision2 = pl12.collision(hero2,collision2,2);
                collision2 = pl13.collision(hero2,collision2,2);
                collision2 = pl14.collision(hero2,collision2,2);
                collision2 = pl15.collision(hero2,collision2,2);
                if(collision2){// if the character is on the platforms, his vertical speed will change to match the speed of the platforms
                    gravity2 =  -wg0.speed;
                 }
                else{//if the hero is not on a platform he will continue falling down towards the bottom of the screen at a 7 pixel rate
                    gravity2 = 7;
                }
            }
            if(collision1){// if the character is on the platforms, his vertical speed will change to match the speed of the platforms
                gravity = -wg0.speed;
            }
            else{
                gravity = 7;//if the hero is not on a platform he will continue falling down towards the bottom of the screen at a 7 pixel rate
            }

            
            if(hero.y<=0||hero.y+hero.HeroHeight>=d.height){//if hero hits the top
                loser = 1;//who is the loser --> needed for GameOver class
                GameOver = true;//the condition of the game is now GameOver
            }
            if(hero2EXISTS){//if second player is playing
                if(hero2.y<=0||hero2.y+hero2.HeroHeight>=d.height){//if hero hits the top
                    loser = 2;//who is the loser --> needed for GameOver class
                    GameOver = true;//the condition of the game is now GameOver
                }
            }
             if(wg0.GameOver||wg1.GameOver||wg2.GameOver||wg3.GameOver||wg4.GameOver||wg5.GameOver||wg6.GameOver||wg7.GameOver||wg8.GameOver||wg9.GameOver||wg10.GameOver||wg11.GameOver||wg12.GameOver||wg13.GameOver||wg14.GameOver||wg15.GameOver||wg16.GameOver||wg17.GameOver||wg18.GameOver||wg19.GameOver||wg20.GameOver||wg21.GameOver||wg22.GameOver||wg23.GameOver||wg24.GameOver||wg25.GameOver){
                 if(hero2EXISTS){//if the hero hit one of the side walls, the program will determine the loser
                    loser = wg0.GameOver(loser);//same technique of carrying the value of one loser through the entire selection
                    loser = wg1.GameOver(loser);
                    loser = wg2.GameOver(loser);
                    loser = wg3.GameOver(loser);
                    loser = wg4.GameOver(loser);
                    loser = wg5.GameOver(loser);
                    loser = wg6.GameOver(loser);
                    loser = wg7.GameOver(loser);
                    loser = wg8.GameOver(loser);
                    loser = wg9.GameOver(loser);
                    loser = wg10.GameOver(loser);
                    loser = wg11.GameOver(loser);
                    loser = wg12.GameOver(loser);
                    loser = wg13.GameOver(loser);
                    loser = wg14.GameOver(loser);
                    loser = wg15.GameOver(loser);
                    loser = wg16.GameOver(loser);
                    loser = wg17.GameOver(loser);
                    loser = wg18.GameOver(loser);
                    loser = wg19.GameOver(loser);
                    loser = wg20.GameOver(loser);
                    loser = wg21.GameOver(loser);
                    loser = wg22.GameOver(loser);
                    loser = wg23.GameOver(loser);
                    loser = wg24.GameOver(loser);
                    loser = wg25.GameOver(loser);
                 }
                 GameOver = true;//the condition of the game is now GameOver
             }

             if(pl.GameOver||pl2.GameOver||pl3.GameOver||pl4.GameOver||pl5.GameOver||pl6.GameOver||pl7.GameOver||pl8.GameOver||pl9.GameOver||pl10.GameOver||pl11.GameOver||pl12.GameOver||pl13.GameOver||pl14.GameOver||pl15.GameOver){
                    GameOver = true;//the condition of the game is now GameOver
                    //if the hero hits the spiky platform, this if statement is activated
                    if(hero2EXISTS){
                        loser = pl.loser(loser);//same technique of carrying the value of one loser through the entire selection
                        loser = pl2.loser(loser);
                        loser = pl3.loser(loser);
                        loser = pl4.loser(loser);
                        loser = pl5.loser(loser);
                        loser = pl6.loser(loser);
                        loser = pl7.loser(loser);
                        loser = pl8.loser(loser);
                        loser = pl9.loser(loser);
                        loser = pl10.loser(loser);
                        loser = pl11.loser(loser);
                        loser = pl12.loser(loser);
                        loser = pl13.loser(loser);
                        loser = pl14.loser(loser);
                        loser = pl15.loser(loser);
                    }
            }

            if(rightt){//if right is pressed, the hero coordinates will get adjusted acordingly
                HeroX+= right;
            }
            if(leftt){//if left is pressed, the hero coordinates will get adjusted acordingly
                HeroX+= left;
            }
            if(hero2EXISTS){//only goes if the second hero exists
                if(rightt2){//if d is pressed, the hero coordinates will get adjusted acordingly
                HeroX2+= right;
                }
                if(leftt2){//if a is pressed, the hero coordinates will get adjusted acordingly
                HeroX2+= left;
                }
                HeroY2 += gravity2;
                hero2.HeroUpdate(HeroX2, HeroY2);//update second hero coordinates with horizontal and vertical motion
            }
            HeroY +=gravity;
            
            score = info.showScoreTime;//get score from the information class
            info.infoGather(GameOver,restart);//update the information with the game conditions
            hero.HeroUpdate(HeroX, HeroY);

            collision1 = false;//collisions get reset after one update to actually make it possible to fall down if there is no platforms
            collision2 = false;
        }
        else{//all the other game conditions
            if(restart == true){//if the game has ben restarted - all of the classes and values get reset to original values
                HeroX = d.width/2;//hero coordinates
                HeroY = d.height/2-hero.HeroHeight;//hero coordinates
                HeroX2 = d.width/2+20;//hero 2 coordinates
                HeroY2 = d.height/2-hero.HeroHeight;//hero 2 coordinates
                loser = 0;
                hero.HeroUpdate(HeroX, HeroY);
                if(hero2EXISTS){
                    hero2.HeroUpdate(HeroX2, HeroY2);
                }
                GameOver = false;
                info.infoGather(GameOver,restart);
                GameOver = false;
                restart = false;
                collision1 = false;
                collision2 = false;
                pl = new Platforms(d,wg0,d.height/12*1,hero);
                pl2 = new Platforms(d,wg0,d.height/12*2,hero);
                pl3 = new Platforms(d,wg0,d.height/12*3,hero);
                pl4 = new Platforms(d,wg0,d.height/12*4,hero);
                pl5 = new Platforms(d,wg0,d.height/12*5,hero);
                pl6 = new Platforms(d,wg0,d.height/12*5,hero);
                pl7 = new Platforms(d,wg0,d.height/12*7,hero);
                pl8 = new Platforms(d,wg0,d.height/12*8,hero);
                pl9 = new Platforms(d,wg0,d.height/12*9,hero);
                pl10 = new Platforms(d,wg0,d.height/12*10,hero);
                pl11 = new Platforms(d,wg0,d.height/12*11,hero);
                pl12 = new Platforms(d,wg0,d.height/12*12,hero);
                pl13 = new Platforms(d,wg0,d.height/12*2,hero);
                pl14 = new Platforms(d,wg0,d.height/12*7,hero);
                pl15 = new Platforms(d,wg0,d.height/12*5,hero);
                
                wg0 = new WallGenerator(d,0);
                wg1 = new WallGenerator(d,1);
                wg2 = new WallGenerator(d,2);
                wg3 = new WallGenerator(d,3);
                wg4 = new WallGenerator(d,4);
                wg5 = new WallGenerator(d,5);
                wg6 = new WallGenerator(d,6);
                wg7 = new WallGenerator(d,7);
                wg8 = new WallGenerator(d,8);
                wg9 = new WallGenerator(d,9);
                wg10 = new WallGenerator(d,10);
                wg11 = new WallGenerator(d,11);
                wg12 = new WallGenerator(d,12);
                wg13 = new WallGenerator(d,13);
                wg14 = new WallGenerator(d,14);
                wg15 = new WallGenerator(d,15);
                wg16 = new WallGenerator(d,16);
                wg17 = new WallGenerator(d,17);
                wg18 = new WallGenerator(d,18);
                wg19 = new WallGenerator(d,19);
                wg20 = new WallGenerator(d,20);
                wg21 = new WallGenerator(d,21);
                wg22 = new WallGenerator(d,22);
                wg23 = new WallGenerator(d,23);
                wg24 = new WallGenerator(d,24);
                wg25 = new WallGenerator(d,25);
            }
        }
    }
 class draw extends JPanel{//drawing class
        @Override
    public void paintComponent(Graphics g) {
         super.paintComponent(g);
         ///////////Paint everything onto the screen
         if(GameOver==false&&restart==false&&intro == false){//if the game is running
             d.paint(g);//background
             hero.paint(g);//hero 1
             if(hero2EXISTS){//if hero 2 exists
                 hero2.paint(g);//hero 2
             }
             g.setColor(Colorr[ColorChoice]);
             wg0.paint(g);//paint walls
             wg1.paint(g);
             wg2.paint(g);
             wg3.paint(g);
             wg4.paint(g);
             wg5.paint(g);
             wg6.paint(g);
             wg7.paint(g);
             wg8.paint(g);
             wg9.paint(g);
             wg10.paint(g);
             wg11.paint(g);
             wg12.paint(g);
             wg13.paint(g);
             wg14.paint(g);
             wg15.paint(g);
             wg16.paint(g);
             wg17.paint(g);
             wg18.paint(g);
             wg19.paint(g);
             wg20.paint(g);
             wg21.paint(g);
             wg22.paint(g);
             wg23.paint(g);
             wg24.paint(g);
             wg25.paint(g);
             pl.paint(g);//paint platforms
             pl2.paint(g);
             pl3.paint(g);
             pl4.paint(g);
             pl5.paint(g);
             pl6.paint(g);
             pl7.paint(g);
             pl8.paint(g);
             pl9.paint(g);
             pl10.paint(g);
             pl11.paint(g);
             pl12.paint(g);
             pl13.paint(g);
             pl14.paint(g);
             pl15.paint(g);
             info.paint(g);//paint score
         }
         else if(intro){//if intro is true then only paint the tutorial screen
             tutu.paint(g);
         }
         else if(restart){//if restsart is true
             GameOver=false;
         }
         else if(restart==false&&intro == false&&GameOver){//if the player(s) just lost then display the gameover screen
             KO.paint(g,score,loser,hero2EXISTS);
         }
        }
        @Override
      public Dimension getPreferredSize() {//prevents screen from being a tiny 1 pixel by 1 pixel window
         return (new Dimension(ScreenWidth, ScreenHeight));
      }
 
}
}