package com.example.hp.bikebharaui.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hp.bikebharaui.MyDividerItemDecoration;
import com.example.hp.bikebharaui.R;
import com.example.hp.bikebharaui.model.TransactionHistoryList;
import com.example.hp.bikebharaui.view.Interface.IOnOptionsItemPress;
import com.example.hp.bikebharaui.view.adapter.TransactionHistoryAdapter;

import java.util.ArrayList;
import java.util.List;

public class TransactionHistoryFragment extends BaseFragment implements IOnOptionsItemPress {

    private Toolbar toolbar;
    Context mContext;

    private List<TransactionHistoryList> transactionHistoryLists = new ArrayList<>();
    private RecyclerView recyclerView;
    private TransactionHistoryAdapter mAdapter;


    public TransactionHistoryFragment() {
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_transaction_history, container, false);
        mContext = getContext();

        recyclerView = view.findViewById(R.id.transaction_history_recyclerView);


        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (activity != null) {
            toolbar = view.findViewById(R.id.toolbar);
            activity.setSupportActionBar(toolbar);
            ActionBar actionBar = activity.getSupportActionBar();
            if (actionBar != null){
                actionBar.setTitle("Transaction history");
                actionBar.setDisplayHomeAsUpEnabled(true);
            }
        }

//        toolbar = findViewById(R.id.toolbar_transaction_history);
//        toolbar.setTitle("Transaction History");
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//             /*   Intent intent = new Intent(TransactionHistoryActivity.this,UserManagementActivity.class);
//                startActivity(intent);*/
//            }
//        });


        mAdapter = new TransactionHistoryAdapter(transactionHistoryLists);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new MyDividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL, 16));
        recyclerView.setAdapter(mAdapter);

        prepareData();

        return view;
    }

    @Override
    public boolean onHomeOptionPress() {
        return false;
    }

    private void prepareData() {
        TransactionHistoryList t = new TransactionHistoryList("Asif Ahmed", "01675599357", "19 March 2018 10:30 AM", "500 tk", "deposite");
        transactionHistoryLists.add(t);

        t = new TransactionHistoryList("Asif Ahmed", "01675599357", "19 March 2018 10:30 AM", "500 tk", "ride");
        transactionHistoryLists.add(t);

        t = new TransactionHistoryList("Asif Ahmed", "01675599357", "19 March 2018 10:30 AM", "500 tk", "ride");
        transactionHistoryLists.add(t);

        t = new TransactionHistoryList("Asif Ahmed", "01675599357", "19 March 2018 10:30 AM", "500 tk", "ride");
        transactionHistoryLists.add(t);

        t = new TransactionHistoryList("Asif Ahmed", "01675599357", "19 March 2018 10:30 AM", "500 tk", "ride");
        transactionHistoryLists.add(t);

        mAdapter.notifyDataSetChanged();


    }
}
