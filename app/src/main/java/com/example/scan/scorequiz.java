package com.example.scan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class scorequiz extends AppCompatActivity {

    private Button buttonquiz, buttonhistory;
    private TextView scoreView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scorequiz);


        buttonquiz = findViewById(R.id.btnAfterQuiz);
        buttonhistory = findViewById(R.id.btnAfterHistory);
        scoreView = findViewById(R.id.scoreViewer);

        String score = getIntent().getStringExtra("score");
        String quizItem = getIntent().getStringExtra("quizItem");

        scoreView.setText(score + "/" + quizItem);




        Intent svc=new Intent(this, bgService.class);
        startService(svc); //OR stopService(svc);
        buttonquiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(scorequiz.this, quiz.class);
                startActivity(intent);

            }
        });
        buttonhistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(scorequiz.this, quizhistory.class);
                startActivity(intent);

            }
        });
    }
}