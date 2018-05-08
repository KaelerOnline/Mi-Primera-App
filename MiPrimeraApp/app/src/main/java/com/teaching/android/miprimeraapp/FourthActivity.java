package com.teaching.android.miprimeraapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class FourthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.ic_launcher);
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String email = intent.getStringExtra("email");
        String password = intent.getStringExtra("password");
        String age = intent.getStringExtra("age");
        TextView username2 = findViewById(R.id.username2);
        TextView email2 = findViewById(R.id.email2);
        TextView password2 = findViewById(R.id.password2);
        TextView age2 = findViewById(R.id.age2);

        username2.setText(username);
        email2.setText(email);
        password2.setText(password);
        age2.setText(age);
    }
}
