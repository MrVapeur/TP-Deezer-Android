package com.example.deezertp.Services.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DataAlbum implements Serializable{

	@SerializedName("tracklist")
	public String tracklist;

	@SerializedName("link")
	public String link;

	@SerializedName("cover_small")
	public String coverSmall;

	@SerializedName("title")
	public String title;

	@SerializedName("explicit_lyrics")
	public boolean explicitLyrics;

	@SerializedName("type")
	public String type;

	@SerializedName("genre_id")
	public int genreId;

	@SerializedName("record_type")
	public String recordType;

	@SerializedName("fans")
	public int fans;

	@SerializedName("cover")
	public String cover;

	@SerializedName("cover_xl")
	public String coverXl;

	@SerializedName("release_date")
	public String releaseDate;

	@SerializedName("cover_medium")
	public String coverMedium;

	@SerializedName("id")
	public int id;

	@SerializedName("cover_big")
	public String coverBig;
}