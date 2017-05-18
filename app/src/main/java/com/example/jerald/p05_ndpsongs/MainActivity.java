package com.example.jerald.p05_ndpsongs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etTitle,etSinger,etYear;
    TextView tvTitle,tvSinger,tvYear,tvStar;
    RadioButton rb1,rb2,rb3,rb4,rb5;
    Button btnInsert,btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTitle = (EditText)findViewById(R.id.etTitle);
        etSinger = (EditText)findViewById(R.id.etSinger);
        etYear = (EditText)findViewById(R.id.etYear);

        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvSinger = (TextView) findViewById(R.id.tvSinger);
        tvYear = (TextView) findViewById(R.id.tvYear);
        tvStar = (TextView) findViewById(R.id.tvStar);

        rb1 = (RadioButton)findViewById(R.id.rb1);
        rb2 = (RadioButton)findViewById(R.id.rb2);
        rb3 = (RadioButton)findViewById(R.id.rb3);
        rb4 = (RadioButton)findViewById(R.id.rb4);
        rb5 = (RadioButton)findViewById(R.id.rb5);

        btnInsert = (Button)findViewById(R.id.btnInsert);
        btnShow = (Button)findViewById(R.id.btnShow);
    }
}
