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
import com.example.hp.bikebharaui.model.LogRideList;
import com.example.hp.bikebharaui.view.adapter.LogRideAdapter;

import java.util.ArrayList;
import java.util.List;

public class LogRideFragment extends BaseFragment {

   // private Toolbar toolbar;
    private FloatingActionButton fabLogRide;
    Context mContext;

    private List<LogRideList> logRideLists = new ArrayList<>();
    private RecyclerView recyclerView;
    private LogRideAdapter mAdapter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_log_ride,container,false);

        recyclerView = view.findViewById(R.id.log_ride_recylerView);
        mContext=getContext();

        //toolbar = findViewById(R.id.toolbar_log_ride);

//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(LogRideActivity.this,DashboardActivity.class);
//                startActivity(intent);
//            }
//        });

//        toolbar.setTitle("Ride history");

        fabLogRide = view.findViewById(R.id.fab_log_ride);

        fabLogRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(mContext,LogRideMoneyActivity.class);
//                mContext.startActivity(intent);
                loadFragment(new LogRideMoneyFragment(), RideHistoryFragment.class.getSimpleName());
            }
        });



        mAdapter = new LogRideAdapter(logRideLists);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new MyDividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL, 16));
        recyclerView.setAdapter(mAdapter);

        prepareData();
        return view;
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


