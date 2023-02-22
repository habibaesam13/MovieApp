package com.example.movieapp;

import androidx.annotation.NonNull;

public class User {
    private static String _username;
    private static String _email;
    private static String _password;
    private static User INSTANCE;

//    public User(String username, String email, String password) {
//        this.username = username;
//        this.email = email;
//        this.password = password;
//    }


    @NonNull
    @Override
    public String toString() {
        return "User{" +
                "username='" + _username + '\'' +
                ", email='" + _email + '\'' +
                ", password='" + _password + '\'' +
                '}';
    }

    private User() {
    }

    public static void setData(String username, String email, String password) {
        _username = username;
       _email= email;
        _password = password;
    }

    public static User getInstance() {
        if (INSTANCE==null){
            INSTANCE=new User();
        }
        return INSTANCE;
    }



}
