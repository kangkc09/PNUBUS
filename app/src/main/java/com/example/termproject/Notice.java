package com.example.termproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Notice extends AppCompatActivity {
    private Button notice1;
    private Button notice2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        notice1 = (Button) findViewById(R.id.notice1);
        notice1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent Intent =new Intent(Notice.this,Notice1.class);
                startActivity(Intent);
            }
        });

        notice2 = (Button) findViewById(R.id.notice2);
        notice2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent Intent =new Intent(Notice.this,Notice2.class);
                startActivity(Intent);
            }
        });
    }
}