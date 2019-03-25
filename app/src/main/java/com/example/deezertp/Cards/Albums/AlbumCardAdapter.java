package com.example.deezertp.Cards.Albums;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.deezertp.R;
import com.example.deezertp.Services.data.DataAlbum;

import java.util.List;

public class AlbumCardAdapter extends RecyclerView.Adapter<AlbumCardViewHolder> {

    public List<DataAlbum> albumList;

    public AlbumCardAdapter(List<DataAlbum> list){
        this.albumList = list;
    }

    @Override
    public AlbumCardViewHolder onCreateViewHolder( ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.album_card, viewGroup, false);
        return new AlbumCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AlbumCardViewHolder myViewHolder, int position) {
        DataAlbum myObject = albumList.get(position);
        myViewHolder.bind(myObject);
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
