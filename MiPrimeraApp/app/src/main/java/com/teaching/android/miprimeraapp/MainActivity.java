package com.teaching.android.miprimeraapp;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.support.v7.app.ActionBar;
import static android.content.Intent.ACTION_DIAL;
import static android.content.Intent.ACTION_VIEW;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.ic_launcher);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity","MARCO: onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity","MARCO: onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity","MARCO: onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity","MARCO: onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MainActivity","MARCO: onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity","MARCO: onDestroy");
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("id","Android Roolz");
        startActivity(intent);
    }

    public void linkURL(View view){
        String url = "https://www.google.com";
        Intent intent = new Intent(ACTION_VIEW, Uri.parse(url));
        Log.d("MainActivity","MARCO: URL");
        startActivity(intent);
    }

    public void numero(View view){
        Intent intent = new Intent(ACTION_DIAL, Uri.parse("tel: 1234"));
        Log.d("MainActivity","MARCO: tel: 1234");
        startActivity(intent);
    }

    public void tercero (View view){
        Intent intent = new Intent(this,ThirdActivity.class);
        startActivity(intent);
    }

    public void quinto (View view){
        Intent intent = new Intent(this, FifthActivity.class);
        startActivity(intent);
    }

    public void gallery (View view){
        Intent intent = new Intent(this, GalleryActivity.class);
        startActivity(intent);
    }

    public void list (View view){
        Intent intent = new Intent(this,ListActivity.class);
        startActivity(intent);
    }

}
