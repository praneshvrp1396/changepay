package com.example.siva1.change;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

public interface APIClass {
    @FormUrlEncoded
    @GET("/api/unknown")
    Call<List<Panel>> getPanelList();
}
