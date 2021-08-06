package com.NHLStenden;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

// The class that handles the playing of alarm sound
public class Sound
{
    // Plays the weather alarm
    public void playSound()
    {
        try
        {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(System.getProperty("user.dir") + "\\src\\com\\NHLStenden\\Audio\\Warning.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex)
        {
            System.out.println("Error with playing sound. But crop damage is still incoming!");
            ex.printStackTrace();
        }
    }
}