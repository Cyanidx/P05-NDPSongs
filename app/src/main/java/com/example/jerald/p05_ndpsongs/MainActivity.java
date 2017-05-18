package com.example.jerald.p05_ndpsongs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etTitle,etSinger,etYear;
    TextView tvTitle,tvSinger,tvYear,tvStar;
    RadioButton rb1,rb2,rb3,rb4,rb5;
    Button btnInsert,btnShow;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg = (RadioGroup)findViewById(R.id.rg);

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
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etTitle.getText().toString();
                String singer = etSinger.getText().toString();
                int year = Integer.parseInt(etYear.getText().toString());
                RadioGroup rg = (RadioGroup) findViewById(R.id.rg);
                int selectedButtonId = rg.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) findViewById(selectedButtonId);
                String strAmountStars = rb.getText() + "";
                int amountStars = Integer.parseInt(strAmountStars);


                DBHelper dbh = new DBHelper(MainActivity.this);
                long row_affected = dbh.insertSong(title, singer, year, amountStars);
                dbh.close();

                if (row_affected != -1){
                    Toast.makeText(MainActivity.this, "Insert successful",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(MainActivity.this,
                        SecondActivity.class);
                // Start the new activity
                startActivity(i);
            }
        });




    }
}
