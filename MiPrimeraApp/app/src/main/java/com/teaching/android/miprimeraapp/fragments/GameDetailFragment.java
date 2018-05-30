package com.teaching.android.miprimeraapp.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.teaching.android.miprimeraapp.GamesInteractorCallback;
import com.teaching.android.miprimeraapp.R;
import com.teaching.android.miprimeraapp.WebViewActivity;
import com.teaching.android.miprimeraapp.interactors.GamesFirebseInteractor;
import com.teaching.android.miprimeraapp.interactors.GamesInteractor;
import com.teaching.android.miprimeraapp.model.GameModel;
import com.bumptech.glide.Glide;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class GameDetailFragment extends Fragment {

    private GamesFirebseInteractor gamesFirebseInteractor;


    public GameDetailFragment()
    {
        // Required empty public constructor
    }

    public static GameDetailFragment newInstance (int gameId)
    {
        GameDetailFragment fragment = new GameDetailFragment();
        Bundle bundle = new Bundle();

        bundle.putInt("game_Id",gameId);
        fragment.setArguments(bundle);

        return fragment;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        final View fragmentView = inflater.inflate(R.layout.fragment_game_detail, container, false);

        final int gameId = Objects.requireNonNull(getArguments()).getInt("game_Id",0);

        gamesFirebseInteractor = new GamesFirebseInteractor();
        gamesFirebseInteractor.getGames(new GamesInteractorCallback()
        {
            @Override
            public void onGamesAvailable()
            {
                final GameModel game = gamesFirebseInteractor.getGamesWithId(gameId);

                ImageView icono = fragmentView.findViewById(R.id.Logo);
                Glide.with(fragmentView).load(game.getIcon()).into(icono);

                ImageView background = fragmentView.findViewById(R.id.game_container);
                Glide.with(fragmentView).load(game.getBackground()).into(background);

                TextView gamedesc = fragmentView.findViewById(R.id.Description);
                gamedesc.setText(game.getDescription());

                Button boton = fragmentView.findViewById(R.id.urlButton);
                boton.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        Intent webintent = new Intent(getContext(),WebViewActivity.class);
                        webintent.putExtra("url",game.getOfficialWebsiteUrl());
                        startActivity(webintent);
                    }
                });

            }
        });

        return fragmentView;

    }





}
