package com.example.deezertp.Cards.Albums;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.deezertp.R;
import com.example.deezertp.Services.data.DataAlbum;
import com.squareup.picasso.Picasso;

public class AlbumCardViewHolder extends RecyclerView.ViewHolder {
    private final static String TAG = "AlbumCardViewHolder";
    private TextView albumName;
    private ImageView albumImage;
    private DataAlbum albumToSend;

    public AlbumCardViewHolder(final View itemView) {
        super(itemView);

        // When the card is clicked, opens new activity and sends data to said activity
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent albumActivityIntent = new Intent(itemView.getContext(), ArtistContentActivity.class);
//                albumActivityIntent.putExtra("ArtistId", albumToSend.id);
//                albumActivityIntent.putExtra("ArtistName", albumToSend.name);
//                itemView.getContext().startActivity(albumActivityIntent);
                Log.d(TAG,"click");
            }
        });

        albumName = itemView.findViewById(R.id.album_name);
        albumImage = itemView.findViewById(R.id.album_image);
    }

    // Sets the content to be displayed by binding data and views
    public void bind(DataAlbum anAlbum) {
        albumToSend = anAlbum;
        albumName.setText(anAlbum.title);
        Picasso.get().load(anAlbum.coverBig).into(albumImage);
    }
}
