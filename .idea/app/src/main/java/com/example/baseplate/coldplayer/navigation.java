package com.example.baseplate.coldplayer;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class navigation extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        setToolbar();
        navigationView = (NavigationView) findViewById(R.id.navigationMenu);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.albums:
                        Toast.makeText(navigation.this, "Albums", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.playlist:
                        break;
                    case R.id.favourites:
                        break;
                    case R.id.mostPlayed:
                        break;
                    case R.id.news:
                        break;
                    case R.id.stream:
                        break;
                    case R.id.settings:
                        break;

                }
                return false;
            }
        });
        //Creates the song list
        ArrayList<song> songs = new ArrayList<song>();
        songs.add(new song("01 Always In My Head", "Coldplay", R.drawable.ghoststories));
        songs.add(new song("02 Magic", "Coldplay", R.drawable.ghoststories));
        songs.add(new song("03 Ink", "Coldplay", R.drawable.ghoststories));
        songs.add(new song("04 True Love", "Coldplay", R.drawable.ghoststories));
        songs.add(new song("05 Midnight", "Coldplay", R.drawable.ghoststories));
        songs.add(new song("06 Another's Arms", "Coldplay", R.drawable.ghoststories));
        songs.add(new song("08 A Sky Full Of Stars", "Coldplay", R.drawable.ghoststories));
        songs.add(new song("09 O", "Coldplay", R.drawable.ghoststories));
        songs.add(new song("10 All Your Friends", "Coldplay", R.drawable.ghoststories));
        songs.add(new song("11 Ghost Story", "Coldplay", R.drawable.ghoststories));
        songs.add(new song("12 O (Part 2 - Reprise)", "Coldplay", R.drawable.ghoststories));

        songAdapter adapter = new songAdapter(this, songs);
        ListView listViewItems = (ListView) findViewById(R.id.song_list);
        listViewItems.setAdapter(adapter);
    }

    public void setToolbar(){
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }
}