package com.music.packages;
import java.util.*;

public class Main {

	public static HashMap <String , Album> albumNameWithObj = new HashMap<String , Album>();
	public static HashMap <String , LinkedList<Song>> PlaylistNameWithLindkedlist = new HashMap<String , LinkedList<Song>>();
	
	public static void main(String[] args) {
		
		
		addNewAlbum("album1","Imagine dragon");
		addSongToAlbum("album1","thunder",4.00);
		addSongToAlbum("album1","beliver",4.50);
		addSongToAlbum("album1","bird",3.20);
		
		
		addNewAlbum("album2","One direction");
		addSongToAlbum("album2","beautifull", 3.55);
		addSongToAlbum("album2","steal my girl", 4.20);
		addSongToAlbum("album2","prefect", 4.00);
		addSongToAlbum("album2","night changes", 4.35);
	
		addNewPlaylist("Playlist-1");
		
		addSongToPlaylist("Playlist-1","album1","thunder");
		addSongToPlaylist("Playlist-1","album1","bird");
		addSongToPlaylist("Playlist-1","album1","beliver");
		addSongToPlaylist("Playlist-1","album2","steal my girl");
		addSongToPlaylist("Playlist-1","album2","night changes");

		
		addNewPlaylist("Playlist-2");
		addSongToPlaylist("Playlist-2","album1","bird");
		addSongToPlaylist("Playlist-2","album2","prefect");
		addSongToPlaylist("Playlist-2","album2","beautifull");	
		
		//Album albumSongs = new Album("zach seabhug album" , "zach seabhug");
		albumNameWithObj.get("album1").printSong();
		
		
		
		playPlaylist("Playlist-1");

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
				
			case 7:
				System.out.println("Enter Album name and Artist , put space between both names and don't give space in any name use -,_");
				String albumname = sc.next();
				String artistname = sc.next();
				addNewAlbum(albumname , artistname);
				break;
				
			case 8:
				System.out.println("Enter Album name , Song name and duration of the song , put space between the values and don't give space in any name use -,_");
				String nameofalbum = sc.next();
				String nameOfSong = sc.next();
				double durationOfSong = sc.nextDouble();
				addSongToAlbum(nameofalbum , nameOfSong , durationOfSong);
				break;
				
			case 9:
				System.out.println("Enter playlist name,don't give space in any name use -,_");
				String playlistName = sc.next();
				playPlaylist(playlistName);
				break;
				
			case 10:
				System.out.println("Enter playlist name ,don't give space in any name use -,_");
				String NameOfPlaylist = sc.next();
				addNewPlaylist(NameOfPlaylist);
				break;
				
			case 11:
				System.out.println("Enter playlist name , album name and song name . put space between the values and don't give space in any name use -,_");
				String PlaylistName = sc.next();
				String AlbumName = sc.next();
				String songName = sc.next();
				addSongToPlaylist(PlaylistName , AlbumName , songName);
				break;
				
			case 12:
				Iterator<String> It = PlaylistNameWithLindkedlist.keySet().iterator();
				
				while(It.hasNext()) {
					System.out.println(It.next() + " \n ");
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
				"6 - delete current song\n"+
				"7 - Add new album\n"+
				"8 - Add song to ablum\n"+
				"9 - To change playlist\n"+
				"10 - Create new playlist\n"+
				"11 - Add song to playlist\n"+
				"12 - View All playlist's\n"
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
	
	public static void addNewAlbum(String newAlbumName , String artistName) {
		//String Str = newAlbumName;
		Album album = new Album(newAlbumName , artistName);
		albumNameWithObj.put(newAlbumName , album);
		System.out.println("album added");
		//System.out.println(albumNameWithObj.get(newAlbumName));
	}
	
	public static void addSongToAlbum (String albumName ,String name , double duartion) {
		
		Album albumObj = albumNameWithObj.get(albumName);
		if(albumObj != null) {
			albumObj.addSong(name, duartion);
			System.out.println("Song added sucseefully to album " + albumName );
		}else {
			System.out.println(albumName +" - doest not exist");
		}
	}
	
	public static void addNewPlaylist(String PlaylistName) {
		LinkedList<Song> Playlist = new LinkedList<>();
		PlaylistNameWithLindkedlist.put(PlaylistName , Playlist);
		System.out.println(PlaylistName + "created new playlist");
		
	}
	
	public static void addSongToPlaylist(String playlistName , String albumName , String songName) {
		LinkedList<Song> playlist = PlaylistNameWithLindkedlist.get(playlistName);
		if (playlist != null) {
		    albumNameWithObj.get(albumName).addtoPlayList(songName, playlist);
		    System.out.println("Successfully Song added to playlist " + playlistName );

		} else {
		    System.out.println(playlistName + " does not exist.");
		}
	}
	
	public static void playPlaylist(String playlistName) {
		LinkedList<Song> playPlaylist = PlaylistNameWithLindkedlist.get(playlistName);
		if(playPlaylist != null) {
			play(playPlaylist);
		}else {
			System.out.println(playlistName + "  - does not exist");
		}
		
	}

}


