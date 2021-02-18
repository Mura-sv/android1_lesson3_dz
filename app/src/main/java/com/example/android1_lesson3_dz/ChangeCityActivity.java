package com.example.android1_lesson3_dz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class ChangeCityActivity extends AppCompatActivity {

    ImageButton back;
    Button save;
    EditText city_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_city);

        save = findViewById(R.id.btn_changecity_save);
        city_value = findViewById(R.id.et_cityname);
        back = findViewById(R.id.btn_back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.putExtra("key", city_value.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });


    }
}