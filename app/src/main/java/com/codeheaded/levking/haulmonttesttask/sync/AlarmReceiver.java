package com.codeheaded.levking.haulmonttesttask.sync;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.codeheaded.levking.haulmonttesttask.onlinework.DownloadNews;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        DownloadNews task = new DownloadNews();
        task.execute();
    }
}
