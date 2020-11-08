package com.example.testwebapi;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Earthquake> dataList;
    private LayoutInflater inflater;

    public MyAdapter(Context context, ArrayList<Earthquake> dataList) {
        this.context = context;
        inflater = inflater.from(context);
        this.dataList = dataList;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int i) {
        return dataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    private class ViewHolder{
        TextView tvMag;
        TextView tvLocationDistance;
        TextView tvCity;
        TextView tvDate;
        TextView tvTime;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;

        if(view == null){
            view = inflater.inflate(R.layout.item_view, null);

            holder = new ViewHolder();
            holder.tvMag = view.findViewById(R.id.tv_mag);
            holder.tvLocationDistance = view.findViewById(R.id.tv_locationDistance);
            holder.tvCity = view.findViewById(R.id.tv_city);
            holder.tvDate = view.findViewById(R.id.tv_date);
            holder.tvTime = view.findViewById(R.id.tv_time);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }

        //設定震級
        double mag = dataList.get(i).getMagnitude();
        DecimalFormat formatter = new DecimalFormat("0.0");
        String magToDisplay = formatter.format(mag);
        holder.tvMag.setText(magToDisplay);
        //設定震級圓圈顏色
        GradientDrawable magCircle = (GradientDrawable) holder.tvMag.getBackground();
        int magColor = getMagColor(mag);
        magCircle.setColor(magColor);

        //設定位置
        String location = dataList.get(i).getLocation();
        String[] parts = location.split(" of ");
        String distance;
        String city;
        if(parts.length == 1){
            distance = "Near the";
            city = parts[0];
        }else{
            distance = parts[0] + " of";
            city = parts[1];
        }

        holder.tvLocationDistance.setText(distance);
        holder.tvCity.setText(city);

        //取得時間資料
        long unixTime = dataList.get(i).getUnixTime();
        Date dateObject = new Date(unixTime);

        //設定日期
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        String dateToDisplay = dateFormat.format(dateObject);
        holder.tvDate.setText(dateToDisplay);
        //設定時間
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        String timeToDisplay = timeFormat.format(dateObject);
        holder.tvTime.setText(timeToDisplay);

        return view;
    }

    private int getMagColor(double mag) {
        //去除小數
        int mMag = (int) Math.floor(mag);
        int colorID;
        switch (mMag){
            case 0:
            case 1:
                colorID = R.color.magnitude1;
                break;
            case 2:
                colorID = R.color.magnitude2;
                break;
            case 3:
                colorID = R.color.magnitude3;
                break;
            case 4:
                colorID = R.color.magnitude4;
                break;
            case 5:
                colorID = R.color.magnitude5;
                break;
            case 6:
                colorID = R.color.magnitude6;
                break;
            case 7:
                colorID = R.color.magnitude7;
                break;
            case 8:
                colorID = R.color.magnitude8;
                break;
            case 9:
                colorID = R.color.magnitude9;
                break;
            default:
                colorID = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(context, colorID);
    }
}
