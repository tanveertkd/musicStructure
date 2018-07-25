package com.example.baseplate.coldplayer;

public class song {
    private String songName;
    private String artistName;
    private int albumArt;

    //contructor to handle stuff

    public song(String nameOfSong, String nameOfArtist, int albumA){
        songName = nameOfSong;
        artistName = nameOfArtist;
        albumArt = albumA;
    }

    //return song details

    public String getSongName(){
        return songName;
    }

    public String getArtistName() {
        return artistName;
    }
    public int getAlbumArt(){
        return albumArt;
    }
}
