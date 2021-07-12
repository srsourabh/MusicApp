import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;


public class main {
	
	private static ArrayList<Album> albums = new ArrayList<Album>();


	public static void main(String[] args) {
		
		
		Album album = new Album("Album1", "Ac/Dc");
		album.addSong("TNT",4.5);
		album.addSong("storm",4.0);
		album.addSong("Jawani",4);
		album.addSong("Challa",5);
		albums.add(album);
		
		album = new Album("Album2","Eminam");
		album.addSong("rap",2);
		album.addSong("storm",4.0);
		album.addSong("Jawani",4);
		album.addSong("Challa",5);
		albums.add(album);
		
		LinkedList<song> playList_1 = new LinkedList<>();
		albums.get(0).addToPlayList("TNT", playList_1);
		albums.get(0).addToPlayList("storm", playList_1);
		albums.get(0).addToPlayList("Jawani", playList_1);
		albums.get(0).addToPlayList("Challa", playList_1);

		
		play(playList_1);
	}
	
	private static void play(LinkedList<song>playList) {
		Scanner sc = new Scanner (System.in);
		boolean quit = false;
		boolean forward = true;
		ListIterator<song> listIterator = playList.listIterator();
				
			if(playList.size() == 0 ) {
				System.out.println("this pyalist has no song");
				
			}else {
				System.out.println("now playing" + listIterator.next().toString());
			}
		
			while(!quit) {
				int action = sc.nextInt();
				sc.hasNextLine();
				
				switch (action) {
				case 0:
					System.out.println("Playlist completed");
					quit = true;
					break;
					
				case 1:
					if(!forward) {
						if(listIterator.hasNext()) {
							listIterator.next();						
					}
					forward  = true;

				}
				if(listIterator.hasNext()) {
					System.out.println("now playing" +listIterator.next().toString() );
				
				}else {
					System.out.println("no song available reached to the end");
					forward = false;
				}
				break;
				case 2: 
					if(forward) {
						if(listIterator.hasPrevious()) {
							listIterator.previous();
						}
						forward  =  false;
					}
					if(listIterator.hasPrevious()) {
						System.out.println("now playing"+ listIterator.previous().toString());
					}else {
						System.out.println("We are at the first song");
					forward = false;
					
					}break;
					
				case 3:
					if(forward) {
						if(listIterator.hasPrevious()) {
							System.out.println("now playing " + listIterator.previous().toString());
						forward  = false;
						}else {
							System.out.println("we are at the start of the list");
						}
					}
						else {
							if(listIterator.hasNext()) {
								System.out.println("now playing"+listIterator.next().toString());
							forward = true;
							}else {
								System.out.println("we reached to end of the list");
							}
						}
					break;
				case 4:
					printList(playList);
					break;
				case 5:
					printMenu();
					break;
					
				case 6:
					if(playList.size()>0) {
						listIterator.remove();
						if(listIterator.hasNext()) {
							System.out.println("now playing " + listIterator.next().toString());
							forward = true;
						}
						else {
							if(listIterator.hasPrevious()) {
								System.out.println("now playing" +listIterator.previous().toString() );
								
							}
						}
					}
					}
			}
	}
	
	
	private static void printMenu() {
		System.out.println("Available options\n press");
		System.out.println("0 - to Quit\n" + 
		"1 - to play next song\n" + 
		"2 - to play previos song\n" + 
		"3 - To replay the current song\n" + 
		"4 - List all the songs\n" + 
		"5 - Print all available options\n" + 
		"6 - delete current song"
				);
	}
	private static void printList(LinkedList<song>playList) {
		Iterator<song> iterator = playList.iterator();
		System.out.println("-------------------------");
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

}
