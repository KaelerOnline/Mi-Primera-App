package com.teaching.android.miprimeraapp;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class UserEntity {

    @PrimaryKey
    @NonNull
    @ColumnInfo (name = "username")
    private String username;

    @ColumnInfo (name = "email")
    private String email;

    @ColumnInfo (name = "age")
    private String age;

    @ColumnInfo (name = "password")
    private String password;

    @NonNull
    public String getUsername() {
        return username;
    }

    public void setUsername(@NonNull String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
