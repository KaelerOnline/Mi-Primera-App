package com.teaching.android.miprimeraapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ThirdActivity extends MainActivity {



    Button sendButton;
    EditText usernameEditText;
    EditText emailEditText;
    EditText passwordEditText;
    EditText ageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        setupActionBar();
        ActionBar ab = getSupportActionBar();
        assert ab != null;
        ab.setDisplayHomeAsUpEnabled(true);
        sendButton = findViewById(R.id.button6);
        usernameEditText = findViewById(R.id.username);
        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        ageEditText = findViewById(R.id.age);
        if (intent.hasExtra("username")&& intent.hasExtra("password")){
            usernameEditText.setText(intent.getStringExtra("username"));
            passwordEditText.setText(intent.getStringExtra("password"));
        }
    }

    public void unf (View view){
        Vibrator v = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        if (v != null) {
            v.vibrate(250);
            usernameEditText.setText("");
            emailEditText.setText("");
            passwordEditText.setText("");
            ageEditText.setText("");
        }
    }

    public void introducir (View view){
        Intent intent = new Intent(this, FourthActivity.class);
        intent.putExtra("username",usernameEditText.getText().toString());
        intent.putExtra("email",emailEditText.getText().toString());
        intent.putExtra("password",passwordEditText.getText().toString());
        intent.putExtra("age",ageEditText.getText().toString());
        startActivity(intent);
    }
}
