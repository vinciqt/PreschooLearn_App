package com.example.scan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.scan.quizData.ShapeQuestion;
import com.example.scan.quizData.ShapeQuizData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class quizimage extends AppCompatActivity {

    private ImageButton button;

    private Button btnqshape, btnqcolor, btnqalphabet, btnqnumber;

    private ImageView quizQuestionImage;

    private ImageButton[] imageButtons = new ImageButton[4];
    private int[] BUTTON_IDS_CHOICES = {
            R.id.btnqa,
            R.id.btnqb,
            R.id.btnqc,
            R.id.btnqd
    };

    private int score = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizimage);
        button = findViewById(R.id.btnback);
        Intent svc = new Intent(this, bgService.class);
        String currentScreen = getIntent().getStringExtra("screen");
        String screenName = getIntent().getStringExtra("screen_name");
        System.out.println("CHECKKKK" + currentScreen);

        quizQuestionImage = findViewById(R.id.imageViewQuestion);
        startService(svc); //OR stopService(svc);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(quizimage.this, quizcategory.class);
                intent.putExtra("screen", currentScreen);
                startActivity(intent);
            }
        });



        if (screenName.equals("Shape")) {
            generateShapeQuestion(currentScreen);
        }
        if (screenName == "Color") {

        }
        if (screenName == "Alphabet") {

        }
        if (screenName == "Number") {

        }
    }

    public void generateShapeQuestion(String currentScreen) {
        int counter = new ShapeQuizData().questionCounter();

        if(counter >= ShapeQuizData.SHAPE_QUESTION_NAMES.length) {
          finishQuiz(currentScreen);
          return;
        }

        ShapeQuestion question = new ShapeQuizData().getOneQuestion(ShapeQuizData.SHAPE_QUESTION_NAMES[counter]);
            quizQuestionImage.setImageResource(question.getImageViewQuestion());
            for (int i = 0; i < imageButtons.length; i++) {
                imageButtons[i] = (ImageButton) findViewById(BUTTON_IDS_CHOICES[i]);
                if (i == 0) {
                    imageButtons[i].setImageResource(question.getOtherAnswer1());
                    targetCorrectAnswer(i, question.getCorrectAnswerPosition(), imageButtons[i], currentScreen);
                }
                if (i == 1) {
                    imageButtons[i].setImageResource(question.getOtherAnswer2());
                    targetCorrectAnswer(i, question.getCorrectAnswerPosition(), imageButtons[i], currentScreen);
                }
                if (i == 2) {
                    imageButtons[i].setImageResource(question.getOtherAnswer3());
                    targetCorrectAnswer(i, question.getCorrectAnswerPosition(), imageButtons[i], currentScreen);
                }
                if (i == 3) {
                    imageButtons[i].setImageResource(question.getCorAnswer());
                    targetCorrectAnswer(i, question.getCorrectAnswerPosition(), imageButtons[i], currentScreen);
                }
            }
    }

    public void targetCorrectAnswer(int indexButton, int indexCorrectAnswer, ImageButton btn, String currentScreen){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(indexButton == indexCorrectAnswer){
                    System.out.println("CORRECT");
                    score++;
                    generateShapeQuestion(currentScreen);

                }else{
                    System.out.println("WRONG");
                    generateShapeQuestion(currentScreen);
                }
            }
        });
    }

    public void finishQuiz(String currentScreen){
        score = 0;
        Intent intent = new Intent(quizimage.this, quizcategory.class);
        intent.putExtra("screen", currentScreen);
        startActivity(intent);

    }
}