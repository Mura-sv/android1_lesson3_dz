package com.example.android1_lesson3_dz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class Activity_search extends AppCompatActivity {

    Button search;
    ImageButton back;
    EditText text_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        search = findViewById(R.id.btn_search);
        text_value = findViewById(R.id.et_search);
back = findViewById(R.id.btn_back);

back.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        finish();
    }
});

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
               String term = text_value.getText().toString();
               intent.putExtra(SearchManager.QUERY,term);
               startActivity(intent);
            }
        });
    }
}