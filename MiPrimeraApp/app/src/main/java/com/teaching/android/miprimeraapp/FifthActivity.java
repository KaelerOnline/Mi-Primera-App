package com.teaching.android.miprimeraapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.File;

public class FifthActivity extends BaseActivity {

    protected void setupActionBar() {
        Toolbar toolbar = findViewById(R.id.toolbar3);
        toolbar.setLogo(R.mipmap.ic_launcher);
        setSupportActionBar(toolbar);
        toolbar.inflateMenu(R.menu.menu_go_back);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_go_back, menu);
        return true;
    }

    EditText usernameEditText;
    EditText passwordEditText;
    Button login;
    ImageButton mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        setupActionBar();
        ActionBar ab = getSupportActionBar();
        assert ab != null;
        ab.setDisplayHomeAsUpEnabled(true);
        usernameEditText = findViewById(R.id.useredittext);
        passwordEditText = findViewById(R.id.passedittext);
        mImageView = findViewById(R.id.ProfileView);
    }

    public void submit(View view) {
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if (TextUtils.isEmpty(username)) {
            usernameEditText.setError(getString(R.string.username_error));
        } else if (TextUtils.isEmpty(password)) {
            passwordEditText.setError(getString(R.string.password_error));
        } else {
            SharedPreferences sharedPref = getSharedPreferences(getString(R.string.login_activity_file), Context.MODE_PRIVATE);
            SharedPreferences.Editor prefEdit = sharedPref.edit();
            prefEdit.putString("username", usernameEditText.getText().toString());
            prefEdit.apply();
            Intent profileIntent = new Intent(this, FourthActivity.class);
            profileIntent.putExtra("username", usernameEditText.getText().toString());
            profileIntent.putExtra("password", passwordEditText.getText().toString());
            profileIntent.putExtra("age", "");
            profileIntent.putExtra("email", "");
            startActivity(profileIntent);
        }
    }

    public void register(View view) {
        Intent intent = new Intent(this, ThirdActivity.class);
        intent.putExtra("username", usernameEditText.getText().toString());
        intent.putExtra("password", passwordEditText.getText().toString());
        startActivity(intent);
    }

    public void cancel(View view) {
        Vibrator v = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        if (v != null) {
            v.vibrate(250);
            usernameEditText.setText("");
            passwordEditText.setText("");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.login_activity_file), Context.MODE_PRIVATE);
        String value = sharedPref.getString("username", null);
        if (value != null) {
            usernameEditText.setText(value);
        }
        File myFile = createImageFile();
        if (myFile.exists()) {
            mImageView = findViewById(R.id.ProfileView);
            mImageView.setImageURI(Uri.fromFile(myFile));
        } else {
            mImageView.setImageResource(R.mipmap.ic_launcher_round);
        }

    }

    public void cameraIntent(View View) {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (cameraIntent.resolveActivity(getPackageManager()) != null) {
            File photoFile = createImageFile();
            Uri photoURI = FileProvider.getUriForFile(this, "com.teaching.android.miprimeraapp", photoFile);
            cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
            /*if (isExternalStorageWriteable()){
                File photo = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), "profile.jpg");
            }*/
            startActivityForResult(cameraIntent, 100);
        }
    }

    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100 && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            mImageView.setImageBitmap(imageBitmap);
        }
    }*/

    private File createImageFile() {
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        return new File(storageDir, "profile.jpg");
    }

}
