package com.ebookfrenzy.listviewapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Simple array with a list of my favorite TV shows
        String[] favoriteTVShows = {"Pushing Daisies", "Better Off Ted",
                "Twin Peaks", "Freaks and Geeks", "Orphan Black", "Walking Dead",
                "Breaking Bad", "The 400", "Alphas", "Life on Mars"};
        // The ListAdapter acts as a bridge between the data and each ListItem
        // You fill the ListView with a ListAdapter. You pass it a context represented by
        // this. A Context provides access to resources you need.
        // android.R.layout.simple_list_item_1 is one of the resources needed.
        // It is a predefined layout provided by Android that stands in as a default
        // 1 ListAdapter theAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,favoriteTVShows);
        // 2 ListAdapter theAdapter = new ArrayAdapter<String>(this,R.layout.row_layout,R.id.textViewOne,favoriteTVShows);
        ListAdapter theAdapter = new MyAdapter(this,favoriteTVShows);//3
        // ListViews display data in a scrollable list
        ListView theListView = (ListView) findViewById(R.id.theListView);
        // Tells the ListView what data to use
        theListView.setAdapter(theAdapter);
        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String tvShowPicked = "You selected " +
                        String.valueOf(adapterView.getItemAtPosition(i));
                Toast.makeText(MainActivity.this, tvShowPicked, Toast.LENGTH_SHORT).show();
            }
        });
    }}