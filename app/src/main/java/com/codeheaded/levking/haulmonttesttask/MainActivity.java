package com.codeheaded.levking.haulmonttesttask;

import android.arch.persistence.room.Database;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.codeheaded.levking.haulmonttesttask.offlinecache.DatabasePresenter;
import com.codeheaded.levking.haulmonttesttask.offlinecache.NewsDAO;
import com.codeheaded.levking.haulmonttesttask.offlinecache.NewsDatabase;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = this.findViewById(R.id.recyclerView);
        progressBar = this.findViewById(R.id.progressBar2);

        setRecyclerViewAdapter();
    }


    private void setRecyclerViewAdapter(){
        NewsDatabase newsDatabase = DatabasePresenter.getInstance().getNewsDatabase();
        NewsDAO newsDAO = newsDatabase.newsDAO();
        List<News> newsList = newsDAO.getAll();

        //Rewrite when connection is finished
        if(!newsList.isEmpty()) {
            progressBar.setVisibility(View.INVISIBLE);
            recyclerView.setAdapter(new RecyclerViewNewsAdapter(newsDAO.getAll()));
        }
    }

}
