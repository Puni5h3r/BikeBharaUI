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
import android.widget.ImageButton;

import com.example.hp.bikebharaui.MyDividerItemDecoration;
import com.example.hp.bikebharaui.R;
import com.example.hp.bikebharaui.Session;
import com.example.hp.bikebharaui.model.LogRideList;
import com.example.hp.bikebharaui.model.TransactionHistoryList;
import com.example.hp.bikebharaui.view.Interface.IOnBackPressed;
import com.example.hp.bikebharaui.view.Interface.IOnOptionsItemPress;
import com.example.hp.bikebharaui.view.adapter.LogRideAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class LogRideFragment extends BaseFragment implements IOnOptionsItemPress,IOnBackPressed {

    private Toolbar toolbar;
    private FloatingActionButton fabLogRide;
    Context mContext;

    private List<LogRideList> logRideLists = new ArrayList<>();
    private RecyclerView recyclerView;
    private LogRideAdapter mAdapter;
    private EditText edtSearch;
    private FirebaseDatabase firebaseDatabaseInstance;
    private ImageButton imageSearchButton;
private Double outStanding=0.00;
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

       AppCompatActivity activity = (AppCompatActivity)getActivity();
       if(activity!=null){
           toolbar = view.findViewById(R.id.toolbar);
           activity.setSupportActionBar(toolbar);
           ActionBar actionBar = activity.getSupportActionBar();
           if(actionBar!=null){
               actionBar.setTitle("Log Ride");
               actionBar.setDisplayHomeAsUpEnabled(true);

           }

       }

        fabLogRide = view.findViewById(R.id.fab_log_ride);
       edtSearch = view.findViewById(R.id.edittext_searchbox_log_ride);
       imageSearchButton=view.findViewById(R.id.button_searchbox_log_ride);

        fabLogRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(mContext,LogRideMoneyActivity.class);
//                mContext.startActivity(intent);
                loadFragment(new LogRideMoneyFragment());
            }
        });
        if(Session.getUserType()){
            fabLogRide.setVisibility(View.INVISIBLE);
            fabLogRide.setVisibility(View.GONE);
        }



        mAdapter = new LogRideAdapter(logRideLists);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new MyDividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL, 16));
        recyclerView.setAdapter(mAdapter);

        firebaseDatabaseInstance = FirebaseDatabase.getInstance();
        DatabaseReference dbLogRideReference = firebaseDatabaseInstance.getReference().child("DB").child("Ride History");
        getData(dbLogRideReference);


if(!Session.getUserType()) {
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
            List<LogRideList> newList = new ArrayList<>();
            for (LogRideList logRideList : logRideLists) {
                String name = logRideList.getName().toLowerCase();
                if (name.contains(userInput)) {
                    newList.add(logRideList);
                }

            }
            mAdapter.updateList(newList);
        }
    });
}
else {

    edtSearch.setFocusable(false);
    imageSearchButton.setVisibility(View.INVISIBLE);
    imageSearchButton.setVisibility(View.GONE);
}
        return view;
    }

    private void getData(DatabaseReference dbLogRideReference) {

        dbLogRideReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                logRideLists.clear();
                for(DataSnapshot data:dataSnapshot.getChildren()) {
                    if (Session.getUserType()) {
                        String checker = (String) data.child("user type").getValue();
                        String idChecker = (String) data.child("id").getValue();
                        String rideORDEPOSIT = (String) data.child("transfer type").getValue();
                        String phnNumberChecker = (String) data.child("phone number").getValue();
                        if (checker != null && idChecker != null && rideORDEPOSIT!=null && phnNumberChecker!=null) {
                            if(checker.equals("Passenger") && idChecker.equals(Session.getPassengerid()) && rideORDEPOSIT.equals("Deposit")
                                    && phnNumberChecker.equals(Session.getPassengerphnNumber())){
                                String amount = (String) data.child("amount").getValue();
                                double value = Double.parseDouble(amount);
                                outStanding = outStanding+value;

                            }
                            if (checker.equals("Passenger") && idChecker.equals(Session.getPassengerid()) && rideORDEPOSIT.equals("Ride")
                                   && phnNumberChecker.equals(Session.getPassengerphnNumber())) {
                                String name = (String) data.child("name").getValue();
                                String phnNumber = (String) data.child("phone number").getValue();
                                String time = (String) data.child("time").getValue();
                                String id = (String) data.child("id").getValue();
                                String amount = (String) data.child("amount").getValue();
                                double value = Double.parseDouble(amount);
                                outStanding = outStanding-value;
                                LogRideList logRideListListModel = new LogRideList(name, phnNumber, time);
                                logRideListListModel.setAmount(amount);
                                logRideListListModel.setLogRideId(id);
                                logRideLists.add(logRideListListModel);

                            }
                            String k = "OutStanding: "+Double.toString(outStanding);
                            edtSearch.setText(k);
                        }
                    }else {
                            String checker = (String) data.child("user type").getValue();
                        String idChecker = (String) data.child("id").getValue();
                        String rideORDEPOSIT = (String) data.child("transfer type").getValue();
                            if (checker != null && idChecker!=null && rideORDEPOSIT!=null) {
                                if(checker.equals("Passenger") && idChecker.equals(Session.getRiderid()) && rideORDEPOSIT.equals("Ride")) {
                                    String name = (String) data.child("name").getValue();
                                    String phnNumber = (String) data.child("phone number").getValue();
                                    String time = (String) data.child("time").getValue();
                                    String id = (String) data.child("id").getValue();
                                    String amount = (String) data.child("amount").getValue();
                                    LogRideList logRideListListModel = new LogRideList(name, phnNumber, time);
                                    logRideListListModel.setAmount(amount);
                                    logRideListListModel.setLogRideId(id);
                                    logRideLists.add(logRideListListModel);
                                    Log.e("TAG", "onDataChange: " + data + "\t" + phnNumber + " " + time + "\t" + id + "\t");
                                }
                                }

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


