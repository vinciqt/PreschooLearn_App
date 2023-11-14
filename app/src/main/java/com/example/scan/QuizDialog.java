package com.example.scan;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
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

    public QuizDialog(String _message, boolean _isFirstVisit) {
        this.message = _message;
        this.isFirstVisit = _isFirstVisit;
    }

    public int random;

    public int randomWrong;
    private int firstVisitImage = R.drawable.startquiz;
    public int[][] correctImage = {
            {R.drawable.excellent_work, R.raw.excellentwork},
            {R.drawable.fantastic, R.raw.fantastictounailedit},
            {R.drawable.perfect, R.raw.perfectthatslovely},
            {R.drawable.thats_amazing, R.raw.thatsamazing},
            {R.drawable.great_job, R.raw.greatjob},
            {R.drawable.great_you_got_it_right, R.raw.greatyougotitright}
    };

    public int[][] wrongImage = {
            {R.drawable.goodeffort, R.raw.goodefforttryagain},
            {R.drawable.nicetry, R.raw.nicetrytryagainnexttime},
            {R.drawable.incorrect, R.raw.incorrecttryagain}
    };


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_quiz_layout, container, false);

        quizDialogImg = view.findViewById(R.id.quizDialogImg);

        random = new Random().nextInt(6);
        randomWrong = new Random().nextInt(3);


        if (isFirstVisit) {
            quizDialogImg.setImageResource(firstVisitImage);
        } else {
            if (message.equals("CORRECT")) {
                mediaPlayer = MediaPlayer.create(getContext(), correctImage[random][1]);
                quizDialogImg.setImageResource(correctImage[random][0]);
                mediaPlayer.start();
            } else {
                mediaPlayer = MediaPlayer.create(getContext(), wrongImage[randomWrong][1]);
                quizDialogImg.setImageResource(wrongImage[randomWrong][0]);
                mediaPlayer.start();
            }
        }
        return view;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Handler handler = new Handler();
        Runnable runnable = () -> {
            dialog.dismiss();
        };
        handler.postDelayed(runnable, 2000);
        return dialog;
    }
}
