package com.example.my_proyect;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class info_Act extends AppCompatActivity {

    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_);

        videoView = (VideoView)findViewById(R.id.vd); //LLAMO AL ELEMENTO

        String ruta = "android.resource://"+ getPackageName()+ "/"+R.raw.video; //obtener la ruta del video a visualizar
        Uri uri = Uri.parse(ruta);
        videoView.setVideoURI(uri);

         //controles de video
        MediaController media = new MediaController(this);
        videoView.setMediaController(media);
    }
}