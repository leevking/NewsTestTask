package com.codeheaded.levking.haulmonttesttask.offlinecache;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.codeheaded.levking.haulmonttesttask.News;

import java.util.List;

@Database(entities = {News.class} , version = 1)
public abstract class NewsDatabase extends RoomDatabase {

    public abstract NewsDAO newsDAO();

}
