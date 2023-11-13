package com.example.scan.quizData;

import com.example.scan.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;


public class NumberQuizData {

    public static HashMap<String, NumberQuestion> hashMapQuestion = new HashMap<String, NumberQuestion>();
    public static int NUMBER_QUESTION_SIZE = 9;
    public static boolean QUIZ_INITIAL_VISIT = true;
    public static int NUMBER_QUESTION_COUNTER = -1;
    public static String[] NUMBER_QUESTION_NAMES = {
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"
    };

    public static Random rand = new Random();
    public static int[] randomNumbers;

    public HashMap<String, NumberQuestion> createNumberQuizQuestion(int _imageViewQuestion, String _correctAnswer, int _correctAnswerPosition, int _otherAnswer1, int _otherAnswer2, int _otherAnswer3, int _corAnswer) {

        hashMapQuestion.put(_correctAnswer, new NumberQuestion(_imageViewQuestion, _correctAnswer, _correctAnswerPosition, _otherAnswer1, _otherAnswer2, _otherAnswer3, _corAnswer));

        return hashMapQuestion;
    }

    public void setNumberQuestion() {
        System.out.println("CHECK RANDOM " + Arrays.toString(randomNumbers));
        randomNumbers=  rand.ints(0, NUMBER_QUESTION_NAMES.length).distinct().limit(NUMBER_QUESTION_NAMES.length).toArray();
        createNumberQuizQuestion(R.drawable.quiz_cookie, "1", 3, R.drawable.numbernine, R.drawable.numberfive, R.drawable.numberseven, R.drawable.numberone);
        createNumberQuizQuestion(R.drawable.quiz_persons, "2", 0, R.drawable.numbertwo, R.drawable.numberone, R.drawable.numberfour, R.drawable.numberseven);
        createNumberQuizQuestion(R.drawable.quiz_robots, "3", 1, R.drawable.numbersix, R.drawable.numberthree, R.drawable.numbereight, R.drawable.numbertwo);
        createNumberQuizQuestion(R.drawable.quiz_dinos, "4", 2, R.drawable.numberone, R.drawable.numberfive, R.drawable.numberfour, R.drawable.numberten);
        createNumberQuizQuestion(R.drawable.quiz_ghosts, "5", 1, R.drawable.numbertwo, R.drawable.numberfive, R.drawable.numberseven, R.drawable.numbersix);
        createNumberQuizQuestion(R.drawable.quiz_wizards, "6", 0, R.drawable.numbersix, R.drawable.numbereight, R.drawable.numbernine, R.drawable.numberten);
        createNumberQuizQuestion(R.drawable.quiz_witches, "7", 2, R.drawable.numberone, R.drawable.numberthree, R.drawable.numberseven, R.drawable.numbersix);
        createNumberQuizQuestion(R.drawable.quiz_bees, "8", 3, R.drawable.numberten, R.drawable.numbertwo, R.drawable.numberthree, R.drawable.numbereight);
        createNumberQuizQuestion(R.drawable.quiz_parrots, "9", 0, R.drawable.numbernine, R.drawable.numberthree, R.drawable.numberfour, R.drawable.numberfive);
        createNumberQuizQuestion(R.drawable.quiz_ufos, "10", 1, R.drawable.numberseven, R.drawable.numberten, R.drawable.numberthree, R.drawable.numbertwo);

        System.out.println(hashMapQuestion.size());
    }

    public NumberQuestion getOneNumberQuestion(String keyName){
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

}
