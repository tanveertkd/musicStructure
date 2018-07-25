package com.example.baseplate.coldplayer;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class songAdapter extends ArrayAdapter<song> {
    public songAdapter(Activity context, ArrayList<song> songs) {
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listView = convertView;
        if (listView == null){
            listView = LayoutInflater.from(getContext()).inflate(R.layout.song_list, parent, false);
        }
        song currentSong = getItem(position);

        TextView songTitle = (TextView) listView.findViewById(R.id.song_name);
        songTitle.setText(currentSong.getSongName());

        TextView songArtist = (TextView) listView.findViewById(R.id.artist_name);
        songArtist.setText(currentSong.getArtistName());

        ImageView songImage = (ImageView) listView.findViewById(R.id.thumbnail);
        songImage.setImageResource(currentSong.getAlbumArt());

        return listView;
    }
}
