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


    public HashMap<String, AlphabetQuestion> createAlphabetQuizQuestion(int _imageViewQuestion, String _correctAnswer, int _correctAnswerPosition, int _otherAnswer1, int _otherAnswer2, int _otherAnswer3, int _corAnswer, int _soundQuestion) {

        hashMapQuestion.put(_correctAnswer, new AlphabetQuestion(_imageViewQuestion, _correctAnswer, _correctAnswerPosition, _otherAnswer1, _otherAnswer2, _otherAnswer3, _corAnswer, _soundQuestion));

        return hashMapQuestion;
    }

    public void setAlphabetQuestion() {
        System.out.println("CHECK RANDOM " + Arrays.toString(randomNumbers));
        randomNumbers =  rand.ints(0, ALPHABET_QUESTION_NAMES.length).distinct().limit(ALPHABET_QUESTION_NAMES.length).toArray();
        createAlphabetQuizQuestion(R.drawable.quiz_ant, "A", 3, R.drawable.letterg, R.drawable.letterz, R.drawable.letteri, R.drawable.lettera, R.raw.voicequiz_ant);
        createAlphabetQuizQuestion(R.drawable.quiz_bee, "B", 0, R.drawable.letterb, R.drawable.letterd, R.drawable.letters, R.drawable.letterp, R.raw.voicequiz_bee);
        createAlphabetQuizQuestion(R.drawable.quiz_cat, "C", 1, R.drawable.lettert, R.drawable.letterc, R.drawable.letterr, R.drawable.letterl, R.raw.voicequiz_cat);
        createAlphabetQuizQuestion(R.drawable.quiz_dog, "D", 3, R.drawable.letterq, R.drawable.letterw, R.drawable.letteru, R.drawable.letterd, R.raw.voicequiz_dog);
        createAlphabetQuizQuestion(R.drawable.quiz_egg, "E", 1, R.drawable.letterm, R.drawable.lettere, R.drawable.letterx, R.drawable.letterv, R.raw.voicequiz_egg);
        createAlphabetQuizQuestion(R.drawable.quiz_frog, "F", 0, R.drawable.letterf, R.drawable.lettera, R.drawable.lettere, R.drawable.lettery, R.raw.voicequiz_frog);
        createAlphabetQuizQuestion(R.drawable.quiz_goat, "G", 2, R.drawable.lettero, R.drawable.letterk, R.drawable.letterg, R.drawable.letterj, R.raw.voicequiz_goat);
        createAlphabetQuizQuestion(R.drawable.quiz_heart, "H", 3, R.drawable.letterf, R.drawable.letterb, R.drawable.letterc, R.drawable.letterh, R.raw.voicequiz_heart);
        createAlphabetQuizQuestion(R.drawable.quiz_icecream, "I", 0, R.drawable.letteri, R.drawable.lettern, R.drawable.letterh, R.drawable.letterp, R.raw.voicequiz_icecream);
        createAlphabetQuizQuestion(R.drawable.quiz_jellyfish, "J", 1, R.drawable.lettera, R.drawable.letterj, R.drawable.letterd, R.drawable.letterf, R.raw.voicequiz_jellyfish);
        createAlphabetQuizQuestion(R.drawable.quiz_kite, "K", 3, R.drawable.letterl, R.drawable.letterq, R.drawable.letterb, R.drawable.letterk, R.raw.voicequiz_kite);
        createAlphabetQuizQuestion(R.drawable.quiz_lion, "L", 1, R.drawable.letterc, R.drawable.letterl, R.drawable.lettere, R.drawable.letterx, R.raw.voicequiz_lion);
        createAlphabetQuizQuestion(R.drawable.quiz_milk, "M", 0, R.drawable.letterm, R.drawable.lettern, R.drawable.letterz, R.drawable.lettery, R.raw.voicequiz_milk);
        createAlphabetQuizQuestion(R.drawable.quiz_necklace, "N", 2, R.drawable.lettero, R.drawable.letterr, R.drawable.lettern, R.drawable.letterg, R.raw.voicequiz_necklace);
        createAlphabetQuizQuestion(R.drawable.quiz_octopus, "O", 3, R.drawable.letterk, R.drawable.letteri, R.drawable.letterh, R.drawable.lettero, R.raw.voicequiz_octopus);
        createAlphabetQuizQuestion(R.drawable.quiz_pig, "P", 0, R.drawable.letterp, R.drawable.letterw, R.drawable.letterv, R.drawable.letteru, R.raw.voicequiz_pig);
        createAlphabetQuizQuestion(R.drawable.quiz_queen, "Q", 1, R.drawable.lettert, R.drawable.letterq, R.drawable.letters, R.drawable.letterj, R.raw.voicequiz_queen);
        createAlphabetQuizQuestion(R.drawable.quiz_robot, "R", 3, R.drawable.letterc, R.drawable.lettera, R.drawable.letterm, R.drawable.letterr, R.raw.voicequiz_robot);
        createAlphabetQuizQuestion(R.drawable.quiz_star, "S", 1, R.drawable.letterb, R.drawable.letters, R.drawable.lettero, R.drawable.letterp, R.raw.voicequiz_starfish);
        createAlphabetQuizQuestion(R.drawable.quiz_train, "T", 0, R.drawable.lettert, R.drawable.letteru, R.drawable.letterz, R.drawable.lettery, R.raw.voicequiz_train);
        createAlphabetQuizQuestion(R.drawable.quiz_umbrella, "U", 2, R.drawable.letterj, R.drawable.letterf, R.drawable.letteru, R.drawable.letterh, R.raw.voicequiz_umbrella);
        createAlphabetQuizQuestion(R.drawable.quiz_vase, "V", 3, R.drawable.letterr, R.drawable.letterk, R.drawable.letterm, R.drawable.letterv, R.raw.voicequiz_vase);
        createAlphabetQuizQuestion(R.drawable.quiz_worm, "W", 0, R.drawable.letterw, R.drawable.letteri, R.drawable.letterq, R.drawable.lettern, R.raw.voicequiz_worm);
        createAlphabetQuizQuestion(R.drawable.quiz_xylophone, "X", 1, R.drawable.letterv, R.drawable.letterx, R.drawable.lettere, R.drawable.letterw, R.raw.voicequiz_yoyo);
        createAlphabetQuizQuestion(R.drawable.quiz_yoyo, "Y", 3, R.drawable.letters, R.drawable.lettere, R.drawable.lettert, R.drawable.lettery, R.raw.voicequiz_xylophone);
        createAlphabetQuizQuestion(R.drawable.quiz_zebra, "Z", 1, R.drawable.letterd, R.drawable.letterz, R.drawable.letterl, R.drawable.letterg, R.raw.voicequiz_zebra);

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
