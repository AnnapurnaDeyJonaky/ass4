package com.example.ass4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ArrayAdapter;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Item> {

    private Context context;
    private List<Item> items;

    public CustomAdapter(Context context, List<Item> items) {
        super(context, 0, items);
        this.context = context;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }

        Item item = getItem(position);
        if (item != null) {
            ImageView imageView = convertView.findViewById(R.id.itemImage);
            TextView textView = convertView.findViewById(R.id.itemTitle);

            imageView.setImageResource(item.getImageResource());
            textView.setText(item.getTitle());
        }

        return convertView;
    }
}