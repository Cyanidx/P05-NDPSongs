package com.example.jerald.p05_ndpsongs;

/**
 * Created by 15017292 on 18/5/2017.
 */

// Bryan Edited: added setter


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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSinger(String singers) {
        this.singer = singers;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setStar(int stars) {
        this.star = stars;
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
