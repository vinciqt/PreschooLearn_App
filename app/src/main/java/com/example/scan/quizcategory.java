package com.example.scan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class quizcategory extends AppCompatActivity {

    private ImageButton button;

    private Button btnqshape, btnqcolor, btnqalphabet, btnqnumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizcategory);
        button = findViewById(R.id.btnback);
        Intent svc=new Intent(this, bgService.class);
        startService(svc); //OR stopService(svc);
        String currentScreen = getIntent().getStringExtra("screen");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(quizcategory.this,quiz.class);
                startActivity(intent);
            }
        });
        if (currentScreen.equals("screen_voice")) {
            goToQuizVoice(btnqshape, R.raw.shapes, R.id.btnqcshape,currentScreen);
            goToQuizVoice(btnqcolor, R.raw.colors, R.id.btnqccolor,currentScreen);
            goToQuizVoice(btnqalphabet, R.raw.alphabet, R.id.btnqcalphabet,currentScreen);
            goToQuizVoice(btnqnumber, R.raw.numbers, R.id.btnqcnumber,currentScreen);
        }
        if (currentScreen.equals("screen_image")) {
            goToQuizImage(btnqshape, R.raw.shapes, R.id.btnqcshape,currentScreen);
            goToQuizImage(btnqcolor, R.raw.colors, R.id.btnqccolor,currentScreen);
            goToQuizImage(btnqalphabet, R.raw.alphabet, R.id.btnqcalphabet,currentScreen);
            goToQuizImage(btnqnumber, R.raw.numbers, R.id.btnqcnumber,currentScreen);
        }
    }

    private void goToQuizVoice(Button btn, int raw, int id,String screen){
        MediaPlayer mp = MediaPlayer.create(getBaseContext(),raw);
        btn = findViewById(id);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                Intent intent=new Intent(quizcategory.this,quizvoice.class);
                intent.putExtra("screen", screen);
                startActivity(intent);
            }
        });
    }
    private void goToQuizImage(Button btn, int raw, int id,String screen){
        MediaPlayer mp = MediaPlayer.create(getBaseContext(),raw);
        btn = findViewById(id);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                Intent intent=new Intent(quizcategory.this,quizimage.class);
                intent.putExtra("screen", screen);
                startActivity(intent);
            }
        });
    }
}