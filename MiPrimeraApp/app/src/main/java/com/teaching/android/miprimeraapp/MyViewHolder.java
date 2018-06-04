package com.teaching.android.miprimeraapp;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MyViewHolder extends RecyclerView.ViewHolder {
    private TextView myTextView;

    public MyViewHolder(View itemView){
        super(itemView);
        myTextView = itemView.findViewById(R.id.text_view_holder);
    }

    public void Bind (String value){
        if(value.equals("#FFFFFF")){
            myTextView.setText(value);
            myTextView.setTextColor(Color.BLACK);
            myTextView.setBackgroundColor(Color.parseColor(value));
            myTextView.setHeight(new Random().nextInt(800)+200);
        }else{
            myTextView.setText(value);
            myTextView.setBackgroundColor(Color.parseColor(value));
            myTextView.setHeight(new Random().nextInt(800)+200);
        }
    }

}
