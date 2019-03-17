package com.example.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        if (getIntent() != null) {

            Intent intent = getIntent();
            String name = intent.getStringExtra("name");


            TextView txtMessage = findViewById(R.id.txtReciever);

            txtMessage.setText(name);


        }
    }
}
