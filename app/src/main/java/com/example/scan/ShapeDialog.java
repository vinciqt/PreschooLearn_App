package com.example.scan;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.PixelFormat;
import android.graphics.drawable.shapes.Shape;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.bumptech.glide.Glide;


public class ShapeDialog extends DialogFragment {
    public static String TAG = "ShapeDialog";
    public int imageSrc;
    public int title;

    public int sound;
    public String videoRaw;

    ShapeDialog(int _imgSrc, int _title, int _sound, String _videoRaw){
        this.imageSrc = _imgSrc;
        this.title = _title;
        this.sound = _sound;
        this.videoRaw = _videoRaw;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_shape_layout, container, false);
        ImageButton imageButton = view.findViewById(R.id.btnShapeDialog);
        TextView shapeTitle = view.findViewById(R.id.textShapeDialog);
        //imageButton.setImageResource(this.imageSrc);
        Glide.with(this.getContext()).load(this.imageSrc).into(imageButton);
        shapeTitle.setText(this.title);

        VideoView videoView = view.findViewById(R.id.shapeDialogVideo);
        String videoPath = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(this.videoRaw);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(getContext());
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        videoView.start();
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });

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
