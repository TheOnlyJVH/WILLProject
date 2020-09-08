package com.higher.login_register_home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    private EditText edtEmail, edtNewPassword;
    private ImageButton btnRegister;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        assignToVariables();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewUser();
            }
        });
    }

    private void assignToVariables() {
        edtEmail = findViewById(R.id.edtEmail);
        edtNewPassword = findViewById(R.id.edtNewPassword);
        btnRegister = findViewById(R.id.btnRegister);

        auth = FirebaseAuth.getInstance();
    }

    private void addNewUser() {
        boolean emailFlag = false;
        boolean passwordFlag = false;

        final String email = edtEmail.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            edtEmail.setError("Please Enter a Username!");
        } else {
            emailFlag = true;
        }

        String password = edtNewPassword.getText().toString().trim();

        if (TextUtils.isEmpty(password)) {
            edtNewPassword.setError("Please Enter a Password!");
        } else {
            if (password.length() < 6) {
                edtNewPassword.setError("Password must be at least 6 characters");
            } else {
                passwordFlag = true;
            }
        }

        if (emailFlag && passwordFlag) {
            auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Register.this, "Account successfully created!", Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(Register.this, Home.class));
                            } else {
                                Toast.makeText(Register.this, "Account failed to be created...", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }
}
