package com.example.mathpuzzles;

import static com.example.mathpuzzles.MainActivity.editor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    String[] ansArr = {"10","25","6","14","128","7","50","1025","100","3","212","3011","14","16","1","2","44","45","625","1","13","47","50","34","6","41"};
    ImageView imageView,skip,hint,delete;
    TextView ans,submit,level;
    TextView[] btn = new TextView[10];
    String s="";
    int levelNo=0;
    private ArrayList<String> imgArr=new ArrayList<>();
    private List<String> arrayList=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        imageView = findViewById(R.id.imageView);
        level=findViewById(R.id.level);
        levelNo=getIntent().getIntExtra("levelNo",0);
        getImage();
        hint=findViewById(R.id.hint);
        ans=findViewById(R.id.ans_field);
        delete=findViewById(R.id.delete);
        submit=findViewById(R.id.submit);
        skip=findViewById(R.id.skip_button);

        level.setText("Puzzle "+(levelNo+1));

        hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(SecondActivity.this).create();

                alertDialog.setTitle("Hint");
                alertDialog.setMessage("Hint is not available this puzzle");

                alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertDialog.show();
            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                levelNo++;
                editor.putInt("levelNo",levelNo);
                editor.putString("levelStatus"+levelNo,"skip");
                editor.commit();

                Intent  intent=new Intent(SecondActivity.this,SecondActivity.class);
                intent.putExtra("levelNo",levelNo);
                startActivity(intent);
                finish();
            }
        });

        for(int i=0;i<btn.length;i++)
        {
            int id = getResources().getIdentifier("btn"+i,"id",getPackageName());
            btn[i] = findViewById(id);
            btn[i].setOnClickListener(this);
        }

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=ans.getText().toString();
                if(s.length()>0)
                {
                    s=s.substring(0,s.length()-1);
                    ans.setText(""+s);
                }
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ans.getText().toString().equals(ansArr[levelNo]))
                {
                    levelNo++;
                    editor.putInt("levelNo",levelNo);
                    editor.putString("levelStatus"+(levelNo-1),"win");
                    editor.commit();

                    Intent intent=new Intent(SecondActivity.this, ThirdActivity.class);
                    intent.putExtra("levelNo",levelNo);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }
    private void getImage()
    {
        try {
            String[] images = getAssets().list("images/");
            imgArr = new ArrayList<String>(Arrays.asList(images));
            imgArr.remove("clock_font.png");
            imgArr.remove("android-logo-mask.png");
            imgArr.remove("android-logo-shine.png");
            imgArr.remove("clock_font.png");
            imgArr.remove("progress_font.png");
            System.out.println("images"+imgArr);
        } catch (IOException e) {
            e.getLocalizedMessage();
        }
        Collections.sort(imgArr);
        arrayList=imgArr.subList(0,imgArr.size()-1);
        try {
            InputStream ims = getAssets().open("images/"+arrayList.get(levelNo));
            Drawable d = Drawable.createFromStream(ims, null);
            imageView.setImageDrawable(d);
            ims.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        for(int i=0;i<btn.length;i++){
            if(v.getId()==btn[i].getId()){
                s+=i;
                ans.setText(""+s);
            }
        }
    }
}
