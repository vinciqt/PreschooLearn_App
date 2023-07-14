package com.example.scan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class quiz extends AppCompatActivity {

    private ImageButton button, buttonVoice, buttonImage, buttonViewHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        button = findViewById(R.id.btnback);
        Intent svc=new Intent(this, bgService.class);
        startService(svc); //OR stopService(svc);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(quiz.this,CATEGORY.class);
                startActivity(intent);
            }
        });
        buttonVoice = findViewById(R.id.btnvoice);
        buttonVoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(quiz.this, quizcategory.class);
                intent.putExtra("screen","screen_voice");
                startActivity(intent);
            }
        });

        buttonImage = findViewById(R.id.btnimage);
        buttonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(quiz.this, quizcategory.class);
                intent.putExtra("screen","screen_image");
                startActivity(intent);
            }
        });
        buttonViewHistory = findViewById(R.id.btnviewhistory);
        buttonViewHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(quiz.this,quizhistory.class);
                startActivity(intent);
            }
        });
    }
}