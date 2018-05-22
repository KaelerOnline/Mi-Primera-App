package com.teaching.android.miprimeraapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.widget.ImageViewCompat;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;


public class FourthActivity extends BaseActivity {

    protected void setupActionBar(){
        Toolbar toolbar = findViewById(R.id.toolbar4);
        toolbar.setLogo(R.mipmap.ic_launcher);
        setSupportActionBar(toolbar);
        toolbar.inflateMenu(R.menu.menu_save_profile);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_save_profile, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        setupActionBar();
        ActionBar ab = getSupportActionBar();
        assert ab != null;
        ab.setDisplayHomeAsUpEnabled(true);

        ImageView myImage = findViewById(R.id.imageExt);
        if(isExternalStorageReadable()){
            if(isExternalStorageWritable()){
                File imageFile = new File(getExternalFilesDir(null),"web_hi_res_512.png");
                if (imageFile.exists()){
                    myImage.setImageURI(Uri.fromFile(imageFile));
                }else {
                    myImage.setImageURI(null);
                }
            }else{
                myImage.setImageURI(null);
            }
        }else{
            myImage.setImageURI(null);
        }

        /*Intent intent = getIntent();
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
        age2.setText(age);*/
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int indentity = item.getItemId();
        switch (indentity){
            case R.id.doomguyReapFaceAction2:
                Toast.makeText(this, getString(R.string.thirdActivity) ,Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, ThirdActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.login_activity_file), Context.MODE_PRIVATE);
        String username = sharedPref.getString("username",null);
        String age = sharedPref.getString("age",null);
        String email = sharedPref.getString("email",null);

        TextView username2 = findViewById(R.id.username2);
        TextView email2 = findViewById(R.id.email2);
        TextView age2 = findViewById(R.id.age2);

        username2.setText(username);
        email2.setText(email);
        age2.setText(age);
    }

    @Override
    protected void onStop() {
        super.onStop();
        TextView username = findViewById(R.id.username2);
        TextView email = findViewById(R.id.email2);
        TextView age = findViewById(R.id.age2);

        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.login_activity_file), Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEdit = sharedPref.edit();
        prefEdit.putString("username",username.getText().toString());
        prefEdit.putString("email",email.getText().toString());
        prefEdit.putString("age",age.getText().toString());
        prefEdit.apply();
    }

    public boolean isExternalStorageReadable (){
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)||Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

}
