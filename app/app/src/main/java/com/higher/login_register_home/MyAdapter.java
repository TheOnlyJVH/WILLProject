package com.higher.login_register_home;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.ArrayList;
import java.util.Locale;

//_____Gallery Code
// Coded By: Hilton
// Edited by:
//Tested by:

//this is for the list of the images (RecyclerView)
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private ArrayList<Cell> galleryList;
    private Context context;


    public MyAdapter(Context context, ArrayList<Cell> galleryList) {
        this.galleryList = galleryList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell, viewGroup, false);

        return new MyAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        viewHolder.img.setScaleType(ImageView.ScaleType.CENTER_CROP);
        setImageFromPath(galleryList.get(i).getPath(), viewHolder.img);
        viewHolder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //take the user to the gallery where they can modify the photo selected

                String path = galleryList.get(i).getPath();

                File photo = new File(Environment.getExternalStorageDirectory(),  path);

                final Intent intent = new Intent(Intent.ACTION_VIEW)//
                        .setDataAndType(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N ?
                                        FileProvider.getUriForFile(context, BuildConfig.APPLICATION_ID+ ".provider", photo) : Uri.fromFile(photo),
                                "image/*").addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

                context.startActivity(intent);


            }
        });
    }

    @Override
    public int getItemCount() {
        return galleryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;

        public ViewHolder(View view) {
            super(view);

            img = (ImageView) view.findViewById(R.id.img);
        }
    }

    private void setImageFromPath(String path, ImageView image) {
        File imgFile = new File(path);
        if(imgFile.exists()) {
            Bitmap myBitmap = ImageHelper.decodeSampledBitmapFromPath(imgFile.getAbsolutePath(), 200, 200);

            myBitmap = ImageHelper.autoRotate(myBitmap);

            image.setImageBitmap(myBitmap);
        }
    }


}
