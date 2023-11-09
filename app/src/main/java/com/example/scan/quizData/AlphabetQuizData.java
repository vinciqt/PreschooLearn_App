package com.example.scan.quizData;

import com.example.scan.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;


public class AlphabetQuizData {

    public static HashMap<String, AlphabetQuestion> hashMapQuestion = new HashMap<String, AlphabetQuestion>();
    public static int ALPHABET_QUESTION_SIZE = 25;
    public static boolean QUIZ_INITIAL_VISIT = true;
    public static int ALPHABET_QUESTION_COUNTER = -1;
    public static String[] ALPHABET_QUESTION_NAMES = {
            "A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"
    };

    public static Random rand = new Random();
    public static int[] randomNumbers;


    public HashMap<String, AlphabetQuestion> createAlphabetQuizQuestion(int _imageViewQuestion, String _correctAnswer, int _correctAnswerPosition, int _otherAnswer1, int _otherAnswer2, int _otherAnswer3, int _corAnswer) {

        hashMapQuestion.put(_correctAnswer, new AlphabetQuestion(_imageViewQuestion, _correctAnswer, _correctAnswerPosition, _otherAnswer1, _otherAnswer2, _otherAnswer3, _corAnswer));

        return hashMapQuestion;
    }

    public void setAlphabetQuestion() {
        System.out.println("CHECK RANDOM " + Arrays.toString(randomNumbers));
        randomNumbers =  rand.ints(0, ALPHABET_QUESTION_NAMES.length).distinct().limit(ALPHABET_QUESTION_NAMES.length).toArray();
        createAlphabetQuizQuestion(R.drawable.lettera, "A", 3, R.drawable.imgcircle, R.drawable.imgheart, R.drawable.imgoval, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.letterb, "B", 0, R.drawable.imgstar, R.drawable.imgheart, R.drawable.imgoval, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.letterc, "C", 1, R.drawable.imgcircle, R.drawable.imgoval, R.drawable.imgoval, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.letterd, "D", 3, R.drawable.imgcircle, R.drawable.imgsquare, R.drawable.imgoval, R.drawable.imgheart);
        createAlphabetQuizQuestion(R.drawable.lettere, "E", 1, R.drawable.imgcircle, R.drawable.imgrectangle, R.drawable.imgoval, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.letterf, "F", 0, R.drawable.imgcircle, R.drawable.imgheart, R.drawable.imgoval, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.letterg, "G", 2, R.drawable.imgcircle, R.drawable.imgheart, R.drawable.imgrectangle, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.letterh, "H", 3, R.drawable.imgcircle, R.drawable.imgheart, R.drawable.imgoval, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.letteri, "I", 0, R.drawable.imgstar, R.drawable.imgheart, R.drawable.imgoval, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.letterj, "J", 1, R.drawable.imgcircle, R.drawable.imgoval, R.drawable.imgoval, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.letterk, "K", 3, R.drawable.imgcircle, R.drawable.imgsquare, R.drawable.imgoval, R.drawable.imgheart);
        createAlphabetQuizQuestion(R.drawable.letterl, "L", 1, R.drawable.imgcircle, R.drawable.imgrectangle, R.drawable.imgoval, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.letterm, "M", 0, R.drawable.imgcircle, R.drawable.imgheart, R.drawable.imgoval, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.lettern, "N", 2, R.drawable.imgcircle, R.drawable.imgheart, R.drawable.imgrectangle, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.lettero, "O", 3, R.drawable.imgcircle, R.drawable.imgheart, R.drawable.imgoval, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.letterp, "P", 0, R.drawable.imgstar, R.drawable.imgheart, R.drawable.imgoval, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.letterq, "Q", 1, R.drawable.imgcircle, R.drawable.imgoval, R.drawable.imgoval, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.letterr, "R", 3, R.drawable.imgcircle, R.drawable.imgsquare, R.drawable.imgoval, R.drawable.imgheart);
        createAlphabetQuizQuestion(R.drawable.letters, "S", 1, R.drawable.imgcircle, R.drawable.imgrectangle, R.drawable.imgoval, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.lettert, "T", 0, R.drawable.imgcircle, R.drawable.imgheart, R.drawable.imgoval, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.letteru, "U", 2, R.drawable.imgcircle, R.drawable.imgheart, R.drawable.imgrectangle, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.letterv, "V", 3, R.drawable.imgcircle, R.drawable.imgheart, R.drawable.imgoval, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.letterw, "W", 0, R.drawable.imgstar, R.drawable.imgheart, R.drawable.imgoval, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.letterx, "X", 1, R.drawable.imgcircle, R.drawable.imgoval, R.drawable.imgoval, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.lettery, "Y", 3, R.drawable.imgcircle, R.drawable.imgsquare, R.drawable.imgoval, R.drawable.imgheart);
        createAlphabetQuizQuestion(R.drawable.letterz, "Z", 1, R.drawable.imgcircle, R.drawable.imgrectangle, R.drawable.imgoval, R.drawable.imgsquare);

        System.out.println(hashMapQuestion.size());
    }

    public AlphabetQuestion getOneAlphabetQuestion(String keyName){
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
