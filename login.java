package com.kingoffinance.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class login extends AppCompatActivity {
    Button signupbutton,loginbutton;
    TextInputLayout username_var,password_var;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.login);

        signupbutton= findViewById(R.id.signupbutton);
        loginbutton=findViewById(R.id.loginbutton);

        username_var=findViewById(R.id.user_text_field_design);
        password_var=findViewById(R.id.password_text_field);

        loginbutton.setOnClickListener(v -> {
            String username_ = Objects.requireNonNull(username_var.getEditText()).getText().toString();
            String password_ = Objects.requireNonNull(password_var.getEditText()).getText().toString();

            if(!username_.isEmpty()){
                username_var.setError(null);
                username_var.setErrorEnabled(false);
                if(!password_.isEmpty()){
                    password_var.setError(null);
                    password_var.setErrorEnabled(false);
                }else{
                    password_var.setError("Please enter the Password");
                }
            }else {
                username_var.setError("Please enter the username");
            }
        });



        signupbutton.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),signup.class);
            startActivity(intent);

        });
    }

}
