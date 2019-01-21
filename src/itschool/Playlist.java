package itschool;

import java.io.BufferedReader;
import java.io.FileReader;

public class Playlist
{
	String playlistPath;
	int itemQuantity;
	int itemCurrent;
	PlayListItem[]playList;
	
	Playlist(String playlistPath)
	{
		this.playlistPath = playlistPath;
	}

	public void setPlaylistPath (String playlistPath){this.playlistPath = playlistPath;}
	public String getPlaylistPath() {return this.playlistPath;}

	public void setItemQuantity(){this.itemQuantity = itemQuantity;}
	public int getItemQuantity(){return this.itemQuantity;}

	public void setItemCurrent (int itemCurrent){this.itemCurrent = itemCurrent;}
	public int getItemCurrent(){return this.itemCurrent;}

	public void playlistInitialize()
	{
		try 
		{
			FileReader fileReader = new FileReader(this.playlistPath);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String s = null;
			s = bufferedReader.readLine();
			this.itemQuantity = Integer.valueOf(s);
			s = bufferedReader.readLine();
			this.itemCurrent = Integer.valueOf(s);

			bufferedReader.close();
			fileReader.close();
			
			playList = new PlayListItem[this.itemQuantity];
			for (int i = 0; i < this.itemQuantity; i++)
				playList[i] = new PlayListItem();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}		
	}
	
	public void loadPlaylist()
	{
		this.playlistInitialize();
		try 
		{
			FileReader fr = new FileReader(this.playlistPath);
			BufferedReader br = new BufferedReader(fr);
			
			br.readLine();
			br.readLine();
			for (int i = 0; i < this.itemQuantity; i++ )
			{
				playList[i].setItemNumber(Integer.valueOf(br.readLine()));
				playList[i].setItemTitle(br.readLine());
				playList[i].setItemArtist(br.readLine());
				playList[i].setItemAlbumTitle(br.readLine());
				playList[i].setItemRating(Integer.valueOf(br.readLine()).byteValue());
				playList[i].setItemDuration(Integer.valueOf(br.readLine()));
				playList[i].setItemPath(br.readLine());								
			}
			
			br.close();
			fr.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}