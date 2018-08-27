package com.example.hp.bikebharaui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LogRideActivity extends AppCompatActivity {

    private List<LogRideList> logRideLists = new ArrayList<>();
    private RecyclerView recyclerView;
    private LogRideAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_ride);

        recyclerView = findViewById(R.id.log_ride_recylerView);

        mAdapter = new LogRideAdapter(logRideLists);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.VERTICAL, 19));
        recyclerView.setAdapter(mAdapter);

        prepareData();
    }

    private void prepareData() {
        LogRideList u = new LogRideList("Asif Ahmed", "01675599357", "19 March 2018 10:30 AM");
        logRideLists.add(u);



        u = new LogRideList("Asif Ahmed", "01675599357", "19 March 2018 10:30 AM");
        logRideLists.add(u);
        u = new LogRideList("Asif Ahmed", "01675599357", "19 March 2018 10:30 AM");
        logRideLists.add(u);
        u = new LogRideList("Asif Ahmed", "01675599357", "19 March 2018 10:30 AM");
        logRideLists.add(u);
        u = new LogRideList("Asif Ahmed", "01675599357", "19 March 2018 10:30 AM");
        logRideLists.add(u);
        u = new LogRideList("Asif Ahmed", "01675599357", "19 March 2018 10:30 AM");
        logRideLists.add(u);
        u = new LogRideList("Asif Ahmed", "01675599357", "19 March 2018 10:30 AM");
        logRideLists.add(u);
        u = new LogRideList("Asif Ahmed", "01675599357", "19 March 2018 10:30 AM");
        logRideLists.add(u);

        mAdapter.notifyDataSetChanged();

    }
}
