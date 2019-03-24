package com.example.deezertp.Services.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class DataSearchArtist implements Serializable {

	@SerializedName("total")
	public int total;

	@SerializedName("data")
	public List<DataArtist> data;
}