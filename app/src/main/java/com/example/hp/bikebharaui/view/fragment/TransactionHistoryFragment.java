package com.example.hp.bikebharaui.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.provider.CalendarContract;
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
import android.widget.EditText;

import com.example.hp.bikebharaui.InsertData;
import com.example.hp.bikebharaui.MyDividerItemDecoration;
import com.example.hp.bikebharaui.R;
import com.example.hp.bikebharaui.model.RideHistoryList;
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
    private EditText edtSearch;

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
        edtSearch = view.findViewById(R.id.edittext_searchbox_transaction_history);
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


        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String userInput = s.toString().toLowerCase();
                List<TransactionHistoryList> newList = new ArrayList<>();
                for(TransactionHistoryList transactionHistoryList : transactionHistoryLists){
                    String name = transactionHistoryList.getName().toLowerCase();
                    if(name.contains(userInput)){
                        newList.add(transactionHistoryList);
                    }
            }
            mAdapter.updateList(newList);
            }
        });

        return view;
    }

    private void getData(DatabaseReference dbTranHistReference) {
    dbTranHistReference.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            transactionHistoryLists.clear();
            for(DataSnapshot data:dataSnapshot.getChildren()) {
                String checker = (String) data.child("user type").getValue();
                if (checker!=null&&checker.equals("Passenger")) {
                    String name = (String) data.child("name").getValue();
                    String phnNumber = (String) data.child("phone number").getValue();
                    String time = (String) data.child("time").getValue();
                    String id = (String) data.child("id").getValue();
                    String rideORDEPOSIT = (String) data.child("transfer type").getValue();
                    String amount = (String) data.child("amount").getValue();
                    TransactionHistoryList transactionHistoryListModel = new TransactionHistoryList(name, phnNumber, time, amount, rideORDEPOSIT);
                    transactionHistoryListModel.setTransactionHistoryId(id);
                    transactionHistoryLists.add(transactionHistoryListModel);
                    Log.e("TAG", "onDataChange: " + name + "\t" + phnNumber + " " + time + "\t" + id + "\t" + amount + " " + rideORDEPOSIT);
                }
            }

                mAdapter.notifyDataSetChanged();
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
