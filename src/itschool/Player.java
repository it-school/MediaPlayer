package itschool;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Player extends Thread
{
    int currentTrack = 2;
    AdvancedPlayer zoomPlayer;
    boolean isPaused;

    public void stopPlaying()
    {
        zoomPlayer.close();

    }

    public void kill()
    {
        //this.interrupt();
        this.stop();
    }

    public void pause() throws JavaLayerException
    {
        System.out.println(this.getState());
        if (this.isPaused)
        {
            this.resume();
        }
        else
        {
            this.suspend();
        }

        isPaused = !isPaused;
    }

    @Override
    public void run()
    {
        FileInputStream mp3Path = null;
        try
        {
            mp3Path = new FileInputStream("" + currentTrack + ".mp3");
            zoomPlayer = new AdvancedPlayer(mp3Path);
            System.out.println(this.getState());
            this.isPaused = false;
            zoomPlayer.play();
            System.out.println(this.getState());

        } catch (FileNotFoundException e)
        {
            System.out.println(e.getLocalizedMessage());
        } catch (JavaLayerException e)
        {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
