package com.example.kimhun.practice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    double totalCredit = 0.0;
    double totalGrade = 0.0;
    EditText credit;
    EditText grade;
    TextView totalCreditText;
    TextView totalGradeText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        totalCreditText = (TextView) findViewById(R.id.total_credit);
        totalCreditText.setText(Double.toString(totalCredit));
        totalGradeText = (TextView) findViewById(R.id.total_grade);
        totalGradeText.setText(Double.toString(totalGrade));
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
        Toast.makeText(this, Double.toString(result),Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("result", result);
        intent.putExtra("totalCredit", totalCredit);
        intent.putExtra("totalGrade", totalGrade);
        startActivity(intent);
    }
}
