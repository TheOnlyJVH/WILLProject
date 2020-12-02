package com.higher.login_register_home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

//_____Camera Code
// Coded By: Hilton
// Edited by:
//Tested by:

public class PictureMenuActivity extends AppCompatActivity {

    Button buttonStart;
    Button buttonManagePhotos;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_picture_menu);

        buttonStart = findViewById(R.id.btnStart);
        buttonManagePhotos = findViewById(R.id.btnManagePhotos);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(PictureMenuActivity.this, PictureGame.class);
                PictureMenuActivity.this.startActivity(myIntent);
            }
        });


        //take user to gallery to edit, delete or move files in the PhotoApp folder
        buttonManagePhotos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent myIntent = new Intent(PictureMenuActivity.this, GalleryActivity.class);
                PictureMenuActivity.this.startActivity(myIntent);
            }
        });
    }




}
