package com.teaching.android.miprimeraapp.interactors;


import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.teaching.android.miprimeraapp.GamesInteractorCallback;
import com.teaching.android.miprimeraapp.model.GameModel;

import java.util.ArrayList;

public class GamesFirebseInteractor {

    private ArrayList<GameModel> games = new ArrayList<>();

    public GamesFirebseInteractor() {
    }

    public void getGames(final GamesInteractorCallback callback){
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myReference = firebaseDatabase.getReference("games");
        myReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot gameNode : dataSnapshot.getChildren()){
                    GameModel model = gameNode.getValue(GameModel.class);
                    games.add(model);
                    Log.d("gameNode FirebaseInter ", "Game: "+ model.getName());
                }
                callback.onGamesAvailable();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


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
