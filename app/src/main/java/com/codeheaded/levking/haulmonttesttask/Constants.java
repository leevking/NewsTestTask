package com.codeheaded.levking.haulmonttesttask;

public class Constants {
    public static final String APP_PREFERENCE = "preferences";
    public static final String PREF_SYNC_TIME_KEY = "sync_time";
    public static final String PREF_SORT_KEY = "sort_order";
    public static final String API_KEY = "cec3543f3e2646208b26958b2feee4ad";
    public static final String NEWS_RESOURCE = "rt";
    public static final String KEY_AUTHOR = "author";
    public static final String KEY_TITLE = "title";
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_URL = "url";
    public static final String KEY_URLTOIMAGE = "urlToImage";
    public static final String KEY_PUBLISHEDAT = "publishedAt";
    public static final String NEWS_REQUEST_TEMPLATE ="https://newsapi.org/v2/everything?sources="+NEWS_RESOURCE+"&sortBy=top&apiKey="+API_KEY;

    public static int syncTime;
    public static boolean sortOrder;

    public static int getSynTime(){
        return syncTime;
    }

    public static boolean getSortOrder(){
        return sortOrder;
    }

    public static void setSyncTime(int newSyncTime){
        syncTime = (newSyncTime+15)*60;
    }

    public static void setSortOrder(boolean newSortOrder){
        sortOrder = newSortOrder;
    }

}
