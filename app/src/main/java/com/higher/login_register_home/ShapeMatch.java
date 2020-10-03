package com.higher.login_register_home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.higher.login_register_home.Adapters.DifficultyAdapter;
import com.higher.login_register_home.Adapters.OptionsAdapter;
import com.higher.login_register_home.Objects.QuestionObject;

import java.util.ArrayList;
import java.util.List;

public class ShapeMatch extends AppCompatActivity {

    //Components
    private ImageView imgShape;
    private RecyclerView recOptionList;
    private TextView txtQuestionNumber;
    private ImageButton btnBack;
    private ImageButton btnNext;

    //Variables
    private int currQuestion = 0; //Stores the current question (Defaults to 0).
    private int displayCurrNumber = 1; //The question number displayed to user
    private int totalQuestions = 0; //Stores the max number of questions (Defaults to 0).
    private List<QuestionObject> Questions;
    OptionsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shape_match);

        setVariables(); //Sets all the variables up with their respective components

        //Collects intents
        Intent intent = getIntent();
        totalQuestions = Questions.size();
        int level = intent.getIntExtra("level", 1);

        prepQuestion();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (displayCurrNumber < totalQuestions) {
                    displayCurrNumber += 1;
                    currQuestion += 1;
                    prepQuestion();
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (displayCurrNumber > 1) {
                    displayCurrNumber -= 1;
                    currQuestion -= 1;
                    prepQuestion();
                }
            }
        });
    }

    //Sets all components to a variable.
    public void setVariables()
    {
        imgShape = findViewById(R.id.imgShape);
        recOptionList = findViewById(R.id.recOption);
        txtQuestionNumber = findViewById(R.id.txtQuestionNumber);
        btnBack = findViewById(R.id.btnBack);
        btnNext = findViewById(R.id.btnNext);

        Questions = new ArrayList<>();

        DifficultyAdapter createQuestion = new DifficultyAdapter();
        Questions = createQuestion.generateQuestion(1, this);
    }

    private void prepQuestion()
    {
        imgShape.setImageResource(Questions.get(currQuestion).getLink());
        buildRecyclerView(Questions.get(currQuestion).getOption());
        adapter.notifyDataSetChanged();
        txtQuestionNumber.setText(displayCurrNumber + "/" + totalQuestions);
    }

    private void buildRecyclerView(List<String> option)
    {
        recOptionList.setHasFixedSize(true);
        adapter = new OptionsAdapter(option);

        recOptionList.setLayoutManager(new LinearLayoutManager(this));
        recOptionList.setAdapter(adapter);

        adapter.setOnOptionsClickListener(new OptionsAdapter.onOptionClickListener() {
            @Override
            public void onOptionClick(int position) {
                if (Questions.get(currQuestion).getOption().get(position) == Questions.get(currQuestion).getShape()) {
                    Toast.makeText(ShapeMatch.this, "Correct!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ShapeMatch.this, "Wrong, the correct answer is: " + Questions.get(currQuestion).getShape(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
