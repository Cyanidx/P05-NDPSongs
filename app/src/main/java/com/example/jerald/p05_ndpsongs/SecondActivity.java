package com.example.jerald.p05_ndpsongs;

//Bryan Created


import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    private DBHelper dbHelper;
    ListView lv;
    SongAdapter adapter;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_second);
            lv = (ListView)this.findViewById(R.id.lvShow);
            DBHelper dbh = new DBHelper(this);

        final ArrayList<Song> songs = dbh.getAllSong();

        adapter = new SongAdapter(this, R.layout.row, songs);
        lv.setAdapter(adapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    int getId = position+1;
                    Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                    intent.putExtra("id",getId);
                    startActivity(intent);
                }
            });
        }
}