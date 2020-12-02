package com.higher.login_register_home.Adapters;

import android.content.Context;

import com.higher.login_register_home.Objects.QuestionObject;
import com.higher.login_register_home.Objects.QuestionObject;
import com.higher.login_register_home.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DifficultyAdapter {

    public List<QuestionObject> generateQuestion(int difficulty, Context This) {
        int numQuestionsEasy;
        int numQuestionsHard;
        int numPosAnswers;
        List<QuestionObject> levelPrep = new ArrayList<>();
        List<String> shapeArray = generateShapeArrayEasy();
        List<Integer> imageArray = generateEasyImagesArray();
        Random random = new Random();

        switch (difficulty) {
            case 1:
                numQuestionsEasy = 3;
                numQuestionsHard = 0;
                numPosAnswers = 4;
                break;

            case 2:
            case 3:
            case 4:
                numQuestionsEasy = 5;
                numQuestionsHard = 0;
                numPosAnswers = 4;
                break;

            case 5:
                numQuestionsEasy = 2;
                numQuestionsHard = 5;
                numPosAnswers = 4;
                break;

            default:
                numQuestionsEasy = 0;
                numQuestionsHard = 0;
                numPosAnswers = 0;
                break;
        }

        String correctShape = "";
        Integer imgLink = 0;
        int imgPos;
        Boolean flag = false;
        List<Integer> selected = new ArrayList<>();

        for (int i = 0; i < numQuestionsEasy; i++)
        {
            List<String> options = new ArrayList<>();
            options.clear();
            flag = false;

            while (flag == false)
            {
                imgPos = random.nextInt(imageArray.size());
                if (!selected.contains((imgPos)))
                {
                    correctShape = shapeArray.get(imgPos);
                    imgLink = imageArray.get(imgPos);
                    options.add(correctShape);
                    flag = true;
                    selected.add(imgPos);
                }
            }

            for (int j = 0; j < numPosAnswers - 1;) {
                String shape = shapeArray.get(random.nextInt(imageArray.size()));
                if (!options.contains(shape)) {
                    options.add(shape);
                    j++;
                }
            }
            Collections.shuffle(options);
            levelPrep.add(new QuestionObject(correctShape, imgLink, options));
        }

        if (numQuestionsHard > 0)
        {
            shapeArray = generateShapeArrayHard();
            imageArray = generateHardImagesArray();
            selected.clear();

            for (int i = 0; i < numQuestionsHard; i++)
            {
                List<String> options = new ArrayList<>();
                options.clear();
                flag = false;

                while (flag == false)
                {
                    imgPos = random.nextInt(imageArray.size());
                    if (!selected.contains((imgPos)))
                    {
                        correctShape = shapeArray.get(imgPos);
                        imgLink = imageArray.get(imgPos);
                        options.add(correctShape);
                        flag = true;
                        selected.add(imgPos);
                    }
                }

                for (int j = 0; j < numPosAnswers - 1;) {
                    String shape = shapeArray.get(random.nextInt(imageArray.size()));
                    if (!options.contains(shape)) {
                        options.add(shape);
                        j++;
                    }
                }
                Collections.shuffle(options);
                levelPrep.add(new QuestionObject(correctShape, imgLink, options));
            }
        }

        return levelPrep;
    }

    private List<Integer> generateEasyImagesArray() {
        List<Integer> shapeArrayEasy = new ArrayList<>();
        shapeArrayEasy.add(R.drawable.circle);
        shapeArrayEasy.add(R.drawable.triangle);
        shapeArrayEasy.add(R.drawable.square);
        shapeArrayEasy.add(R.drawable.rectangle);
        shapeArrayEasy.add(R.drawable.diamond);
        shapeArrayEasy.add(R.drawable.star);
        return shapeArrayEasy;
    }

    private List<String> generateShapeArrayEasy() {
        List<String> imageArray = new ArrayList<>();
        imageArray.add("Circle");
        imageArray.add("Triangle");
        imageArray.add("Square");
        imageArray.add("Rectangle");
        imageArray.add("Diamond");
        imageArray.add("Star");
        return imageArray;
    }

    private List<Integer> generateHardImagesArray() {
        List<Integer> shapeArrayHard = new ArrayList<>();
        shapeArrayHard.add(R.drawable.pizza);
        shapeArrayHard.add(R.drawable.goldstar);
        shapeArrayHard.add(R.drawable.dice);
        shapeArrayHard.add(R.drawable.rectangleman);
        shapeArrayHard.add(R.drawable.bricks);
        shapeArrayHard.add(R.drawable.greendiamond);
        return shapeArrayHard;
    }

    private List<String> generateShapeArrayHard() {
        List<String> imageArray = new ArrayList<>();
        imageArray.add("Triangle");
        imageArray.add("Star");
        imageArray.add("Square");
        imageArray.add("Rectangle");
        imageArray.add("Rectangle");
        imageArray.add("Diamond");
        return imageArray;
    }
}
