package com.codeheaded.levking.haulmonttesttask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.List;

public class RecyclerViewNewsAdapter extends RecyclerView.Adapter<RecyclerViewNewsAdapter.ViewHolder> {

    private final List<News> mValues;

    public RecyclerViewNewsAdapter(List<News> items){
        mValues = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.newsUnit = mValues.get(position);
        holder.newsTitle.setText(holder.newsUnit.getTitle());
        holder.newsDetails.setText(holder.newsUnit.getDetails());
        holder.newsDate.setText(holder.newsUnit.getDate());
        File imgFile = new File(holder.newsUnit.getImageURL());
        if(imgFile.exists()){
            Bitmap imgBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            holder.newsImage.setImageBitmap(imgBitmap);
        }
        else{holder.newsImage.setImageResource(R.drawable.ic_launcher_background);}

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder{

        public final ImageView newsImage;
        public final TextView newsTitle, newsDetails, newsDate;
        public News newsUnit;

        public ViewHolder(View view){
            super(view);
            newsImage = view.findViewById(R.id.newsImage);
            newsTitle = view.findViewById(R.id.newsTitle);
            newsDetails = view.findViewById(R.id.newsDetail);
            newsDate = view.findViewById(R.id.newsDate);
        }
    }
}
