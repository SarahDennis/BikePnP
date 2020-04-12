package com.bikepnp;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {


    //referenced: https://www.youtube.com/watch?v=H3JAy94UFw0
    private ArrayAdapter<String> mAdapter;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);


        ArrayList<String> searchItems = new ArrayList<>();
        //Grab the array of all of the data so far from the server
        //searchItems.addAll(Arrays.asList);

        mAdapter = new ArrayAdapter<String>(
                SearchActivity.this,
                android.R.layout.simple_list_item_1,
                searchItems
                );


    }
}
