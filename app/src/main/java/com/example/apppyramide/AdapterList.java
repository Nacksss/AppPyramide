package com.example.apppyramide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AdapterList extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private String[] user;

    public AdapterList(Context context, String[] user){
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.user = user;
    }
    
    @Override
    public int getCount() {
        return user.length;
    }

    @Override
    public Object getItem(int position) {
        return user[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.liste, null);
        TextView user_text_view = convertView.findViewById(R.id.user_textView);
        user_text_view.setText(user[position]);

        return convertView;
    }
}
