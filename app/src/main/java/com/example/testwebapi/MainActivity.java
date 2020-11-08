package com.example.testwebapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Context context;

    ArrayList<Earthquake> myData;

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        Log.d("mTest", QueryUtils.extractEarthquakes().toString());

        //取得ListView
        lv = findViewById(R.id.lv);
        //取得資料
        myData = QueryUtils.extractEarthquakes();
        //建立適配器
        MyAdapter adapter = new MyAdapter(context, myData);
        lv.setAdapter(adapter);


    }
}