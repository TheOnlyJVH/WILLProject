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
        int numQuestions;
        int numPosAnswers;
        List<QuestionObject> levelPrep = new ArrayList<>();
        List<String> shapeArray = generateShapeArray();
        List<Integer> imageArray = generateImagesArray();
        Random random = new Random();

        switch (difficulty) {
            case 1:
                numQuestions = 3;
                numPosAnswers = 4;
                break;

            case 2:
                numQuestions = 5;
                numPosAnswers = 4;
                break;

            case 3:
                numQuestions = 7;
                numPosAnswers = 6;
                break;

            default:
                numQuestions = 0;
                numPosAnswers = 0;
                break;
        }

        for (int i = 0; i < numQuestions; i++) {
            String correctShape;
            Integer imgLink;
            List<String> options = new ArrayList<>();
            options.clear();

            int imgPos = random.nextInt(imageArray.size());

            correctShape = shapeArray.get(imgPos);
            imgLink = imageArray.get(imgPos);
            options.add(correctShape);

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
        return levelPrep;
    }

    private List<Integer> generateImagesArray() {
        List<Integer> shapeArray = new ArrayList<>();
        shapeArray.add(R.drawable.circle);
        shapeArray.add(R.drawable.triangle);
        shapeArray.add(R.drawable.square);
        shapeArray.add(R.drawable.rectangle);
        shapeArray.add(R.drawable.diamond);
        shapeArray.add(R.drawable.star);
        return shapeArray;
    }

    private List<String> generateShapeArray() {
        List<String> imageArray = new ArrayList<>();
        imageArray.add("Circle");
        imageArray.add("Triangle");
        imageArray.add("Square");
        imageArray.add("Rectangle");
        imageArray.add("Diamond");
        imageArray.add("Star");
        return imageArray;
    }
}
