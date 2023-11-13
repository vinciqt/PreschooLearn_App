package com.example.scan;

import android.app.Dialog;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Random;

public class QuizDialog extends DialogFragment {

    public static String TAG = "QuizDialog";
    private String message;
    private boolean isFirstVisit;
    private ImageView quizDialogImg;
    private MediaPlayer mediaPlayer;

    public QuizDialog(String _message, boolean _isFirstVisit){
        this.message = _message;
        this.isFirstVisit = _isFirstVisit;
    }

    public int random;
    private int firstVisitImage = R.drawable.brain;
    private int wrongAnswerImage = R.drawable.w;
    private int wrongAnswerSound = R.raw.two;

    public int[][] correctImage = {
            {R.drawable.quiz_ant, R.raw.amazing},
            {R.drawable.quiz_apple, R.raw.blue},
            {R.drawable.quiz_ball, R.raw.five}
    };


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_quiz_layout, container, false);

        quizDialogImg = view.findViewById(R.id.quizDialogImg);

        random = new Random().nextInt(3);


        if(isFirstVisit){
            quizDialogImg.setImageResource(firstVisitImage);
        }else {
            if(message.equals("CORRECT")) {
                mediaPlayer = MediaPlayer.create(getContext(), correctImage[random][1]);
                quizDialogImg.setImageResource(correctImage[random][0]);
                mediaPlayer.start();
            }else{
                mediaPlayer = MediaPlayer.create(getContext(), wrongAnswerSound);
                quizDialogImg.setImageResource(wrongAnswerImage);
                mediaPlayer.start();
            }
        }
        return view;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        return dialog;

    }

}
