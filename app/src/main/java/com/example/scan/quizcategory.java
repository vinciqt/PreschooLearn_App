package com.example.scan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.scan.QuizScore.QuizScoreModel;
import com.example.scan.database.QuizScoreDatabaseHelper;
import com.example.scan.voiceData.VoiceQuizModel;

import java.util.ArrayList;

public class quizcategory extends AppCompatActivity {

    private ImageButton button;

    private Button btnqshape, btnqcolor, btnqalphabet, btnqnumber;

    private QuizScoreDatabaseHelper quizScoreDatabaseHelper;
    private ArrayList<QuizScoreModel> quizModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizcategory);

        quizScoreDatabaseHelper = new QuizScoreDatabaseHelper(this);

        quizModelArrayList = quizScoreDatabaseHelper.getAllQuiz();

        System.out.println("SAMPLE " + quizModelArrayList.get(0).getQuizCategory());


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
            goToQuizVoice(btnqshape, R.raw.shapes, R.id.btnqcshape,currentScreen, "Shape");
            goToQuizVoice(btnqcolor, R.raw.colors, R.id.btnqccolor,currentScreen, "Color");
            goToQuizVoice(btnqalphabet, R.raw.alphabet, R.id.btnqcalphabet,currentScreen, "Alphabet");
            goToQuizVoice(btnqnumber, R.raw.numbers, R.id.btnqcnumber,currentScreen, "Number");
        }
        if (currentScreen.equals("screen_image")) {

            goToQuizImage(btnqshape, R.raw.shapes, R.id.btnqcshape,currentScreen, "Shape");
            goToQuizImage(btnqcolor, R.raw.colors, R.id.btnqccolor,currentScreen, "Color");
            goToQuizImage(btnqalphabet, R.raw.alphabet, R.id.btnqcalphabet,currentScreen, "Alphabet");
            goToQuizImage(btnqnumber, R.raw.numbers, R.id.btnqcnumber,currentScreen, "Number");
        }
    }

    private void goToQuizVoice(Button btn, int raw, int id,String screen, String screenName){
        MediaPlayer mp = MediaPlayer.create(getBaseContext(),raw);
        btn = findViewById(id);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                Intent intent=new Intent(quizcategory.this,quizvoice.class);
                intent.putExtra("screen", screen);
                intent.putExtra("screen_name", screenName);
                startActivity(intent);
            }
        });
    }
    private void goToQuizImage(Button btn, int raw, int id,String screen, String screenName){
        MediaPlayer mp = MediaPlayer.create(getBaseContext(),raw);
        btn = findViewById(id);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                Intent intent=new Intent(quizcategory.this,quizimage.class);
                intent.putExtra("screen", screen);
                intent.putExtra("screen_name", screenName);
                startActivity(intent);
            }
        });
    }
}