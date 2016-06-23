//'Infinite Fun' by Braden, Dan and Stan.
package computersummative;
import java.io.*;
import sun.audio.*;
//class plays music
public class Music {
    private String titleOfSong;
    public Music(String title){
        titleOfSong = title;
    }
    //music credits to slick
    public void play(){//method replays music over and over using sun audio player
        AudioStream music;
            AudioData data;
            AudioPlayer player = AudioPlayer.player;
            ContinuousAudioDataStream loop = null;
            try {
                music = new AudioStream(new FileInputStream(titleOfSong));//streams music
                data = music.getData();//gets data of music
                loop = new ContinuousAudioDataStream(data);
                player.start(loop);//starts looping music
            } catch (IOException error) { System.out.println(error);
    }
}
}
