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
        createAlphabetQuizQuestion(R.drawable.lettera, "A");
        createAlphabetQuizQuestion(R.drawable.letterb, "B");
        createAlphabetQuizQuestion(R.drawable.letterc, "C");
        createAlphabetQuizQuestion(R.drawable.letterd, "D");
        createAlphabetQuizQuestion(R.drawable.lettere, "E");
        createAlphabetQuizQuestion(R.drawable.letterf, "F");
        createAlphabetQuizQuestion(R.drawable.letterg, "G");
        createAlphabetQuizQuestion(R.drawable.letterh, "H");
        createAlphabetQuizQuestion(R.drawable.letteri, "I");
        createAlphabetQuizQuestion(R.drawable.letterj, "J");
        createAlphabetQuizQuestion(R.drawable.letterk, "K");
        createAlphabetQuizQuestion(R.drawable.letterl, "L");
        createAlphabetQuizQuestion(R.drawable.letterm, "M");
        createAlphabetQuizQuestion(R.drawable.lettern, "N");
        createAlphabetQuizQuestion(R.drawable.lettero, "O");
        createAlphabetQuizQuestion(R.drawable.letterp, "P");
        createAlphabetQuizQuestion(R.drawable.letterq, "Q");
        createAlphabetQuizQuestion(R.drawable.letterr, "R");
        createAlphabetQuizQuestion(R.drawable.letters, "S");
        createAlphabetQuizQuestion(R.drawable.lettert, "T");
        createAlphabetQuizQuestion(R.drawable.letteru, "U");
        createAlphabetQuizQuestion(R.drawable.letterv, "V");
        createAlphabetQuizQuestion(R.drawable.letterw, "W");
        createAlphabetQuizQuestion(R.drawable.letterx, "X");
        createAlphabetQuizQuestion(R.drawable.lettery, "Y");
        createAlphabetQuizQuestion(R.drawable.letterz, "Z");

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
