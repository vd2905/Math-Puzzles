package com.example.mathpuzzles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import LevelAdapter.LevelAdapter;

public class LevelActivity extends AppCompatActivity {

    GridView gridview;
    LevelAdapter adapter;
    int levelNo;
    int[] no = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_item);

        gridview = findViewById(R.id.gridview);
        levelNo = getIntent().getIntExtra("levelNo",0);
        adapter = new LevelAdapter(LevelActivity.this,no);
        gridview.setAdapter(adapter);
    }
}