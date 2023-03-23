package com.example.loginregisteruipractice.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.loginregisteruipractice.R;
import com.example.loginregisteruipractice.adapters.ProductsAdapter;
import com.example.loginregisteruipractice.api.ProductApi;
import com.example.loginregisteruipractice.models.Product;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsActivity extends AppCompatActivity {

    private List<Product> products;

    private ImageView cartRedirect;
    private ImageView imBack;

    private RecyclerView rvProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        setUpUI();
        setUpListener();
        getProduct();
    }

    private void setUpListener() {
        cartRedirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductsActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });

        imBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setUpUI() {
        cartRedirect = findViewById(R.id.partial_iv_cart_item);
        imBack = findViewById(R.id.partial_iv_back);

        rvProducts = findViewById(R.id.partial_rvProducts);
    }

    private void getProduct(){
        ProductApi.productApi.getAllProduct().enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                products = response.body();

                if (products != null) {
                    ProductsAdapter adapter = new ProductsAdapter(products);
                    rvProducts.setAdapter(adapter);
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
                    gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    rvProducts.setLayoutManager(gridLayoutManager);
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                products = new ArrayList<Product>();
            }
        });
    }
}