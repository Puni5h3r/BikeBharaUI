package com.example.hp.bikebharaui.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
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
import com.example.hp.bikebharaui.model.DepositeHistoryList;
import com.example.hp.bikebharaui.view.Interface.IOnBackPressed;
import com.example.hp.bikebharaui.view.Interface.IOnOptionsItemPress;
import com.example.hp.bikebharaui.view.adapter.DeposityHistoryAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DepositHistoryFragment extends BaseFragment implements IOnOptionsItemPress,IOnBackPressed {


    private Toolbar toolbar;
    private FloatingActionButton fabDepositeHistory;

    private List<DepositeHistoryList> depositeHistoryLists = new ArrayList<>();
    private RecyclerView recyclerView;
    private DeposityHistoryAdapter mAdapter;
    private EditText edtSearchbox;

    FirebaseDatabase firebaseDatabaseInstance;

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
        edtSearchbox = view.findViewById(R.id.edittext_searchbox_deposit_history);

        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if(activity!=null){
            toolbar = (Toolbar) view.findViewById(R.id.toolbar);
            activity.setSupportActionBar(toolbar);
            ActionBar actionBar = activity.getSupportActionBar();
            if (actionBar != null){
                actionBar.setTitle("Deposit history");
                actionBar.setDisplayHomeAsUpEnabled(true);
            }

        }


        fabDepositeHistory = view.findViewById(R.id.fab_deposite_history);

        fabDepositeHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(mContext,DepositMoneyActivity.class);
//                mContext.startActivity(intent);

                loadFragment(new DepositMoneyFrag());
            }
        });

        mAdapter = new DeposityHistoryAdapter(depositeHistoryLists);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new MyDividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL, 16));
        recyclerView.setAdapter(mAdapter);


        firebaseDatabaseInstance = FirebaseDatabase.getInstance();
        DatabaseReference rideHistoryRef = firebaseDatabaseInstance.getReference().child("DB").child("Ride History");

        getData(rideHistoryRef);

        edtSearchbox.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            String userInput = s.toString().toLowerCase();
            List<DepositeHistoryList> newList = new ArrayList<>();
                for(DepositeHistoryList depositeHistoryList : depositeHistoryLists){
                    String name = depositeHistoryList.getName().toLowerCase();
                    if(name.contains(userInput)){
                        newList.add(depositeHistoryList);
                    }

                }
                mAdapter.updateList(newList);
            }
        });
        return view;
    }

    private void getData(DatabaseReference dbDepositHistory) {
        dbDepositHistory.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                depositeHistoryLists.clear();
                for(DataSnapshot data:dataSnapshot.getChildren()) {
                    String checker = (String) data.child("user type").getValue();
                       if (checker!=null && checker.equals("Passenger")) {
                        String name = (String) data.child("name").getValue();
                        String phnNumber = (String) data.child("phone number").getValue();
                        String time = (String) data.child("time").getValue();
                        String id = (String) data.child("id").getValue();
                        // Long amt = (Long) data.child("amount").getValue();
                        String amount = (String) data.child("amount").getValue();
                        DepositeHistoryList depositeHistoryModel = new DepositeHistoryList(name, phnNumber, time, amount);
                        depositeHistoryModel.setDepositHisotryid(id);
                        depositeHistoryLists.add(depositeHistoryModel);

                    }
                }

                mAdapter.notifyDataSetChanged();
                Log.e("TAG","onDataChange: "+dataSnapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

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
