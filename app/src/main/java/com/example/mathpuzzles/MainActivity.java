package com.example.mathpuzzles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt1,txt2;
    public static SharedPreferences preferences;
    public static SharedPreferences.Editor editor;
    int levelNo=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1=findViewById(R.id.continue_button);
        txt2=findViewById(R.id.puzzles);

        preferences=getSharedPreferences("myPref",MODE_PRIVATE);
        editor=preferences.edit();
        levelNo=preferences.getInt("levelNo",0);

        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("levelNo",levelNo);
                startActivity(intent);
            }
        });
        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LevelActivity.class);
                startActivity(intent);
            }
        });

    }
}