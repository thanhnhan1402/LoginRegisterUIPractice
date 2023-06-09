package com.example.loginregisteruipractice.api;

import com.example.loginregisteruipractice.models.Product;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ProductApi {
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-mm-dd hh:MM:ss")
            .create();

    ProductApi productApi = new Retrofit.Builder()
            .baseUrl("https://641bf93c1f5d999a446e0cb7.mockapi.io/api/product-management/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProductApi.class);

    @GET("products")
    Call<List<Product>> getAllProduct();

    @GET("products")
    Call<List<Product>> getAllProductByYear(@Query("year") String year);

    @GET("products/{id}")
    Call<Product> getProductById(@Path("id") int id);

    @GET("products")
    Call<List<Product>> getAllProductByCategory(@Query("categoryId") String categoryId);
}
