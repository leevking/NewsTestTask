package com.codeheaded.levking.haulmonttesttask;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.List;

public class RecyclerViewNewsAdapter extends RecyclerView.Adapter<RecyclerViewNewsAdapter.ViewHolder> {


    private List<News> listNews;
    private  Activity activity;
    public RecyclerViewNewsAdapter(Activity activity, List<News> list) {
        this.activity = activity; listNews = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.bindTo(listNews.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                holder.onClick(v);
            }
        });
//        File imgFile = new File(holder.newsUnit.getImageURL());
//        if (imgFile.exists()) {
//            Bitmap imgBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
//            holder.newsImage.setImageBitmap(imgBitmap);
//        } else {
//
//            holder.newsImage.setImageResource(R.drawable.ic_launcher_background);
//        }
    }

    @Override
    public int getItemCount() {
        return listNews.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public final ImageView newsImage;
        public final TextView newsTitle, newsDetails, newsDate;
        public News newsUnit;

        public ViewHolder(View view) {
            super(view);
            newsImage = view.findViewById(R.id.newsImage);
            newsTitle = view.findViewById(R.id.newsTitle);
            newsDetails = view.findViewById(R.id.newsDetail);
            newsDate = view.findViewById(R.id.newsDate);
        }

        public void bindTo(News news) {
            newsUnit = news;
            newsTitle.setText(newsUnit.getTitle());
            newsDetails.setText(newsUnit.getDetails());
            newsDate.setText(newsUnit.getDate());
            if(newsUnit.getImageURL().length()>5){
                Picasso.with(activity).load(newsUnit.getImageURL()).resize(300,200).into(newsImage);
            } else newsImage.setImageResource(R.drawable.ic_launcher_background);
        }



        @Override
        public void onClick(View v){
            Intent i = new Intent(activity, DetailsActivity.class);
            i.putExtra("url", newsUnit.getURL());
            activity.startActivity(i);
        }

    }
}
