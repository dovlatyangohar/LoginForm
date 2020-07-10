package com.example.loginform;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SignedUpActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signed_up);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String email = intent.getStringExtra("email");
        String pass = intent.getStringExtra("password");
        String number = intent.getStringExtra("phone");

        TextView tvUsername = findViewById(R.id.tvUsername);
        TextView tvEmail = findViewById(R.id.tvEmail);
        TextView tvPass = findViewById(R.id.tvPass);
        TextView tvNum = findViewById(R.id.tvNumber);

        tvUsername.setText(String.format("Here is your info %s", username));
        tvEmail.setText(email);
        tvPass.setText(pass);
        tvNum.setText(number);
    }
}
