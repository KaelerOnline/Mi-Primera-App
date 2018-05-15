package com.teaching.android.miprimeraapp.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.teaching.android.miprimeraapp.R;
import com.teaching.android.miprimeraapp.WebViewActivity;
import com.teaching.android.miprimeraapp.interactors.GamesInteractor;
import com.teaching.android.miprimeraapp.model.GameModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class GameDetailFragment extends Fragment {


    public GameDetailFragment() {
        // Required empty public constructor
    }

    public static GameDetailFragment newInstance (int gameId){

        GameDetailFragment fragment = new GameDetailFragment();
        Bundle bundle = new Bundle();

        bundle.putInt("game_Id",gameId);
        fragment.setArguments(bundle);

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentView = inflater.inflate(R.layout.fragment_game_detail, container, false);

        int gameId = getArguments().getInt("game_Id",0);
        final GameModel game = new GamesInteractor().getGamesWithId(gameId);

        ImageView icono = fragmentView.findViewById(R.id.Logo);
        RelativeLayout background = fragmentView.findViewById(R.id.game_container);
        TextView gamedesc = fragmentView.findViewById(R.id.Description);

        icono.setImageResource(game.getIconDrawable());
        background.setBackgroundResource(game.getBackgroundDrawable());
        gamedesc.setText(game.getDescription());

        Button boton = fragmentView.findViewById(R.id.urlButton);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent webintent = new Intent(getContext(),WebViewActivity.class);
                    webintent.putExtra("url",getString(game.getOfficialWebsiteUrl()));
                    startActivity(webintent);
            }
        });

        return fragmentView;


    }





}
