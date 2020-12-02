package com.higher.login_register_home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class nounsverbsMenu extends AppCompatActivity {

    Button r1,r2,r3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nounsverbsmenu);

        r1 = findViewById(R.id.round1);
        r2= findViewById(R.id.round2);
        r3 = findViewById(R.id.round3);

        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(nounsverbsMenu.this, nounsverbsRound1.class));
            }
        });

        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(nounsverbsMenu.this, nounsverbsRound2.class));
            }
        });

        r3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 startActivity(new Intent(nounsverbsMenu.this, nounsverbsRound3.class));
            }
        });

    }
}