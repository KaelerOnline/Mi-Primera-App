package com.teaching.android.miprimeraapp;

import android.content.Context;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class ListActivity extends BaseActivity {
    protected void setupActionBar(){
        Toolbar toolbar = findViewById(R.id.toolbar2);
        toolbar.setLogo(R.mipmap.ic_launcher);
        setSupportActionBar(toolbar);
        toolbar.inflateMenu(R.menu.menu_list_activity);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_list_activity, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        setupActionBar();

        GridView listView = findViewById(R.id.list_view);
        listView.setAdapter(new myAdapter());

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListActivity.this, getString(R.string.selection)+ position, Toast.LENGTH_LONG).show();
            }
        });

    }


    private class myAdapter extends BaseAdapter {

        private int[] icons = {R.drawable.ic_action_doomguy_reap_face, R.drawable.ic_shortcut_doomguy_reap_face, R.mipmap.ic_launcher};
        private String[] names = {"ActionReap", "ShortReap", "Reap"};

        @Override
        public int getCount() {
            return names.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.list_item, parent, false);

            ImageView myImageView = rowView.findViewById(R.id.imageView);
            myImageView.setImageResource(icons[position]);

            TextView myTextView = rowView.findViewById(R.id.textView);
            myTextView.setText(names[position]);

            return rowView;
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int indentity = item.getItemId();
        switch (indentity){
            case R.id.doomguyReapFaceShortcut:
                Toast.makeText(this, getString(R.string.fifthActivity) ,Toast.LENGTH_LONG).show();
                Intent intent2 = new Intent(this, FifthActivity.class);
                startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }




}
