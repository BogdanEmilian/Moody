package com.example.moody;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import java.util.ArrayList;


public class ProgressActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        Button backButton = (Button) findViewById(R.id.BUTTON_goBack);
        Button restButton = (Button) findViewById(R.id.BUTTON_Rest);
        GraphView graph = findViewById(R.id.graph);

        DBHandler dbHandler = new DBHandler(ProgressActivity.this);
        ArrayList<Data> array = dbHandler.getLastWeek();

        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(0, array.get(0).getHappiness()),
                new DataPoint(1, array.get(1).getHappiness()),
                new DataPoint(2, array.get(2).getHappiness()),
                new DataPoint(3, array.get(3).getHappiness()),
                new DataPoint(4, array.get(4).getHappiness()),
                new DataPoint(5, array.get(5).getHappiness()),
                new DataPoint(6, array.get(6).getHappiness())
        });

        graph.addSeries(series);


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                finish();
            }
        });

        restButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (restButton.getText() == "Rest level") {
                    graph.removeAllSeries();
                    LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
                            new DataPoint(0, array.get(0).getRest()),
                            new DataPoint(1, array.get(1).getRest()),
                            new DataPoint(2, array.get(2).getRest()),
                            new DataPoint(3, array.get(3).getRest()),
                            new DataPoint(4, array.get(4).getRest()),
                            new DataPoint(5, array.get(5).getRest()),
                            new DataPoint(6, array.get(6).getRest())
                    });

                    graph.addSeries(series);
                    restButton.setText("Happiness level");
                } else {
                    graph.removeAllSeries();
                    LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
                            new DataPoint(0, array.get(0).getHappiness()),
                            new DataPoint(1, array.get(1).getHappiness()),
                            new DataPoint(2, array.get(2).getHappiness()),
                            new DataPoint(3, array.get(3).getHappiness()),
                            new DataPoint(4, array.get(4).getHappiness()),
                            new DataPoint(5, array.get(5).getHappiness()),
                            new DataPoint(6, array.get(6).getHappiness())
                    });

                    graph.addSeries(series);
                    restButton.setText("Rest level");
                }
            }
        });

    }
}