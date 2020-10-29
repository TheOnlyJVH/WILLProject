package com.higher.login_register_home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.higher.login_register_home.Adapters.DifficultyAdapter;
import com.higher.login_register_home.Adapters.OptionsAdapter;
import com.higher.login_register_home.Message.AnswerDisplay;
import com.higher.login_register_home.Objects.QuestionObject;

import java.util.ArrayList;
import java.util.List;

public class ShapeMatch extends AppCompatActivity {

    //Components
    private ImageView imgShape;
    private RecyclerView recOptionList;
    private TextView txtQuestionNumber;

    //Variables
    private int currQuestion = 0; //Stores the current question (Defaults to 0).
    private int displayCurrNumber = 1; //The question number displayed to user
    private int totalQuestions = 0; //Stores the max number of questions (Defaults to 0).
    private List<QuestionObject> Questions;
    private OptionsAdapter adapter;
    private List<Boolean> markTracking;

    //Objects


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shape_match);

        //Collects intents
        Intent intent = getIntent();
        int level = intent.getIntExtra("Level", 1);
        setVariables(level); //Sets all the variables up with their respective components
        totalQuestions = Questions.size();

        prepQuestion();
        for (int i = 0; i < totalQuestions; i++)
        {
            markTracking.add(false);
        }
    }

    //Sets all components to a variable.
    public void setVariables(int level)
    {
        imgShape = findViewById(R.id.imgShape);
        recOptionList = findViewById(R.id.recOption);
        txtQuestionNumber = findViewById(R.id.txtQuestionNumber);

        Questions = new ArrayList<>();

        DifficultyAdapter createQuestion = new DifficultyAdapter();
        Questions = createQuestion.generateQuestion(level, this);
        markTracking = new ArrayList<>();
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
        adapter.setCurrentGuess(Questions.get(currQuestion).getShape());

        recOptionList.setLayoutManager(new LinearLayoutManager(this));
        recOptionList.setAdapter(adapter);

        adapter.setOnOptionsClickListener(new OptionsAdapter.onOptionClickListener() {
            @Override
            public void onOptionClick(int position) {
                AnswerDisplay messageBox = new AnswerDisplay();
                if (Questions.get(currQuestion).getOption().get(position) == Questions.get(currQuestion).getShape())
                {
                    messageBox.setTitle("Correct!");
                    messageBox.setMessage("Well Done!" + "\n" + "The answer was " + Questions.get(currQuestion).getShape() + "!");
                }
                else
                {
                    messageBox.setTitle("Wrong...");
                    messageBox.setMessage("Nice try!" + "\n" + "The answer was " + Questions.get(currQuestion).getShape() + "!");
                }

                markTracking.set(currQuestion, true);
                messageBox.showNow(getSupportFragmentManager(), "messageBox");
                messageBox.getDialog().setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {

                        if (displayCurrNumber == totalQuestions)
                        {

                        }
                        else
                        {
                            displayCurrNumber += 1;
                            currQuestion += 1;
                            prepQuestion();
                        }
                    }
                });
            }
        });


    }
}
