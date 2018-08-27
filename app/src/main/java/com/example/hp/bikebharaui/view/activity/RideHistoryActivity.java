package com.example.hp.bikebharaui.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.hp.bikebharaui.MyDividerItemDecoration;
import com.example.hp.bikebharaui.R;
import com.example.hp.bikebharaui.model.RideHistoryList;
import com.example.hp.bikebharaui.view.adapter.RideHistoryAdapter;

import java.util.ArrayList;
import java.util.List;

public class RideHistoryActivity extends AppCompatActivity {
    private List<RideHistoryList> rideHistoryLists = new ArrayList<>();
    private RecyclerView recyclerView;
    private RideHistoryAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride_history);


        recyclerView = (RecyclerView) findViewById(R.id.ride_history_recyclerView);

        mAdapter = new RideHistoryAdapter(rideHistoryLists);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.VERTICAL, 19));
        recyclerView.setAdapter(mAdapter);

        prepareData();
    }

    private void prepareData() {
        RideHistoryList u = new RideHistoryList("Asif Ahmed", "01675599357", "19 March 2018 10:30 AM");
        rideHistoryLists.add(u);

        u = new RideHistoryList("Asif Ahmed", "01675599357", "19 March 2018 10:30 AM");
        rideHistoryLists.add(u);

        u = new RideHistoryList("Asif Ahmed", "01675599357", "19 March 2018 10:30 AM");
        rideHistoryLists.add(u);

        u = new RideHistoryList("Asif Ahmed", "01675599357", "19 March 2018 10:30 AM");
        rideHistoryLists.add(u);

        u = new RideHistoryList("Asif Ahmed", "01675599357", "19 March 2018 10:30 AM");
        rideHistoryLists.add(u);

        u = new RideHistoryList("Asif Ahmed", "01675599357", "19 March 2018 10:30 AM");
        rideHistoryLists.add(u);

        u = new RideHistoryList("Asif Ahmed", "01675599357", "19 March 2018 10:30 AM");
        rideHistoryLists.add(u);

        mAdapter.notifyDataSetChanged();

    }
}
