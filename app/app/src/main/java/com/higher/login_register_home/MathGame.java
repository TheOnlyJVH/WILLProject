package com.higher.login_register_home;

import java.util.ArrayList;
import java.util.Random;

public class MathGame
{

    int max = 0, level = 0;
    boolean plus = false, minus = false, times = false, divide = false;
    Random rand  = new Random();

    //level selector level = size of number
    public void setLevel(int level)
    {
        this.level = level;
        if(level == 1)
        {
            max = 10;
        }

        if(level == 2)
        {
            max = 50;
        }

        if(level == 3)
        {
            max = 100;
        }
    }

    //choose which operations can be used
    public void setOperator(boolean plus, boolean minus, boolean times, boolean divide)
    {
        this.plus = plus;
        this.minus= minus;
        this.times = times;
        this.divide = divide;
    }

    public QuestAndAns createQuestionAndAnswers() {
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
