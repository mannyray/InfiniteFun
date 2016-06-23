//'Infinite Fun' by Braden, Dan and Stan.
package computersummative;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;

public class Main extends JFrame{
    public Main(){
      GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
      if (device.isFullScreenSupported())//gets the dimensions of the screen
      { 
         this.setUndecorated(true);    //Don't show the title or border
         this.setResizable(false);     //Make the window size not resizable
         device.setFullScreenWindow(this);
      }
      Control game = new Control(this.getWidth(), this.getHeight());//Implementing our control class
      this.setContentPane(game); // Set the Control game class as the stuff being shown
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//set default operation
      this.setTitle("Infinite Fun");  //The title - which is also not visible. However, it's not fullscreen mode on ubuntu
      this.pack();                    // Pack it to preferred size
      this.setVisible(true);          //Show the screen
    }
   public static void main(String[] args) {
      // Run UI in the Event Dispatcher Thread (EDT), instead of Main thread`
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            new Main();//start Main class
         }
      });
   }
}