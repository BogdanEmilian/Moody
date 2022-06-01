package com.example.moody;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button insertScene = (Button) findViewById(R.id.BUTTON_updateData);
        Button progressScene = (Button) findViewById(R.id.BUTTON_viewProgress);

        insertScene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, UpdateScene.class));
            }
        });

        progressScene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, ProgressActivity.class));
            }
        });
    }
}