package com.teaching.android.miprimeraapp.presenters;
import com.teaching.android.miprimeraapp.interactors.GamesInteractor;
import com.teaching.android.miprimeraapp.model.GameModel;
import com.teaching.android.miprimeraapp.view.GameDetailView;

import java.util.ArrayList;

public class GameDetailPresenter {

    private GamesInteractor interactor;
    private GameDetailView view;

    public void startPresenting(GameDetailView view){
        this.view = view;
        interactor = new GamesInteractor();
    }

    public void loadGameWithId(int id){
        GameModel game =  interactor.getGamesWithId(id);
        view.onGameLoaded(game);
    }

    public ArrayList<GameModel> getGames (){
        return interactor.getGames();
    }


}
