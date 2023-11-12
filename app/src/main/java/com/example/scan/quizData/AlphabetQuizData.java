package com.example.scan.quizData;

import com.example.scan.R;

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
        createAlphabetQuizQuestion(R.drawable.quizant, "A", 3, R.drawable.imgcircle, R.drawable.imgheart, R.drawable.imgoval, R.drawable.lettera);
        createAlphabetQuizQuestion(R.drawable.quizalphabee, "B", 0, R.drawable.letterb, R.drawable.imgheart, R.drawable.imgoval, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.quizcat, "C", 1, R.drawable.imgcircle, R.drawable.letterc, R.drawable.imgoval, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.quizdog, "D", 3, R.drawable.imgcircle, R.drawable.imgsquare, R.drawable.imgoval, R.drawable.letterd);
        createAlphabetQuizQuestion(R.drawable.quizalphaegg, "E", 1, R.drawable.imgcircle, R.drawable.lettere, R.drawable.imgoval, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.quizfrog, "F", 0, R.drawable.letterf, R.drawable.imgheart, R.drawable.imgoval, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.quizgoat, "G", 2, R.drawable.imgcircle, R.drawable.imgheart, R.drawable.letterg, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.quizalphaheart, "H", 3, R.drawable.imgcircle, R.drawable.imgheart, R.drawable.imgoval, R.drawable.letterh);
        createAlphabetQuizQuestion(R.drawable.quizicecream, "I", 0, R.drawable.letteri, R.drawable.imgheart, R.drawable.imgoval, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.quizjellyfish, "J", 1, R.drawable.imgcircle, R.drawable.letterj, R.drawable.imgoval, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.quizkite, "K", 3, R.drawable.imgcircle, R.drawable.imgsquare, R.drawable.imgoval, R.drawable.letterk);
        createAlphabetQuizQuestion(R.drawable.quizlion, "L", 1, R.drawable.imgcircle, R.drawable.letterl, R.drawable.imgoval, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.quizmilk, "M", 0, R.drawable.letterm, R.drawable.imgheart, R.drawable.imgoval, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.quiznest, "N", 2, R.drawable.imgcircle, R.drawable.imgheart, R.drawable.lettern, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.quizoctopus, "O", 3, R.drawable.imgcircle, R.drawable.imgheart, R.drawable.imgoval, R.drawable.lettero);
        createAlphabetQuizQuestion(R.drawable.quizpumpkin, "P", 0, R.drawable.letterp, R.drawable.imgheart, R.drawable.imgoval, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.quizqueen, "Q", 1, R.drawable.imgcircle, R.drawable.letterq, R.drawable.imgoval, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.quizrobot, "R", 3, R.drawable.imgcircle, R.drawable.imgsquare, R.drawable.imgoval, R.drawable.letterr);
        createAlphabetQuizQuestion(R.drawable.quizalphastar, "S", 1, R.drawable.imgcircle, R.drawable.letters, R.drawable.imgoval, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.quiztrain, "T", 0, R.drawable.lettert, R.drawable.imgheart, R.drawable.imgoval, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.quizambrella, "U", 2, R.drawable.imgcircle, R.drawable.imgheart, R.drawable.letteru, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.quizvase, "V", 3, R.drawable.imgcircle, R.drawable.imgheart, R.drawable.imgoval, R.drawable.letterv);
        createAlphabetQuizQuestion(R.drawable.quizworm, "W", 0, R.drawable.letterw, R.drawable.imgheart, R.drawable.imgoval, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.quizxylophone, "X", 1, R.drawable.imgcircle, R.drawable.letterx, R.drawable.imgoval, R.drawable.imgsquare);
        createAlphabetQuizQuestion(R.drawable.quizyoyo, "Y", 3, R.drawable.imgcircle, R.drawable.imgsquare, R.drawable.imgoval, R.drawable.lettery);
        createAlphabetQuizQuestion(R.drawable.quizzoo, "Z", 1, R.drawable.imgcircle, R.drawable.letterz, R.drawable.imgoval, R.drawable.imgsquare);

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
