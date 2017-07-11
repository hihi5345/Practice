package com.example.kimhun.practice;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by kimhun on 2017-07-10.
 */

public class FirstFragment extends Fragment {

    TextView result;
    TextView totalCredit;
    TextView totalGrade;

    double resultGrade;
    double credit;
    double grade;

    public FirstFragment(double resultGrade, double credit, double grade) {

        this.resultGrade = resultGrade;
        this.credit = credit;
        this.grade = grade;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.first_fragment, container, false);

        result = (TextView) view.findViewById(R.id.result);
        totalCredit = (TextView) view.findViewById(R.id.total_credit);
        totalGrade = (TextView) view.findViewById(R.id.total_grade);

        result.setText(Double.toString(resultGrade));
        totalCredit.setText(Double.toString(credit));
        totalGrade.setText(Double.toString(grade));

        return view;
    }
}
