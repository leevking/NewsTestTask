package com.codeheaded.levking.haulmonttesttask;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class News {

    @PrimaryKey
    private String title;
    private String details;
    private String date;
    private String imageURL;

    public News(String title, String details, String date, String imageURL){
        this.title = title;
        this.details = details;
        this.date = date;
        this.imageURL = imageURL;
    }

    public News(){
        this.title = "New Title";
        this.details = "Some Details";
        this.date = "Today";
        this.imageURL = "";
    }

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
}
