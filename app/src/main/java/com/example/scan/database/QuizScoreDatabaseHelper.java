package com.example.scan.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.scan.CATEGORY;
import com.example.scan.QuizDialog;
import com.example.scan.QuizScore.QuizScoreModel;

import java.util.ArrayList;
import java.util.Arrays;

public class QuizScoreDatabaseHelper extends SQLiteOpenHelper {

    public static String DATABASE_NAME = "quiz_score_db";
    private static int DATABASE_VERSION = 3;

    private static final String QUIZ_SCORE_TABLE = "quiz_score_table";
    private static final String KEY_ID = "quiz_id";
    private static final String KEY_QUIZ_CATEGORY = "quiz_category";
    private static final String KEY_QUIZ_TYPE = "quiz_type";
    private static final String KEY_QUIZ_SCORE = "quiz_score";
    private static final String KEY_QUIZ_DATE = "quiz_date";

    private static final String KEY_QUIZ_COUNT_OVERALL = "quiz_count_overall";

    private static final String CREATE_TABLE = "CREATE TABLE " +
            QUIZ_SCORE_TABLE + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            KEY_QUIZ_CATEGORY + " TEXT NOT NULL," +
            KEY_QUIZ_TYPE + " TEXT NOT NULL," +
            KEY_QUIZ_SCORE + " TEXT NOT NULL," +
            KEY_QUIZ_COUNT_OVERALL + " TEXT NOT NULL, " +
            KEY_QUIZ_DATE + " TEXT NOT NULL " + ");";

    public QuizScoreDatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("Table", CREATE_TABLE);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS '" + QUIZ_SCORE_TABLE + "'");
        onCreate(sqLiteDatabase);
    }

    public long insertQuizScore(String quizCategory, String quizType, String quizScore, String quizDate, String quizScoreOverAll){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values  = new ContentValues();

        values.put(KEY_QUIZ_CATEGORY, quizCategory);
        values.put(KEY_QUIZ_TYPE, quizType);
        values.put(KEY_QUIZ_SCORE, quizScore);
        values.put(KEY_QUIZ_DATE, quizDate);
        values.put(KEY_QUIZ_COUNT_OVERALL, quizScoreOverAll);
        long insert = db.insert(QUIZ_SCORE_TABLE, null, values);

        String query = "SELECT * FROM " + QUIZ_SCORE_TABLE;
        Cursor c = db.rawQuery(query, null);

        return insert;
    }

    public ArrayList<QuizScoreModel> getAllQuiz(){
        ArrayList<QuizScoreModel> quizScoreModelArrayList = new ArrayList<QuizScoreModel>();

        String getAllQuery = "SELECT * FROM " + QUIZ_SCORE_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(getAllQuery, null);

        if(c.moveToFirst()) {
            do {
                @SuppressLint("Range") int id = c.getInt(c.getColumnIndex(KEY_ID));
                @SuppressLint("Range") String quizCategory = c.getString(c.getColumnIndex(KEY_QUIZ_CATEGORY));
                @SuppressLint("Range") String quizType = c.getString(c.getColumnIndex(KEY_QUIZ_TYPE));
                @SuppressLint("Range") String quizScore = c.getString(c.getColumnIndex(KEY_QUIZ_SCORE));
                @SuppressLint("Range") String quizDate = c.getString(c.getColumnIndex(KEY_QUIZ_DATE));
                @SuppressLint("Range") String quizScoreOverall = c.getString(c.getColumnIndex(KEY_QUIZ_COUNT_OVERALL));

                QuizScoreModel quizScoreModel = new QuizScoreModel(id, quizCategory,quizType, quizScore, quizDate, quizScoreOverall);
                quizScoreModelArrayList.add(quizScoreModel);

            } while(c.moveToNext());
        }

        return quizScoreModelArrayList;
    }
}
