package com.example.hp.bikebharaui.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hp.bikebharaui.MyDividerItemDecoration;
import com.example.hp.bikebharaui.R;
import com.example.hp.bikebharaui.model.RideHistoryList;
import com.example.hp.bikebharaui.view.adapter.RideHistoryAdapter;

import java.util.ArrayList;
import java.util.List;

public class RideHistoryFragment extends BaseFragment {
    private Context mContext;

   // private Toolbar toolbar;
    private FloatingActionButton fabRideHistoryActivity;

    private List<RideHistoryList> rideHistoryLists = new ArrayList<>();
    private RecyclerView recyclerView;
    private RideHistoryAdapter mAdapter;

    public  RideHistoryFragment(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_ride_history,container,false);

        mContext = getContext();

        fabRideHistoryActivity = view.findViewById(R.id.fab_ride_history);

        fabRideHistoryActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(mContext, LogRideMoneyActivity.class);
//                mContext.startActivity(intent);

                loadFragment(new LogRideMoneyFragment());
            }
        });

//        toolbar = findViewById(R.id.toolbar_ride_history);
//        toolbar.setTitle("Ride history");
//
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(RideHistoryActivity.this,DashboardActivity.class);
//                startActivity(intent);
//            }
//        });


        recyclerView = (RecyclerView) view.findViewById(R.id.ride_history_recyclerView);

        mAdapter = new RideHistoryAdapter(rideHistoryLists);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new MyDividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL, 16));
        recyclerView.setAdapter(mAdapter);

        prepareData();


        return view;
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
