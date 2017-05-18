package com.example.jerald.p05_ndpsongs;


//done by Bryan



import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {
    EditText etTitle, etSinger, etYear;
    TextView tvId;
    Button btnUpdate, btnDelete, btnCancel;
    RadioButton rb1 , rb2, rb3, rb4, rb5;
    Song data;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        tvId = (TextView)findViewById(R.id.tvId);
        etTitle = (EditText)findViewById(R.id.etTitle);
        etSinger =(EditText)findViewById(R.id.etSinger);
        etYear = (EditText)findViewById(R.id.etYear);
        btnUpdate = (Button)findViewById(R.id.btnUpdate);
        btnDelete = (Button)findViewById(R.id.btnDelete);
        btnCancel = (Button)findViewById(R.id.btnCancel);

        dbHelper = new DBHelper(this);

        Intent intent = getIntent();
        final int recId = intent.getIntExtra("id",0);
        Cursor res = dbHelper.getData(recId);
        res.moveToFirst();

        final int id = res.getColumnIndex("_id");
        tvId.setText(String.valueOf(recId));
        etTitle.setText(res.getString(res.getColumnIndex("title")));
        etSinger.setText(res.getString(res.getColumnIndex("singers")));
        etYear.setText(String.valueOf(res.getString(res.getColumnIndex("year"))));
        int selected = res.getColumnIndex("star");

        if(selected == 1){
            rb1 = (RadioButton)findViewById(R.id.rb1);
            rb1.setChecked(true);
        } else if(selected == 2){
            rb2 = (RadioButton)findViewById(R.id.rb2);
            rb2.setChecked(true);
        } else if(selected == 3){
            rb3 = (RadioButton)findViewById(R.id.rb3);
            rb3.setChecked(true);
        } else if(selected == 4){
            rb4 = (RadioButton)findViewById(R.id.rb4);
            rb4.setChecked(true);
        } else {
            rb5 = (RadioButton)findViewById(R.id.rb5);
            rb5.setChecked(true);
        }
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbh = new DBHelper(ThirdActivity.this);
                RadioGroup rg = (RadioGroup)findViewById(R.id.rgStars);
                int selected = rg.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton)findViewById(selected);
                int stars = Integer.parseInt(rb.getText().toString());
                String updSinger = etSinger.getText().toString();
                String upddTitle = etTitle.getText().toString();
                int year = Integer.parseInt(etYear.getText().toString());
                int id = recId;

                int x = dbh.updateSong(id,upddTitle,updSinger,year,stars);
                dbh.close();
                Intent intent = new Intent(ThirdActivity.this, SecondActivity.class);
                startActivity(intent);

            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbh = new DBHelper(ThirdActivity.this);
                dbh.deleteSong(recId);
                dbh.close();
                Intent intent = new Intent(ThirdActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}