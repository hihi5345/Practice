package com.example.kimhun.practice;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private double totalCredit = 0.0;
    private double totalGrade = 0.0;

    private EditText credit;
    private EditText grade;

    private TextView totalCreditText;
    private TextView totalGradeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

        totalCreditText = (TextView) findViewById(R.id.total_credit);
        totalCreditText.setText(Double.toString(totalCredit));

        totalGradeText = (TextView) findViewById(R.id.total_grade);
        totalGradeText.setText(Double.toString(totalGrade));

    }


    public void initData(){

        Resources res = getResources();
        String[] gradeArray = res.getStringArray(R.array.grade);

        for(int i = 0;i < gradeArray.length;i++){
            if(i % 2 == 0){
                totalCredit += Double.parseDouble(gradeArray[i]);
            } else {
                totalGrade += Double.parseDouble(gradeArray[i-1]) * Double.parseDouble(gradeArray[i]);
            }
        }
    }

    public void plus(View view){
        credit = (EditText) findViewById(R.id.credit);
        grade = (EditText) findViewById(R.id.grade);

        String creditString = credit.getText().toString();
        String gradeString = grade.getText().toString();

        totalCredit += Double.parseDouble(creditString);
        totalGrade += Double.parseDouble(gradeString) * Double.parseDouble(creditString);

        totalCreditText = (TextView) findViewById(R.id.total_credit);
        totalCreditText.setText(Double.toString(totalCredit));

        totalGradeText = (TextView) findViewById(R.id.total_grade);
        totalGradeText.setText(Double.toString(totalGrade));
    }

    public void result(View view){
        double result = totalGrade / totalCredit;
        Intent intent = new Intent(this, ResultActivity.class);

        intent.putExtra("result", result);
        intent.putExtra("totalCredit", totalCredit);
        intent.putExtra("totalGrade", totalGrade);

        startActivity(intent);
    }
}
