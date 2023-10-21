package com.example.scan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class number extends AppCompatActivity {

    private ImageButton button;
    private ImageButton btnone, btntwo, btnthree, btnfour, btnfive, btnsix, btnseven, btneight, btnnine, btnten;

    private ImageButton imgbtnvoiceout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);
        button = findViewById(R.id.btnback);
        Intent svc=new Intent(this, bgService.class);
        stopService(svc); //OR stopService(svc);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(number.this,CATEGORY.class);
                startActivity(intent);
            }
        });
        btnone = findViewById(R.id.btnone);
        btnone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.numberone, R.string.txt_one, R.raw.one, new videoRaw().getVideoRaw(getPackageName(),R.raw.videoone)).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btntwo = findViewById(R.id.btntwo);
        btntwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.numbertwo, R.string.txt_two, R.raw.two, new videoRaw().getVideoRaw(getPackageName(),R.raw.videotwo)).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnthree = findViewById(R.id.btnthree);
        btnthree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.numberthree, R.string.txt_three, R.raw.three, new videoRaw().getVideoRaw(getPackageName(),R.raw.videothree)).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnfour = findViewById(R.id.btnfour);
        btnfour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.numberfour, R.string.txt_four, R.raw.four, new videoRaw().getVideoRaw(getPackageName(),R.raw.videofour)).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnfive = findViewById(R.id.btnfive);
        btnfive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.numberfive, R.string.txt_five, R.raw.five, new videoRaw().getVideoRaw(getPackageName(),R.raw.videofive)).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnsix = findViewById(R.id.btnsix);
        btnsix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.numbersix, R.string.txt_six, R.raw.six, new videoRaw().getVideoRaw(getPackageName(),R.raw.videosix)).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnseven = findViewById(R.id.btnseven);
        btnseven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.numberseven, R.string.txt_seven, R.raw.seven, new videoRaw().getVideoRaw(getPackageName(),R.raw.videoseven)).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btneight = findViewById(R.id.btneight);
        btneight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.numbereight, R.string.txt_eight, R.raw.eight, new videoRaw().getVideoRaw(getPackageName(),R.raw.videoeight)).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnnine = findViewById(R.id.btnnine);
        btnnine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.numbernine, R.string.txt_nine, R.raw.nine, new videoRaw().getVideoRaw(getPackageName(),R.raw.videonine)).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnten = findViewById(R.id.btnten);
        btnten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.numberten, R.string.txt_ten, R.raw.ten, new videoRaw().getVideoRaw(getPackageName(),R.raw.videoten)).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
    }
}