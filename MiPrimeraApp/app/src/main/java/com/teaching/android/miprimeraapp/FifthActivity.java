package com.teaching.android.miprimeraapp;

import android.os.Vibrator;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class FifthActivity extends AppCompatActivity {


    EditText usernameEditText;
    EditText passwordEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.ic_launcher);
        usernameEditText = findViewById(R.id.useredittext);
        passwordEditText = findViewById(R.id.passedittext);
    }

    public void cancel (View view){
        Vibrator v = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        if (v != null) {
            v.vibrate(250);
            usernameEditText.setText("");
            passwordEditText.setText("");
        }
    }
}
