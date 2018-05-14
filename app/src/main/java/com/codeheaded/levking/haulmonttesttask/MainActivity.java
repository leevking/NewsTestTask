package com.codeheaded.levking.haulmonttesttask;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.arch.persistence.room.Database;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.codeheaded.levking.haulmonttesttask.offlinecache.DatabasePresenter;
import com.codeheaded.levking.haulmonttesttask.offlinecache.NewsDAO;
import com.codeheaded.levking.haulmonttesttask.offlinecache.NewsDatabase;
import com.codeheaded.levking.haulmonttesttask.sync.AlarmReceiver;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressBar progressBar;
    SwipeRefreshLayout refreshLayout;
    FloatingActionButton button;
    private PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        refreshLayout = this.findViewById(R.id.swipeRefreshLayout);
        recyclerView = this.findViewById(R.id.recyclerView);
        progressBar = this.findViewById(R.id.progressBar2);
        button = this.findViewById(R.id.floatingActionButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                DownloadNews task = new DownloadNews();
                if(Connection.isNetworkAccesable(getApplicationContext())){
                    task.execute();
                    recyclerView.getAdapter().notifyDataSetChanged();

                }
                refreshLayout.setRefreshing(false);

            }
        });


    }

    @Override
    protected void onResume(){
        super.onResume();
        setRecyclerViewAdapter();
        Intent alarmIntent = new Intent(MainActivity.this, AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, alarmIntent, 0);

        AlarmScheduler alarm = new AlarmScheduler();
        alarm.cancel();
        alarm.start();
    }

    @Override
    protected void onPause(){
        super.onPause();

    }


    private void setRecyclerViewAdapter(){
        DownloadNews task = new DownloadNews();
        NewsDatabase newsDatabase = DatabasePresenter.getInstance().getNewsDatabase();
        NewsDAO newsDAO = newsDatabase.newsDAO();
        if(Connection.isNetworkAccesable(getApplicationContext()))task.execute();
        recyclerView.setAdapter(new RecyclerViewNewsAdapter(this,newsDAO.getAll()));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        progressBar.setVisibility(View.INVISIBLE);
    }

    private class AlarmScheduler{
        public void start(){
            AlarmManager manager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
            manager.setInexactRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), Constants.getSynTime(),  pendingIntent);
        }

        public void cancel(){
            AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            manager.cancel(pendingIntent);
        }
    }

}
