package com.example.hp.bikebharaui.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import com.example.hp.bikebharaui.Session;
import com.example.hp.bikebharaui.model.DepositeHistoryList;
import com.example.hp.bikebharaui.model.RideHistoryList;
import com.example.hp.bikebharaui.view.Interface.IOnBackPressed;
import com.example.hp.bikebharaui.view.Interface.IOnOptionsItemPress;
import com.example.hp.bikebharaui.view.adapter.RideHistoryAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class RideHistoryFragment extends BaseFragment implements IOnOptionsItemPress, IOnBackPressed {
    private Context mContext;

    private Toolbar toolbar;
    private FloatingActionButton fabRideHistoryActivity;

    private List<RideHistoryList> rideHistoryLists = new ArrayList<>();
    private RecyclerView recyclerView;
    private RideHistoryAdapter mAdapter;
    private EditText edtSearchView;

    private FirebaseDatabase firebaseDatabaseInstance;

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
        edtSearchView = view.findViewById(R.id.edittext_searchbox_ride_history);
        fabRideHistoryActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(mContext, LogRideMoneyActivity.class);
//                mContext.startActivity(intent);

                loadFragment(new LogRideMoneyFragment());
            }
        });

        AppCompatActivity activity = (AppCompatActivity)getActivity();
        if(activity!=null){
            toolbar=view.findViewById(R.id.toolbar);
            activity.setSupportActionBar(toolbar);
            ActionBar actionBar = activity.getSupportActionBar();
            if(actionBar!=null){
                actionBar.setTitle("Ride History");
                actionBar.setDisplayHomeAsUpEnabled(true);

            }

        }

        recyclerView = (RecyclerView) view.findViewById(R.id.ride_history_recyclerView);

        mAdapter = new RideHistoryAdapter(rideHistoryLists);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new MyDividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL, 16));
        recyclerView.setAdapter(mAdapter);


        firebaseDatabaseInstance = FirebaseDatabase.getInstance();
        DatabaseReference rideHistoryRef = firebaseDatabaseInstance.getReference().child("DB").child("Ride History");

        getData(rideHistoryRef);

        edtSearchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String userInput = s.toString().toLowerCase();
                List<RideHistoryList> newList = new ArrayList<>();
                for(RideHistoryList rideHistoryList : rideHistoryLists){
                    String name = rideHistoryList.getName().toLowerCase();
                    if(name.contains(userInput)){
                        newList.add(rideHistoryList);
                    }

                }
                mAdapter.updateList(newList);
            }
        });

        return view;
    }

    private void getData(DatabaseReference myRef) {
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                rideHistoryLists.clear();
                for(DataSnapshot data:dataSnapshot.getChildren()) {
                    if (Session.getUserType()) {
                        String checker = (String) data.child("user type").getValue();
                        String idChecker = (String) data.child("id").getValue();
                        if (checker != null && idChecker!=null) {
                            if (checker.equals("Passenger") && idChecker.equals(Session.getId())) {
                                String name = (String) data.child("name").getValue();
                                String phnNumber = (String) data.child("phone number").getValue();
                                String time = (String) data.child("time").getValue();
                                String id = (String) data.child("id").getValue();
                                // Long amt = (Long) data.child("amount").getValue();
                                String amount = (String) data.child("amount").getValue();
                                RideHistoryList rideHistoryListModel = new RideHistoryList(name, phnNumber, time);
                                rideHistoryListModel.setRideHistoryId(id);
                                rideHistoryLists.add(rideHistoryListModel);;
                            }
                        }
                    }
                    else{
                        String checker = (String) data.child("user type").getValue();
                        if (checker != null && checker.equals("Passenger")) {
                            String name = (String) data.child("name").getValue();
                            String phnNumber = (String) data.child("phone number").getValue();
                            String time = (String) data.child("time").getValue();
                            String id = (String) data.child("id").getValue();
                            RideHistoryList rideHistoryListModel = new RideHistoryList(name, phnNumber, time);
                            rideHistoryListModel.setRideHistoryId(id);
                            rideHistoryLists.add(rideHistoryListModel);
                            Log.e("TAG", "onDataChange: " + name + "\t" + phnNumber + " " + time + "\t" + id);

                        }
                    }
                }

                mAdapter.notifyDataSetChanged();

                Log.e("TAG", "onDataChange: "+dataSnapshot);
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
