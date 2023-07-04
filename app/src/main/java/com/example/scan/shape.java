package com.example.scan;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class shape extends AppCompatActivity {

    private ImageButton button;
    private ImageButton btnstar, btnsquare;

    private ImageButton imgbtnvoiceout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shape);
        button = findViewById(R.id.btnback);

        Intent svc=new Intent(this, bgService.class);
        stopService(svc); //OR stopService(svc);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(shape.this,CATEGORY.class);
                startActivity(intent);
            }
        });
        btnstar = findViewById(R.id.btnstar);
        btnstar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.star, R.string.txt_star, R.raw.star).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnsquare = findViewById(R.id.btnsquare);
        btnsquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.square, R.string.txt_square, R.raw.square).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
    }
}