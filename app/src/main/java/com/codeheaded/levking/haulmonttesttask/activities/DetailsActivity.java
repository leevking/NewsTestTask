package com.codeheaded.levking.haulmonttesttask.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.codeheaded.levking.haulmonttesttask.onlinework.Connection;
import com.codeheaded.levking.haulmonttesttask.R;

public class DetailsActivity extends AppCompatActivity {

    WebView webView;
    ProgressBar loader;
    String url = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        loader = findViewById(R.id.progressBar3);
        webView = findViewById(R.id.webView);


    }

    @Override
    protected void onResume(){
        super.onResume();
        setWebViewSettings(webView);
        webView.loadUrl(url);
        webView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                if (progress == 100) {
                    loader.setVisibility(View.GONE);
                } else {
                    loader.setVisibility(View.VISIBLE);
                }
            }
        });

    }

    private void setWebViewSettings(WebView webView){
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.getSettings().setAppCachePath( getApplicationContext().getCacheDir().getAbsolutePath() );
        webView.getSettings().setAllowFileAccess( true );
        webView.getSettings().setAppCacheEnabled( true );
        webView.getSettings().setJavaScriptEnabled( true );
        if(!Connection.isNetworkAccesable(getApplicationContext()))webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ONLY);
        else webView.getSettings().setCacheMode( WebSettings.LOAD_DEFAULT );
    }
}
