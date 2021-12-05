package com.example.a1918134_tugas7;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Komik> Komik;
    public CustomListAdapter(Activity activity, List<Komik>
            Komik) {
        this.activity = activity;
        this.Komik = Komik;
    }
    @Override
    public int getCount() {
        return Komik.size();
    }
    @Override
    public Object getItem(int location) {
        return Komik.get(location);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup
            parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity

                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list,
                    null);
        TextView judul = (TextView)
                convertView.findViewById(R.id.text_judul);
        TextView author = (TextView)
                convertView.findViewById(R.id.text_author);
        ImageView imageView = (ImageView)
                convertView.findViewById(R.id.iconid);
        Komik m = Komik.get(position);
        judul.setText("Judul : "+ m.get_judul());
        author.setText("Author : "+ m.get_author());
        return convertView;
    }
}
