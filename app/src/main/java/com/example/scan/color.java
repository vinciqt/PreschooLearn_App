package com.example.scan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class color extends AppCompatActivity {

    private ImageButton button;
    private ImageButton btnblue, btnred, btnyellow, btnorange, btnviolet, btngreen;

    private ImageButton imgbtnvoiceout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        button = findViewById(R.id.btnback);
        Intent svc=new Intent(this, bgService.class);
        stopService(svc); //OR stopService(svc);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(color.this,CATEGORY.class);
                startActivity(intent);
            }
        });
        btnblue = findViewById(R.id.btnblue);
        btnblue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.blue, R.string.txt_blue, R.raw.blue).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnred = findViewById(R.id.btnred);
        btnred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.red, R.string.txt_red, R.raw.red).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnyellow = findViewById(R.id.btnyellow);
        btnyellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.yellow, R.string.txt_yellow, R.raw.yellow).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnorange = findViewById(R.id.btnorange);
        btnorange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.orange, R.string.txt_orange, R.raw.orange).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnviolet = findViewById(R.id.btnviolet);
        btnviolet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.violet, R.string.txt_violet, R.raw.violet).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btngreen = findViewById(R.id.btngreen);
        btngreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.green, R.string.txt_green, R.raw.green).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
    }
}