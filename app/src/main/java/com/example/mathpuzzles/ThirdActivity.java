package com.example.mathpuzzles;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    TextView txt1,txt2,level;
    int levelNo=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        txt1=findViewById(R.id.continue_button);
        txt2=findViewById(R.id.main_button);
        level=findViewById(R.id.win_level);
        levelNo = getIntent().getIntExtra("levelNo",0);
        level.setText("PUZZLE "+levelNo+" COMPLETED");

        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThirdActivity.this,SecondActivity.class);
                intent.putExtra("levelNo",levelNo);
                startActivity(intent);
            }
        });
        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThirdActivity.this,MainActivity.class);
                intent.putExtra("levelNo",levelNo);
                startActivity(intent);
            }
        });
    }
}