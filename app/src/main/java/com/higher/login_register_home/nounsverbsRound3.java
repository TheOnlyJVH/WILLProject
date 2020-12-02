package com.higher.login_register_home;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.higher.login_register_home.Message.AnswerDisplay;

public class nounsverbsRound3 extends AppCompatActivity {
    ImageButton image1,image2,image3,image4,image5,image6;

    Button round;

    int num = 0;
    int count = 0;
    int points = 0;
    int gameOver = 0;

    EditText questionWord;

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
        setContentView(R.layout.activity_nounsverbsround3);

        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);

        image5 = findViewById(R.id.image5);
        image6 = findViewById(R.id.image6);

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



        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count == 2){
                    final Drawable d = getResources().getDrawable(nouns[num+2]);
                    final Drawable a = getResources().getDrawable(verbs[num+2]);
                    final Drawable b = getResources().getDrawable(verbs[num+2]);
                    final Drawable c = getResources().getDrawable(nouns[num+2]);

                    image1.setImageDrawable(d);
                    image2.setImageDrawable(a);
                    image3.setImageDrawable(b);
                    image4.setImageDrawable(c);
                    questionWord.setText(question[0]);
                    count = 0;
                    gameOver++;
                }
                else if(count != 2){
                    if (String.valueOf(image1.getTag()).equals(questionWord.getText().toString())){
                        AnswerDisplay dialog = new AnswerDisplay();
                        dialog.setTitle("Correct");
                        dialog.setMessage("Well done!, the answer was " + questionWord.getText());
                        dialog.show(getSupportFragmentManager(), "MyDialogFragmentTag");
                        points++;
                        count++;
                    }
                    else{
                        AnswerDisplay dialog = new AnswerDisplay();
                        dialog.setTitle("Incorrect");
                        dialog.setMessage("Correct answer was: " + questionWord.getText().toString());
                        dialog.show(getSupportFragmentManager(), "MyDialogFragmentTag");
                        count++;
                    }
                }
                else if(gameOver ==  5){
                    AnswerDisplay dialog = new AnswerDisplay();
                    dialog.setTitle("GAME OVER");
                    dialog.setMessage("Well done, your score is  " + points);
                    dialog.show(getSupportFragmentManager(), "MyDialogFragmentTag");
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after 5s = 5000ms
                            startActivity(new Intent(nounsverbsRound3.this, nounsverbsMenu.class));
                        }
                    }, 4000);// end of handler
                }
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count == 2){
                    final Drawable d = getResources().getDrawable(nouns[num+2]);
                    final Drawable a = getResources().getDrawable(verbs[num+2]);
                    final Drawable b = getResources().getDrawable(verbs[num+2]);
                    final Drawable c = getResources().getDrawable(nouns[num+2]);

                    image1.setImageDrawable(d);
                    image2.setImageDrawable(a);
                    image3.setImageDrawable(b);
                    image4.setImageDrawable(c);
                    questionWord.setText(question[0]);
                    count = 0;
                    gameOver++;
                }
                else if(count != 2){
                    if (String.valueOf(image2.getTag()).equals(questionWord.getText().toString())){
                        AnswerDisplay dialog = new AnswerDisplay();
                        dialog.setTitle("Correct");
                        dialog.setMessage("Well done!, the answer was " + questionWord.getText());
                        dialog.show(getSupportFragmentManager(), "MyDialogFragmentTag");
                        points++;
                        count++;
                    }
                    else{
                        AnswerDisplay dialog = new AnswerDisplay();
                        dialog.setTitle("Incorrect");
                        dialog.setMessage("Correct answer was: " + questionWord.getText().toString());
                        dialog.show(getSupportFragmentManager(), "MyDialogFragmentTag");
                        count++;
                    }
                }
                else if(gameOver ==  5){
                    AnswerDisplay dialog = new AnswerDisplay();
                    dialog.setTitle("GAME OVER");
                    dialog.setMessage("Well done, your score is  " + points);
                    dialog.show(getSupportFragmentManager(), "MyDialogFragmentTag");
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after 5s = 5000ms
                            startActivity(new Intent(nounsverbsRound3.this, nounsverbsMenu.class));
                        }
                    }, 4000);// end of handler
                }
            }
        });

        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count == 2){
                    final Drawable d = getResources().getDrawable(nouns[num+2]);
                    final Drawable a = getResources().getDrawable(verbs[num+2]);
                    final Drawable b = getResources().getDrawable(verbs[num+2]);
                    final Drawable c = getResources().getDrawable(nouns[num+2]);

                    image1.setImageDrawable(d);
                    image2.setImageDrawable(a);
                    image3.setImageDrawable(b);
                    image4.setImageDrawable(c);
                    questionWord.setText(question[0]);
                    count = 0;
                    gameOver++;
                }
                else if(count != 2){
                    if (String.valueOf(image3.getTag()).equals(questionWord.getText().toString())){
                        AnswerDisplay dialog = new AnswerDisplay();
                        dialog.setTitle("Correct");
                        dialog.setMessage("Well done!, the answer was " + questionWord.getText());
                        dialog.show(getSupportFragmentManager(), "MyDialogFragmentTag");
                        points++;
                        count++;
                    }
                    else{
                        AnswerDisplay dialog = new AnswerDisplay();
                        dialog.setTitle("Incorrect");
                        dialog.setMessage("Correct answer was: " + questionWord.getText().toString());
                        dialog.show(getSupportFragmentManager(), "MyDialogFragmentTag");
                        count++;
                    }
                }
                else if(gameOver ==  5){
                    AnswerDisplay dialog = new AnswerDisplay();
                    dialog.setTitle("GAME OVER");
                    dialog.setMessage("Well done, your score is  " + points);
                    dialog.show(getSupportFragmentManager(), "MyDialogFragmentTag");
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after 5s = 5000ms
                            startActivity(new Intent(nounsverbsRound3.this, nounsverbsMenu.class));
                        }
                    }, 4000);// end of handler
                }
            }
        });

        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count == 2){
                    final Drawable d = getResources().getDrawable(nouns[num+2]);
                    final Drawable a = getResources().getDrawable(verbs[num+2]);
                    final Drawable b = getResources().getDrawable(verbs[num+2]);
                    final Drawable c = getResources().getDrawable(nouns[num+2]);

                    image1.setImageDrawable(d);
                    image2.setImageDrawable(a);
                    image3.setImageDrawable(b);
                    image4.setImageDrawable(c);
                    questionWord.setText(question[0]);
                    count = 0;
                    gameOver++;
                }
                else if(count != 2){
                    if (String.valueOf(image4.getTag()).equals(questionWord.getText().toString())){
                        AnswerDisplay dialog = new AnswerDisplay();
                        dialog.setTitle("Correct");
                        dialog.setMessage("Well done!, the answer was " + questionWord.getText());
                        dialog.show(getSupportFragmentManager(), "MyDialogFragmentTag");
                        points++;
                        count++;
                    }
                    else{
                        AnswerDisplay dialog = new AnswerDisplay();
                        dialog.setTitle("Incorrect");
                        dialog.setMessage("Correct answer was: " + questionWord.getText().toString());
                        dialog.show(getSupportFragmentManager(), "MyDialogFragmentTag");
                        count++;
                    }
                }
                else if(gameOver ==  5){
                    AnswerDisplay dialog = new AnswerDisplay();
                    dialog.setTitle("GAME OVER");
                    dialog.setMessage("Well done, your score is  " + points);
                    dialog.show(getSupportFragmentManager(), "MyDialogFragmentTag");
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after 5s = 5000ms
                            startActivity(new Intent(nounsverbsRound3.this, nounsverbsMenu.class));
                        }
                    }, 4000);// end of handler
                }
            }
        });

        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count == 2){
                    final Drawable d = getResources().getDrawable(nouns[num+2]);
                    final Drawable a = getResources().getDrawable(verbs[num+2]);
                    final Drawable b = getResources().getDrawable(verbs[num+2]);
                    final Drawable c = getResources().getDrawable(nouns[num+2]);

                    image1.setImageDrawable(d);
                    image2.setImageDrawable(a);
                    image3.setImageDrawable(b);
                    image4.setImageDrawable(c);
                    questionWord.setText(question[0]);
                    count = 0;
                    gameOver++;
                }
                else if(count != 2){
                    if (String.valueOf(image5.getTag()).equals(questionWord.getText().toString())){
                        AnswerDisplay dialog = new AnswerDisplay();
                        dialog.setTitle("Correct");
                        dialog.setMessage("Well done!, the answer was " + questionWord.getText());
                        dialog.show(getSupportFragmentManager(), "MyDialogFragmentTag");
                        points++;
                        count++;
                    }
                    else{
                        AnswerDisplay dialog = new AnswerDisplay();
                        dialog.setTitle("Incorrect");
                        dialog.setMessage("Correct answer was: " + questionWord.getText().toString());
                        dialog.show(getSupportFragmentManager(), "MyDialogFragmentTag");
                        count++;
                    }
                }
                else if(gameOver ==  5){
                    AnswerDisplay dialog = new AnswerDisplay();
                    dialog.setTitle("GAME OVER");
                    dialog.setMessage("Well done, your score is  " + points);
                    dialog.show(getSupportFragmentManager(), "MyDialogFragmentTag");
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after 5s = 5000ms
                            startActivity(new Intent(nounsverbsRound3.this, nounsverbsMenu.class));
                        }
                    }, 4000);// end of handler
                }
            }
        });

        image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count == 2){
                    final Drawable d = getResources().getDrawable(nouns[num+2]);
                    final Drawable a = getResources().getDrawable(verbs[num+2]);
                    final Drawable b = getResources().getDrawable(verbs[num+2]);
                    final Drawable c = getResources().getDrawable(nouns[num+2]);;

                    image1.setImageDrawable(d);
                    image2.setImageDrawable(a);
                    image3.setImageDrawable(b);
                    image4.setImageDrawable(c);
                    questionWord.setText(question[0]);
                    count = 0;
                    gameOver++;
                }
                else if(count != 2){
                    if (String.valueOf(image6.getTag()).equals(questionWord.getText().toString())){
                        AnswerDisplay dialog = new AnswerDisplay();
                        dialog.setTitle("Correct");
                        dialog.setMessage("Well done!, the answer was " + questionWord.getText());
                        dialog.show(getSupportFragmentManager(), "MyDialogFragmentTag");
                        points++;
                        count++;
                    }
                    else{
                        AnswerDisplay dialog = new AnswerDisplay();
                        dialog.setTitle("Incorrect");
                        dialog.setMessage("Correct answer was: " + questionWord.getText().toString());
                        dialog.show(getSupportFragmentManager(), "MyDialogFragmentTag");
                        count++;
                    }
                }
                else if(gameOver ==  5){
                    AnswerDisplay dialog = new AnswerDisplay();
                    dialog.setTitle("GAME OVER");
                    dialog.setMessage("Well done, your score is  " + points);
                    dialog.show(getSupportFragmentManager(), "MyDialogFragmentTag");
                    startActivity(new Intent(nounsverbsRound3.this, nounsverbsMenu.class));
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after 5s = 5000ms
                            startActivity(new Intent(nounsverbsRound3.this, nounsverbsMenu.class));
                        }
                    }, 4000);// end of handler
                }
            }
        });



    }
}