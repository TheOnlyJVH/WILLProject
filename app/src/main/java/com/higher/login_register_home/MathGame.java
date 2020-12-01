package com.higher.login_register_home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.higher.login_register_home.Message.AnswerDisplay;

import java.util.ArrayList;
import java.util.Random;

public class MathGame extends AppCompatActivity
{

    int max = 0, level = 0;
    boolean plus = false, minus = false, times = false, divide = false;
    private Random rand  = new Random();
    private Button topLeft,topRight,bottomLeft,bottomRight;
    private QuestAndAns temp =  createQuestionAndAnswers();
    int correctAnswerCount, count = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_game);

        topLeft = findViewById(R.id.topLeft);
        topRight = findViewById(R.id.topRight);
        bottomLeft = findViewById(R.id.bottomLeft);
        bottomRight = findViewById(R.id.bottomRight);

        level = getIntent().getIntExtra("Level", 0);

        topLeft.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                answerCheck(String.valueOf(topLeft.getText()));
            }
        });

        topRight.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                answerCheck(String.valueOf(topRight.getText()));
            }
        });

        bottomLeft.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                answerCheck(String.valueOf(bottomLeft.getText()));
            }
        });

        bottomRight.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                answerCheck(String.valueOf(bottomRight.getText()));
            }
        });

        update();
    }

    private void answerCheck(String answer)
    {
        count++;

        final AnswerDisplay messageBox = new AnswerDisplay();
        final AnswerDisplay messageBoxEnd = new AnswerDisplay();

        if(count > 5)
        {
            messageBoxEnd.setTitle("Final Score");
            messageBoxEnd.setMessage("Well Done!" + "\n" + "Your score is: "  + correctAnswerCount + " out of 5!"  + "!");
            messageBoxEnd.showNow(getSupportFragmentManager(), "messageBox");
            messageBoxEnd.getDialog().setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialogInterface)
                {
                    startActivity(new Intent(MathGame.this, MathMenuActivity.class));
                }
            });
        }
        else
        {
            if(answer.compareTo(String.valueOf(temp.answer)) == 0)//checks if the button selected is correct
            {
                correctAnswerCount++;
                messageBox.setTitle("Correct!");
                messageBox.setMessage("Well Done!" + "\n" + "The answer was " + temp.answer + "!");

            }
            else
            {
                messageBox.setTitle("Incorrect");
                messageBox.setMessage("Well Tried!" + "\n" + "The answer was " + temp.answer + "!");
            }

            messageBox.showNow(getSupportFragmentManager(), "messageBox");
            messageBox.getDialog().setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialogInterface)
                {
                    update();
                }
            });
        }


    }

    //updates the players page with new answers and question
    private void update()
    {
        temp =  createQuestionAndAnswers();

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
        topLeft.setBackgroundResource(colors.get(color1));
        colors.remove(color1);
        topLeft.setText(String.valueOf(choices.get(num1)));
        choices.remove(num1);


        int color2 = rand.nextInt(colors.size());
        int num2 = rand.nextInt(choices.size());
        topRight.setBackgroundResource(colors.get(color2));
        colors.remove(color2);
        topRight.setText(String.valueOf(choices.get(num2)));//temp.getWrongAnswers()
        choices.remove(num2);


        int color3 = rand.nextInt(colors.size());
        int num3 = rand.nextInt(choices.size());
        bottomLeft.setBackgroundResource(colors.get(color3));
        colors.remove(color3);
        bottomLeft.setText(String.valueOf(choices.get(num3)));//temp.getWrongAnswers()
        choices.remove(num3);


        int color4 = rand.nextInt(colors.size());
        int num4 = rand.nextInt(choices.size());
        bottomRight.setBackgroundResource(colors.get(color4));
        colors.remove(color4);
        bottomRight.setText(String.valueOf(choices.get(num4)));//temp.getWrongAnswers()
        choices.remove(num4);
    }


    public QuestAndAns createQuestionAndAnswers()
    {
        if(level == 0)
        {
            max = 10;
            plus = true;
            minus = true;
        }

        if(level == 1)
        {
            max = 40;
            plus = true;
            minus = true;
        }

        if(level == 2)
        {
            max = 60;
            max = 100;
            plus = true;
            minus = true;
            times =true;
        }

        if(level == 3)
        {
            max = 80;
            max = 100;
            plus = true;
            minus = true;
            times =true;
        }

        if(level == 4)
        {
            max = 100;
            plus = true;
            minus = true;
            times =true;
            divide = true;
        }

        String quest = " ";
        int num1 = rand.nextInt((max) + 1);
        int num2 = rand.nextInt((max) + 1);
        double answer = 0.0;

        ArrayList<Character> operators = new ArrayList<Character>();


        if (plus = true) {
            operators.add('+');
        }

        if (minus = true) {
            operators.add('-');
        }

        if (times = true) {
            operators.add('x');
        }

        if (divide = true) {
            operators.add('÷');
        }


        int randOp = rand.nextInt(operators.size());

        switch (randOp) {
            case 0:
                answer = (double) num1 + num2;
                break;
            case 1:
                if (level == 1) {
                    if (num1 - num2 < 0) {
                        int temp = num1;
                        num1 = num2;
                        num2 = temp;
                    }
                }
                answer = (double) num1 - num2;//make sure not negitive if level is 1
                break;
            case 2:
                answer = (double) num1 * num2;
                break;
            case 3:
                while (num1 == 0) {
                    num1 = rand.nextInt((max) + 1);
                }

                while (num2 == 0) {
                    num2 = rand.nextInt((max) + 1);
                }

                while (num1 % num2 != 0) {
                    num2 = rand.nextInt((max) + 1);
                }

                answer = (double) num1 / num2;//make sure no decimals if level is 1
                break;
        }

        quest = String.valueOf(num1)
                + " "
                + String.valueOf(operators.get(randOp))
                + " "
                + String.valueOf(num2)
                + " =";

        QuestAndAns q = new QuestAndAns();
        q.setAnswer((int) answer);
        q.setQuestion(quest);

        return q;
    }
}