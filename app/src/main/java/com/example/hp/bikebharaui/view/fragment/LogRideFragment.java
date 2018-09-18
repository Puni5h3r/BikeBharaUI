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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.hp.bikebharaui.MyDividerItemDecoration;
import com.example.hp.bikebharaui.R;
import com.example.hp.bikebharaui.model.LogRideList;
import com.example.hp.bikebharaui.view.Interface.IOnBackPressed;
import com.example.hp.bikebharaui.view.Interface.IOnOptionsItemPress;
import com.example.hp.bikebharaui.view.adapter.LogRideAdapter;

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

        fabLogRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(mContext,LogRideMoneyActivity.class);
//                mContext.startActivity(intent);
                loadFragment(new LogRideMoneyFragment());
            }
        });



        mAdapter = new LogRideAdapter(logRideLists);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new MyDividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL, 16));
        recyclerView.setAdapter(mAdapter);

        prepareData();

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
                for(LogRideList logRideList : logRideLists){
                    String name = logRideList.getName().toLowerCase();
                    if(name.contains(userInput)){
                        newList.add(logRideList);
                    }

                }
                mAdapter.updateList(newList);
            }
        });
        return view;
    }

    private void prepareData() {
        LogRideList u = new LogRideList("Asif Ahmed", "01675599357", "19 March 2018 10:30 AM");
        logRideLists.add(u);



        u = new LogRideList("Asif Ahmed", "01675599357", "19 March 2018 10:30 AM");
        logRideLists.add(u);
        u = new LogRideList("Asif Ahmed", "01675599357", "19 March 2018 10:30 AM");
        logRideLists.add(u);
        u = new LogRideList("Asif Ahmed", "01675599357", "19 March 2018 10:30 AM");
        logRideLists.add(u);
        u = new LogRideList("Asif Ahmed", "01675599357", "19 March 2018 10:30 AM");
        logRideLists.add(u);
        u = new LogRideList("Asif Ahmed", "01675599357", "19 March 2018 10:30 AM");
        logRideLists.add(u);
        u = new LogRideList("Asif Ahmed", "01675599357", "19 March 2018 10:30 AM");
        logRideLists.add(u);
        u = new LogRideList("Asif Ahmed", "01675599357", "19 March 2018 10:30 AM");
        logRideLists.add(u);

        mAdapter.notifyDataSetChanged();

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


