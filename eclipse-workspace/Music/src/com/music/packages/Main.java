package com.music.packages;
import java.util.*;

public class Main {

	public static ArrayList<Album> albums = new ArrayList<>(); 
	public static void main(String[] args) {
		
		Album album = new Album("album1","Imagine dragon");
		album.addSong("thunder",4.00);
		album.addSong("beliver",4.50);
		album.addSong("bird",3.20);
		albums.add(album);
		
		album = new Album("album2" , "one direction");
		album.addSong("beautifull", 3.55);
		album.addSong("steal my girl", 4.20);
		album.addSong("prefect", 4.00);
		album.addSong("night changes", 4.35);
		albums.add(album);
		
		LinkedList<Song> playlist_1 = new LinkedList<>();
		
		albums.get(0).addtoPlayList("thunder",playlist_1);
		albums.get(0).addtoPlayList("beliver", playlist_1);
		albums.get(1).addtoPlayList("steal my girl", playlist_1);
		albums.get(1).addtoPlayList("night changes", playlist_1);
		
		LinkedList<Song> playlist_2 = new LinkedList<>();
		
		albums.get(0).addtoPlayList("bird", playlist_2);
		albums.get(1).addtoPlayList("prefect", playlist_2);
		albums.get(1).addtoPlayList("beautifull", playlist_2);
		
		play(playlist_1);

	}
	
	private static void play(LinkedList<Song>playlist) {
		Scanner sc = new Scanner(System.in);
		boolean quit = false;
		boolean forward = true;
		ListIterator<Song> listIterator = playlist.listIterator();
		
		if(playlist.size() == 0) {
				System.out.println("Playlist is empty");
			}else {
				System.out.println("Now playing " + listIterator.next().toString());
				printMenu();
			}
		
		while(!quit) {
			int x = sc.nextInt();
			
			switch(x) {
			case 0:
				System.out.println("stopped playing playlist");
				quit = true;
				break;
				
			case 1:
				if(!forward) {
					if(listIterator.hasNext()) {
						listIterator.next();
						forward = true;
						
					}
				}
					if(listIterator.hasNext()) {
						System.out.println("Now playing" + listIterator.next().toString());
					}else {
						System.out.println("Playlist has reached to end");
					}
				
				break;
				
			case 2 :
				if(forward) {
					if(listIterator.hasPrevious()) {
						listIterator.previous();
					}
					forward = false;
				}
				if(listIterator.hasPrevious()) {
					System.out.println("Now playing previous song " + listIterator.previous().toString());
				}else {
					System.out.println("Playlist is playing first song");
					forward = false;
				}
				break;
				
			case 3 :
				if(forward) {
					if(listIterator.hasPrevious()) {
						System.out.println("Now playing " + listIterator.previous().toString());
						forward = false;
					}else {
						System.out.println("You are at the Start of the list");
					}
				}else {
					if(listIterator.hasNext()) {
						System.out.println("Now playing " + listIterator.next().toString());
						forward = true;
					}else {
						System.out.println("you are at the end of the list");
					}
				}
				break;
				
			case 4:
				printList(playlist);
				break;
				
			case 5:
				printMenu();
				break;
				
			case 6:
				if(playlist.size() >= 0) {
					listIterator.remove();
					if(listIterator.hasNext()) {
						System.out.println("Now playing " + listIterator.next().toString());
					}else {
						if(listIterator.hasPrevious()) {
							System.out.println("Now playing " + listIterator.previous().toString());
						}
					}
				}
				break;
			}
			
		}
	}
	
	private static void printMenu() {
		System.out.println("Available option\n press");
		System.out.println("0 - to Quit \n"+
				"1 - play next song \n"+
				"2 - to play presvious song \n"+
				"3 - to replay current song\n"+
				"4 - List of all songs\n"+
				"5 - print all alvailabe option\n"+
				"6 - delete current song\n"
				);
	}
	
	private static void printList(LinkedList<Song>playlist) {
		Iterator<Song> iterator = playlist.iterator();
		
		System.out.println("------------------");
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		System.out.println("------------------");
	}

}
