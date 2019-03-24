package com.example.deezertp.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.deezertp.Cards.Artists.ArtistCardAdapter;
import com.example.deezertp.R;
import com.example.deezertp.Services.DeezerService;
import com.example.deezertp.Services.data.DataArtist;
import com.example.deezertp.Services.data.DataSearchArtist;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private List<DataArtist> artists = new ArrayList<>();
    private Gson gson;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.artist_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

//        GsonBuilder gsonBuilder = new GsonBuilder();
//        gsonBuilder.setDateFormat("d/M/yy hh:mm a");
//        gson = gsonBuilder.create();

        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItemSearch = menu.findItem(R.id.search);
        final SearchView searchView = (SearchView) menuItemSearch.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            String lastText = null;

            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.d(TAG,"Query : " + query);
                //Snackbar.make(findViewById(R.id.content),query,Snackbar.LENGTH_LONG).show();
                if(!query.equals(lastText))
                {
                    lastText = query;
                    Log.d(TAG, "lastText : " +lastText );

                    Response.Listener<DataSearchArtist> rep = new Response.Listener<DataSearchArtist>() {
                        @Override
                        public void onResponse(DataSearchArtist response) {
                            //...
                            Log.d(TAG, "nb artist = " +response.data.size());
                            artists = response.data;
                            recyclerView.setAdapter(new ArtistCardAdapter(artists));
                        }
                    };
                    Response.ErrorListener error = new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    };

                    DeezerService.searchArtist(MainActivity.this,
                            query,
                            rep,
                            error);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
