package com.example.danielzhuravelproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ActivitySummaries extends AppCompatActivity {

    ListView lstview;
    ArrayList<Summarie> arrSumm = new ArrayList<Summarie>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summaries);

        lstview = findViewById(R.id.listViewSummaries);

        getSummarieData();

        SummarieAdapter sa = new SummarieAdapter(this, R.layout.summarie,arrSumm);
        lstview.setAdapter(sa);
    }

    public void getSummarieData() {
        Summarie s = new Summarie("Math", "Daniel", "Plus Minus rules", this);

        arrSumm.add(s);
        s = new Summarie("English","Gabriel","Super Mario",this);
        arrSumm.add(s);
        s = new Summarie("PE","Oded","Jumps and Runs",this);
        arrSumm.add(s);
    }
}