package com.kingoffinance.app;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class signup extends AppCompatActivity {
    TextInputLayout fullname_var, username_var, Password_var, phonenumber_var, email_var;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        fullname_var = findViewById(R.id.fullname_field_design);
        Password_var = findViewById(R.id.password_field);
        phonenumber_var = findViewById(R.id.phone_number_field_design);
        email_var = findViewById(R.id.email_field_design);
        username_var = findViewById(R.id.username_text_field_design);
    }

    public void loginbuttonclick(View view) {
        Intent intent = new Intent(getApplicationContext(), login.class);
        startActivity(intent);
        finish();
    }

    public void registerbuttonclick(View view) {
        String fullname_ = fullname_var.getEditText().getText().toString();
        String username_ = username_var.getEditText().getText().toString();
        String phonenumber_ =phonenumber_var.getEditText().getText().toString();
        String email_ = email_var.getEditText().getText().toString();
        String Password_ = Password_var.getEditText().getText().toString();
        if (!fullname_.isEmpty()) {
            fullname_var.setError(null);
            fullname_var.setErrorEnabled(false);
            if (!username_.isEmpty()) {
                username_var.setError(null);
                username_var.setErrorEnabled(false);
                if (!email_.isEmpty()) {
                    email_var.setError(null);
                    email_var.setErrorEnabled(false);
                    if (!phonenumber_.isEmpty()) {
                        phonenumber_var.setError(null);
                        phonenumber_var.setErrorEnabled(false);
                        if (!Password_.isEmpty()) {
                            Password_var.setError(null);
                            Password_var.setErrorEnabled(false);
                            if (email_.matches("([a-zA-Z0-9_\\-.]+)@([a-zA-Z0-9_\\-.]+)\\.([a-zA-Z]{2,5})$\"")){
                            firebaseDatabase=FirebaseDatabase.getInstance();
                            reference= firebaseDatabase.getReference("client");
                        }else {
                                email_var.setError("Invalid email");
                            }
                        }else {
                            Password_var.setError("Please enter the Password");
                        }
                    } else {
                        phonenumber_var.setError("Please enter the phone number");
                    }
                } else {
                    email_var.setError("Please enter the email");
                }
            } else {
                username_var.setError("Please enter the full name");
            }

        } else {
            fullname_var.setError("Please enter the username");
        }
    }
}
