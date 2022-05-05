package com.codegym.model;


public class Music {
    private String musicName;
    private String musicArtist;
    private String musicGenre;
    private String musicLink;

    public Music() {
    }

    public Music(String musicName, String musicArtist, String musicGenre, String musicLink) {
        this.musicName = musicName;
        this.musicArtist = musicArtist;
        this.musicGenre = musicGenre;
        this.musicLink = musicLink;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getMusicArtist() {
        return musicArtist;
    }

    public void setMusicArtist(String musicArtist) {
        this.musicArtist = musicArtist;
    }

    public String getMusicGenre() {
        return musicGenre;
    }

    public void setMusicGenre(String musicGenre) {
        this.musicGenre = musicGenre;
    }

    public String getMusicLink() {
        return musicLink;
    }

    public void setMusicLink(String musicLink) {
        this.musicLink = musicLink;
    }
}
