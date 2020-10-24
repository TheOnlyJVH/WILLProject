package com.higher.login_register_home;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Picture;
import android.os.Bundle;
import android.os.Environment;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import org.w3c.dom.Text;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

//_____Camera Code
// Coded By: Hilton
// Edited by:
//Tested by:

public class PictureGame extends AppCompatActivity {

    List<Cell> allFilesPaths;
    ArrayList<Cell> images;
    int count;
    ImageView imageView;
    Button button1, button2, button3, buttonNext;
    TextView heading;
    String answerText, colorGreen = "#008000", colorPrimaryDark = "#3700B3", colorRed = "#FF0000";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_game);

        imageView = findViewById(R.id.imageView);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        buttonNext = findViewById(R.id.buttonNext);
        heading = findViewById(R.id.txtHeading);

        setupGame();


        //what happens whenever a user gets a right or wrong answer for each button
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(button1.getText().equals(answerText)){
                    heading.setText("Correct!");
                    heading.setTextColor(Color.parseColor(colorGreen));
                    button1.setBackgroundColor(Color.parseColor(colorGreen));

                }
                else{
                    heading.setText("Incorrect");
                    heading.setTextColor(Color.parseColor(colorRed));
                    button1.setBackgroundColor(Color.parseColor(colorRed));
                }
                button2.setVisibility(View.INVISIBLE);
                button3.setVisibility(View.INVISIBLE);
                buttonNext.setVisibility(View.VISIBLE);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(button2.getText().equals(answerText)){
                    heading.setText("Correct!");
                    heading.setTextColor(Color.parseColor(colorGreen));
                    button2.setBackgroundColor(Color.parseColor(colorGreen));

                }
                else{
                    heading.setText("Incorrect");
                    heading.setTextColor(Color.parseColor(colorRed));
                    button2.setBackgroundColor(Color.parseColor(colorRed));
                }
                button1.setVisibility(View.INVISIBLE);
                button3.setVisibility(View.INVISIBLE);
                buttonNext.setVisibility(View.VISIBLE);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(button3.getText().equals(answerText)){
                    heading.setText("Correct!");
                    heading.setTextColor(Color.parseColor(colorGreen));
                    button3.setBackgroundColor(Color.parseColor(colorGreen));

                }
                else{
                    heading.setText("Incorrect");
                    heading.setTextColor(Color.parseColor(colorRed));
                    button3.setBackgroundColor(Color.parseColor(colorRed));
                }
                button1.setVisibility(View.INVISIBLE);
                button2.setVisibility(View.INVISIBLE);
                buttonNext.setVisibility(View.VISIBLE);
            }
        });

        //go to next question or finish game if all images have been answered
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count >= images.size()){

                    //game is over so go back to main menu
                    //TODO maybe add a results page showing user score and/or what they got wrong and right
                    Toast.makeText(PictureGame.this, "Game is over, thanks for playing!" , Toast.LENGTH_SHORT).show();

                    Intent myIntent = new Intent(PictureGame.this, PictureMenuActivity.class);
                    PictureGame.this.startActivity(myIntent);
                }
                else{

                    //resetting everything for next question
                    button1.setVisibility(View.VISIBLE);
                    button2.setVisibility(View.VISIBLE);
                    button3.setVisibility(View.VISIBLE);
                    buttonNext.setVisibility(View.INVISIBLE);
                    button1.setBackgroundColor(Color.parseColor(colorPrimaryDark));
                    button2.setBackgroundColor(Color.parseColor(colorPrimaryDark));
                    button3.setBackgroundColor(Color.parseColor(colorPrimaryDark));

                    heading.setText("Who is this?");
                    heading.setTextColor(Color.parseColor(colorPrimaryDark));

                    loadRound(images);
                }
            }
        });
    }

    public void setupGame(){
        //this is the folder with the images that have been captured via the app
        String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pictures/PhotoApp/";
        allFilesPaths = new ArrayList<>();
        allFilesPaths = listAllFiles(path);
        images = prepareData();

        Collections.shuffle(images);
        count = 0;

        if(images.size()<3){
            Toast.makeText(PictureGame.this, "Please add at least 3 pictures before starting the game!" , Toast.LENGTH_SHORT).show();

            Intent myIntent = new Intent(PictureGame.this, PictureMenuActivity.class);
            PictureGame.this.startActivity(myIntent);
        }
        else{
            loadRound(images);

        }


        /*for (Cell c : images) {
            loadRound(images, count);
            count++;
        }*/
    }


    private void loadRound(ArrayList<Cell> images){
        ArrayList<String> imageNames = new ArrayList<String>();
        String answer, dummy1 = "", dummy2 = "";
        String[] splitTemp;
        int randomTemp = -1, dummy1Int = -1, dummy2Int = -1;

        //display answer's picture
        setImageFromPath(images.get(count).getPath(), imageView);

        //get answer
        splitTemp = images.get(count).getTitle().split("_");
        answer = splitTemp[0];

        imageNames.add(answer);
        answerText = answer;


        //get dummy answers
        while(dummy2.equals("")){

            //keep on generating random number until it isn't equal to our answer's or dummy1's array pos
            do{
                randomTemp = (int) (Math.random() * images.size());

            }while(randomTemp == count || randomTemp == dummy1Int);

            if(dummy1Int != -1 && dummy2Int == -1){
                dummy2Int = randomTemp;

                //get dummy2
                splitTemp = images.get(randomTemp).getTitle().split("_");
                dummy2 = splitTemp[0];
            }

            if(dummy1Int == -1){
                dummy1Int = randomTemp;

                //get dummy1
                splitTemp = images.get(randomTemp).getTitle().split("_");
                dummy1 = splitTemp[0];
            }
        }
        imageNames.add(dummy1);
        imageNames.add(dummy2);
        Collections.shuffle(imageNames);

        button1.setText(imageNames.get(0));
        button2.setText(imageNames.get(1));
        button3.setText(imageNames.get(2));

        count++;
    }

    //load all files from the folder
    private List<Cell> listAllFiles(String pathName) {
        List<Cell> allFiles = new ArrayList<>();
        File file = new File(pathName);
        File[] files = file.listFiles();
        if(files != null) {
            for (File f : files) {
                Cell cell = new Cell();
                cell.setTitle(f.getName());
                cell.setPath(f.getAbsolutePath());
                allFiles.add(cell);
            }
        }
        return  allFiles;
    }
    //TODO these two methods are very similar and can probably be merged

    //prepare the images for the array list
    public ArrayList<Cell> prepareData(){
        ArrayList<Cell> allImages = new ArrayList<>();
        for(Cell c : allFilesPaths) {
            Cell cell = new Cell();
            cell.setTitle(c.getTitle());
            cell.setPath(c.getPath());
            allImages.add(cell);
        }
        return allImages;
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
