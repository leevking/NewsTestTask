package com.codeheaded.levking.haulmonttesttask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    @Override
    protected void onResume(){
        super.onResume();
        Intent intent = new Intent(StartActivity.this, MainActivity.class);
        try {
            wait(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        startActivity(intent);
    }
}
