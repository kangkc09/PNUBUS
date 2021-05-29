package com.example.termproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private Button btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn4=(Button) findViewById(R.id.button4);
        btn4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent Intent =new Intent(MainActivity.this,Notice.class);
                startActivity(Intent);
            }
        });
    }

}