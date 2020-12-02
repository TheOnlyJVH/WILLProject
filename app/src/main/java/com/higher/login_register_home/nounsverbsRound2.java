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

public class nounsverbsRound2 extends AppCompatActivity {

    Button word1, word2, word3,word4;
    ImageView image1,image2,image3,image4;

    int num = 0;
    int gameOver = 0;
    int check = 0;

    EditText questionWord;

    int points = 0;

    int[] nouns = {
            R.drawable.a,
            R.drawable.e,
            R.drawable.d,
            R.drawable.dog,
            R.drawable.lion,
            R.drawable.flowers,
            R.drawable.apples

    };//pics to be displayed

    int[] verbs = {
            R.drawable.b,
            R.drawable.c,
            R.drawable.f,
            R.drawable.reading,
            R.drawable.playing,
            R.drawable.shouting,
            R.drawable.teaching

    };

    String[] question = {
            "NOUN",
            "VERB"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nounsverbsround2);

        word1 = findViewById(R.id.word1);
        word2 = findViewById(R.id.word2);
        word3 = findViewById(R.id.word3);
        word4 = findViewById(R.id.word4);

        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        questionWord = findViewById(R.id.questionWord);

        final Drawable d = getResources().getDrawable(nouns[num]);
        final Drawable a = getResources().getDrawable(verbs[num]);
        final Drawable b = getResources().getDrawable(verbs[num+1]);
        final Drawable c = getResources().getDrawable(nouns[num+1]);

        image1.setImageDrawable(d);
        image2.setImageDrawable(a);
        image3.setImageDrawable(b);
        image4.setImageDrawable(c);

        questionWord.setText(question[0]);




