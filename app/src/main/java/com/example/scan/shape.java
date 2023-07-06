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
    private ImageButton btnstar, btnsquare, btncircle, btnrectangle, btndiamond, btntriangle, btnheart, btnoval;

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
        btncircle = findViewById(R.id.btncircle);
        btncircle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.circle, R.string.txt_circle, R.raw.circle).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnrectangle = findViewById(R.id.btnrectangle);
        btnrectangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.rectangle, R.string.txt_rectangle, R.raw.rectangle).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btndiamond = findViewById(R.id.btndiamond);
        btndiamond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.diamond, R.string.txt_diamond, R.raw.diamond).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btntriangle = findViewById(R.id.btntriangle);
        btntriangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.triangle, R.string.txt_triangle, R.raw.triangle).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnheart = findViewById(R.id.btnheart);
        btnheart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.heart, R.string.txt_heart, R.raw.heart).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnoval = findViewById(R.id.btnoval);
        btnoval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.oval, R.string.txt_oval, R.raw.oval).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
    }
}