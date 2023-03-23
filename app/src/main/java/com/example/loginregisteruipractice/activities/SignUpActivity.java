package com.example.loginregisteruipractice.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginregisteruipractice.R;
import com.google.android.material.button.MaterialButton;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        TextView fullname = (TextView) findViewById(R.id.fullname);
        TextView username = (TextView) findViewById(R.id.username);
        TextView password = (TextView) findViewById(R.id.password);
        TextView confirmPassword = (TextView) findViewById(R.id.confirmPass);
        TextView email = (TextView) findViewById(R.id.email);
        TextView phone = (TextView) findViewById(R.id.phone);
        TextView signinredirect = (TextView) findViewById(R.id.signinredirect) ;

        MaterialButton registerbtn = (MaterialButton) findViewById(R.id.registerbtn);

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checkConditions = true;
                if (fullname.getText().toString().isEmpty()) {
                    checkConditions = false;
                    Toast.makeText(SignUpActivity.this, "Fullname can't be left blank", Toast.LENGTH_SHORT).show();
                }
                if (username.getText().toString().isEmpty())
                {
                    checkConditions = false;
                    Toast.makeText(SignUpActivity.this, "Username can't be left blank", Toast.LENGTH_SHORT).show();
                }
                if (password.getText().toString().isEmpty())
                {
                    checkConditions = false;
                    Toast.makeText(SignUpActivity.this, "Password can't be left blank", Toast.LENGTH_SHORT).show();
                }
                if (username.getText().length() < 4) {
                    checkConditions = false;
                    Toast.makeText(SignUpActivity.this, "Username must be at least 4 characters above", Toast.LENGTH_SHORT).show();
                }
                if (password.getText().length() < 8) {
                    checkConditions = false;
                    Toast.makeText(SignUpActivity.this, "Password must be at least 8 characters above", Toast.LENGTH_SHORT).show();
                }
                if (!confirmPassword.getText().toString().equals(password.getText().toString())) {
                    checkConditions = false;
                    Toast.makeText(SignUpActivity.this, "ConfirmPassword is incompatible with password", Toast.LENGTH_SHORT).show();
                }
                if(!phone.equals(null))
                {
                    String phoneRegex = "\\d+";
                    if (phone.length() != 10) {
                        checkConditions = false;
                        Toast.makeText(SignUpActivity.this, "Phone number must be 10 digit", Toast.LENGTH_SHORT).show();
                    }
                    if (!phone.getText().toString().matches(phoneRegex)) {
                        checkConditions = false;
                        Toast.makeText(SignUpActivity.this, "Phone number can only contain numbers", Toast.LENGTH_SHORT).show();
                    }
                }
                if(!email.equals(null))
                {
                    if(!isValidEmail(email.getText()))
                    {
                        checkConditions = false;
                        Toast.makeText(SignUpActivity.this, "Invalid email format type", Toast.LENGTH_SHORT).show();
                    }
                }
                if (checkConditions) {
                    Toast.makeText(SignUpActivity.this, "REGISTER SUCCESS", Toast.LENGTH_SHORT).show();
                }
            }
        });

        signinredirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLoginPage();
            }
        });
    }

    public void openLoginPage()
    {
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
    }

    public boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
}
