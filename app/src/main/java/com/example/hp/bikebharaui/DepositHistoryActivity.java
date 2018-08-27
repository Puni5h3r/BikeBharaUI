package com.example.hp.bikebharaui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DepositHistoryActivity extends AppCompatActivity {

    private List<DepositeHistoryList> depositeHistoryLists = new ArrayList<>();
    private RecyclerView recyclerView;
    private DeposityHistoryAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit_history);

        recyclerView = findViewById(R.id.deposite_history_recyclerview);

        mAdapter = new DeposityHistoryAdapter(depositeHistoryLists);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.VERTICAL, 19));
        recyclerView.setAdapter(mAdapter);

        prepareData();


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
