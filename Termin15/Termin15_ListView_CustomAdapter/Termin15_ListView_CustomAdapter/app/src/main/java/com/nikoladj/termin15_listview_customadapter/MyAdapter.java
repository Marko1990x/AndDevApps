package com.nikoladj.termin15_listview_customadapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    private List<String> data;
    private Activity activity;

    public MyAdapter(Activity activity, List<String> data) {
        this.data = data;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = activity.getLayoutInflater().inflate(R.layout.my_list_item, null);
        }

        TextView tvPrimary = convertView.findViewById(R.id.tvPrimary);
        tvPrimary.setText(data.get(position));
        TextView tvSecondary = convertView.findViewById(R.id.tvSecondary);
        tvSecondary.setText(data.get(position));

        return convertView;
    }
}

