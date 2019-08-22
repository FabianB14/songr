package com.brooksfabe.songr.model;

import javax.persistence.*;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String title;
    int trackNumber;
    int length;
    @ManyToOne
    Album album;

    public Song(){}
    public Song(String title, int trackNumber, int length, Album album){
        this.title = title;
        this.trackNumber = trackNumber;
        this.length = length;
        this.album = album;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public int getLength() {
        return length;
    }

    public Album getAlbum() {
        return album;
    }
}

