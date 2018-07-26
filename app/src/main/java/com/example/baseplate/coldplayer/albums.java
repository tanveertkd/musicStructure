package com.example.baseplate.coldplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class albums extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);

        ArrayList<song> songs = new ArrayList<song>();
        songs.add(new song("01 Always In My Head", "Ghost Stories", R.drawable.ghost_stories_large));
        songs.add(new song("02 Magic", "Ghost Stories", R.drawable.ghost_stories_large));
        songs.add(new song("03 Ink", "Ghost Stories", R.drawable.ghost_stories_large));
        songs.add(new song("04 True Love", "Ghost Stories", R.drawable.ghost_stories_large));
        songs.add(new song("05 Midnight", "Ghost Stories", R.drawable.ghost_stories_large));
        songs.add(new song("06 Another's Arms", "Ghost Stories", R.drawable.ghost_stories_large));
        songs.add(new song("08 A Sky Full Of Stars", "Ghost Stories", R.drawable.ghost_stories_large));
        songs.add(new song("09 O", "Ghost Stories", R.drawable.ghost_stories_large));
        songs.add(new song("10 All Your Friends", "Ghost Stories", R.drawable.ghost_stories_large));
        songs.add(new song("11 Ghost Story", "Ghost Stories", R.drawable.ghost_stories_large));
        songs.add(new song("12 O (Part 2 - Reprise)", "Ghost Stories", R.drawable.ghost_stories_large));

        gridAdapter adapter = new gridAdapter(this, songs);
        GridView gridViewItems = (GridView) findViewById(R.id.song_list);
        gridViewItems.setAdapter(adapter);

        gridViewItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent play = new Intent(getApplicationContext(), now_playing.class);
                startActivity(play);
            }
        });
    }
}
