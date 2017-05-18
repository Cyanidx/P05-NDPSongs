package com.example.jerald.p05_ndpsongs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by 15017292 on 18/5/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ndpsong.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NOTE = "song";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_title = "title";
    private static final String COLUMN_singers = "singers";
    private static final String COLUMN_year = "year";
    private static final String COLUMN_star = "star";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createNoteTableSql = "CREATE TABLE " + TABLE_NOTE + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_title + " TEXT," + COLUMN_singers + " TEXT," + COLUMN_year + " INTEGER," + COLUMN_star + " INTEGER )";
        db.execSQL(createNoteTableSql);
        Log.i("info", "created tables");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTE);
        onCreate(db);
    }

    public long insertSong(String title, String singers, int year, int star) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_title, title);
        values.put(COLUMN_singers, singers);
        values.put(COLUMN_year, year);
        values.put(COLUMN_star, star);
        long result = db.insert(TABLE_NOTE, null, values);
        db.close();
        Log.d("SQL Insert",""+ result); //id returned, shouldn’t be -1
        return result;
    }

    public ArrayList<Song> getAllSong() {
        ArrayList<Song> song = new ArrayList<Song>();

        String selectQuery = "SELECT " + COLUMN_ID + ","
                + COLUMN_title + "," + COLUMN_singers + "," + COLUMN_year + "," + COLUMN_star + " FROM " + TABLE_NOTE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String title = cursor.getString(1);
                String singer = cursor.getString(2);
                int year = cursor.getInt(3);
                int star = cursor.getInt(4);
                song.add(new Song(id,title,singer,year,star));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return song;
    }

    public int updateSong(Song data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_title, data.getTitle());
        values.put(COLUMN_singers, data.getSinger());
        values.put(COLUMN_year, data.getYear());
        values.put(COLUMN_star, data.getStar());
        String condition = COLUMN_ID + "= ?";
        String[] args = {String.valueOf(data.getId())};
        int result = db.update(TABLE_NOTE, values, condition, args);
        db.close();
        return result;
    }

    public int deleteSong(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String condition = COLUMN_ID + "= ?";
        String[] args = {String.valueOf(id)};
        int result = db.delete(TABLE_NOTE, condition, args);
        db.close();
        return result;
    }






}