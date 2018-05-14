package com.codeheaded.levking.haulmonttesttask.onlinework;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Connection {

    public static boolean isNetworkAccesable(Context context) {
        ConnectivityManager connMngr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo i = connMngr.getActiveNetworkInfo();
        return i != null && i.isConnected() && i.isAvailable();
    }

    public static String executeGet(String tUrl, String parmsURL){

        URL url;
        HttpURLConnection connection = null;
        try{
            url = new URL(tUrl);
            connection = (HttpURLConnection)url.openConnection();
            connection.setRequestProperty("content-type", "application/json; charset=utf-8");
            connection.setRequestProperty("Content-Language", "ru-RUS");
            connection.setUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(false);

            InputStream is;

            int status = connection.getResponseCode();

            if (status != HttpURLConnection.HTTP_OK)
                is = connection.getErrorStream();
            else
                is = connection.getInputStream();



            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuffer response = new StringBuffer();
            while((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            return response.toString();

        }catch (IOException e) {

            e.printStackTrace();
            return null;
        } finally {
            if(connection !=null)connection.disconnect();
        }
    }
}
