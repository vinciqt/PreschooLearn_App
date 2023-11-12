package com.example.scan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.scan.Adapter.QuizScoreAdapter;
import com.example.scan.QuizScore.QuizScoreModel;
import com.example.scan.database.QuizScoreDatabaseHelper;

import java.util.ArrayList;

public class quizhistory extends AppCompatActivity {

    private ImageButton button;

    private ArrayList<QuizScoreModel> quizScoreModelArrayList;
    private QuizScoreDatabaseHelper quizScoreDatabaseHelper;
    private QuizScoreAdapter quizScoreAdapter;
    private ListView quizScoreListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizhistory);

        quizScoreListView = findViewById(R.id.quizScoreListView);
        quizScoreDatabaseHelper = new QuizScoreDatabaseHelper(this);
        quizScoreModelArrayList = quizScoreDatabaseHelper.getAllQuiz();

        quizScoreAdapter = new QuizScoreAdapter(this, quizScoreModelArrayList);
        quizScoreListView.setAdapter(quizScoreAdapter);

        button = findViewById(R.id.btnback);


        Intent svc=new Intent(this, bgService.class);
        startService(svc); //OR stopService(svc);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(quizhistory.this, quiz.class);
                startActivity(intent);

            }
        });
    }
}