package itschool;

public class PlayListItem
{
	private int itemNumber;
	private String itemTitle;
	private String itemArtist;
	private String itemAlbumTitle;
	private byte itemRating;
	private int itemDuration;
	private String itemPath;
	
	public void setItemPath(String itemPath) 
	{
		this.itemPath = itemPath;
	}

	public String getItemPath() 
	{
		return this.itemPath;
	}
	
	public void setItemNumber(int itemNumber) 
	{
		this.itemNumber = itemNumber;
	}

	public int getItemNumber() {
		return this.itemNumber;
	}

	public void setItemTitle(String itemTitle) 
	{
		this.itemTitle = itemTitle;
	}

	public String getItemTitle() 
	{
		return this.itemTitle;
	}

	public void setItemArtist(String itemArtist) 
	{
		this.itemArtist = itemArtist;
	}

	public String getItemArtist() 
	{
		return this.itemArtist;
	}

	public void setItemAlbumTitle(String itemAlbumTitle) 
	{
		this.itemAlbumTitle = itemAlbumTitle;
	}

	public String getItemAlbumTitle() 
	{
		return this.itemAlbumTitle;
	}

	public void setItemRating(byte itemRating) 
	{
		this.itemRating = itemRating;
	}

	public byte getItemRating() 
	{
		return this.itemRating;
	}

	public void setItemDuration(int Duration) 
	{
		this.itemDuration = Duration;
	}

	public String getItemDuration() 
	{
		return String.format("%s:%s:%s", (itemDuration / 3600), ((itemDuration / 60) % 60), (itemDuration % 60));

	}

	public String getItemInfo() {
		return this.itemNumber + ") " + itemArtist + " - " + itemTitle + "[" + itemAlbumTitle + "] (" + itemRating
				+ ") - " + this.getItemDuration();
	}
}