package com.codeheaded.levking.haulmonttesttask.onlinework;

import android.os.AsyncTask;

import com.codeheaded.levking.haulmonttesttask.Constants;
import com.codeheaded.levking.haulmonttesttask.News;
import com.codeheaded.levking.haulmonttesttask.offlinecache.DatabasePresenter;
import com.codeheaded.levking.haulmonttesttask.offlinecache.NewsDAO;
import com.codeheaded.levking.haulmonttesttask.offlinecache.NewsDatabase;
import com.codeheaded.levking.haulmonttesttask.onlinework.Connection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class DownloadNews extends AsyncTask<String, Void, String> {

    List<News> newsList;

    @Override
    protected void onPreExecute(){
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String xml){
        if(xml.length()>10) {
            try {
                JSONObject jsonResponse = new JSONObject(xml);
                JSONArray jsonArray = jsonResponse.getJSONArray("articles");
                NewsDatabase newsDatabase = DatabasePresenter.getInstance().getNewsDatabase();
                NewsDAO newsDAO = newsDatabase.newsDAO();

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    newsDAO.delete(new News(
                            jsonObject.optString(Constants.KEY_TITLE).toString(),
                            jsonObject.optString(Constants.KEY_DESCRIPTION).toString(),
                            jsonObject.optString(Constants.KEY_PUBLISHEDAT).toString(),
                            jsonObject.optString(Constants.KEY_URLTOIMAGE).toString(),
                            jsonObject.optString(Constants.KEY_URL).toString()
                    ));
                    newsDAO.insert(new News(
                            jsonObject.optString(Constants.KEY_TITLE).toString(),
                            jsonObject.optString(Constants.KEY_DESCRIPTION).toString(),
                            jsonObject.optString(Constants.KEY_PUBLISHEDAT).toString(),
                            jsonObject.optString(Constants.KEY_URLTOIMAGE).toString(),
                            jsonObject.optString(Constants.KEY_URL).toString()
                    ));
                }


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected String doInBackground(String... strings) {
        return Connection.executeGet(Constants.NEWS_REQUEST_TEMPLATE,"");
    }


}
