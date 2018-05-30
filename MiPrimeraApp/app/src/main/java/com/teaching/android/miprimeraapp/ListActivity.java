package com.teaching.android.miprimeraapp;

import android.content.Context;

import android.content.Intent;
import android.os.Bundle;
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

import com.teaching.android.miprimeraapp.interactors.GamesFirebseInteractor;


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

    private GridView listView;
    private GamesFirebseInteractor gamesFirebseInteractor;
    private myAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        setupActionBar();

        listView = findViewById(R.id.list_view);
        gamesFirebseInteractor = new GamesFirebseInteractor();
        gamesFirebseInteractor.getGames(new GamesInteractorCallback() {
            @Override
            public void onGamesAvailable() {
                findViewById(R.id.loading_indicator).setVisibility(View.GONE);
                myAdapter = new myAdapter();
                listView.setAdapter(myAdapter);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent (ListActivity.this, GameDetailActivity.class);
                intent.putExtra("position",position);
                startActivity(intent);
            }
        });

    }


    private class myAdapter extends BaseAdapter {

        private int[] icons = {R.mipmap.ic_doom, R.mipmap.ic_blood,R.mipmap.ic_blake};
        private String[] names = {"Doom", "Blood","Blake Stone"};

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
        return super.onOptionsItemSelected(item);
    }




}
