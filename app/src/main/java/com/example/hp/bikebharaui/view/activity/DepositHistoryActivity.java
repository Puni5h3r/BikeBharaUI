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

import com.example.hp.bikebharaui.MyDividerItemDecoration;
import com.example.hp.bikebharaui.R;
import com.example.hp.bikebharaui.model.DepositeHistoryList;
import com.example.hp.bikebharaui.view.adapter.DeposityHistoryAdapter;

import java.util.ArrayList;
import java.util.List;

public class DepositHistoryActivity extends AppCompatActivity {

   private Toolbar toolbar;
   private FloatingActionButton fabDepositeHistory;

    private List<DepositeHistoryList> depositeHistoryLists = new ArrayList<>();
    private RecyclerView recyclerView;
    private DeposityHistoryAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit_history);

        recyclerView = findViewById(R.id.deposite_history_recyclerview);

        toolbar = findViewById(R.id.toolbar_deposit_history);

        toolbar.setTitle("Deposite History");


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DepositHistoryActivity.this,DashboardActivity.class);
                startActivity(intent);
            }
        });


        fabDepositeHistory = findViewById(R.id.fab_deposite_history);

        fabDepositeHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DepositHistoryActivity.this,DepositMoneyActivity.class);
                startActivity(intent);
            }
        });

        mAdapter = new DeposityHistoryAdapter(depositeHistoryLists);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.VERTICAL, 16));
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
