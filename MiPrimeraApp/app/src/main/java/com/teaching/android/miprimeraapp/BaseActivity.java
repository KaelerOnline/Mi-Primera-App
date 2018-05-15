package com.teaching.android.miprimeraapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_activity, menu);
        return true;
    }

    protected void setupActionBar(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);
        setSupportActionBar(toolbar);
        toolbar.inflateMenu(R.menu.menu_main_activity);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int indentity = item.getItemId();
        switch (indentity){
            case R.id.doomguyReapFaceAction:
                Toast.makeText(this, getString(R.string.fourthActivity) ,Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, FourthActivity.class);
                startActivity(intent);
                break;

            case R.id.doomguyReapFaceShortcut:
                Toast.makeText(this, getString(R.string.fifthActivity) ,Toast.LENGTH_LONG).show();
                Intent intent2 = new Intent(this, FifthActivity.class);
                startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
