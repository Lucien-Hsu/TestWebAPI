package com.example.testwebapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.EventLog;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Context context;

    List<Earthquake> myData;

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        Log.d("mTest", QueryUtils.extractEarthquakes().toString());

        //取得ListView
        lv = findViewById(R.id.lv);
        //取得地震串列資料
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
                //傳送隱式意圖，打開相應網頁
                Intent intent = new Intent(Intent.ACTION_VIEW, earthquakeUri);
                startActivity(intent);
            }
        });
    }

    //使用AsyncTas以新執行緒處理網路讀取
    private class EarthquakeAsyncTask extends AsyncTask<String, Void, List<Earthquake>>{
        /**
         * 此方法在後台執行緒上调用，因此我们可以執行
         * 諸如網路請求等長時間運行操作。
         */
        @Override
        protected List<Earthquake> doInBackground(String... urls) {
            List<Earthquake> result = null;
            // 如果不存在任何 URL 或第一個 URL 為空，切勿執行请求。
            if (urls.length < 1 || urls[0] == null) {
                return null;
            }

            //讀取URL
//            EventLog.Event result = Utils.fetchEarthquakeData(urls[0]);

            return result;
        }

        /**
         * 此方法是在完成後台工作後，在主 UI 執行緒上執行的。
         *
         * 可以在此方法内修改 UI。並更新螢幕上的視圖。
         */
        @Override
        protected void onPostExecute(List<Earthquake> result) {
            super.onPostExecute(result);

            // 如果不存在任何结果，则不执行任何操作。
            if (result == null) {
                return;
            }

            //更新UI
//            updateUi(result);
        }
    }
}