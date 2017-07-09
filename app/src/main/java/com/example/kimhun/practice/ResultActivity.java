package com.example.kimhun.practice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by kimhun on 2017-07-07.
 */

public class ResultActivity extends AppCompatActivity {
    double resultGrade;
    double credit;
    double grade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        resultGrade = intent.getDoubleExtra("result", resultGrade);
        credit = intent.getDoubleExtra("totalCredit", credit);
        grade = intent.getDoubleExtra("totalGrade", grade);
        TextView result = (TextView) findViewById(R.id.result);
        TextView totalCredit = (TextView) findViewById(R.id.total_credit);
        TextView totalGrade = (TextView) findViewById(R.id.total_grade);
        result.setText(Double.toString(resultGrade));
        totalCredit.setText(Double.toString(credit));
        totalGrade.setText(Double.toString(grade));

    }
}