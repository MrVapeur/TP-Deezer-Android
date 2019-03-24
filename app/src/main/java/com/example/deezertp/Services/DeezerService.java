package com.example.deezertp.Services;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.deezertp.Services.data.DataSearchArtist;
import com.google.gson.Gson;

import java.net.URLEncoder;

public class DeezerService {

    private Gson gson;

    public DeezerService() {
        this.gson = new Gson();
    }

    public static void searchArtist(Context context,
                                    String name,
                                    Response.Listener<DataSearchArtist> rep,
                                    Response.ErrorListener error) {

        final String url = "http://api.deezer.com/search/artist?q=" + URLEncoder.encode(name);
        RequestQueue queue = Volley.newRequestQueue(context);
        GsonRequest<DataSearchArtist> request = new GsonRequest(url,
                DataSearchArtist.class, null,
                rep, error);

        queue.add(request);


    }
}
