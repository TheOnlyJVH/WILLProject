package com.higher.login_register_home;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.security.spec.ECField;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import static android.os.Environment.getExternalStoragePublicDirectory;

//_____Camera Code
// Coded By: Hilton
// Edited by:
//Tested by:

public class TakePictureActivity extends AppCompatActivity {

    Button btnTakePic, btnRename;
    ImageView imageView;
    String pathToFile, name;
    EditText imageName;

    File photo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_take_picture);
        btnRename = findViewById(R.id.btnRename);
        btnTakePic = findViewById(R.id.btnTakePic);
        imageName = findViewById(R.id.imageName);
        imageView = findViewById(R.id.image);

        //ask for permissions
        if(Build.VERSION.SDK_INT >= 23) {
            requestPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 2);
        }
        //check if user has chosen a name for the photo, if not ask and if so continue with taking a photo
        btnTakePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchPictureTakeAction();
                btnRename.setVisibility(View.VISIBLE);
                btnTakePic.setVisibility(View.INVISIBLE);
                imageName.setVisibility(View.VISIBLE);
            }
        });

        btnRename.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(imageName.getText().toString().isEmpty()){
                    Toast.makeText(TakePictureActivity.this, "Please give the photo a name first." , Toast.LENGTH_SHORT).show();
                }
                else{


                    String root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString();
                    //String root = TakePictureActivity.this.getExternalMediaDirs().toString();

                    File dir = new File(root + "/PhotoApp/");

                    Log.e("Directory: ", dir.getAbsolutePath());

                    if(dir.exists()){

                        File from = new File(dir,photo.getName());
                        String [] nameSplit = photo.getName().split("_");
                        File to = new File(dir,imageName.getText() + "_"+ nameSplit[1]);
                        //Toast.makeText(MainActivity.this, name , Toast.LENGTH_SHORT).show();
                        if(from.exists())
                            Toast.makeText(TakePictureActivity.this, "Photo successfully named." , Toast.LENGTH_SHORT).show();
                        from.renameTo(to);
                    }
                }
            }
        });
    }

    //if everything went well show a preview of the image that has been taken
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK) {
            if(requestCode == 1){
                Bitmap bitmap = BitmapFactory.decodeFile(pathToFile);

                bitmap = ImageHelper.autoRotate(bitmap);

                imageView.setImageBitmap(bitmap);

                Log.e("Path to file",pathToFile);

                /*Intent myIntent = new Intent(MainActivity.this, GalleryActivity.class);
                MainActivity.this.startActivity(myIntent);*/
            }
        }
    }

    //create an intent to go to the default camera application for the device
    private void dispatchPictureTakeAction() {
        Intent takePic = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(takePic.resolveActivity(getPackageManager())!= null){
            File photoFile = null;
            photoFile = createPhotoFile();
            photo = photoFile;


            //if nothing went wrong, start the camera activity, take the picture, and set the picture that will be taken to the path of the temp file generated
            if(photoFile != null){
                pathToFile = photoFile.getAbsolutePath();
                Uri photoURI = FileProvider.getUriForFile(Objects.requireNonNull(getApplicationContext()),
                        BuildConfig.APPLICATION_ID + ".provider", photoFile);
                //Uri photoURI = FileProvider.getUriForFile(MainActivity.this, "com.u18002446.photo_app.fileprovider", photoFile);
                takePic.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePic, 1);

            }

        }
    }


    //create the file preemptively that the image will be stored in
    private File createPhotoFile() {
        //generate name based on given name and time
        String time = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String tempName = "TEMP_" + time;
        name = tempName + ".jpg";

        String root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString();

        Log.e("myLog", "Root : " + root);

        //set root file
        File storageDir = new File(root + "/PhotoApp/");
        Log.e("myLog", "StorageDir : " + storageDir);
        File image = null;

        //if the root file location doesn't exist, create it
        if(!storageDir.exists()){
            storageDir.mkdir();
        }
        //append .jpg to make the file an image
        try{
            image = File.createTempFile(tempName, ".jpg", storageDir);
        }
        catch (IOException e){
            Log.e("myLog", "Exception : " + e.toString());
        }
        return image;

    }
}