package com.example.hp.bikebharaui.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.hp.bikebharaui.MyDividerItemDecoration;
import com.example.hp.bikebharaui.R;
import com.example.hp.bikebharaui.model.TransactionHistoryList;
import com.example.hp.bikebharaui.view.adapter.TransactionHistoryAdapter;

import java.util.ArrayList;
import java.util.List;

public class TransactionHistoryActivity extends AppCompatActivity {

    private List<TransactionHistoryList> transactionHistoryLists = new ArrayList<>();
    private RecyclerView recyclerView;
    private TransactionHistoryAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_history);

        recyclerView = findViewById(R.id.transaction_history_recyclerView);

        mAdapter = new TransactionHistoryAdapter(transactionHistoryLists);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.VERTICAL, 19));
        recyclerView.setAdapter(mAdapter);

        prepareData();

    }

    private void prepareData() {
        TransactionHistoryList t = new TransactionHistoryList("Asif Ahmed", "01675599357", "19 March 2018 10:30 AM", "500 tk","deposite");
        transactionHistoryLists.add(t);

        t = new TransactionHistoryList("Asif Ahmed", "01675599357", "19 March 2018 10:30 AM", "500 tk","ride");
        transactionHistoryLists.add(t);

        t = new TransactionHistoryList("Asif Ahmed", "01675599357", "19 March 2018 10:30 AM", "500 tk","ride");
        transactionHistoryLists.add(t);

        t = new TransactionHistoryList("Asif Ahmed", "01675599357", "19 March 2018 10:30 AM", "500 tk","ride");
        transactionHistoryLists.add(t);

        t = new TransactionHistoryList("Asif Ahmed", "01675599357", "19 March 2018 10:30 AM", "500 tk","ride");
        transactionHistoryLists.add(t);

        mAdapter.notifyDataSetChanged();



    }
}
