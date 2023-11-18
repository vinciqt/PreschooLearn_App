package com.example.scan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.scan.database.QuizScoreDatabaseHelper;
import com.example.scan.quizData.AlphabetQuizData;
import com.example.scan.quizData.ColorQuizData;
import com.example.scan.quizData.NumberQuestion;
import com.example.scan.quizData.NumberQuizData;
import com.example.scan.quizData.ShapeQuizData;
import com.example.scan.voiceData.VoiceAlphabetQuizData;
import com.example.scan.voiceData.VoiceColorQuizData;
import com.example.scan.voiceData.VoiceNumberQuizData;
import com.example.scan.voiceData.VoiceQuizModel;
import com.example.scan.voiceData.VoiceShapeQuizData;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class quizvoice extends AppCompatActivity {

    MediaPlayer mediaplayer;

    private ImageButton button;
    public static final Integer RecordAudioRequestCode = 1;
    private SpeechRecognizer speechRecognizer;

    private ImageButton micButton;
    private ImageView imgVoiceQuestion;
    public String screenName, currentScreen;

    public final Intent speechRecognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

    private int score = 0;



    private QuizScoreDatabaseHelper quizScoreDatabaseHelper;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        quizScoreDatabaseHelper = new QuizScoreDatabaseHelper(this);

        new VoiceShapeQuizData().setShapeQuestion();
        new VoiceColorQuizData().setColorQuestion();
        new VoiceAlphabetQuizData().setAlphabetQuestion();
        new VoiceNumberQuizData().setNumberQuestion();

        setContentView(R.layout.activity_quiz_voice);
        Intent svc=new Intent(this, bgService.class);
        currentScreen = getIntent().getStringExtra("screen");
        screenName = getIntent().getStringExtra("screen_name");
        stopService(svc); //OR stopService(svc);

        button = findViewById(R.id.btnback);
        imgVoiceQuestion = findViewById(R.id.imgVoiceQuestion);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VoiceShapeQuizData.resetCounter();
                VoiceColorQuizData.resetCounter();
                VoiceAlphabetQuizData.resetCounter();
                VoiceNumberQuizData.resetCounter();
                Intent intent=new Intent(quizvoice.this,quizcategory.class);
                intent.putExtra("screen", currentScreen);
                startActivity(intent);
            }
        });


        micButton = findViewById(R.id.micbtn);
        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);


        speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());


        if(screenName.equals("Shape")){
            generateShapeQuestion(currentScreen, screenName);
        }
        if(screenName.equals("Color")) {
            generateColorQuestion(currentScreen,screenName);
        }
        if(screenName.equals("Alphabet")) {
            generateAlphabetQuestion(currentScreen,screenName);
        }
        if(screenName.equals("Number")) {
            generateNumberQuestion(currentScreen,screenName);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        speechRecognizer.destroy();
    }

    private void checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.RECORD_AUDIO},RecordAudioRequestCode);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == RecordAudioRequestCode && grantResults.length > 0 ){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED)
                Toast.makeText(this,"Permission Granted",Toast.LENGTH_SHORT).show();
        }
    }


    @SuppressLint("ClickableViewAccessibility")
    public void targetVoiceAnswer (ImageButton btnMic, String correctAnswer, String currentScreen, String screenName){
        if(ContextCompat.checkSelfPermission(this,Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED){
            checkPermission();
        }

        SpeechRecognizer speechRecog = SpeechRecognizer.createSpeechRecognizer(this);
        speechRecog.setRecognitionListener(new RecognitionListener() {
            @Override
            public void onReadyForSpeech(Bundle bundle) {

            }

            @Override
            public void onBeginningOfSpeech() {

            }

            @Override
            public void onRmsChanged(float v) {

            }

            @Override
            public void onBufferReceived(byte[] bytes) {

            }

            @Override
            public void onEndOfSpeech() {

            }

            @Override
            public void onError(int i) {
                /*Toast.makeText(getBaseContext(),"TRY AGAIN",Toast.LENGTH_SHORT).show();
                mediaplayer = MediaPlayer.create(quizvoice.this, R.raw.please);
                mediaplayer.start();*/

            }

            @Override
            public void onResults(Bundle bundle) {


                ArrayList<String> data = bundle.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
                System.out.println("answer " + data.get(0));
                if (data.get(0).equals(correctAnswer.toLowerCase())){
                    score++;
                    new QuizDialog("CORRECT", false).show(getSupportFragmentManager(), QuizDialog.TAG);
                    if(screenName.equals("Shape")){
                        generateShapeQuestion(currentScreen, screenName);
                    }
                    if(screenName.equals("Color")) {
                        generateColorQuestion(currentScreen,screenName);
                    }
                    if(screenName.equals("Alphabet")) {
                        generateAlphabetQuestion(currentScreen,screenName);
                    }
                    if(screenName.equals("Number")) {
                        generateNumberQuestion(currentScreen,screenName);
                    }

                }
                else {
                    new QuizDialog("WRONG", false).show(getSupportFragmentManager(), QuizDialog.TAG);
                    if(screenName.equals("Shape")){
                        generateShapeQuestion(currentScreen, screenName);
                    }
                    if(screenName.equals("Color")) {
                        generateColorQuestion(currentScreen,screenName);
                    }
                    if(screenName.equals("Alphabet")) {
                        generateAlphabetQuestion(currentScreen,screenName);
                    }
                    if(screenName.equals("Number")) {
                        generateNumberQuestion(currentScreen,screenName);
                    }
                }

            }

            @Override
            public void onPartialResults(Bundle bundle) {

            }

            @Override
            public void onEvent(int i, Bundle bundle) {

            }
        });

        btnMic.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP){
                    speechRecog.stopListening();
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){

                    speechRecog.startListening(speechRecognizerIntent);
                }
                return false;

            }
        });
    }

    public void generateShapeQuestion(String currentScreen, String screenName){
        try {
            if(VoiceShapeQuizData.QUIZ_INITIAL_VISIT){
                new QuizDialog("LET START THE QUIZ", true).show(getSupportFragmentManager(), QuizDialog.TAG);
                VoiceShapeQuizData.QUIZ_INITIAL_VISIT = false;
            }
            int counterShape = new VoiceShapeQuizData().questionCounterShape();

            if(counterShape >= VoiceShapeQuizData.SHAPE_QUESTION_NAMES.length) {
                finishQuiz(currentScreen, screenName, VoiceShapeQuizData.SHAPE_QUESTION_NAMES.length);
                return;
            }

            VoiceQuizModel question = new VoiceShapeQuizData().getOneShapeQuestion(VoiceShapeQuizData.SHAPE_QUESTION_NAMES[counterShape]);
            imgVoiceQuestion.setImageResource(question.getVoiceQuizImage());

            targetVoiceAnswer(micButton, question.getVoiceQuizCorrectAnswer(),currentScreen, screenName);

        }catch(Exception e){

            finishQuiz(currentScreen, screenName, VoiceShapeQuizData.SHAPE_QUESTION_NAMES.length);
        }
    }

    public void generateColorQuestion(String currentScreen, String screenName){
        try{
            if(VoiceColorQuizData.QUIZ_INITIAL_VISIT){
                new QuizDialog("LET START THE QUIZ",true).show(getSupportFragmentManager(),QuizDialog.TAG);
                VoiceColorQuizData.QUIZ_INITIAL_VISIT = false;
            }
            int counterColor = new VoiceColorQuizData().questionCounterColor();
            if(counterColor >= VoiceColorQuizData.COLOR_QUESTION_NAMES.length){
                finishQuiz(currentScreen, screenName, VoiceColorQuizData.COLOR_QUESTION_NAMES.length);
                return;
            }

            VoiceQuizModel question = new VoiceColorQuizData().getOneColorQuestion(VoiceColorQuizData.COLOR_QUESTION_NAMES[counterColor]);
            imgVoiceQuestion.setImageResource(question.getVoiceQuizImage());

            targetVoiceAnswer(micButton, question.getVoiceQuizCorrectAnswer(),currentScreen,screenName);
        }catch (Exception e){
            finishQuiz(currentScreen, screenName, VoiceColorQuizData.COLOR_QUESTION_NAMES.length);
        }
    }
    public void generateAlphabetQuestion(String currentScreen, String screenName){
        try{
            if(VoiceAlphabetQuizData.QUIZ_INITIAL_VISIT){
                new QuizDialog("LET START THE QUIZ", true).show(getSupportFragmentManager(),QuizDialog.TAG);
                VoiceAlphabetQuizData.QUIZ_INITIAL_VISIT = false;
            }
            int counterAlphabet = new VoiceColorQuizData().questionCounterColor();
            if(counterAlphabet >= VoiceColorQuizData.COLOR_QUESTION_NAMES.length){
                finishQuiz(currentScreen, screenName, VoiceColorQuizData.COLOR_QUESTION_NAMES.length);
                return;
            }

            VoiceQuizModel question = new VoiceAlphabetQuizData().getOneAlphabetQuestion(VoiceAlphabetQuizData.ALPHABET_QUESTION_NAMES[counterAlphabet]);
            imgVoiceQuestion.setImageResource(question.getVoiceQuizImage());

            targetVoiceAnswer(micButton, question.getVoiceQuizCorrectAnswer(),currentScreen,screenName);
        }catch (Exception e){
            finishQuiz(currentScreen, screenName, VoiceColorQuizData.COLOR_QUESTION_NAMES.length);
        }
    }
    public void generateNumberQuestion(String currentScreen, String screenName){
        try{
            if(VoiceNumberQuizData.QUIZ_INITIAL_VISIT){
                new QuizDialog("LET START THE QUIZ",true).show(getSupportFragmentManager(),QuizDialog.TAG);
                VoiceNumberQuizData.QUIZ_INITIAL_VISIT = false;
            }
            int counterNumber = new VoiceNumberQuizData().questionCounterNumber();
            if(counterNumber >= VoiceNumberQuizData.NUMBER_QUESTION_NAMES.length){
                finishQuiz(currentScreen, screenName, VoiceNumberQuizData.NUMBER_QUESTION_NAMES.length);
                return;
            }

            VoiceQuizModel question = new VoiceNumberQuizData().getOneNumberQuestion(VoiceNumberQuizData.NUMBER_QUESTION_NAMES[counterNumber]);
            imgVoiceQuestion.setImageResource(question.getVoiceQuizImage());

            targetVoiceAnswer(micButton, question.getVoiceQuizCorrectAnswer(),currentScreen,screenName);
        }catch (Exception e){
            e.printStackTrace();
            finishQuiz(currentScreen, screenName, VoiceNumberQuizData.NUMBER_QUESTION_NAMES.length);
        }
    }


    public void finishQuiz(String currentScreen, String screenName, int quizItem){
        if(screenName.equals("Shape")){
            quizScoreDatabaseHelper.insertQuizScore("VOICE", "SHAPE", Integer.toString(score), LocalDate.now().toString(), Integer.toString(VoiceShapeQuizData.SHAPE_QUESTION_NAMES.length));
        }
        if(screenName.equals("Color")) {
            quizScoreDatabaseHelper.insertQuizScore("VOICE", "COLOR", Integer.toString(score), LocalDate.now().toString(), Integer.toString(VoiceColorQuizData.COLOR_QUESTION_NAMES.length));
        }
        if(screenName.equals("Alphabet")) {
            quizScoreDatabaseHelper.insertQuizScore("VOICE", "ALPHABET", Integer.toString(score), LocalDate.now().toString(), Integer.toString(VoiceAlphabetQuizData.ALPHABET_QUESTION_NAMES.length));
        }
        if(screenName.equals("Number")){
            quizScoreDatabaseHelper.insertQuizScore("VOICE", "NUMBER", Integer.toString(score), LocalDate.now().toString(), Integer.toString(VoiceNumberQuizData.NUMBER_QUESTION_NAMES.length));
        }

        score = 0;
        VoiceShapeQuizData.resetCounter();
        VoiceColorQuizData.resetCounter();
        VoiceAlphabetQuizData.resetCounter();
        VoiceNumberQuizData.resetCounter();
        Intent intent = new Intent(this, scorequiz.class);
        intent.putExtra("screen", currentScreen);
        intent.putExtra("quizItem", quizItem);
        intent.putExtra("score", score);
        startActivity(intent);

    }

}