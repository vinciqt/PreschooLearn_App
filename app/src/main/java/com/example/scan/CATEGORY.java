package com.example.scan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class CATEGORY extends AppCompatActivity {

    private ImageButton button;
    private Button buttonShape, buttonColor, buttonAlpha, buttonNum, buttonQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        button = findViewById(R.id.btnback);

        Intent svc=new Intent(this, bgService.class);
        startService(svc); //OR stopService(svc);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CATEGORY.this, MainActivity.class);
                startActivity(intent);

            }
        });

        buttonShape = findViewById(R.id.btnshape);
        buttonShape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CATEGORY.this, shape.class);
                startActivity(intent);
            }
        });

        buttonColor = findViewById(R.id.btncolor);
        buttonColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CATEGORY.this, color.class);
                startActivity(intent);
            }
        });

        buttonAlpha = findViewById(R.id.btnalphabet);
        buttonAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CATEGORY.this, alphabet.class);
                startActivity(intent);
            }
        });

        buttonNum = findViewById(R.id.btnnumber);
        buttonNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CATEGORY.this, number.class);
                startActivity(intent);
            }
        });

        buttonQuiz = findViewById(R.id.btnquiz);
        buttonQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CATEGORY.this, quiz.class);
                startActivity(intent);
            }
        });
    }
}