package com.example.scan.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.scan.QuizScore.QuizScoreModel;
import com.example.scan.R;

import java.util.ArrayList;

public class QuizScoreAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<QuizScoreModel> quizScoreModelArrayList;

    public QuizScoreAdapter(Context _context, ArrayList<QuizScoreModel> _quizScoreModelArrayList) {
        this.context = _context;
        this.quizScoreModelArrayList = _quizScoreModelArrayList;
    }
    @Override
    public int getCount() {
        return quizScoreModelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return quizScoreModelArrayList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
       ViewHolder holder;

       holder = new ViewHolder();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.quiz_score_layout, null, true);

        holder.quizCategory = (TextView) view.findViewById(R.id.tvQuizScoreCategory);
        holder.quizType = (TextView) view.findViewById(R.id.tvQuizScoreType);
        holder.quizScore = (TextView) view.findViewById(R.id.tvQuizScore);
        holder.quizDate = (TextView) view.findViewById(R.id.tvQuizScoreDate);
        view.setTag(holder);

        holder.quizCategory.setText(quizScoreModelArrayList.get(position).getQuizCategory());
        holder.quizType.setText(quizScoreModelArrayList.get(position).getQuizType());
        holder.quizScore.setText(quizScoreModelArrayList.get(position).getQuizScore());
        holder.quizDate.setText(quizScoreModelArrayList.get(position).getQuizDate());

        return view;
    }

    private class ViewHolder {
        protected TextView quizCategory, quizType, quizScore, quizDate;
    }
}
