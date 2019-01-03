package com.example.techpex.beautyapplication.home.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.techpex.beautyapplication.R;
import com.example.techpex.beautyapplication.home.callbacks.PagerImageClickListner;

public class HomeScreenPagerAdapter extends PagerAdapter {

    Context context;
    int images1[];
    LayoutInflater layoutInflater;

    public HomeScreenPagerAdapter(Context context, int images1[]) {
        this.context = context;
        this.images1 = images1;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container,final int position) {
        View itemView = layoutInflater.inflate(R.layout.view_pager_item_layout, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
        imageView.setImageResource(images1[position]);

        container.addView(itemView);

        //listening to image click
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((PagerImageClickListner)context).onPagerImageClick(position);
            }
        });

        return itemView;
    }

    @Override
    public int getCount() {
        return images1.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
