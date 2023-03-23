package com.example.loginregisteruipractice.api;

import com.example.loginregisteruipractice.models.Category;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CategoryApi {
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-mm-dd hh:MM:ss")
            .create();

    CategoryApi categoryApi = new Retrofit.Builder()
            .baseUrl("https://641bf93c1f5d999a446e0cb7.mockapi.io/api/product-management/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CategoryApi.class);

    @GET("categories")
    Call<List<Category>> getAllCategory();

    @GET("categories/{id}")
    Call<Category> getCategoryById(@Path("id") int id);
}
