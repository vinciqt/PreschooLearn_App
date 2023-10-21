package com.example.scan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class alphabet extends AppCompatActivity {

    private ImageButton button;
    private ImageButton btna, btnb, btnc, btnd, btne, btnf, btng, btnh, btni, btnj, btnk, btnl, btnm, btnn, btno, btnp, btnq, btnr, btns, btnt, btnu, btnv, btnw, btnx, btny, btnz;

    private ImageButton imgbtnvoiceout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet);
        button = findViewById(R.id.btnback);
        Intent svc=new Intent(this, bgService.class);
        stopService(svc); //OR stopService(svc);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(alphabet.this,CATEGORY.class);
                startActivity(intent);
            }
        });
        btna = findViewById(R.id.btna);
        btna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.lettera, R.string.txt_a, R.raw.a, new videoRaw().getVideoRaw(getPackageName(),R.raw.videoa)).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnb = findViewById(R.id.btnb);
        btnb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.letterb, R.string.txt_b, R.raw.b, new videoRaw().getVideoRaw(getPackageName(),R.raw.videob)).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnc = findViewById(R.id.btnc);
        btnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.letterc, R.string.txt_c, R.raw.c, new videoRaw().getVideoRaw(getPackageName(),R.raw.videoc)).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnd = findViewById(R.id.btnd);
        btnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.letterd, R.string.txt_d, R.raw.d, new videoRaw().getVideoRaw(getPackageName(),R.raw.videod)).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btne = findViewById(R.id.btne);
        btne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.lettere, R.string.txt_e, R.raw.e, new videoRaw().getVideoRaw(getPackageName(),R.raw.videoe)).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnf = findViewById(R.id.btnf);
        btnf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.letterf, R.string.txt_f, R.raw.f, new videoRaw().getVideoRaw(getPackageName(),R.raw.videof)).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btng = findViewById(R.id.btng);
        btng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.letterg, R.string.txt_g, R.raw.g, new videoRaw().getVideoRaw(getPackageName(),R.raw.videog)).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnh = findViewById(R.id.btnh);
        btnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.letterh, R.string.txt_h, R.raw.h, new videoRaw().getVideoRaw(getPackageName(),R.raw.videoh)).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btni = findViewById(R.id.btni);
        btni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.letteri, R.string.txt_i, R.raw.i, new videoRaw().getVideoRaw(getPackageName(),R.raw.videoi)).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnj = findViewById(R.id.btnj);
        btnj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.letterj, R.string.txt_j, R.raw.j, new videoRaw().getVideoRaw(getPackageName(),R.raw.videoj)).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnk = findViewById(R.id.btnk);
        btnk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.letterk, R.string.txt_k, R.raw.k, new videoRaw().getVideoRaw(getPackageName(),R.raw.videok)).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnl = findViewById(R.id.btnl);
        btnl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.letterl, R.string.txt_l, R.raw.l, new videoRaw().getVideoRaw(getPackageName(),R.raw.videol)).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnm = findViewById(R.id.btnm);
        btnm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.letterm, R.string.txt_m, R.raw.m, new videoRaw().getVideoRaw(getPackageName(),R.raw.videom)).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnn = findViewById(R.id.btnn);
        btnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.lettern, R.string.txt_n, R.raw.n, new videoRaw().getVideoRaw(getPackageName(),R.raw.videon)).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btno = findViewById(R.id.btno);
        btno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.lettero, R.string.txt_o, R.raw.o, new videoRaw().getVideoRaw(getPackageName(),R.raw.videoo)).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnp = findViewById(R.id.btnp);
        btnp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.letterp, R.string.txt_p, R.raw.p, new videoRaw().getVideoRaw(getPackageName(),R.raw.videop)).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnq = findViewById(R.id.btnq);
        btnq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.letterq, R.string.txt_q, R.raw.q, new videoRaw().getVideoRaw(getPackageName(),R.raw.videoq)).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnr = findViewById(R.id.btnr);
        btnr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.letterr, R.string.txt_r, R.raw.r, new videoRaw().getVideoRaw(getPackageName(),R.raw.videor)).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btns = findViewById(R.id.btns);
        btns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.letters, R.string.txt_s, R.raw.s, new videoRaw().getVideoRaw(getPackageName(),R.raw.videos)).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnt = findViewById(R.id.btnt);
        btnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.lettert, R.string.txt_t, R.raw.t, new videoRaw().getVideoRaw(getPackageName(),R.raw.videot)).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnu = findViewById(R.id.btnu);
        btnu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.letteru, R.string.txt_u, R.raw.u, new videoRaw().getVideoRaw(getPackageName(),R.raw.videou)).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnv = findViewById(R.id.btnv);
        btnv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.letterv, R.string.txt_v, R.raw.v, new videoRaw().getVideoRaw(getPackageName(),R.raw.videov)).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnw = findViewById(R.id.btnw);
        btnw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.letterw, R.string.txt_w, R.raw.w, new videoRaw().getVideoRaw(getPackageName(),R.raw.videow)).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnx = findViewById(R.id.btnx);
        btnx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.letterx, R.string.txt_x, R.raw.x, new videoRaw().getVideoRaw(getPackageName(),R.raw.videox)).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btny = findViewById(R.id.btny);
        btny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.lettery, R.string.txt_y, R.raw.y, new videoRaw().getVideoRaw(getPackageName(),R.raw.videoy)).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnz = findViewById(R.id.btnz);
        btnz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.letterz, R.string.txt_z, R.raw.z, new videoRaw().getVideoRaw(getPackageName(),R.raw.videoz)).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
    }
}