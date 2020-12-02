package com.higher.login_register_home;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.higher.login_register_home.Message.AnswerDisplay;

import java.util.Arrays;

public class nounsverbsRound1 extends AppCompatActivity {
    Button noun, verb, menu;
    ImageView image;

    int count = 0;
    int num = 0;
    int points = 0;
    int gameOver = 0;
    EditText word, round;

    View v;

    int[] pics = {
            R.drawable.a,
            R.drawable.e,
            R.drawable.d,
            R.drawable.b,
            R.drawable.c,
            R.drawable.f,
            R.drawable.teaching,
            R.drawable.dog,
            R.drawable.playing,
            R.drawable.lion,
            R.drawable.shouting,
            R.drawable.flowers,
            R.drawable.apples,
            R.drawable.reading


    };//pics to be displayed

     Drawable d;

    String[] questions = {
            "TABLE",
            "CHAIR",
            "SUN",
            "RUN",
            "STEALING",
            "WALKING",
            "TEACHING",
            "DOG",
            "PLAYING",
            "LION",
            "SHOUTING" ,
            "FLOWERS" ,
            "APPLES",
            "READING"


    };//Contains all the words for parallel array


    String[] verbNouns = {
            "NOUN",
            "NOUN",
            "NOUN",
            "VERB",
            "VERB",
            "VERB"
    };//Contains all the words for parallel array

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nounsverbsround1);

        v = this.getWindow().getDecorView();


        noun = findViewById(R.id.btnNoun);
        verb = findViewById(R.id.btnVerb);
        //previous = findViewById(R.id.previous);
        round = findViewById(R.id.round);

        //next = findViewById(R.id.next);
        word = findViewById(R.id.word);
        image = findViewById(R.id.image);

        noun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(gameOver == 5){
                   AnswerDisplay dialog = new AnswerDisplay();
                   dialog.setTitle("GAME OVER");
                   dialog.setMessage("Well done, your score is  " + points);
                   dialog.show(getSupportFragmentManager(), "MyDialogFragmentTag");
                   final Handler handler = new Handler();
                   handler.postDelayed(new Runnable() {
                       @Override
                       public void run() {
                           // Do something after 5s = 5000ms
                           startActivity(new Intent(nounsverbsRound1.this, nounsverbsMenu.class));
                       }
                   }, 4000);// end of handler
               }
               else{
                   int indexWord = Arrays.asList(questions).indexOf(word.getText().toString());


                   if (verbNouns[indexWord] == "NOUN"){
                       round.setVisibility(View.VISIBLE);
                       AnswerDisplay dialog = new AnswerDisplay();
                       dialog.setTitle("Correct");
                       dialog.setMessage("Well done!");
                       dialog.show(getSupportFragmentManager(), "MyDialogFragmentTag");

                       points++;
                       gameOver++;

                       // Do something after 5s = 5000ms
                       word.setText(questions[count++]);
                       d = getResources().getDrawable(pics[num+1]);
                       image.setImageDrawable(d);
                   }
                   else{
                       AnswerDisplay dialog = new AnswerDisplay();
                       dialog.setTitle("Incorrect");
                       dialog.setMessage("The answer was noun");
                       dialog.show(getSupportFragmentManager(), "MyDialogFragmentTag");;
                       verb.setBackgroundColor(Color.GREEN);
                       final Handler handler = new Handler();
                       handler.postDelayed(new Runnable() {
                           @Override
                           public void run() {
                               // Do something after 5s = 5000ms
                               d = getResources().getDrawable(pics[num+1]);
                               image.setImageDrawable(d);
                               verb.setBackgroundColor(Color.YELLOW);
                               word.setText(questions[count++]);
                               gameOver++;
                           }
                       }, 3000);// end of handler

                   }//end of ifelse
               }
            }


        });//end of button


        verb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gameOver == 5){
                    AnswerDisplay dialog = new AnswerDisplay();
                    dialog.setTitle("GAME OVER");
                    dialog.setMessage("Well done, your score is  " + points);
                    dialog.show(getSupportFragmentManager(), "MyDialogFragmentTag");
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after 5s = 5000ms
                            startActivity(new Intent(nounsverbsRound1.this, nounsverbsMenu.class));
                        }
                    }, 4000);// end of handler
                }
                else{
                    int indexWord = Arrays.asList(questions).indexOf(word.getText().toString());

                    if (verbNouns[indexWord] == "VERB"){
                        round.setVisibility(View.VISIBLE);

                        AnswerDisplay dialog = new AnswerDisplay();
                        dialog.setTitle("Correct");
                        dialog.setMessage("Well done!");
                        dialog.show(getSupportFragmentManager(), "MyDialogFragmentTag");

                        gameOver++;
                        points++;
                        // Do something after 5s = 5000ms
                        d = getResources().getDrawable(pics[num+1]);
                        image.setImageDrawable(d);
                        word.setText(questions[count++]);
                        verb.setBackgroundColor(Color.YELLOW);
                    }
                    else{
                        AnswerDisplay dialog = new AnswerDisplay();
                        dialog.setTitle("Incorrect");
                        dialog.setMessage("The answer was noun");
                        dialog.show(getSupportFragmentManager(), "MyDialogFragmentTag");;
                        noun.setBackgroundColor(Color.GREEN);

                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // Do something after 5s = 5000ms
                                d = getResources().getDrawable(pics[num+1]);
                                image.setImageDrawable(d);
                                word.setText(questions[count++]);
                                noun.setBackgroundColor(Color.YELLOW);
                                gameOver++;
                            }
                        }, 3000);// end of handler
                    }//end of ifelse
                }
            }//end of button
        });

    }
}