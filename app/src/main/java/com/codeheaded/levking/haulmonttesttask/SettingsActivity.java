package com.codeheaded.levking.haulmonttesttask;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.Switch;

public class SettingsActivity extends AppCompatActivity {

    private static final int DEFAULT_SYN_TIME = 15;

    SharedPreferences preferences;
    SeekBar seekBar;
    Switch aSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        seekBar = findViewById(R.id.seekBar);
        aSwitch = findViewById(R.id.switch1);
        seekBar.setMax(15);

    }

    @Override
    protected void onResume(){
        super.onResume();
        preferences = getSharedPreferences(Constants.APP_PREFERENCE, Context.MODE_PRIVATE);
        if(preferences.contains(Constants.PREF_SYNC_TIME_KEY)&& preferences.contains(Constants.PREF_SORT_KEY)){
            seekBar.setProgress(preferences.getInt(Constants.PREF_SYNC_TIME_KEY,DEFAULT_SYN_TIME));
            aSwitch.setChecked(preferences.getBoolean(Constants.PREF_SORT_KEY,true));
        }
    }

    @Override
    protected void onPause(){
        super.onPause();
        preferences.edit().
                putInt(Constants.PREF_SYNC_TIME_KEY, seekBar.getProgress()).
                putBoolean(Constants.PREF_SORT_KEY, aSwitch.isChecked()).apply();
        Constants.setSortOrder(aSwitch.isChecked());
        Constants.setSyncTime(seekBar.getProgress());
    }
}
