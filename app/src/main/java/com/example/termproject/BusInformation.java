package com.example.termproject;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BusInformation extends AppCompatActivity {

    private UserDatabaseHelper userDatabaseHelper;
    public static final String TABLE_NAME = "user";
    SQLiteDatabase database;

    Button showButton;
    Button onButton;
    Button offButton;
    Button clearButton;
    TextView textView;

    String onboard;
    String dropoff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_businfo);

        showButton = findViewById(R.id.show_btn);
        onButton = findViewById(R.id.board_btn);
        offButton = findViewById(R.id.drop_btn);
        clearButton = findViewById(R.id.clear_btn);
        textView = findViewById(R.id.textView);

        userDatabaseHelper = userDatabaseHelper.getInstance(this);
        database = userDatabaseHelper.getWritableDatabase();

        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showData(TABLE_NAME);
            }
        });

        onButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onboard = getTime();
                Toast.makeText(getApplicationContext(),"승차하였습니다.",Toast.LENGTH_SHORT).show();
            }
        });

        offButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dropoff = getTime();
                insertData(onboard, dropoff);
                Toast.makeText(getApplicationContext(),"승하차 정보가 기록되었습니다",Toast.LENGTH_SHORT).show();
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteData();
                showData(TABLE_NAME);
            }
        });
    }

    private String getTime() {
        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat mFormat = new SimpleDateFormat("yy/MM/dd HH:mm");
        String time = mFormat.format(date);
        return time;
    }

    private void insertData(String on, String off) {
        if (database != null) {
            String sql = "INSERT INTO user(onboard, dropoff) VALUES(?, ?)";
            Object[] params = {on, off};
            database.execSQL(sql, params);
        }
    }

    private void showData(String tableName) {
        textView.setText("");  // textView 초기화
        if (database != null) {
            String sql = "SELECT onboard, dropoff FROM " + tableName;
            Cursor cursor = database.rawQuery(sql, null);

            println("데이터 개수 : " + cursor.getCount());

            for (int i = 1; i <= cursor.getCount(); i++) {
                cursor.moveToNext();
                String on = cursor.getString(0);
                String off = cursor.getString(1);
                println("[" + i + "] 승차시간: " + on + "," + " 하차시간: " + off);
            }
            cursor.close();
        }
    }

    private void deleteData() {
        String sql = "DELETE FROM user";
        database.execSQL(sql);
    }

    public void println (String data) {
        textView.append(data + "\n");
    }

    @Override
    protected void onDestroy() {
        userDatabaseHelper.close();
        super.onDestroy();
    }
}