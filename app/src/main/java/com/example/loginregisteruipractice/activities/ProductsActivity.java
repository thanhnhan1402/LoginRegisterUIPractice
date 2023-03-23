package com.example.loginregisteruipractice.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.loginregisteruipractice.R;
import com.example.loginregisteruipractice.adapters.ProductsAdapter;
import com.example.loginregisteruipractice.api.ProductApi;
import com.example.loginregisteruipractice.models.Category;
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
    private TextView tv_categoryName;
    private TextView tv_orderByPrice;

    private RecyclerView rvProducts;
    private Category category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        setUpUI();
        setUpListener();
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
        category = (Category) getIntent().getExtras().get("CATEGORY");

        getProduct(category);
        tv_categoryName = findViewById(R.id.tv_categoryName);
        tv_orderByPrice = findViewById(R.id.tv_orderByPrice);
        if (category != null) {
            tv_categoryName.setText(category.getName());
            tv_orderByPrice.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    orderByPrice();
                }
            });
        }
    }

    private void getProduct(Category category){
        String categoryId = String.valueOf(category.getId());

        categoryId = (TextUtils.isEmpty(categoryId) || categoryId == null) ? "" : categoryId;

        ProductApi.productApi.getAllProductByCategory(categoryId).enqueue(new Callback<List<Product>>() {
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
                products = new ArrayList<>();
            }
        });
    }

    private void orderByPrice() {

    }
}