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
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hp.bikebharaui.MyDividerItemDecoration;
import com.example.hp.bikebharaui.R;
import com.example.hp.bikebharaui.Session;
import com.example.hp.bikebharaui.model.TransactionHistoryList;
import com.example.hp.bikebharaui.view.Interface.IOnBackPressed;
import com.example.hp.bikebharaui.view.Interface.IOnOptionsItemPress;
import com.example.hp.bikebharaui.view.adapter.TransactionHistoryAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class TransactionHistoryFragment extends BaseFragment implements IOnOptionsItemPress, IOnBackPressed {

    private Toolbar toolbar;
    Context mContext;

    private List<TransactionHistoryList> transactionHistoryLists = new ArrayList<>();
    private RecyclerView recyclerView;
    private TransactionHistoryAdapter mAdapter;
    private TextView txtViewOUTStanding;
    private double outstanding=0.00;

    private FirebaseDatabase firebaseDatabaseInstance;


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
        txtViewOUTStanding = view.findViewById(R.id.textView_outstanding_transaction_history);
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



        mAdapter = new TransactionHistoryAdapter(transactionHistoryLists);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new MyDividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL, 16));
        recyclerView.setAdapter(mAdapter);


        firebaseDatabaseInstance = FirebaseDatabase.getInstance();
        DatabaseReference dbTranHistReference = firebaseDatabaseInstance.getReference().child("DB").child("Ride History");
        getData(dbTranHistReference);




        return view;
    }

    private void getData(DatabaseReference dbTranHistReference) {
    dbTranHistReference.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            transactionHistoryLists.clear();
            for(DataSnapshot data:dataSnapshot.getChildren()) {
                if (!Session.getUserType()) {
                    String idChecker = (String) data.child("id").getValue();
                    String checker = (String) data.child("user type").getValue();
                    String phnNOChecker = (String) data.child("phone number").getValue();

                    if (checker != null && idChecker!=null && phnNOChecker!=null) {
                        if (checker.equals("Passenger") && idChecker.equals(Session.getPassengerid()) && phnNOChecker.equals(Session.getPassengerphnNumber())) {
                            String name = (String) data.child("name").getValue();
                            String phnNumber = (String) data.child("phone number").getValue();
                            String time = (String) data.child("time").getValue();
                            String id = (String) data.child("id").getValue();
                            String rideORDEPOSIT = (String) data.child("transfer type").getValue();
                            String amount = (String) data.child("amount").getValue();
                            if(rideORDEPOSIT!=null && amount!=null) {
                                if (rideORDEPOSIT.equals("Deposit")) {
                                    double value = Double.parseDouble(amount);
                                    outstanding = value + outstanding;
                                } else {
                                    double value = Double.parseDouble(amount);
                                    outstanding = outstanding - value;
                                }
                            }
                            TransactionHistoryList transactionHistoryListModel = new TransactionHistoryList(name, phnNumber, time, amount, rideORDEPOSIT);
                            transactionHistoryListModel.setTransactionHistoryId(id);
                            transactionHistoryLists.add(transactionHistoryListModel);
                            Log.e("TAG", "onDataChange: " + name + "\t" + phnNumber + " " + time + "\t" + id + "\t" + amount + " " + rideORDEPOSIT);
                        }
                    }
                }
            }

                mAdapter.notifyDataSetChanged();
            txtViewOUTStanding.setText("OutStanding: "+Double.toString(outstanding));
            Log.e("TAG", "onDataChange: "+dataSnapshot);
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {
            Log.e("TAG", "onDataChange: "+databaseError);
        }
    });

    }

    @Override
    public boolean onHomeOptionPress() {
        return false;
    }


    @Override
    public boolean onBackPress() {
        return true;
    }
}
