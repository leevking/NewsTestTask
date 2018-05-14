package com.codeheaded.levking.haulmonttesttask;

public class Constants {
    static final String APP_PREFERENCE = "preferences";
    static final String PREF_SYNC_TIME_KEY = "sync_time";
    static final String PREF_SORT_KEY = "sort_order";
    static final String API_KEY = "cec3543f3e2646208b26958b2feee4ad";
    static final String NEWS_RESOURCE = "rt";
    static final String KEY_AUTHOR = "author";
    static final String KEY_TITLE = "title";
    static final String KEY_DESCRIPTION = "description";
    static final String KEY_URL = "url";
    static final String KEY_URLTOIMAGE = "urlToImage";
    static final String KEY_PUBLISHEDAT = "publishedAt";
    static final String NEWS_REQUEST_TEMPLATE ="https://newsapi.org/v2/everything?sources="+NEWS_RESOURCE+"&sortBy=top&apiKey="+API_KEY;

    static int syncTime;
    static boolean sortOrder;

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
