package com.codeheaded.levking.haulmonttesttask.offlinecache;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.codeheaded.levking.haulmonttesttask.News;

import java.util.List;

@Dao
public interface NewsDAO {

    @Query("SELECT * FROM news")
    List<News> getAll();

    @Query("SELECT * FROM news WHERE title = :title")
    News getByTitle(String title);

    @Insert
    void insert(News news);

    @Update
    void update(News news);

    @Delete
    void delete(News news);

}
