package com.example.kimhun.practice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by kimhun on 2017-07-07.
 */

public class ResultActivity extends AppCompatActivity {
    double result_grade;
    double grade1;
    double grade2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        result_grade = intent.getDoubleExtra("result",result_grade);
        grade1 = intent.getDoubleExtra("total_grade1",grade1);
        grade2 = intent.getDoubleExtra("total_grade2",grade2);
        TextView result = (TextView) findViewById(R.id.result);
        TextView total_grade1 = (TextView) findViewById(R.id.total_grade1);
        TextView total_grade2 = (TextView) findViewById(R.id.total_grade2);
        result.setText(Double.toString(result_grade));
        total_grade1.setText(Double.toString(grade1));
        total_grade2.setText(Double.toString(grade2));

    }
}