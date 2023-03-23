package com.example.loginregisteruipractice.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.loginregisteruipractice.R;
import com.example.loginregisteruipractice.api.ProductApi;
import com.example.loginregisteruipractice.models.Product;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDetailActivity extends AppCompatActivity {

    private ImageView back;
    private ImageView cart;
    private ImageView imageView;
    private TextView tvProductName;
    private TextView tvQuantity;
    private TextView tvPrice;
    private TextView tvDescription;
    private Product product;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);

        setUpUI();
        setUpListener();
    }

    public void setUpUI() {
        cart = findViewById(R.id.iv_cart_item);
        back = findViewById(R.id.iv_back);
        imageView = findViewById(R.id.ivDetail);
        tvProductName = findViewById(R.id.tvProductName);
        tvQuantity = findViewById(R.id.tv_amountLeft);
        tvPrice = findViewById(R.id.tv_Price);
        tvDescription = findViewById(R.id.tvDescription);

        int id = Integer.parseInt(getIntent().getStringExtra("PRODUCT_ID"));
        getProductById(id);
    }

    public void setUpListener() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { finish();}
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductDetailActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });
    }

    private void getProductById(int productId) {
        ProductApi.productApi.getProductById(productId).enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                product = response.body();
                Picasso.get().load(product.getUrl())
                        .into(imageView);
                tvProductName.setText(product.getName());
                tvQuantity.setText(String.valueOf(product.getQuantity()));
                tvPrice.setText(String.format("%.0f VND", product.getPrice()));
                tvDescription.setText(product.getDescription());
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {
                product = null;
            }
        });
    }
}