package com.example.utspemogramanmobile1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ItemList extends BaseAdapter {

    private Context context;
    private String[] titles;
    private String[] descriptions;
    private int[] images;

    public ItemList(Context context, String[] titles, String[] descriptions, int[] images) {
        this.context = context;
        this.titles = titles;
        this.descriptions = descriptions;
        this.images = images;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public Object getItem(int position) {
        return titles[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Inflate layout jika belum dibuat
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_item_list, parent, false);
        }

        // Hubungkan ke komponen
        TextView title = convertView.findViewById(R.id.itemText);
        TextView description = convertView.findViewById(R.id.itemDescription);
        ImageView image = convertView.findViewById(R.id.itemImage);

        // Set nilai
        title.setText(titles[position]);
        description.setText(descriptions[position]);
        image.setImageResource(images[position]);

        return convertView;
    }
}