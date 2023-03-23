package com.example.loginregisteruipractice.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginregisteruipractice.R;
import com.example.loginregisteruipractice.adapters.CartsAdapter;
import com.example.loginregisteruipractice.models.CartItem;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    private ImageView ivBack;
    private Button btnOrder;
    private Button btnHomepage;
    private TextView totalPrice;

    private RecyclerView rvCarts;

    private ArrayList<CartItem> cartItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        setUpUI();
        setUpListener();

        buildCartRecycleView();
    }

    private void setUpUI()
    {
        ivBack = findViewById(R.id.ivBackArrow);
        btnOrder = findViewById(R.id.btn_order);
        btnHomepage = findViewById(R.id.btn_home);
        totalPrice = findViewById(R.id.tv_totalPrice);
        rvCarts = findViewById(R.id.rvCart);
    }

    private void setUpListener()
    {
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CartActivity.this, "ĐẶT HÀNG THÀNH CÔNG", Toast.LENGTH_SHORT).show();
            }
        });
        btnHomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CartActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void buildCartRecycleView()
    {
        cartItems = CartItem.createCartItems(7);
        // Create adapters passing in the sample user data
        CartsAdapter adapter = new CartsAdapter(CartActivity.this, cartItems);
        // Attach the adapters to the recyclerview to populate items
        rvCarts.setAdapter(adapter);
        // set a GridLayoutManager with 3 number of columns
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 1);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL); // set Horizontal Orientation
        rvCarts.setLayoutManager(gridLayoutManager); // set
    }
}