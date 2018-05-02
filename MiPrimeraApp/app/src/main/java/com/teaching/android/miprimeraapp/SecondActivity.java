package com.teaching.android.miprimeraapp;

import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        super.onCreate(savedInstanceState);
        String valor = intent.getStringExtra("id");
        setContentView(R.layout.activity_second);
        Log.d("SecondActivity:", valor);
        Vibrator v = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        if (v != null) {
            v.vibrate(2500);
        }
    }
}
