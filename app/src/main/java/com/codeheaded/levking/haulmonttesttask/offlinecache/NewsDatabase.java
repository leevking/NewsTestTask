package com.codeheaded.levking.haulmonttesttask.offlinecache;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.codeheaded.levking.haulmonttesttask.News;



@Database(entities = {News.class} , version = 1, exportSchema = false)
public abstract class NewsDatabase extends RoomDatabase {

    public abstract NewsDAO newsDAO();

}
