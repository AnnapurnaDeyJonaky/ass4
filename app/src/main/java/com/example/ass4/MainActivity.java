package com.example.ass4;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.ExpandableListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView customListView;
    private ExpandableListView expandableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customListView = findViewById(R.id.customListView);
        expandableListView = findViewById(R.id.expandableListView);

        // Custom ListView Data
        List<Item> customItems = new ArrayList<>();
        customItems.add(new Item("Item 1", R.drawable.ic_sample_image));
        customItems.add(new Item("Item 2", R.drawable.ic_sample_image));
        customItems.add(new Item("Item 3", R.drawable.ic_sample_image));

        CustomAdapter customAdapter = new CustomAdapter(this, customItems);
        customListView.setAdapter(customAdapter);

        // Expandable ListView Data
        List<String> groupList = new ArrayList<>();
        groupList.add("Category 1");
        groupList.add("Category 2");

        List<List<Item>> childList = new ArrayList<>();
        List<Item> childItems1 = new ArrayList<>();
        childItems1.add(new Item("Sub Item 1", R.drawable.ic_sample_image));
        childItems1.add(new Item("Sub Item 2", R.drawable.ic_sample_image));

        List<Item> childItems2 = new ArrayList<>();
        childItems2.add(new Item("Sub Item 3", R.drawable.ic_sample_image));

        childList.add(childItems1);
        childList.add(childItems2);

        ExpandableAdapter expandableAdapter = new ExpandableAdapter(this, groupList, childList);
        expandableListView.setAdapter(expandableAdapter);
    }
}