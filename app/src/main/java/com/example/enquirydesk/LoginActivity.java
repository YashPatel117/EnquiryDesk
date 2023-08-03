package com.example.enquirydesk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.time.Instant;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText emailEditTextLogin , passwordEditTextLogin;
    private TextView signupTextViewLogin;
    private Button loginButtonLogin;
    private CheckBox togglepassword ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditTextLogin = findViewById(R.id.emailEditTextLogin);
        passwordEditTextLogin = findViewById(R.id.passwordEditTextLogin);
        signupTextViewLogin = findViewById(R.id.signupTextViewLogin);
        loginButtonLogin = findViewById(R.id.loginButtonLogin);
        togglepassword = findViewById(R.id.togglePasswordCheckBoxLogin);

        signupTextViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext() , RegisterActivity.class);
                startActivity(intent);
            }
        });

        togglepassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    // Show password in plain text
                    passwordEditTextLogin.setTransformationMethod(null);
                } else {
                    // Hide password (default behavior)
                    passwordEditTextLogin.setTransformationMethod(new PasswordTransformationMethod());
                }
            }
        });

        loginButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RetrofitBaseUrl.getInstance().apiinterface.userLogin(emailEditTextLogin.getText().toString() , passwordEditTextLogin.getText().toString()).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        System.out.println(response);
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });
            }
        });

    }
}