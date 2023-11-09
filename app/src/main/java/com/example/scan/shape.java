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
                new ShapeDialog(R.drawable.imgstar, R.string.txt_star, R.raw.star, new videoRaw().getVideoRaw(getPackageName(),R.raw.videostar)).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnsquare = findViewById(R.id.btnsquare);
        btnsquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.imgsquare, R.string.txt_square, R.raw.square, new videoRaw().getVideoRaw(getPackageName(),R.raw.videosquare)).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btncircle = findViewById(R.id.btncircle);
        btncircle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.imgcircle, R.string.txt_circle, R.raw.circle, new videoRaw().getVideoRaw(getPackageName(),R.raw.videocircle)).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnrectangle = findViewById(R.id.btnrectangle);
        btnrectangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.imgrectangle, R.string.txt_rectangle, R.raw.rectangle, new videoRaw().getVideoRaw(getPackageName(),R.raw.videorectangle)).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        //btndiamond = findViewById(R.id.btndiamond);
        //btndiamond.setOnClickListener(new View.OnClickListener() {
            //@Override
            //public void onClick(View v) {
                //new ShapeDialog(R.drawable.diamond, R.string.txt_diamond, R.raw.diamond, new videoRaw().getVideoRaw(getPackageName(),R.raw.video)).show(getSupportFragmentManager(), ShapeDialog.TAG);
            //}
        //});
        btntriangle = findViewById(R.id.btntriangle);
        btntriangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.imgtriangle, R.string.txt_triangle, R.raw.triangle, new videoRaw().getVideoRaw(getPackageName(),R.raw.videotriangle)).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnheart = findViewById(R.id.btnheart);
        btnheart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.imgheart, R.string.txt_heart, R.raw.heart, new videoRaw().getVideoRaw(getPackageName(),R.raw.videoheart)).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnoval = findViewById(R.id.btnoval);
        btnoval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.imgoval, R.string.txt_oval, R.raw.oval, new videoRaw().getVideoRaw(getPackageName(),R.raw.videooval)).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
    }
}