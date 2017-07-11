package com.example.kimhun.practice;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

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

        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(R.id.fragment, new FirstFragment(resultGrade, credit, grade));
        fragmentTransaction.commit();
    }
    public void selectFrag(View view){

        Fragment fr;

        if(view == findViewById(R.id.btn_result)){
            fr = new FirstFragment(resultGrade, credit, grade);
        } else {
            fr = new SecondFragment();
        }

        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment, fr);
        fragmentTransaction.commit();
    }
}