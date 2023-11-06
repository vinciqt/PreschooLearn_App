package com.example.scan.quizData;

import com.example.scan.R;

import java.util.ArrayList;
import java.util.HashMap;


public class AlphabetQuizData {

    public static HashMap<String, AlphabetQuestion> hashMapQuestion = new HashMap<String, AlphabetQuestion>();
    public static int ALPHABET_QUESTION_SIZE = 25;
    public static int ALPHABET_QUESTION_COUNTER = -1;
    public static String[] ALPHABET_QUESTION_NAMES = {
            "A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"
    };


    public HashMap<String, AlphabetQuestion> createAlphabetQuizQuestion(int _imageViewQuestion, String _correctAnswer, int _correctAnswerPosition, int _otherAnswer1, int _otherAnswer2, int _otherAnswer3, int _corAnswer) {

        hashMapQuestion.put(_correctAnswer, new AlphabetQuestion(_imageViewQuestion, _correctAnswer, _correctAnswerPosition, _otherAnswer1, _otherAnswer2, _otherAnswer3, _corAnswer));

        return hashMapQuestion;
    }

    public void setAlphabetQuestion() {
        createAlphabetQuizQuestion(R.drawable.imgsquare, "A", 3, R.drawable.imgcircle, R.drawable.imgheart, R.drawable.imgoval, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.imgstar, "B", 0, R.drawable.imgstar, R.drawable.imgheart, R.drawable.imgoval, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.imgoval, "C", 1, R.drawable.imgcircle, R.drawable.imgoval, R.drawable.imgoval, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.imgheart, "D", 3, R.drawable.imgcircle, R.drawable.imgsquare, R.drawable.imgoval, R.drawable.imgheart);
        createAlphabetQuizQuestion(R.drawable.imgtriangle, "E", 1, R.drawable.imgcircle, R.drawable.imgrectangle, R.drawable.imgoval, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.imgcircle, "F", 0, R.drawable.imgcircle, R.drawable.imgheart, R.drawable.imgoval, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.imgrectangle, "G", 2, R.drawable.imgcircle, R.drawable.imgheart, R.drawable.imgrectangle, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.imgsquare, "H", 3, R.drawable.imgcircle, R.drawable.imgheart, R.drawable.imgoval, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.imgstar, "I", 0, R.drawable.imgstar, R.drawable.imgheart, R.drawable.imgoval, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.imgoval, "J", 1, R.drawable.imgcircle, R.drawable.imgoval, R.drawable.imgoval, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.imgheart, "K", 3, R.drawable.imgcircle, R.drawable.imgsquare, R.drawable.imgoval, R.drawable.imgheart);
        createAlphabetQuizQuestion(R.drawable.imgtriangle, "L", 1, R.drawable.imgcircle, R.drawable.imgrectangle, R.drawable.imgoval, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.imgcircle, "M", 0, R.drawable.imgcircle, R.drawable.imgheart, R.drawable.imgoval, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.imgrectangle, "N", 2, R.drawable.imgcircle, R.drawable.imgheart, R.drawable.imgrectangle, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.imgsquare, "O", 3, R.drawable.imgcircle, R.drawable.imgheart, R.drawable.imgoval, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.imgstar, "P", 0, R.drawable.imgstar, R.drawable.imgheart, R.drawable.imgoval, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.imgoval, "Q", 1, R.drawable.imgcircle, R.drawable.imgoval, R.drawable.imgoval, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.imgheart, "R", 3, R.drawable.imgcircle, R.drawable.imgsquare, R.drawable.imgoval, R.drawable.imgheart);
        createAlphabetQuizQuestion(R.drawable.imgtriangle, "S", 1, R.drawable.imgcircle, R.drawable.imgrectangle, R.drawable.imgoval, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.imgcircle, "T", 0, R.drawable.imgcircle, R.drawable.imgheart, R.drawable.imgoval, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.imgrectangle, "U", 2, R.drawable.imgcircle, R.drawable.imgheart, R.drawable.imgrectangle, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.imgsquare, "V", 3, R.drawable.imgcircle, R.drawable.imgheart, R.drawable.imgoval, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.imgstar, "W", 0, R.drawable.imgstar, R.drawable.imgheart, R.drawable.imgoval, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.imgoval, "X", 1, R.drawable.imgcircle, R.drawable.imgoval, R.drawable.imgoval, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.imgheart, "Y", 3, R.drawable.imgcircle, R.drawable.imgsquare, R.drawable.imgoval, R.drawable.imgheart);
        createAlphabetQuizQuestion(R.drawable.imgtriangle, "Z", 1, R.drawable.imgcircle, R.drawable.imgrectangle, R.drawable.imgoval, R.drawable.imgsquare);

        System.out.println(hashMapQuestion.size());
    }

    public AlphabetQuestion getOneAlphabetQuestion(String keyName){
        return hashMapQuestion.get(keyName);
    }

    public int questionCounterAlphabet(){
        if(ALPHABET_QUESTION_COUNTER > ALPHABET_QUESTION_NAMES.length){
            return ALPHABET_QUESTION_SIZE;
        }
        ALPHABET_QUESTION_COUNTER++;
        return ALPHABET_QUESTION_COUNTER;
    }
    public static void resetCounter () {
        ALPHABET_QUESTION_COUNTER = -1;
    }

}
