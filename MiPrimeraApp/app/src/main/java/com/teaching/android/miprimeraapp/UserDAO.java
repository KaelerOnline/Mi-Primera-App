package com.teaching.android.miprimeraapp;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import java.util.List;

@Dao
public interface UserDAO {

    @Query("SELECT * FROM UserEntity")
    List<UserEntity> getAll();

    @Query("SELECT * FROM UserEntity WHERE username IS :username")
    UserEntity findUserByUsername(String username);

    @Insert
    void insert (UserEntity user);

    @Delete
    void delete (UserEntity user);
}
