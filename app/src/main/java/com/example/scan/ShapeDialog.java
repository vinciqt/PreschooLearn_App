package com.example.scan;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.shapes.Shape;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;


public class ShapeDialog extends DialogFragment {
    public static String TAG = "ShapeDialog";
    public int imageSrc;
    public int title;

    public int sound;

    ShapeDialog(int _imgSrc, int _title, int _sound){
        this.imageSrc = _imgSrc;
        this.title = _title;
        this.sound = _sound;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_shape_layout, container, false);
        ImageButton imageButton = view.findViewById(R.id.btnShapeDialog);
        TextView shapeTitle = view.findViewById(R.id.textShapeDialog);
        imageButton.setImageResource(this.imageSrc);
        shapeTitle.setText(this.title);

        final MediaPlayer mp = MediaPlayer.create(getContext(),this.sound);

        ImageButton imgbtnvoiceout = view.findViewById(R.id.imgbtnvoiceout);
        imgbtnvoiceout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
            }
        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
            }
        });

        return view;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

       Dialog dialog = super.onCreateDialog(savedInstanceState);
       dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
       return dialog;
    }
}
