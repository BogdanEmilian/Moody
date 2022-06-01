package com.example.moody;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class UpdateScene extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_scene);

        Button insertButton = (Button) findViewById(R.id.BUTTON_insert);
        Button backButton = findViewById(R.id.BUTTON_goBack);
        RatingBar happinessLevel = findViewById(R.id.rating1);
        RatingBar restLevel = findViewById(R.id.rating2);
        DBHandler dbHandler = new DBHandler(UpdateScene.this);

        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //DATABASE
                System.out.println(happinessLevel.getRating());
                System.out.println(restLevel.getRating());

                dbHandler.insertData(happinessLevel.getRating(), restLevel.getRating());

                Toast.makeText(UpdateScene.this, "Data has been inserted successfully!", Toast.LENGTH_SHORT);
            }
        });

        happinessLevel.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(UpdateScene.this, "You've selected the happiness value of: "+String.valueOf(rating), Toast.LENGTH_SHORT).show();
            }
        });

        restLevel.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(UpdateScene.this, "You've selected the rest value of: "+String.valueOf(rating), Toast.LENGTH_SHORT).show();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                finish();
            }
        });
    }
}