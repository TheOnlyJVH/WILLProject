package com.higher.login_register_home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    private CardView crdShapes;
    private CardView crdMaths;
    private CardView crdNouns;
    private CardView crdPictures;
    private CardView crdPuzzles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        assignToVariables();

        //Links to other activities.
        crdShapes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(Home.this, ShapeMatchMenu.class));
            }
        });

        crdMaths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(Home.this, .class));
            }
        });

        crdNouns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(Home.this, .class));
            }
        });

        crdPictures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(Home.this, .class));
            }
        });

        crdPuzzles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(Home.this, .class));
            }
        });
    }

    //Assigns components on the layout screen to variables so they can be worked with
    public void assignToVariables() {
        crdShapes = findViewById(R.id.crdShapes);
        crdMaths = findViewById(R.id.crdMaths);
        crdNouns = findViewById(R.id.crdNouns);
        crdPictures = findViewById(R.id.crdPictures);
        crdPuzzles = findViewById(R.id.crdPuzzles);
    }
}
