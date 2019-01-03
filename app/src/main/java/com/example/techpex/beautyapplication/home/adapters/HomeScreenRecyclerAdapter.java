package com.example.techpex.beautyapplication.home.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.techpex.beautyapplication.R;
import com.example.techpex.beautyapplication.home.activities.HomeScreenActivity;
import com.example.techpex.beautyapplication.home.callbacks.PagerImageClickListner;
import com.example.techpex.beautyapplication.home.callbacks.RecyclerImageClickListner;
import com.example.techpex.beautyapplication.home.models.HomeScreenModel;

import java.util.List;

public class HomeScreenRecyclerAdapter extends RecyclerView.Adapter<HomeScreenRecyclerAdapter.MyViewHolder>{


    private List<HomeScreenModel> homeScreenModelList;
    private Context context;
    int images[];
    String title[];

    public HomeScreenRecyclerAdapter(Context context, int images[],String title[]) {
        this.context = context;
        this.images = images;
        this.title =  title;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_screen_recycler_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.image.setImageResource(images[position]);
        holder.title.setText(title[position]);
       // holder.image.setImageBitmap(image);

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((RecyclerImageClickListner)context).onRecyclerImageClick(position);

            }
        });
    }

    @Override
    public int getItemCount() {
        return images.length & title.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView image;
        public MyViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.txt_title);
            image = itemView.findViewById(R.id.image);
        }
    }
}
