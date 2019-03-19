package com.example.deezertp.service;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.deezertp.service.data.DataSearchArtist;

import java.net.URLEncoder;

public class DeezerService {

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
