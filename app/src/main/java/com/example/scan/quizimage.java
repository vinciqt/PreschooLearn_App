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

import com.example.scan.database.QuizScoreDatabaseHelper;
import com.example.scan.quizData.AlphabetQuestion;
import com.example.scan.quizData.AlphabetQuizData;
import com.example.scan.quizData.ColorQuestion;
import com.example.scan.quizData.ColorQuizData;
import com.example.scan.quizData.NumberQuestion;
import com.example.scan.quizData.NumberQuizData;
import com.example.scan.quizData.ShapeQuestion;
import com.example.scan.quizData.ShapeQuizData;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class quizimage extends AppCompatActivity {

    private ImageButton button, btnSoundQuestion;

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
    private QuizScoreDatabaseHelper quizScoreDatabaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizimage);

        quizScoreDatabaseHelper = new QuizScoreDatabaseHelper(this);

        new ShapeQuizData().setShapeQuestion();
        new ColorQuizData().setColorQuestion();
        new AlphabetQuizData().setAlphabetQuestion();
        new NumberQuizData().setNumberQuestion();


        button = findViewById(R.id.btnback);
        Intent svc = new Intent(this, bgService.class);
        String currentScreen = getIntent().getStringExtra("screen");
        String screenName = getIntent().getStringExtra("screen_name");
        System.out.println("CHECKKKK" + currentScreen);

        quizQuestionImage = findViewById(R.id.imageViewQuestion);
        btnSoundQuestion = findViewById(R.id.btnSoundQuestion);
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
        try {
            if(ShapeQuizData.QUIZ_INITIAL_VISIT){
                new QuizDialog("LET START THE QUIZ", true).show(getSupportFragmentManager(), QuizDialog.TAG);
                ShapeQuizData.QUIZ_INITIAL_VISIT = false;
            }
            int counterShape = new ShapeQuizData().questionCounterShape();

            if(counterShape >= ShapeQuizData.SHAPE_QUESTION_NAMES.length) {
                finishQuiz(currentScreen, screenName);
                return;
            }

            ShapeQuestion question = new ShapeQuizData().getOneShapeQuestion(ShapeQuizData.SHAPE_QUESTION_NAMES[counterShape]);

            System.out.println(question.getCorrectAnswer());
            quizQuestionImage.setImageResource(question.getImageViewQuestion());
            triggerSoundQuestion(question.getSoundQuestion());


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
        }catch (Exception e){
            finishQuiz(currentScreen, screenName);
        }

    }

    public void targetCorrectAnswer(int indexButton, int indexCorrectAnswer, ImageButton btn, String currentScreen, String screenName){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(indexButton == indexCorrectAnswer){
                    System.out.println("CORRECT");
                    score++;
                    new QuizDialog("CORRECT", false).show(getSupportFragmentManager(), QuizDialog.TAG);

                }else{
                    new QuizDialog("WRONG", false).show(getSupportFragmentManager(), QuizDialog.TAG);
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

        if(screenName.equals("Shape")){
            quizScoreDatabaseHelper.insertQuizScore("IMAGE", "SHAPE", Integer.toString(score), LocalDate.now().toString(), Integer.toString(ShapeQuizData.SHAPE_QUESTION_NAMES.length));
        }
        if(screenName.equals("Color")){
            quizScoreDatabaseHelper.insertQuizScore("IMAGE", "COLOR", Integer.toString(score), LocalDate.now().toString(), Integer.toString((ColorQuizData.COLOR_QUESTION_NAMES.length)));
        }
        if(screenName.equals("Alphabet")){
            quizScoreDatabaseHelper.insertQuizScore("IMAGE", "ALPHABET", Integer.toString(score), LocalDate.now().toString(), Integer.toString(AlphabetQuizData.ALPHABET_QUESTION_NAMES.length));
        }
        if(screenName.equals("Number")){
            quizScoreDatabaseHelper.insertQuizScore("IMAGE", "NUMBER", Integer.toString(score), LocalDate.now().toString(), Integer.toString(NumberQuizData.NUMBER_QUESTION_NAMES.length));
        }
        score = 0;
        ShapeQuizData.resetCounter();
        ColorQuizData.resetCounter();
        AlphabetQuizData.resetCounter();
        NumberQuizData.resetCounter();
        Intent intent = new Intent(quizimage.this, quizhistory.class);
        intent.putExtra("screen", currentScreen);
        startActivity(intent);

    }
    public void generateColorQuestion(String currentScreen, String screenName) {

        try{
            if(ColorQuizData.QUIZ_INITIAL_VISIT){
                new QuizDialog("LET START THE QUIZ", true).show(getSupportFragmentManager(),QuizDialog.TAG);
                ColorQuizData.QUIZ_INITIAL_VISIT = false;
            }
            int counterColor = new ColorQuizData().questionCounterColor();

            if(counterColor >= ColorQuizData.COLOR_QUESTION_NAMES.length) {
                finishQuiz(currentScreen, screenName);
                return;
            }

            ColorQuestion question = new ColorQuizData().getOneColorQuestion(ColorQuizData.COLOR_QUESTION_NAMES[counterColor]);
            System.out.println(question.getCorrectAnswer());
            quizQuestionImage.setImageResource(question.getImageViewQuestion());
            triggerSoundQuestion(question.getSoundQuestion());

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

        }catch (Exception e){
            finishQuiz(currentScreen, screenName);
        }

    }

    public void generateAlphabetQuestion(String currentScreen, String screenName) {
        try{
            if(AlphabetQuizData.QUIZ_INITIAL_VISIT){
                new QuizDialog("LET START THE QUIZ", true).show(getSupportFragmentManager(),QuizDialog.TAG);
                AlphabetQuizData.QUIZ_INITIAL_VISIT = false;
            }
            int counterAlphabet = new AlphabetQuizData().questionCounterAlphabet();

            if(counterAlphabet >= AlphabetQuizData.ALPHABET_QUESTION_NAMES.length) {
                finishQuiz(currentScreen, screenName);
                return;
            }

            AlphabetQuestion question = new AlphabetQuizData().getOneAlphabetQuestion(AlphabetQuizData.ALPHABET_QUESTION_NAMES[counterAlphabet]);
            System.out.println(question.getCorrectAnswer());
            quizQuestionImage.setImageResource(question.getImageViewQuestion());
            triggerSoundQuestion(question.getSoundQuestion());

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
        }catch (Exception e){
            finishQuiz(currentScreen, screenName);
        }

    }

    public void generateNumberQuestion(String currentScreen, String screenName) {
        try {
            if(NumberQuizData.QUIZ_INITIAL_VISIT){
                new QuizDialog("LET START THE QUIZ", true).show(getSupportFragmentManager(),QuizDialog.TAG);
                NumberQuizData.QUIZ_INITIAL_VISIT = false;
            }
            int counterNumber = new NumberQuizData().questionCounterNumber();

            if(counterNumber >= NumberQuizData.NUMBER_QUESTION_NAMES.length) {
                finishQuiz(currentScreen, screenName);
                return;
            }

            NumberQuestion question = new NumberQuizData().getOneNumberQuestion(NumberQuizData.NUMBER_QUESTION_NAMES[counterNumber]);
            System.out.println(question.getCorrectAnswer());
            quizQuestionImage.setImageResource(question.getImageViewQuestion());
            triggerSoundQuestion(question.getSoundQuestion());

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
        }catch (Exception e){
            finishQuiz(currentScreen, screenName);
        }
    }

    public void triggerSoundQuestion(int sound){
        final MediaPlayer mp = MediaPlayer.create(this, sound);
        btnSoundQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
            }
        });
    }
}