package com.teaching.android.miprimeraapp.interactors;


import com.teaching.android.miprimeraapp.R;
import com.teaching.android.miprimeraapp.model.GameModel;

import java.util.ArrayList;

public class GamesInteractor {

    private ArrayList<GameModel> games;

    public GamesInteractor(){
        if (games == null){
            GameModel doom = new GameModel(0,R.string.doomtitle, R.string.Doom, R.string.doomURL, R.drawable.doom_logo, R.drawable.doombg);
            GameModel blood = new GameModel(1,R.string.bloodtitle,R.string.Blood, R.string.bloodURL, R.drawable.msdos_blood,R.drawable.caleb);
            GameModel blake= new GameModel(2,R.string.blaketitle,R.string.BlakeStone,R.string.blakeURL, R.drawable.blakelogo,R.drawable.blake_800x564);
            games = new ArrayList<>();
            games.add(doom);
            games.add(blood);
            games.add(blake);
        }
    }

    public ArrayList<GameModel> getGames() {
        return games;
    }

    public GameModel getGamesWithId (int id){
        for (GameModel game:games){
            if(game.getId()==id){
                return game;
            }
        }
        return null;
    }

}
