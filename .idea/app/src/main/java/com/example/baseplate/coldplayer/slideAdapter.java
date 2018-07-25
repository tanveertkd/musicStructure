package com.example.baseplate.coldplayer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.baseplate.coldplayer.R;

public class slideAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public slideAdapter(Context context){
        this.context = context;
    }

    public int[] images = {
            R.drawable.ic_headphones_solid,
            R.drawable.ic_podcast_solid,
            R.drawable.ic_newspaper_solid
    };

    public String[] headings = {
            "Offline",
            "Podcasts",
            "Music News"
    };

    public String[] desc = {
            "Listen to music locally right on your phone.",
            "Keep up with your favourite podcasts.",
            "Get all the exciting news right here."
    };

    @Override
    public int getCount() {
        return headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, Object object) {
        return view == (RelativeLayout) object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView sliderImageView = (ImageView) view.findViewById(R.id.imageView);
        TextView sliderHead = (TextView) view.findViewById(R.id.heading);
        TextView sliderDesc = (TextView) view.findViewById(R.id.desc);

        sliderImageView.setImageResource(images[position]);
        sliderHead.setText(headings[position]);
        sliderDesc.setText(desc[position]);

        container.addView(view);

        return view;
    };

    @Override
    public void destroyItem(ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
