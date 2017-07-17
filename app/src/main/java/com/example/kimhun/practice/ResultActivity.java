package com.example.kimhun.practice;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by kimhun on 2017-07-07.
 */

public class ResultActivity extends AppCompatActivity {

    private double resultGrade;
    private double credit;
    private double grade;

    private Button gradeResultBtn;
    private Button gradeListBtn;

    private Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        gradeResultBtn = (Button)findViewById(R.id.btn_result);
        gradeListBtn = (Button)findViewById(R.id.btn_list);

        gradeResultBtn.setOnClickListener(gradeResultBtnClicked);
        gradeListBtn.setOnClickListener(gradeListBtnClicked);

        Intent intent = getIntent();
        resultGrade = intent.getDoubleExtra("result", resultGrade);
        credit = intent.getDoubleExtra("totalCredit", credit);
        grade = intent.getDoubleExtra("totalGrade", grade);

        currentFragment = new FirstFragment(resultGrade, credit, grade);
        changeFragment();
    }

    public void changeFragment(){

        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment, currentFragment);
        fragmentTransaction.commit();
    }

    View.OnClickListener gradeResultBtnClicked = new View.OnClickListener(){

        @Override
        public void onClick(View v) {

            currentFragment = new FirstFragment(resultGrade, credit, grade);
            changeFragment();
        }
    };

    View.OnClickListener gradeListBtnClicked = new View.OnClickListener(){

        @Override
        public void onClick(View v) {

            currentFragment = new SecondFragment();
            changeFragment();
        }
    };
}