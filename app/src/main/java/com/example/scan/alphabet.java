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
                new ShapeDialog(R.drawable.a, R.string.txt_a, R.raw.a).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnb = findViewById(R.id.btnb);
        btnb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.b, R.string.txt_b, R.raw.b).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnc = findViewById(R.id.btnc);
        btnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.c, R.string.txt_c, R.raw.c).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnd = findViewById(R.id.btnd);
        btnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.d, R.string.txt_d, R.raw.d).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btne = findViewById(R.id.btne);
        btne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.e, R.string.txt_e, R.raw.e).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnf = findViewById(R.id.btnf);
        btnf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.f, R.string.txt_f, R.raw.f).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btng = findViewById(R.id.btng);
        btng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.g, R.string.txt_g, R.raw.g).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnh = findViewById(R.id.btnh);
        btnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.h, R.string.txt_h, R.raw.h).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btni = findViewById(R.id.btni);
        btni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.i, R.string.txt_i, R.raw.i).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnj = findViewById(R.id.btnj);
        btnj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.j, R.string.txt_j, R.raw.j).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnk = findViewById(R.id.btnk);
        btnk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.k, R.string.txt_k, R.raw.k).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnl = findViewById(R.id.btnl);
        btnl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.l, R.string.txt_l, R.raw.l).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnm = findViewById(R.id.btnm);
        btnm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.m, R.string.txt_m, R.raw.m).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnn = findViewById(R.id.btnn);
        btnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.n, R.string.txt_n, R.raw.n).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btno = findViewById(R.id.btno);
        btno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.o, R.string.txt_o, R.raw.o).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnp = findViewById(R.id.btnp);
        btnp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.p, R.string.txt_p, R.raw.p).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnq = findViewById(R.id.btnq);
        btnq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.q, R.string.txt_q, R.raw.q).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnr = findViewById(R.id.btnr);
        btnr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.r, R.string.txt_r, R.raw.r).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btns = findViewById(R.id.btns);
        btns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.s, R.string.txt_s, R.raw.s).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnt = findViewById(R.id.btnt);
        btnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.t, R.string.txt_t, R.raw.t).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnu = findViewById(R.id.btnu);
        btnu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.u, R.string.txt_u, R.raw.u).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnv = findViewById(R.id.btnv);
        btnv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.v, R.string.txt_v, R.raw.v).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnw = findViewById(R.id.btnw);
        btnw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.w, R.string.txt_w, R.raw.w).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnx = findViewById(R.id.btnx);
        btnx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.x, R.string.txt_x, R.raw.x).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btny = findViewById(R.id.btny);
        btny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.y, R.string.txt_y, R.raw.y).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
        btnz = findViewById(R.id.btnz);
        btnz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShapeDialog(R.drawable.z, R.string.txt_z, R.raw.z).show(getSupportFragmentManager(), ShapeDialog.TAG);
            }
        });
    }
}