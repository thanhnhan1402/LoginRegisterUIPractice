package com.example.loginregisteruipractice.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginregisteruipractice.R;
import com.example.loginregisteruipractice.api.ProductApi;
import com.example.loginregisteruipractice.models.Product;
import com.google.android.material.button.MaterialButton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInActivity extends AppCompatActivity {

    TextView username;
    TextView password;
    TextView signupredirect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

         username = (TextView) findViewById(R.id.username);
         password = (TextView) findViewById(R.id.password);
         signupredirect = (TextView) findViewById(R.id.signupredirect) ;

        MaterialButton loginbtn = (MaterialButton) findViewById(R.id.loginbtn);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().equals("hiep")
                && password.getText().toString().equals("123"))
                {
                    openProductListPage();
                }
                else if(username.getText().toString().isEmpty())
                {
                    Toast.makeText(SignInActivity.this,"The Username is blank", Toast.LENGTH_SHORT).show();
                }
                else if(password.getText().toString().isEmpty())
                {
                    Toast.makeText(SignInActivity.this,"The Password is blank", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(SignInActivity.this,"LOGIN FAIL! Incorrect Username or Password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        signupredirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegisterPage();
            }
        });
    }

    public void openRegisterPage()
    {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }
    public void openProductListPage()
    {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
    public void openDetailPage()
    {
        Intent intent = new Intent(this, ProductDetailActivity.class);
        startActivity(intent);
    }
}