package com.higher.login_register_home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    private EditText edtUsername, edtPassword;
    private ImageButton btnLogin;
    private TextView btnRegister;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        assignToVariables();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateLogin();
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(Login.this, Register.class));
            }
        });
    }

    //Assigns objects to variables
    private void assignToVariables() {
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);

        auth = FirebaseAuth.getInstance();
    }

    //Checks validity of the login information
    private void validateLogin(){
        boolean usernameFlag = false;
        boolean passwordFlag = false;

        String username = edtUsername.getText().toString().trim();
        if (TextUtils.isEmpty(username)){
            edtUsername.setError("Please Enter your Username!"); //Displays error message for username
        }else {
            usernameFlag = true; //Sets username flag to true.
        }
        String password = edtPassword.getText().toString().trim();
        if (TextUtils.isEmpty(password)){
            edtPassword.setError("Please Enter your Password!"); //Displays error message for password
        }else {
            passwordFlag = true; //Sets password flag to true.
        }

        //Checks both flags. If true, logs the user in and sends them to the home screen
        if (usernameFlag && passwordFlag)
        {
            auth.signInWithEmailAndPassword(username, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) //Does a final check for the user
                            {
                                Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(Login.this, Home.class));
                            }
                            else
                            {
                                //Makes a toast if firebase denies the user
                                Toast.makeText(Login.this, "Login Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }
}
