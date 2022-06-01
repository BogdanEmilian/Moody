package com.example.moody;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.ArrayList;


public class ProgressActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        Button backButton = (Button) findViewById(R.id.BUTTON_goBack);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                finish();
            }
        });

        DBHandler dbHandler = new DBHandler(ProgressActivity.this);

        ArrayList<Data> array = dbHandler.getLastWeek();

        System.out.println("\n\n================\n"+array.get(0).getHappiness()+"\n"+array.get(0).getRest()+"\n================\n\n");
    }
}