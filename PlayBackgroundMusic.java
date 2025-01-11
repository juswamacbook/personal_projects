package newcode;

import java.io.File;
import javax.sound.sampled.*;

/**
 * @author Josh, Alex
 * Here is a class of where the background music is played.
 */
public class PlayBackgroundMusic {
	
	Clip clip; //clip acts like a CD player, defined at class level
	
	/**
	 * Default constructor
	 */
    PlayBackgroundMusic(){

        String filepath = "No Worries.wav"; // here is the file of the song
        
        try {
            File musicPath = new File(filepath);

            // set a condition for if the file exists
            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip(); // create a clip that acts like a CD Player
                clip.open(audioInput); // to then open the "CD Player"
                clip.loop(Clip.LOOP_CONTINUOUSLY); // will loop the song
            } else {
                System.out.println("Can't find file"); // song is not found
            }

        }
        catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * This helper method plays the current clip
     */
    public void playMusic() {
    	this.clip.start(); // starts to play the song
    }
    
    /**
     * This helper method stops the current clip
     */
    public void stopMusic() {
    	this.clip.stop();
    }

}
