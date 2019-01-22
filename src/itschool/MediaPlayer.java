package itschool;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MediaPlayer {
    enum CurrentState {playing, stopped, paused};
    enum RepeatMode {repeatAll, repeatOneSong, NoRepeat};

	CurrentState currentState;
	RepeatMode repeatMode;
	AdvancedPlayer zoomPlayer;
	
	public Playlist playlist;
	
	private int CurrentVolume = 60;
	private int CurrentSongProgress;
	private int CurrentTrackNumber;

	byte defaultVolume = 60; byte minVolume = 0; byte maxVolume = 100;
	
	public void setVolume(int i){
		if (i > 0) {
			if (this.CurrentVolume != maxVolume)
				this.CurrentVolume++;
		} else 
			if (i < 0) 
			{
				if (this.CurrentVolume != minVolume)
					this.CurrentVolume--;
			}
			else
				this.CurrentVolume = this.defaultVolume;
	
	}

	
	public void changeCurrentState(CurrentState currentState) throws FileNotFoundException, JavaLayerException
	{
		this.currentState = currentState;
		if (currentState != CurrentState.stopped)
			this.play();
	}
	
	public void play() throws JavaLayerException, FileNotFoundException
	{
		FileInputStream mp3Path = new FileInputStream("2.mp3");
		zoomPlayer = new AdvancedPlayer(mp3Path);
		
		if(this.currentState == CurrentState.paused)
		{
			System.out.println("Continue playing from " + this.CurrentSongProgress);
			zoomPlayer.play(200, 10000000);
		}
		else
		{
			System.out.println("Playing process was started from the beginning.");
			zoomPlayer.play();
		}
		
	}
	
	// -1 Previous, 0 Next, any positive value is a TrackNumber 
	public boolean goToTrack(int trackNumber)
	{
		if (trackNumber == 0)
		{			
			if (this.CurrentTrackNumber >= this.playlist.itemQuantity)
				this.CurrentTrackNumber = 1;
			else 
				this.CurrentTrackNumber++;
			return true;
		}
		else if (trackNumber == -1)
		{
			if (this.CurrentTrackNumber == 1)
				this.CurrentTrackNumber = this.playlist.itemQuantity;
			else 
				this.CurrentTrackNumber--;
			return true;			
		}
		else if (trackNumber > 0 && trackNumber < this.playlist.itemQuantity)
		{
			this.CurrentTrackNumber = trackNumber;
			return true;
		}
		else
			return false;
		
	}
	public void setCurrentVolume(int CurrentVolume) {
		this.CurrentVolume = CurrentVolume;
	}

	public void createPlayList(String path)
	{
		playlist = new Playlist(path);
		playlist.loadPlaylist();
		this.CurrentTrackNumber = this.playlist.itemCurrent;
		this.currentState = CurrentState.stopped;
		this.CurrentSongProgress = 10;
	}
	
	public int getCurrentVolume() {
		return this.CurrentVolume;
	}

	public void setCurrentSongProgress(int currentSongProgress) {
		this.CurrentSongProgress = currentSongProgress;
	}

	public int getCurrentSongProgress() {
		return this.CurrentSongProgress;
	}

	public void setCurrentTrackNumber(int currentTrackNumber) {
		CurrentTrackNumber = currentTrackNumber;
	}

	public int getCurrentTrackNumber() {
		return this.CurrentTrackNumber;
	}
}
