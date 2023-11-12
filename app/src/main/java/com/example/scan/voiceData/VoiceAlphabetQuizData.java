package com.example.scan.voiceData;

import com.example.scan.R;
import com.example.scan.quizData.AlphabetQuestion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class VoiceAlphabetQuizData {
    public static HashMap<String, VoiceQuizModel> hashMapQuestion = new HashMap<String, VoiceQuizModel>();
    public static boolean QUIZ_INITIAL_VISIT = true;
    public static int ALPHABET_QUESTION_COUNTER = -1;
    public static String[] ALPHABET_QUESTION_NAMES = {
            "A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"
    };

    public static Random rand = new Random();
    public static int[] randomNumbers;


    public HashMap<String, VoiceQuizModel> createAlphabetQuizQuestion(int _imageViewQuestion, String _correctAnswer) {

        hashMapQuestion.put(_correctAnswer, new VoiceQuizModel(_imageViewQuestion, _correctAnswer));

        return hashMapQuestion;
    }

    public void setAlphabetQuestion() {
        System.out.println("CHECK RANDOM " + Arrays.toString(randomNumbers));
        randomNumbers =  rand.ints(0, ALPHABET_QUESTION_NAMES.length).distinct().limit(ALPHABET_QUESTION_NAMES.length).toArray();
        createAlphabetQuizQuestion(R.drawable.quizant, "A");
        createAlphabetQuizQuestion(R.drawable.quizalphabee, "B");
        createAlphabetQuizQuestion(R.drawable.quizcat, "C");
        createAlphabetQuizQuestion(R.drawable.quizdog, "D");
        createAlphabetQuizQuestion(R.drawable.quizalphaegg, "E");
        createAlphabetQuizQuestion(R.drawable.quizfrog, "F");
        createAlphabetQuizQuestion(R.drawable.quizgoat, "G");
        createAlphabetQuizQuestion(R.drawable.quizalphaheart, "H");
        createAlphabetQuizQuestion(R.drawable.quizicecream, "I");
        createAlphabetQuizQuestion(R.drawable.quizjellyfish, "J");
        createAlphabetQuizQuestion(R.drawable.quizkite, "K");
        createAlphabetQuizQuestion(R.drawable.quizlion, "L");
        createAlphabetQuizQuestion(R.drawable.quizmilk, "M");
        createAlphabetQuizQuestion(R.drawable.quiznest, "N");
        createAlphabetQuizQuestion(R.drawable.quizoctopus, "O");
        createAlphabetQuizQuestion(R.drawable.quizpumpkin, "P");
        createAlphabetQuizQuestion(R.drawable.quizqueen, "Q");
        createAlphabetQuizQuestion(R.drawable.quizrobot, "R");
        createAlphabetQuizQuestion(R.drawable.quizalphastar, "S");
        createAlphabetQuizQuestion(R.drawable.quiztrain, "T");
        createAlphabetQuizQuestion(R.drawable.quizambrella, "U");
        createAlphabetQuizQuestion(R.drawable.quizvase, "V");
        createAlphabetQuizQuestion(R.drawable.quizworm, "W");
        createAlphabetQuizQuestion(R.drawable.quizxylophone, "X");
        createAlphabetQuizQuestion(R.drawable.quizyoyo, "Y");
        createAlphabetQuizQuestion(R.drawable.quizzoo, "Z");

        System.out.println(hashMapQuestion.size());
    }

    public VoiceQuizModel getOneAlphabetQuestion(String keyName){
        return hashMapQuestion.get(keyName);
    }

    public int questionCounterAlphabet(){
        if(ALPHABET_QUESTION_COUNTER > ALPHABET_QUESTION_NAMES.length){
            return ALPHABET_QUESTION_NAMES.length;
        }
        ALPHABET_QUESTION_COUNTER++;
        return randomNumbers[ALPHABET_QUESTION_COUNTER];
    }
    public static void resetCounter () {
        ALPHABET_QUESTION_COUNTER = -1;
        QUIZ_INITIAL_VISIT = true;
    }
}
