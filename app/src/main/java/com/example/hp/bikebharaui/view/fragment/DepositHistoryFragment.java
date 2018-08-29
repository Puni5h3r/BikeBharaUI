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
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hp.bikebharaui.MyDividerItemDecoration;
import com.example.hp.bikebharaui.R;
import com.example.hp.bikebharaui.model.DepositeHistoryList;
import com.example.hp.bikebharaui.view.activity.DepositMoneyActivity;
import com.example.hp.bikebharaui.view.adapter.DeposityHistoryAdapter;

import java.util.ArrayList;
import java.util.List;

public class DepositHistoryFragment extends BaseFragment {


    private Toolbar toolbar;
    private FloatingActionButton fabDepositeHistory;

    private List<DepositeHistoryList> depositeHistoryLists = new ArrayList<>();
    private RecyclerView recyclerView;
    private DeposityHistoryAdapter mAdapter;

    Context mContext;

    public DepositHistoryFragment(){}

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View view = inflater.inflate(R.layout.frag_deposit_history,container,false);
      mContext=getContext();


        recyclerView = view.findViewById(R.id.deposite_history_recyclerview);

//        toolbar = view.findViewById(R.id.toolbar_deposit_history);
//
//        toolbar.setTitle("Deposite History");
//
//
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(DepositHistoryActivity.this,DashboardActivity.class);
//                startActivity(intent);
//            }
//        });


        fabDepositeHistory = view.findViewById(R.id.fab_deposite_history);

        fabDepositeHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,DepositMoneyActivity.class);
                mContext.startActivity(intent);
            }
        });

        mAdapter = new DeposityHistoryAdapter(depositeHistoryLists);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new MyDividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL, 16));
        recyclerView.setAdapter(mAdapter);

        prepareData();





        return view;
    }

    private void prepareData() {
        DepositeHistoryList u = new DepositeHistoryList("Asif Ahmed", "01675599357", "19 March 2018 10:30 AM", "500 tk");
        depositeHistoryLists.add(u);
        u = new DepositeHistoryList("Asif Ahmed", "01675599357", "19 March 2018 10:30 AM", "500 tk");
        depositeHistoryLists.add(u);
        u = new DepositeHistoryList("Asif Ahmed", "01675599357", "19 March 2018 10:30 AM", "500 tk");
        depositeHistoryLists.add(u);
        u = new DepositeHistoryList("Asif Ahmed", "01675599357", "19 March 2018 10:30 AM", "500 tk");
        depositeHistoryLists.add(u);
        u = new DepositeHistoryList("Asif Ahmed", "01675599357", "19 March 2018 10:30 AM", "500 tk");
        depositeHistoryLists.add(u);
        u = new DepositeHistoryList("Asif Ahmed", "01675599357", "19 March 2018 10:30 AM", "500 tk");
        depositeHistoryLists.add(u);
        u = new DepositeHistoryList("Asif Ahmed", "01675599357", "19 March 2018 10:30 AM", "500 tk");
        depositeHistoryLists.add(u);
        u = new DepositeHistoryList("Asif Ahmed", "01675599357", "19 March 2018 10:30 AM", "500 tk");
        depositeHistoryLists.add(u);

        mAdapter.notifyDataSetChanged();
    }
}
