package itschool;

import javazoom.jl.decoder.JavaLayerException;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    static Player zplayer;
    public static void main(String[] args) throws FileNotFoundException, JavaLayerException
    {
        MediaPlayer player = new MediaPlayer();
        zplayer = new Player();
        /*
        player.createPlayList("playlist.pls");
*/



        Scanner reader = new Scanner(System.in);
        char key;
        do {
            System.out.println("| <<z | x>> | c # | v >/\" | b-stop | +/- volume | 0 - exit");
            System.out.println(player.getCurrentTrackNumber() + ") the player is " + player.currentState);
            System.out.println("Volume is " + player.getCurrentVolume() + " %.");
            key = reader.next().trim().charAt(0);
            System.out.println(key);
            switch (key) {
                case '0':
                    System.out.println("Stop&Exit");
                    zplayer.kill();
                    System.out.printf("Player stopped");
                    reader.close();
                    System.out.println("Total exit");
                    return;
                case 'z':
                    player.goToTrack(-1);
                    zplayer.currentTrack--;
                    break;
                case 'x':
                    player.goToTrack(0);
                    zplayer.currentTrack++;
                    break;
                case 'c': {
                    int trackNumber = reader.nextInt();
                    if (player.goToTrack(trackNumber) == false)
                        System.out.println("There is no such track number!");
                    break;
                }
                case 'p':
                    zplayer.pause();
                    break;
                case 's':
                    zplayer.stopPlaying();
                    break;
                case 'v':
                    zplayer.start();


                    /*
                    if (player.currentState == MediaPlayer.CurrentState.playing)
                    {
                        player.changeCurrentState(MediaPlayer.CurrentState.paused);
                        player.setCurrentSongProgress(500);
                    }
                    else if (player.currentState == MediaPlayer.CurrentState.paused)
                        player.changeCurrentState(MediaPlayer.CurrentState.playing);
                    else if (player.currentState == MediaPlayer.CurrentState.stopped)
                        player.changeCurrentState(MediaPlayer.CurrentState.playing);
                        */
                    break;
                case 'b':
                    player.changeCurrentState(MediaPlayer.CurrentState.stopped);

                    break;
                case '+': {
                    player.setVolume(1);
                    break;}
                case '-': {
                    player.setVolume(-1);
                    break;}
                case '*':{
                    player.setVolume(0);
                }
                default:
                    System.out.println("There is no such command!");
            }

        } while (true);
    }

}
