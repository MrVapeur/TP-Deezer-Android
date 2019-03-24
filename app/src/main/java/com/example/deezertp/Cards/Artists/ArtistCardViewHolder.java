package com.example.deezertp.Cards.Artists;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.deezertp.Activities.ArtistContentActivity;
import com.example.deezertp.R;
import com.example.deezertp.Services.data.DataArtist;
import com.squareup.picasso.Picasso;

public class ArtistCardViewHolder extends RecyclerView.ViewHolder{
    private final static String TAG = "ArtistCardViewHolder";
    private TextView artistName;
    private ImageView artistImage;
    private DataArtist artistToSend;

    public ArtistCardViewHolder(final View itemView) {
        super(itemView);

        // When the card is clicked, opens new activity and sends data to said activity
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent albumActivityIntent = new Intent(itemView.getContext(), ArtistContentActivity.class);
                    albumActivityIntent.putExtra("ArtistId", artistToSend.id);
                    albumActivityIntent.putExtra("ArtistName", artistToSend.name);
                    itemView.getContext().startActivity(albumActivityIntent);
                Log.d(TAG,"click");
            }
        });

        artistName = itemView.findViewById(R.id.artist_name);
        artistImage = itemView.findViewById(R.id.artist_image);
    }

    // Sets the content to be displayed by binding data and views
    public void bind(DataArtist anArtist) {
        artistToSend = anArtist;
        artistName.setText(anArtist.name);
        Picasso.get().load(anArtist.pictureBig).into(artistImage);
    }
}
