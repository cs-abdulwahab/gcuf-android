package com.example.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageView imgPic = findViewById(R.id.imageView);
        Picasso.get()
                .load("https://dummyimage.com/600x400/000/fff")

                .into(imgPic);


        Button btnPress = findViewById(R.id.btnPress);
        final TextView txtMessage = findViewById(R.id.txtMessage);

        final EditText txtName = findViewById(R.id.txtName);

        btnPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = txtName.getText().toString();
                txtMessage.setText(name);


            }
        });


        Button btnSend = findViewById(R.id.btnSend);


        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = txtName.getText().toString();
                txtMessage.setText(name);

                Intent intent = new Intent(MainActivity.this, Activity2.class);
                intent.putExtra("name", name);
                startActivity(intent);


            }
        });


        Button btnShare = findViewById(R.id.btnShare);
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String name = txtName.getText().toString();

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, name);
                intent.setType("text/plain");


                //String title = getResources().getString(R.string.chooser_title);
                // Create intent to show the chooser dialog
                Intent chooser = Intent.createChooser(intent, "Send this message with");

        // Verify the original intent will resolve to at least one activity
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(chooser);
                }




            }
        });


    }
}
