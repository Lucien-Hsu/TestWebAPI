package com.example.testwebapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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
        //監聽器
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                //取得當前項目的url
                Earthquake mEatthquake = (Earthquake) adapterView.getItemAtPosition(position);
                Uri earthquakeUri = Uri.parse(mEatthquake.getUrl());
                //傳送隱式意圖
                Intent intent = new Intent(Intent.ACTION_VIEW, earthquakeUri);
                startActivity(intent);

            }
        });


    }
}