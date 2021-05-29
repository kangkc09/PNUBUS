package com.example.termproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Notice extends AppCompatActivity {
    private Button btn5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        btn5=(Button) findViewById(R.id.button5);
        btn5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent Intent =new Intent(Notice.this,Notice1.class);
                startActivity(Intent);
            }
        });
    }
}