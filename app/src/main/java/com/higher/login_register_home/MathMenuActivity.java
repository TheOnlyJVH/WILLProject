package com.higher.login_register_home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.higher.login_register_home.Adapters.LevelAdapter;

import java.util.ArrayList;

public class MathMenuActivity extends AppCompatActivity {

    //Components
    private RecyclerView recyclerView;

    //Components
    private LevelAdapter adapter;
    //private RecyclerView.LayoutManager layoutManager;

    //Variables
    private int numLevels = 5;
    private ArrayList<String> levels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_game_menu);

        setVariables();
        createList();
    }

    public void setVariables()
    {
        levels = new ArrayList<>();
        recyclerView = findViewById(R.id.recLevel);
    }

    private void createList() {
        int count = 1;
        for (int i = 0; i < numLevels; i++){
            levels.add("Level " + count);
            count++;
        }
        buildRecyclerView();
    }

    private void buildRecyclerView()
    {
        recyclerView.setHasFixedSize(true);
        //layoutManager = new LinearLayoutManager(this); //May cause problems
        adapter = new LevelAdapter(levels);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        adapter.setOnLevelClickListener(new LevelAdapter.onLevelClickListener() {
            @Override
            public void onLevelClick(int position)
            {
                int level = position + 1;
                Intent i = new Intent(MathMenuActivity.this, MathGame.class);
                i.putExtra("Level", level);
                startActivity(i);
            }
        });
    }
}
