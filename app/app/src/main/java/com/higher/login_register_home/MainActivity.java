package com.higher.login_register_home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Checks if user is logged in
        auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();

        if(user != null)    //Sends user to home activity
        {
            finish();
            startActivity(new Intent(MainActivity.this, Home.class));
        }
        else    //Sends user to login screen
        {
            finish();
            startActivity(new Intent(MainActivity.this, Login.class));
        }
    }
}
