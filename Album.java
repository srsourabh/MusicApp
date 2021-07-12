import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
// properties of album
	private String name;
	private String artist;
	private ArrayList<song> songs;
	
	public Album(String name, String artist) {
		
		this.name = name;
		this.artist = artist;
		this.songs = new ArrayList<song>();
	}
	public Album() {
		
	}
	  //create findSong method to check the song is already exist or not
	
	public song findSong (String title) {
		for(song checkedSong : songs) {
			if(checkedSong.getTitle().equals(title))return checkedSong;
		}
		
		return null;
	}
	
	// to add songs in album
	
	public boolean addSong(String title, double duration) {
		if(findSong(title) == null) {
			songs.add(new song(title, duration));
			//System.out.println(title + "Successfully added to the lisy");
			return true;
		}
		else {
			//System.out.println("Song with name " + title + "already exist in the list");
			return false;
		}
		
	}
	
	//create playlist to add a song with tracknumbber
	public boolean addToPlayList(int trackNumber, LinkedList<song> playList) {
		int index = trackNumber -1 ;
		if(index>0 && index<=this.songs.size())
		{
			playList.add(this.songs.get(index));
			return true;
		}
		//System.out.println("This album does not have song");
		return false;
		
	}
	//create playlist to add a song with title (overloading)
	public boolean addToPlayList(String title, LinkedList<song>playList) {
		for(song checkedSong : this.songs) {
			if(checkedSong.getTitle().equals(title)) {
				playList.add(checkedSong);
				return true;
				
			}
		}
		//System.out.println(title + " There is no such song");
		return false;
		
	}
	
}
