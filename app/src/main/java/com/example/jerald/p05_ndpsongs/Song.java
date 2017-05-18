package com.example.jerald.p05_ndpsongs;

/**
 * Created by 15017292 on 18/5/2017.
 */

public class Song {

    private int id;
    private String title;
    private String singer;
    private int year;
    private int star;

    public Song(int id, String title, String singer, int year, int star) {
        this.id = id;
        this.title = title;
        this.singer = singer;
        this.year = year;
        this.star = star;
    }

    public int getId() {
        return id;
    }



    public String getTitle() {
        return title;
    }



    public String getSinger() {
        return singer;
    }



    public int getYear() {
        return year;
    }



    public int getStar() {
        return star;
    }



}
