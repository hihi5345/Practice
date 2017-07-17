package com.example.kimhun.practice;

import android.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by kimhun on 2017-07-10.
 */

public class SecondFragment extends Fragment {
    private ListView listView;
    private ArrayAdapter<String> mAdapter;
    public SecondFragment(){

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.second_fragment, container, false);
        listView = (ListView) view.findViewById(R.id.list);

        Resources res = getResources();
        String[] gradeArray = res.getStringArray(R.array.grade);

        mAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, gradeArray);
        listView.setAdapter(mAdapter);

        return view;
    }
}
