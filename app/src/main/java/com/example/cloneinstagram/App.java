package com.example.cloneinstagram;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("vNLxoKA374GtQpIcvFZneg40HaE9sPHTBHGJ2Clh")
                // if defined
                .clientKey("uft8ughqj31rS8s665vA7JfhE9biG5PN8mpMall9")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    }
}
