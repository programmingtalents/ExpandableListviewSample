package com.programmingtalents.android.expandablelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private HashMap<String, List<String>> expandableListItems;

    private ExpandableListView expandableListView;
    private ExpandableListAdapter expandableListAdapter;
    private List<String> expandableListHeader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createDataForDisplay();
        expandableListView = (ExpandableListView) findViewById(R.id.myExpandableListView);
        expandableListHeader = new ArrayList<String>(expandableListItems.keySet());
        expandableListAdapter = new CustomAdapter(this, expandableListHeader, expandableListItems);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                //TODO : Write your code here

            }
        });
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                //TODO : Write your code here
            }
        });
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                //TODO : Write your code here
                Toast.makeText(
                       MainActivity.this,
                        expandableListItems.get(
                                expandableListHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT
                ).show();
                return false;
            }
        });
    }
    public void createDataForDisplay() {
        expandableListItems = new HashMap<String, List<String>>();

        List<String> flowers = new ArrayList<String>();
        flowers.add("Lotus");
        flowers.add("Rose");
        flowers.add("Lily");
        flowers.add("Sun Flower");
        flowers.add("Jasmine");

        List<String> cars = new ArrayList<String>();
        cars.add("BMW");
        cars.add("Accord");
        cars.add("Fortuner");
        cars.add("Honda City");
        cars.add("Verna");

        List<String> companyNames = new ArrayList<String>();
        companyNames.add("HCL Technology");
        companyNames.add("Wipro");
        companyNames.add("Google");
        companyNames.add("Facebook");
        companyNames.add("Infosys");

        expandableListItems.put("Flower Names", flowers);
        expandableListItems.put("Car Names", cars);
        expandableListItems.put("IT Company Names", companyNames);
    }
}
