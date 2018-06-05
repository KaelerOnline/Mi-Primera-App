package com.teaching.android.miprimeraapp;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;

import java.io.IOException;

public class MediaPlayerService extends Service {

    private MediaPlayer myMediaPlayer;
    String url = "https://firebasestorage.googleapis.com/v0/b/miprimeraapp-db818.appspot.com/o/crowd-cheering.mp3?alt=media&token=1e1a8341-f108-460c-b3a7-8f19097040e3";
    private boolean isPrepared = false;

    public MediaPlayerService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        try {
            myMediaPlayer = new MediaPlayer();
            myMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            myMediaPlayer.setDataSource(url);
            myMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp){
                    isPrepared = true;
                }
            });
            myMediaPlayer.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String state = intent.getStringExtra("State");
        if(state.equals("play")){
            onPlayerPlay();
        }else if(state.equals("pause")){
            onPlayerPause();
        }
        myMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopSelf();
            }
        });

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        myMediaPlayer.release();
        myMediaPlayer = null;
    }

    public void onPlayerPlay(){
        if(isPrepared){
            myMediaPlayer.start();
        }
    }

    public void onPlayerPause(){
        myMediaPlayer.pause();
    }


}
