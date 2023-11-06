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

import com.example.scan.quizData.AlphabetQuestion;
import com.example.scan.quizData.AlphabetQuizData;
import com.example.scan.quizData.ColorQuestion;
import com.example.scan.quizData.ColorQuizData;
import com.example.scan.quizData.NumberQuestion;
import com.example.scan.quizData.NumberQuizData;
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

        new AlphabetQuizData().setAlphabetQuestion();

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
                ShapeQuizData.resetCounter();
                ColorQuizData.resetCounter();
                AlphabetQuizData.resetCounter();
                NumberQuizData.resetCounter();
            }
        });


        System.out.println("SCREEN NAME " +  screenName);
        if (screenName.equals("Shape")) {
            generateShapeQuestion(currentScreen,screenName);
        }
        if (screenName.equals("Color")) {
            generateColorQuestion(currentScreen, screenName);
        }
        if (screenName.equals("Alphabet")) {
            generateAlphabetQuestion(currentScreen, screenName);
        }
        if (screenName.equals("Number")) {
            generateNumberQuestion(currentScreen, screenName);
        }
    }

    public void generateShapeQuestion(String currentScreen, String screenName) {
        int counterShape = new ShapeQuizData().questionCounterShape();

        if(counterShape >= ShapeQuizData.SHAPE_QUESTION_NAMES.length) {
          finishQuiz(currentScreen, screenName);
          return;
        }

        ShapeQuestion question = new ShapeQuizData().getOneQuestion(ShapeQuizData.SHAPE_QUESTION_NAMES[counterShape]);
            quizQuestionImage.setImageResource(question.getImageViewQuestion());
            for (int i = 0; i < imageButtons.length; i++) {
                imageButtons[i] = (ImageButton) findViewById(BUTTON_IDS_CHOICES[i]);
                if (i == 0) {
                    imageButtons[i].setImageResource(question.getOtherAnswer1());
                    targetCorrectAnswer(i, question.getCorrectAnswerPosition(), imageButtons[i], currentScreen, screenName);
                }
                if (i == 1) {
                    imageButtons[i].setImageResource(question.getOtherAnswer2());
                    targetCorrectAnswer(i, question.getCorrectAnswerPosition(), imageButtons[i], currentScreen, screenName);
                }
                if (i == 2) {
                    imageButtons[i].setImageResource(question.getOtherAnswer3());
                    targetCorrectAnswer(i, question.getCorrectAnswerPosition(), imageButtons[i], currentScreen, screenName);
                }
                if (i == 3) {
                    imageButtons[i].setImageResource(question.getCorAnswer());
                    targetCorrectAnswer(i, question.getCorrectAnswerPosition(), imageButtons[i], currentScreen, screenName);
                }
            }
    }

    public void targetCorrectAnswer(int indexButton, int indexCorrectAnswer, ImageButton btn, String currentScreen, String screenName){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(indexButton == indexCorrectAnswer){
                    System.out.println("CORRECT");
                    score++;

                }else{
                    System.out.println("WRONG");
                }

                if(screenName.equals("Shape")){
                    generateShapeQuestion(currentScreen, screenName);
                }
                if(screenName.equals("Color")){
                    generateColorQuestion(currentScreen, screenName);
                }
                if(screenName.equals("Alphabet")){
                    generateAlphabetQuestion(currentScreen, screenName);
                }
                if(screenName.equals("Number")){
                    generateNumberQuestion(currentScreen, screenName);
                }
            }
        });
    }

    public void finishQuiz(String currentScreen, String screenName){
        score = 0;
        ShapeQuizData.resetCounter();
        ColorQuizData.resetCounter();
        AlphabetQuizData.resetCounter();
        NumberQuizData.resetCounter();
        Intent intent = new Intent(quizimage.this, quizcategory.class);
        intent.putExtra("screen", currentScreen);
        startActivity(intent);

    }
    public void generateColorQuestion(String currentScreen, String screenName) {
        int counterColor = new ColorQuizData().questionCounterColor();

        if(counterColor >= ColorQuizData.COLOR_QUESTION_NAMES.length) {
            finishQuiz(currentScreen, screenName);
            return;
        }

        ColorQuestion question = new ColorQuizData().getOneQuestion(ColorQuizData.COLOR_QUESTION_NAMES[counterColor]);
        quizQuestionImage.setImageResource(question.getImageViewQuestion());
        for (int i = 0; i < imageButtons.length; i++) {
            imageButtons[i] = (ImageButton) findViewById(BUTTON_IDS_CHOICES[i]);
            if (i == 0) {
                imageButtons[i].setImageResource(question.getOtherAnswer1());
                targetCorrectAnswer(i, question.getCorrectAnswerPosition(), imageButtons[i], currentScreen, screenName);
            }
            if (i == 1) {
                imageButtons[i].setImageResource(question.getOtherAnswer2());
                targetCorrectAnswer(i, question.getCorrectAnswerPosition(), imageButtons[i], currentScreen, screenName);
            }
            if (i == 2) {
                imageButtons[i].setImageResource(question.getOtherAnswer3());
                targetCorrectAnswer(i, question.getCorrectAnswerPosition(), imageButtons[i], currentScreen, screenName);
            }
            if (i == 3) {
                imageButtons[i].setImageResource(question.getCorAnswer());
                targetCorrectAnswer(i, question.getCorrectAnswerPosition(), imageButtons[i], currentScreen, screenName);
            }
        }
    }

    public void generateAlphabetQuestion(String currentScreen, String screenName) {
        int counterAlphabet = new AlphabetQuizData().questionCounterAlphabet();

        if(counterAlphabet >= AlphabetQuizData.ALPHABET_QUESTION_NAMES.length) {
            finishQuiz(currentScreen, screenName);
            return;
        }

        AlphabetQuestion question = new AlphabetQuizData().getOneAlphabetQuestion(AlphabetQuizData.ALPHABET_QUESTION_NAMES[counterAlphabet]);

        System.out.println(question.getCorrectAnswer());

        quizQuestionImage.setImageResource(question.getImageViewQuestion());

        for (int i = 0; i < imageButtons.length; i++) {
            imageButtons[i] = (ImageButton) findViewById(BUTTON_IDS_CHOICES[i]);
            if (i == 0) {
                imageButtons[i].setImageResource(question.getOtherAnswer1());
                targetCorrectAnswer(i, question.getCorrectAnswerPosition(), imageButtons[i], currentScreen, screenName);
            }
            if (i == 1) {
                imageButtons[i].setImageResource(question.getOtherAnswer2());
                targetCorrectAnswer(i, question.getCorrectAnswerPosition(), imageButtons[i], currentScreen, screenName);
            }
            if (i == 2) {
                imageButtons[i].setImageResource(question.getOtherAnswer3());
                targetCorrectAnswer(i, question.getCorrectAnswerPosition(), imageButtons[i], currentScreen, screenName);
            }
            if (i == 3) {
                imageButtons[i].setImageResource(question.getCorAnswer());
                targetCorrectAnswer(i, question.getCorrectAnswerPosition(), imageButtons[i], currentScreen, screenName);
            }
        }
    }

    public void generateNumberQuestion(String currentScreen, String screenName) {
        int counterNumber = new NumberQuizData().questionCounterNumber();

        if(counterNumber >= NumberQuizData.NUMBER_QUESTION_NAMES.length) {
            finishQuiz(currentScreen, screenName);
            return;
        }

        NumberQuestion question = new NumberQuizData().getOneQuestion(NumberQuizData.NUMBER_QUESTION_NAMES[counterNumber]);
        quizQuestionImage.setImageResource(question.getImageViewQuestion());

        for (int i = 0; i < imageButtons.length; i++) {
            imageButtons[i] = (ImageButton) findViewById(BUTTON_IDS_CHOICES[i]);
            if (i == 0) {
                imageButtons[i].setImageResource(question.getOtherAnswer1());
                targetCorrectAnswer(i, question.getCorrectAnswerPosition(), imageButtons[i], currentScreen, screenName);
            }
            if (i == 1) {
                imageButtons[i].setImageResource(question.getOtherAnswer2());
                targetCorrectAnswer(i, question.getCorrectAnswerPosition(), imageButtons[i], currentScreen, screenName);
            }
            if (i == 2) {
                imageButtons[i].setImageResource(question.getOtherAnswer3());
                targetCorrectAnswer(i, question.getCorrectAnswerPosition(), imageButtons[i], currentScreen, screenName);
            }
            if (i == 3) {
                imageButtons[i].setImageResource(question.getCorAnswer());
                targetCorrectAnswer(i, question.getCorrectAnswerPosition(), imageButtons[i], currentScreen, screenName);
            }
        }
    }
}