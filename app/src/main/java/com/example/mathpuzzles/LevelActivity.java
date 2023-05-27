package com.example.mathpuzzles;

import static com.example.mathpuzzles.MainActivity.editor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import LevelAdapter.LevelAdapter;

public class LevelActivity extends AppCompatActivity {

    GridView gridview;
    LevelAdapter adapter;
    ImageView imageView,imageView1;
    int levelNo=1,cnt=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        imageView = findViewById(R.id.next);
        imageView1 = findViewById(R.id.back);

        levelNo = getIntent().getIntExtra("levelNo",0);
        gridview = findViewById(R.id.gridview);

        adapter = new LevelAdapter(LevelActivity.this, config.no1,cnt);
        editor.putString("page","p0");
        editor.commit();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cnt++;

                if(cnt==1){
                    adapter = new LevelAdapter(LevelActivity.this, config.no2,cnt);
                    gridview.setAdapter(adapter);
                    editor.putString("page","p1");
                    editor.commit();
                    imageView1.setVisibility(View.VISIBLE);

                }
                if(cnt==2){
                    adapter = new LevelAdapter(LevelActivity.this, config.no3,cnt);
                    gridview.setAdapter(adapter);
                    editor.putString("page","p2");
                    editor.commit();
                }
                if(cnt==3){
                    adapter = new LevelAdapter(LevelActivity.this, config.no4,cnt);
                    gridview.setAdapter(adapter);
                    editor.putString("page","p3");
                    editor.commit();
                }


            }
        });
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cnt--;

                if(cnt==0){
                    adapter = new LevelAdapter(LevelActivity.this, config.no1,cnt);
                    gridview.setAdapter(adapter);
                    editor.putString("page","p0");
                    editor.commit();
                    imageView1.setVisibility(View.INVISIBLE);
                }
                if(cnt==1){
                    adapter = new LevelAdapter(LevelActivity.this, config.no2,cnt);
                    gridview.setAdapter(adapter);
                    editor.putString("page","p1");
                    editor.commit();
                }
                if(cnt==2){
                    adapter = new LevelAdapter(LevelActivity.this, config.no3,cnt);
                    gridview.setAdapter(adapter);
                    editor.putString("page","p2");
                    editor.commit();
                }

            }
        });
        gridview.setAdapter(adapter);
    }
}
