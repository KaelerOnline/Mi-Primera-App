package com.teaching.android.miprimeraapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class ListActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = findViewById(R.id.list_view);
        listView.setAdapter(new myAdapter());

    }
    private class myAdapter extends BaseAdapter{

        private int[] icons = { R.drawable.ic_action_doomguy_reap_face_57c68ecf232e3, R.drawable.ic_shortcut_doomguy_reap_face_57c68ecf232e3,R.mipmap.ic_launcher};
        private String [] names = {"ActionReap","ShortReap", "Reap"};

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
            LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.list_item,parent,false);

            ImageView myImageView = rowView.findViewById(R.id.imageView);
            myImageView.setImageResource(icons[position]);

            TextView myTextView = rowView.findViewById(R.id.textView);
            myTextView.setText(names[position]);

            return rowView;
        }
}




}
