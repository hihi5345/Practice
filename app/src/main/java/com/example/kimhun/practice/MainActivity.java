package com.example.kimhun.practice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    double total_grade1 = 0.0;
    double total_grade2 = 0.0;
    EditText grade1;
    EditText grade2;
    TextView total_grade_text1;
    TextView total_grade_text2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        total_grade_text1 = (TextView) findViewById(R.id.total_grade1);
        total_grade_text1.setText(Double.toString(total_grade1));
        total_grade_text2 = (TextView) findViewById(R.id.total_grade2);
        total_grade_text2.setText(Double.toString(total_grade2));
    }
    public void plus(View view){
        grade1 = (EditText) findViewById(R.id.grade1);
        grade2 = (EditText) findViewById(R.id.grade2);

        String g1_string = grade1.getText().toString();
        String g2_string = grade2.getText().toString();
        total_grade1 += Double.parseDouble(g1_string);
        total_grade2 += Double.parseDouble(g2_string) * Double.parseDouble(g1_string);
        total_grade_text1 = (TextView) findViewById(R.id.total_grade1);
        total_grade_text1.setText(Double.toString(total_grade1));
        total_grade_text2 = (TextView) findViewById(R.id.total_grade2);
        total_grade_text2.setText(Double.toString(total_grade2));
    }
    public void result(View view){
        double result = total_grade2 / total_grade1;
        Toast.makeText(this, Double.toString(result),Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("result", result);
        intent.putExtra("total_grade1", total_grade1);
        intent.putExtra("total_grade2", total_grade2);
        startActivity(intent);
        finish();
    }
}
