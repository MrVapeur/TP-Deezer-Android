package com.example.deezertp.Services.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DataArtist implements Serializable {

	@SerializedName("picture_xl")
	public String pictureXl;

	@SerializedName("tracklist")
	public String tracklist;

	@SerializedName("link")
	public String link;

	@SerializedName("picture_small")
	public String pictureSmall;

	@SerializedName("type")
	public String type;

	@SerializedName("nb_album")
	public int nbAlbum;

	@SerializedName("picture")
	public String picture;

	@SerializedName("nb_fan")
	public int nbFan;

	@SerializedName("radio")
	public boolean radio;

	@SerializedName("picture_big")
	public String pictureBig;

	@SerializedName("name")
	public String name;

	@SerializedName("id")
	public int id;

	@SerializedName("picture_medium")
	public String pictureMedium;
}