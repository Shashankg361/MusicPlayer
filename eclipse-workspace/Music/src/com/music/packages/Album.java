package com.music.packages;

import java.util.*;

public class Album {
	private String name;
	private String artist;
	private ArrayList<Song> songs;
	
	public Album (String name , String artist) {
		this.name = name;
		this.artist = artist ;
		this.songs = new ArrayList<Song>();
	}
	
	public Album() {
		
	}
	
	public void printSong() {
		if(songs.size() != 0) {
			for(Song k : this.songs) {
				System.out.println(k.getTitle());
			}
		}
	}
	
	public Song findSong(String title) {
		for(Song checkedSong : songs) {
			if(checkedSong.getTitle().equals(title)) return checkedSong;
		}return null;
	}
	
	public boolean addSong(String title , double duration) {
		if(findSong(title) == null) {
			songs.add(new Song(title , duration ));
			//System.out.println(title + " Successfully Song added to the list");
			return true;
		}else {
			//System.out.println(title + " Song already exits in the list");
			return false;
		}
	}
	
	public boolean addtoPlayList(int trackNumber , LinkedList<Song>PlayList) {
		int index = trackNumber - 1;
		if(index > 0 && index <= songs.size()) {
			PlayList.add(this.songs.get(index));
			//System.out.println("song with tracknumbet" + trackNumber + " Successfully added");
			return true;
		}
			//System.out.println("album does not have the song with this tarckNumber " + trackNumber);
			return false;
		
	}
	
	public boolean addtoPlayList (String title , LinkedList<Song>PlayList) {
		for(Song checkedSong : songs) {
			if(checkedSong.getTitle().equals(title)) {
				PlayList.add(checkedSong);
				return true;
			}
		}
		//System.out.println(title + " this song does not exits in the List");
		return false;
		
	}
	
}
