package com.codeheaded.levking.haulmonttesttask;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class News {

    @PrimaryKey
    @NonNull
    private String title;
    private String details;
    private String date;
    private String imageURL;
    private String URL;

    public News(String title, String details, String date, String imageURL, String URL){
        this.title = title;
        this.details = details;
        this.date = date;
        this.imageURL = imageURL;
        this.URL = URL;
    }

//    public News(){
//        this.title = "New Title";
//        this.details = "Some Details";
//        this.date = "Today";
//        this.imageURL = "";
//        this.URL = "";
//    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getDetails(){
        return details;
    }

    public void setDetails(String details){
        this.details=details;
    }

    public String getDate(){
        return  date;
    }

    public void setDate(String date){
        this.date = date;
    }

    public String getImageURL(){
        return imageURL;
    }

    public void setImageURL(String imageURL){
        this.imageURL = imageURL;
    }

    public String getURL(){
        return URL;
    }

    public void setURL(String URL){
        this.URL = URL;
    }
}
