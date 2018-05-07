package com.codeheaded.levking.haulmonttesttask.offlinecache;

import android.app.Application;
import android.arch.persistence.room.Room;

public class DatabasePresenter extends Application {

    public static DatabasePresenter instance;

    private NewsDatabase newsDatabase;

    @Override
    public void onCreate(){
        super.onCreate();
        instance = this;

        //I dont want to add LiveData or RxJava to this app
        newsDatabase = Room.databaseBuilder(this, NewsDatabase.class, "newsDatabase").allowMainThreadQueries().build();
    }

    public static DatabasePresenter getInstance() {
        return instance;
    }

    public NewsDatabase getNewsDatabase() {
        return newsDatabase;
    }
}
