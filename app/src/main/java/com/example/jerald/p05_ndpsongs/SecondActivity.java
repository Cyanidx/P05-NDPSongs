package com.example.jerald.p05_ndpsongs;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView lv;
    SongAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lv = (ListView)this.findViewById(R.id.lvShow);
        DBHelper dbh = new DBHelper(this);
        ArrayList<Song> songs = dbh.getAllSong();

        adapter = new SongAdapter(this, R.layout.row, songs);
        lv.setAdapter(adapter);

    }
}