package com.codeheaded.levking.haulmonttesttask;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        SharedPreferences preferences = getSharedPreferences(Constants.APP_PREFERENCE, Context.MODE_PRIVATE);
        Constants.setSortOrder(preferences.getBoolean(Constants.PREF_SORT_KEY, true));
        Constants.setSyncTime(preferences.getInt(Constants.PREF_SYNC_TIME_KEY, 15));
    }

    @Override
    protected void onResume(){
        super.onResume();

        final Intent intent = new Intent(StartActivity.this, MainActivity.class);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                startActivity(intent);
            }
        }, 2000);
    }
}