      word1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
             if(check != 2){
                 if (word1.getText().toString().equals(questionWord.getText().toString())){
                     word1.setBackgroundColor(Color.GREEN);
                     AnswerDisplay dialog = new AnswerDisplay();
                     dialog.setTitle("Correct");
                     dialog.setMessage("Well done!");
                     dialog.show(getSupportFragmentManager(), "MyDialogFragmentTag");
                     check++;
                     points++;
                 }
                 else{
                     AnswerDisplay dialog = new AnswerDisplay();
                     dialog.setTitle("Incorrect");
                     dialog.setMessage("Correct answer was: " + questionWord.getText().toString());
                     dialog.show(getSupportFragmentManager(), "MyDialogFragmentTag");
                     word1.setBackgroundColor(Color.RED);
             }
              }
             else if(check==2){
                 final Handler handler = new Handler();
                 handler.postDelayed(new Runnable() {
                     @Override
                     public void run() {
                         final Drawable d = getResources().getDrawable(nouns[num+2]);
                         final Drawable a = getResources().getDrawable(verbs[num+2]);
                         final Drawable b = getResources().getDrawable(verbs[num+2]);
                         final Drawable c = getResources().getDrawable(nouns[num+2]);

                         image1.setImageDrawable(d);
                         image2.setImageDrawable(a);
                         image3.setImageDrawable(b);
                         image4.setImageDrawable(c);

                         word1.setBackgroundColor(Color.BLUE);
                         word2.setBackgroundColor(Color.YELLOW);
                         word3.setBackgroundColor(Color.MAGENTA);
                         word4.setBackgroundColor(Color.CYAN);
                         gameOver++;
                     }
                 }, 4000);// end of handler
             }
             else if(gameOver == 5){
                 AnswerDisplay dialog = new AnswerDisplay();
                 dialog.setTitle("GAME OVER");
                 dialog.setMessage("Well done, your score is  " + points);
                 dialog.show(getSupportFragmentManager(), "MyDialogFragmentTag");
                 final Handler handler = new Handler();
                 handler.postDelayed(new Runnable() {
                     @Override
                     public void run() {
                         // Do something after 5s = 5000ms
                         startActivity(new Intent(nounsverbsRound2.this, nounsverbsMenu.class));
                     }
                 }, 4000);// end of handler
             }
          }
      });

        word2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check != 2){
                    if (word2.getText().toString().equals(questionWord.getText().toString())){
                        word2.setBackgroundColor(Color.GREEN);
                        AnswerDisplay dialog = new AnswerDisplay();
                        dialog.setTitle("Correct");
                        dialog.setMessage("Well done!");
                        dialog.show(getSupportFragmentManager(), "MyDialogFragmentTag");
                        check++;
                        points++;
                    }
                    else{
                        AnswerDisplay dialog = new AnswerDisplay();
                        dialog.setTitle("Incorrect");
                        dialog.setMessage("Correct answer was: " + questionWord.getText().toString());
                        dialog.show(getSupportFragmentManager(), "MyDialogFragmentTag");
                        word2.setBackgroundColor(Color.RED);
                    }
                }
                else if(check==2){
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            final Drawable d = getResources().getDrawable(nouns[num+2]);
                            final Drawable a = getResources().getDrawable(verbs[num+2]);
                            final Drawable b = getResources().getDrawable(verbs[num+2]);
                            final Drawable c = getResources().getDrawable(nouns[num+2]);

                            image1.setImageDrawable(d);
                            image2.setImageDrawable(a);
                            image3.setImageDrawable(b);
                            image4.setImageDrawable(c);

                            word1.setBackgroundColor(Color.BLUE);
                            word2.setBackgroundColor(Color.YELLOW);
                            word3.setBackgroundColor(Color.MAGENTA);
                            word4.setBackgroundColor(Color.CYAN);
                            gameOver++;
                        }
                    }, 4000);// end of handler
                }
                else if(gameOver == 5){
                    AnswerDisplay dialog = new AnswerDisplay();
                    dialog.setTitle("GAME OVER");
                    dialog.setMessage("Well done, your score is  " + points);
                    dialog.show(getSupportFragmentManager(), "MyDialogFragmentTag");
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after 5s = 5000ms
                            startActivity(new Intent(nounsverbsRound2.this, nounsverbsMenu.class));
                        }
                    }, 4000);// end of handler
                }
            }
        });

        word3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check != 2){
                    if (word3.getText().toString().equals(questionWord.getText().toString())){
                        word3.setBackgroundColor(Color.GREEN);
                        AnswerDisplay dialog = new AnswerDisplay();
                        dialog.setTitle("Correct");
                        dialog.setMessage("Well done!");
                        dialog.show(getSupportFragmentManager(), "MyDialogFragmentTag");
                        check++;
                        points++;
                    }
                    else{
                        AnswerDisplay dialog = new AnswerDisplay();
                        dialog.setTitle("Incorrect");
                        dialog.setMessage("Correct answer was: " + questionWord.getText().toString());
                        dialog.show(getSupportFragmentManager(), "MyDialogFragmentTag");
                        word3.setBackgroundColor(Color.RED);
                    }
                }
                else if(check==2){
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            final Drawable d = getResources().getDrawable(nouns[num+2]);
                            final Drawable a = getResources().getDrawable(verbs[num+2]);
                            final Drawable b = getResources().getDrawable(verbs[num+2]);
                            final Drawable c = getResources().getDrawable(nouns[num+2]);

                            image1.setImageDrawable(d);
                            image2.setImageDrawable(a);
                            image3.setImageDrawable(b);
                            image4.setImageDrawable(c);

                            word1.setBackgroundColor(Color.BLUE);
                            word2.setBackgroundColor(Color.YELLOW);
                            word3.setBackgroundColor(Color.MAGENTA);
                            word4.setBackgroundColor(Color.CYAN);
                            gameOver++;
                        }
                    }, 4000);// end of handler
                }
                else if(gameOver == 5){
                    AnswerDisplay dialog = new AnswerDisplay();
                    dialog.setTitle("GAME OVER");
                    dialog.setMessage("Well done, your score is  " + points);
                    dialog.show(getSupportFragmentManager(), "MyDialogFragmentTag");
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after 5s = 5000ms
                            startActivity(new Intent(nounsverbsRound2.this, nounsverbsMenu.class));
                        }
                    }, 4000);// end of handler
                }
            }
        });

        word4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check != 2){
                    if (word4.getText().toString().equals(questionWord.getText().toString())){
                        word4.setBackgroundColor(Color.GREEN);
                        AnswerDisplay dialog = new AnswerDisplay();
                        dialog.setTitle("Correct");
                        dialog.setMessage("Well done!");
                        dialog.show(getSupportFragmentManager(), "MyDialogFragmentTag");
                        check++;

                        points++;
                    }
                    else{
                        AnswerDisplay dialog = new AnswerDisplay();
                        dialog.setTitle("Incorrect");
                        dialog.setMessage("Correct answer was: " + questionWord.getText().toString());
                        dialog.show(getSupportFragmentManager(), "MyDialogFragmentTag");
                        word4.setBackgroundColor(Color.RED);
                    }
                }
                else if(check==2){
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            final Drawable d = getResources().getDrawable(nouns[num+2]);
                            final Drawable a = getResources().getDrawable(verbs[num+2]);
                            final Drawable b = getResources().getDrawable(verbs[num+2]);
                            final Drawable c = getResources().getDrawable(nouns[num+2]);

                            image1.setImageDrawable(d);
                            image2.setImageDrawable(a);
                            image3.setImageDrawable(b);
                            image4.setImageDrawable(c);

                            word1.setBackgroundColor(Color.BLUE);
                            word2.setBackgroundColor(Color.YELLOW);
                            word3.setBackgroundColor(Color.MAGENTA);
                            word4.setBackgroundColor(Color.CYAN);
                            gameOver++;
                        }
                    }, 4000);// end of handler
                }
                else if(gameOver == 5){
                    AnswerDisplay dialog = new AnswerDisplay();
                    dialog.setTitle("GAME OVER");
                    dialog.setMessage("Well done, your score is  " + points);
                    dialog.show(getSupportFragmentManager(), "MyDialogFragmentTag");
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after 5s = 5000ms
                            startActivity(new Intent(nounsverbsRound2.this, nounsverbsMenu.class));
                        }
                    }, 4000);// end of handler
                }
            }
        });



    }
}