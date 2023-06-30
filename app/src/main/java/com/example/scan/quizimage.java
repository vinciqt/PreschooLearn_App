package com.example.scan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class quizimage extends AppCompatActivity {

    private ImageButton button;

    private Button btnqshape, btnqcolor, btnqalphabet, btnqnumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizimage);
        button = findViewById(R.id.btnback);
        Intent svc=new Intent(this, bgService.class);
        String currentScreen = getIntent().getStringExtra("screen");
        startService(svc); //OR stopService(svc);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(quizimage.this,quizcategory.class);
                intent.putExtra("screen", currentScreen);
                startActivity(intent);
            }
        });
    }
}