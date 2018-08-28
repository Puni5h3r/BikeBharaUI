package com.example.hp.bikebharaui.view.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.hp.bikebharaui.view.adapter.LogRideAdapter;
import com.example.hp.bikebharaui.model.LogRideList;
import com.example.hp.bikebharaui.MyDividerItemDecoration;
import com.example.hp.bikebharaui.R;

import java.util.ArrayList;
import java.util.List;

public class LogRideActivity extends AppCompatActivity {

   private Toolbar toolbar;
   private FloatingActionButton fabLogRide;

    private List<LogRideList> logRideLists = new ArrayList<>();
    private RecyclerView recyclerView;
    private LogRideAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_ride);

        recyclerView = findViewById(R.id.log_ride_recylerView);

        toolbar = findViewById(R.id.toolbar_log_ride);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogRideActivity.this,DashboardActivity.class);
                startActivity(intent);
            }
        });

        toolbar.setTitle("Ride history");

        fabLogRide = findViewById(R.id.fab_log_ride);

        fabLogRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogRideActivity.this,LogRideMoneyActivity.class);
                startActivity(intent);
            }
        });



        mAdapter = new LogRideAdapter(logRideLists);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.VERTICAL, 16));
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
