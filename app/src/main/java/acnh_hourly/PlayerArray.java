package acnh_hourly;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class PlayerArray {
    MediaPlayer[] playerArray;
    static final int HOURS = 24;

    public PlayerArray(Weather weather) { 
            //constructor: creates the array of MediaPlayers and calls setTracks
            //weather enum dictates the version of the track
            playerArray = new MediaPlayer[HOURS];
            this.setTracks(weather.toString());
        }

    public MediaPlayer get (int i) {
            
        return playerArray[i];
    }

    public void play (int i) {
        //System.out.println("playing: " + playerArray[i].getMedia().getSource());
        playerArray[i].play();
    }

    public void setTracks(String version) {
        //populates the array with MediaPlayers containing the appropriate Media for each track 
        
        for (int i = 0; i < HOURS ; i++) {
            String filename = "resources/" + version + (i < 10 ? "0" : "") + i + ".mp3";
            playerArray[i] = new MediaPlayer(new Media(new File(filename).toURI().toString()));
            playerArray[i].setCycleCount(MediaPlayer.INDEFINITE);
        }
    }

    public void stop(int i) {
        playerArray[i].stop();
    }

    public void stop() {
        for (int i = 0; i < HOURS; i++) {
            playerArray[i].stop();
        }
    }


    public void pause(int i) {
        playerArray[i].pause();
    }
    
}
