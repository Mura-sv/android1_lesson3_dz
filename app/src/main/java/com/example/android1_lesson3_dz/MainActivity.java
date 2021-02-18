package com.example.android1_lesson3_dz;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView date, time;
    ImageButton camera, group, search, city;
    TextView cityName;
    Button toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        date = findViewById(R.id.tv_date);
        time = findViewById(R.id.tv_time);
        camera = findViewById(R.id.btn_camera);
        group = findViewById(R.id.btn_group);
        search = findViewById(R.id.btn_google);
        city = findViewById(R.id.imgBtn_city);
        cityName = findViewById(R.id.et_city_main);
        toast = findViewById(R.id.btn_toast);

        // Edit Text
        String currentTime = new SimpleDateFormat("HH:MM", Locale.getDefault()).format(new Date());
        String currentDate = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());
        date.setText(currentDate);
        time.setText(currentTime);


        // Change city
        city.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent changeCity = new Intent(MainActivity.this, ChangeCityActivity.class);
                startActivityForResult(changeCity, 202);
            }
        });


        // camera & video

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Activity_camera.class);
                startActivity(intent);
            }
        });
        group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Activity_call.class);
                startActivity(intent);
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Activity_search.class);
                startActivity(intent);
            }
        });

        toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getApplicationContext(),"•♦○♣♠☻1♥",Toast.LENGTH_LONG);
                toast.show();
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_CANCELED) {
            if (requestCode == 202) {
                String info = data.getStringExtra("key");
                cityName.setText(info);
            }

        }
    }
}