package com.teaching.android.miprimeraapp;

import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class FifthActivity extends AppCompatActivity {


    EditText usernameEditText;
    EditText passwordEditText;
    Button login;
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

    public void submit (View view){
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if (TextUtils.isEmpty(username)){
            usernameEditText.setError(getString(R.string.username_error));
        }
        if ( TextUtils.isEmpty(password)){
            passwordEditText.setError(getString(R.string.password_error));
        }
    }

    public void register (View view){
        Intent intent = new Intent(this, ThirdActivity.class);
        intent.putExtra("username",usernameEditText.getText().toString());
        intent.putExtra("password",passwordEditText.getText().toString());
        startActivity(intent);
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
