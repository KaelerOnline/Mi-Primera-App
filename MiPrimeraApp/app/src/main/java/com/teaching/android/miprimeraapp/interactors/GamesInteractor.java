package com.teaching.android.miprimeraapp.interactors;


import com.teaching.android.miprimeraapp.R;
import com.teaching.android.miprimeraapp.model.GameModel;

import java.util.ArrayList;

public class GamesInteractor {

    private ArrayList<GameModel> games;

    public GamesInteractor(){
        if (games == null){
            GameModel doom = new GameModel(0,"", "", "", "", "");
            GameModel blood = new GameModel(1,"","","", "","");
            GameModel blake= new GameModel(2,"","","", "","");
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
