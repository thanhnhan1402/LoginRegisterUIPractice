package com.example.loginregisteruipractice.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.loginregisteruipractice.R;

public class ProductDetailActivity extends AppCompatActivity {

    ImageView back;
    ImageView cart;

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
}