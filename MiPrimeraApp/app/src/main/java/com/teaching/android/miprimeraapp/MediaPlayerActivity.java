package com.teaching.android.miprimeraapp;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import org.w3c.dom.Text;

import java.io.IOException;

public class MediaPlayerActivity extends AppCompatActivity {

    String videoURL = "https://img-9gag-fun.9cache.com/photo/aV3Z79y_460svvp9.webm";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);
        VideoView webVideo = findViewById(R.id.videoView);
        MediaController videoControl = new MediaController(this);
        videoControl.setAnchorView(webVideo);
        webVideo.setMediaController(videoControl);

        webVideo.setVideoURI(Uri.parse(videoURL));
        webVideo.start();

    }

    @Override
    protected void onStop() {
        super.onStop();
        Intent myIntent = new Intent (this, MediaPlayerService.class);
        stopService(myIntent);
    }

    public void onPlayerPlay (View view){
        Intent myIntent = new Intent (this, MediaPlayerService.class);
        myIntent.putExtra("State","play");
        startService(myIntent);
    }

    public void onPlayerPause(View view){
        Intent myIntent = new Intent (this, MediaPlayerService.class);
        myIntent.putExtra("State","pause");
        stopService(myIntent);
    }

    public void onPlayerStop (View view){
        Intent myIntent = new Intent (this, MediaPlayerService.class);
        stopService(myIntent);
    }

}
