package com.higher.login_register_home;

import android.graphics.LightingColorFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.higher.login_register_home.MathGame;
import com.higher.login_register_home.QuestAndAns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class MathMenuActivity extends AppCompatActivity
{
    private Random rand  = new Random();
    private Button button1,button2,button3,button4;
    private MathGame m = new MathGame();
    private QuestAndAns temp =  m.createQuestionAndAnswers();


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m.setLevel(1);
        m.setOperator(true,true,true,true);


        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.buttonNext);

        button1.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                if(String.valueOf(button1.getText()).compareTo(String.valueOf(temp.answer)) == 0)
                {
                    Toast.makeText(MathMenuActivity.this, "correct", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MathMenuActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                }

                temp =  m.createQuestionAndAnswers();
                update();
            }
        });

        button2.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                if(String.valueOf(button2.getText()).compareTo(String.valueOf(temp.answer)) == 0)
                {
                    Toast.makeText(MathMenuActivity.this, "correct", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MathMenuActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                }

                temp =  m.createQuestionAndAnswers();
                update();
            }
        });

        button3.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                if(String.valueOf(button3.getText()).compareTo(String.valueOf(temp.answer)) == 0)
                {
                    Toast.makeText(MathMenuActivity.this, "correct", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MathMenuActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                }

                temp =  m.createQuestionAndAnswers();
                update();
            }
        });

        button4.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                if(String.valueOf(button4.getText()).compareTo(String.valueOf(temp.answer)) == 0)
                {
                    Toast.makeText(MathMenuActivity.this, "correct", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MathMenuActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                }

                temp =  m.createQuestionAndAnswers();
                update();
            }
        });

        update();

    }

    private void update()
    {
        ArrayList<Integer> colors = new ArrayList<Integer>();
        colors.add(R.drawable.button_red);
        colors.add(R.drawable.button_green);
        colors.add(R.drawable.button_blue);
        colors.add(R.drawable.button_yello);


        ArrayList<Integer> choices = new ArrayList<Integer>();
        choices.add(temp.getAnswer());
        choices.add(rand.nextInt(100));
        choices.add(rand.nextInt(100));
        choices.add(rand.nextInt(100));

        final TextView question = findViewById(R.id.textView);
        question.setText(temp.getQuestion());

        int color1 = rand.nextInt(colors.size());
        int num1 = rand.nextInt(choices.size());
        button1.setBackgroundResource(colors.get(color1));
        colors.remove(color1);
        button1.setText(String.valueOf(choices.get(num1)));
        choices.remove(num1);


        int color2 = rand.nextInt(colors.size());
        int num2 = rand.nextInt(choices.size());
        button2.setBackgroundResource(colors.get(color2));
        colors.remove(color2);
        button2.setText(String.valueOf(choices.get(num2)));//temp.getWrongAnswers()
        choices.remove(num2);


        int color3 = rand.nextInt(colors.size());
        int num3 = rand.nextInt(choices.size());
        button3.setBackgroundResource(colors.get(color3));
        colors.remove(color3);
        button3.setText(String.valueOf(choices.get(num3)));//temp.getWrongAnswers()
        choices.remove(num3);


        int color4 = rand.nextInt(colors.size());
        int num4 = rand.nextInt(choices.size());
        button4.setBackgroundResource(colors.get(color4));
        colors.remove(color4);
        button4.setText(String.valueOf(choices.get(num4)));//temp.getWrongAnswers()
        choices.remove(num4);
    }

}
