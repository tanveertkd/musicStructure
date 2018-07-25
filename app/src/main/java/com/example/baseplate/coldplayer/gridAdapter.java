package com.example.baseplate.coldplayer;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class gridAdapter extends ArrayAdapter<song> {

    public gridAdapter(Activity context, ArrayList<song> songs) {
        super(context, 0, songs);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.album_list, parent, false);
        }
        song currentSong = getItem(position);

        ImageView songImage = (ImageView) view.findViewById(R.id.thumbnail);
        songImage.setImageResource(currentSong.getAlbumArt());

        TextView songArtist = (TextView) view.findViewById(R.id.artist_name);
        songArtist.setText(currentSong.getArtistName());

        return view;
    }
}
