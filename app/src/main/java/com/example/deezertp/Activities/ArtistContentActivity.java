package com.example.deezertp.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.deezertp.R;

public class ArtistContentActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_content);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Data from last activity
        String artistId = getIntent().getStringExtra("ArtistId");
        String artistName = getIntent().getStringExtra("ArtistName");

        getSupportActionBar().setTitle(artistName);

        // Initialising the number of fans to display
        TextView fanText = findViewById(R.id.nb_fans);
        fanText.setText(getIntent().getStringExtra("ArtistFans"));

        // Initializing the recyclerView / two columns setup
        recyclerView = findViewById(R.id.album_list);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        //DeezerService.getAlbumsFromArtist(artistId, ArtistDetailsActivity.this, recyclerView);
    }

}
