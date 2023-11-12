package com.example.scan.voiceData;

import com.example.scan.R;
import com.example.scan.quizData.NumberQuestion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class VoiceNumberQuizData {
    public static HashMap<String, VoiceQuizModel> hashMapQuestion = new HashMap<String, VoiceQuizModel>();

    public static boolean QUIZ_INITIAL_VISIT = true;
    public static int NUMBER_QUESTION_COUNTER = -1;
    public static String[] NUMBER_QUESTION_NAMES = {
            "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Ate", "Nine", "10"
    };

    public static Random rand = new Random();
    public static int[] randomNumbers;

    public HashMap<String, VoiceQuizModel> createNumberQuizQuestion(int _imageViewQuestion, String _correctAnswer) {

        hashMapQuestion.put(_correctAnswer, new VoiceQuizModel(_imageViewQuestion, _correctAnswer));

        return hashMapQuestion;
    }

    public void setNumberQuestion() {

        randomNumbers=  rand.ints(0, NUMBER_QUESTION_NAMES.length).distinct().limit(NUMBER_QUESTION_NAMES.length).toArray();
        createNumberQuizQuestion(R.drawable.quizonecookie, "One");
        createNumberQuizQuestion(R.drawable.quiztwoperson, "Two");
        createNumberQuizQuestion(R.drawable.quizthreerobot, "Three");
        createNumberQuizQuestion(R.drawable.quizfourdino, "Four");
        createNumberQuizQuestion(R.drawable.quizfiveghost, "Five");
        createNumberQuizQuestion(R.drawable.quizsixwizard, "Six");
        createNumberQuizQuestion(R.drawable.quizsevenwitches, "Seven");
        createNumberQuizQuestion(R.drawable.quizeightbees, mapBrokenNumber("Eight"));
        createNumberQuizQuestion(R.drawable.quizninebirds, "Nine");
        createNumberQuizQuestion(R.drawable.quiztenufo, mapBrokenNumber("Ten"));

        System.out.println(hashMapQuestion.size());
        System.out.println("CHECK RANDOM " + Arrays.toString(randomNumbers));
    }

    public VoiceQuizModel getOneNumberQuestion(String keyName){
        return hashMapQuestion.get(keyName);

    }

    public int questionCounterNumber(){
        if(NUMBER_QUESTION_COUNTER > NUMBER_QUESTION_NAMES.length){
            return NUMBER_QUESTION_NAMES.length;
        }
        NUMBER_QUESTION_COUNTER++;
        return randomNumbers[NUMBER_QUESTION_COUNTER];
    }

    public static void resetCounter () {
        NUMBER_QUESTION_COUNTER = -1;
        QUIZ_INITIAL_VISIT = true;
    }

    public String mapBrokenNumber(String keyName) {
        HashMap<String, String> brokenNumber = new HashMap<String, String>();
        brokenNumber.put("Ten", "10");
        brokenNumber.put("Eight", "Ate");

        return brokenNumber.get(keyName);
    }
}
