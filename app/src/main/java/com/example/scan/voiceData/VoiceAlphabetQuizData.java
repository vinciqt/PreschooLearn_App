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
        createAlphabetQuizQuestion(R.drawable.quiz_ant, "A");
        createAlphabetQuizQuestion(R.drawable.quiz_bee, "B");
        createAlphabetQuizQuestion(R.drawable.quiz_cat, "C");
        createAlphabetQuizQuestion(R.drawable.quiz_dog, "D");
        createAlphabetQuizQuestion(R.drawable.quiz_egg, "E");
        createAlphabetQuizQuestion(R.drawable.quiz_frog, "F");
        createAlphabetQuizQuestion(R.drawable.quiz_goat, "G");
        createAlphabetQuizQuestion(R.drawable.quiz_heart, "H");
        createAlphabetQuizQuestion(R.drawable.quiz_icecream, "I");
        createAlphabetQuizQuestion(R.drawable.quiz_jellyfish, "J");
        createAlphabetQuizQuestion(R.drawable.quiz_kite, "K");
        createAlphabetQuizQuestion(R.drawable.quiz_lion, "L");
        createAlphabetQuizQuestion(R.drawable.quiz_milk, "M");
        createAlphabetQuizQuestion(R.drawable.quiz_nest, "N");
        createAlphabetQuizQuestion(R.drawable.quiz_octopus, "O");
        createAlphabetQuizQuestion(R.drawable.quiz_pumpkin, "P");
        createAlphabetQuizQuestion(R.drawable.quiz_queen, "Q");
        createAlphabetQuizQuestion(R.drawable.quiz_robot, "R");
        createAlphabetQuizQuestion(R.drawable.quiz_star, "S");
        createAlphabetQuizQuestion(R.drawable.quiz_train, "T");
        createAlphabetQuizQuestion(R.drawable.quiz_umbrella, "U");
        createAlphabetQuizQuestion(R.drawable.quiz_vase, "V");
        createAlphabetQuizQuestion(R.drawable.quiz_worm, "W");
        createAlphabetQuizQuestion(R.drawable.quiz_xylophone, "X");
        createAlphabetQuizQuestion(R.drawable.quiz_yoyo, "Y");
        createAlphabetQuizQuestion(R.drawable.quiz_zoo, "Z");

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
