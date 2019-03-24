package com.example.deezertp.Cards.Artists;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.deezertp.R;
import com.example.deezertp.Services.data.DataArtist;

import java.util.List;

public class ArtistCardAdapter extends RecyclerView.Adapter<ArtistCardViewHolder> {

    private List<DataArtist> artistList;

    public ArtistCardAdapter(List<DataArtist> list) {
        this.artistList = list;
    }

    // Creates view holder and set layout for the inflater
    @Override
    public ArtistCardViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.artist_card, viewGroup, false);
        return new ArtistCardViewHolder(view);
    }

    // Sets View Content
    @Override
    public void onBindViewHolder(ArtistCardViewHolder myViewHolder, int position) {
        DataArtist myObject = artistList.get(position);
        myViewHolder.bind(myObject);
    }

    @Override
    public int getItemCount() {
        return artistList.size();
    }

}

