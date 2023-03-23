package com.example.loginregisteruipractice.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.loginregisteruipractice.R;
import com.example.loginregisteruipractice.adapters.CategoriesAdapter;
import com.example.loginregisteruipractice.adapters.ProductsAdapter;
import com.example.loginregisteruipractice.api.CategoryApi;
import com.example.loginregisteruipractice.api.ProductApi;
import com.example.loginregisteruipractice.models.Category;
import com.example.loginregisteruipractice.models.Product;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private List<Product> products;
    private List<Category> categories;

    private ImageView cartRedirect;
    private ImageView imMenu;
    private NavigationView navView;
    private DrawerLayout drawerLayout;
    private LinearLayout logoutLayout;
    private LinearLayout productsLayout;
    private LinearLayout ordersLayout;

    private RecyclerView rvProducts;
    private RecyclerView rvCategories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setUpUI();
        setUpListener();
        getProduct();
        setRecycleViewCategory();
    }

    public void setUpUI() {
        cartRedirect = findViewById(R.id.iv_cart_item);
        imMenu = findViewById(R.id.menu);
        navView = findViewById(R.id.nvMenu);

        productsLayout = findViewById(R.id.layout_products);

        if (navView != null) {
            navView.setNavigationItemSelectedListener(this);
        }
        drawerLayout = findViewById(R.id.drawerLayout);
        logoutLayout = findViewById(R.id.layoutLogout);
        ordersLayout = findViewById(R.id.layout_history_order);

        rvProducts = (RecyclerView) findViewById(R.id.rvProducts);
        rvCategories = (RecyclerView) findViewById(R.id.rvCategories);
    }

    public void setUpListener() {
        cartRedirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });
        productsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ProductsActivity.class);
                startActivity(intent);
            }
        });

        ordersLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, OrderHistoryActivity.class);
                startActivity(intent);
            }
        });

        imMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        logoutLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, SignInActivity.class);
                startActivity(intent);
            }
        });
    }


    public void setRecycleViewCategory() {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        Intent intent;

        if (id == R.id.nvPersonalInfo) {
            intent = new Intent(HomeActivity.this, CartActivity.class);
            startActivity(intent);
        }


//
//        if (id == R.id.nav_history) {
//            intent = new Intent(HomeActivity.this, OrderHistoryActivity.class);
//            startActivity(intent);
//        }

        return false;
    }

    private void getProduct() {
        ProductApi.productApi.getAllProductByYear("2023").enqueue(new Callback<List<Product>>() {
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

    private void getCategory() {
        CategoryApi.categoryApi.getAllCategory().enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                categories = response.body();

                if (categories != null) {
                    CategoriesAdapter adapter = new CategoriesAdapter(HomeActivity.this, categories);
                    rvCategories.setAdapter(adapter);
                    LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(HomeActivity.this, LinearLayoutManager.HORIZONTAL, false);
                    rvCategories.setLayoutManager(horizontalLayoutManager);
                }
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                categories = new ArrayList<>();
            }
        });
    }
}