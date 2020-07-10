package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText usernameEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText numberEditText;
    private Button signUpButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.usernameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        numberEditText = findViewById(R.id.phoneNumberEditText);

        signUpButton = findViewById(R.id.signUpButton);

        signUpButton.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signUpButton:
                checkEnteredData();
                break;
        }
    }

    public void sendInfo() {
        Intent passingIntent = new Intent(MainActivity.this, SignedUpActivity.class);
        passingIntent.putExtra("username", usernameEditText.getText().toString());
        passingIntent.putExtra("email", emailEditText.getText().toString());
        passingIntent.putExtra("password", passwordEditText.getText().toString());
        passingIntent.putExtra("phone", numberEditText.getText().toString());
        startActivity(passingIntent);

    }

    boolean isEmpty(EditText text) {
        String str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    boolean isEmail(EditText text) {
        String email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    public void checkEnteredData() {
        boolean isValid = true;

        if (isEmpty(usernameEditText)) {
            usernameEditText.setError("Username is required");
            isValid = false;
        }
        if (!isEmail(emailEditText)) {
            emailEditText.setError("Email isn't valid");
            isValid = false;
        }
        if (isEmpty(passwordEditText)) {
            passwordEditText.setError("Password is required");
            isValid = false;
        }
        if (isValid) {
            sendInfo();
        } else
            Toast.makeText(getApplicationContext(), "Inputs aren't valid", Toast.LENGTH_LONG).show();

    }


}
