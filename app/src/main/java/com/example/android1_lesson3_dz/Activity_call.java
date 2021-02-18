package com.example.android1_lesson3_dz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class Activity_call extends AppCompatActivity {

    Button call;
    ImageButton back;
    EditText phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

    call = findViewById(R.id.btn_call);
    back = findViewById(R.id.btn_back);
phoneNumber = findViewById(R.id.et_phoneNumber);
    back.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            finish();
        }
    });

    call.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String number = phoneNumber.getText().toString();
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:"+number));
        startActivity(intent);
        }
    });


    }
}