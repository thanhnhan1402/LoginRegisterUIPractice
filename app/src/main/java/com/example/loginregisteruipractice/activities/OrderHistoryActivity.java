package com.example.loginregisteruipractice.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.loginregisteruipractice.R;

public class OrderHistoryActivity extends AppCompatActivity {

    ImageView iv_back;

    LinearLayout layout_order, layout_order1, layout_order2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_order);

        setUI();
        setListener();
    }


    private void setListener() {
        layout_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderHistoryActivity.this, OrderDetailActivity.class);
                startActivity(intent);
            }
        });

        layout_order1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderHistoryActivity.this, OrderDetailActivity.class);
                startActivity(intent);
            }
        });

        layout_order2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderHistoryActivity.this, OrderDetailActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setUI() {
        layout_order = findViewById(R.id.layout_order);
        layout_order1 = findViewById(R.id.layout_order1);
        layout_order2 = findViewById(R.id.layout_order2);

        iv_back = findViewById(R.id.iv_back);
    }
}