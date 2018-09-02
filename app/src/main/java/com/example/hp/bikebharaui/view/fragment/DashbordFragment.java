package com.example.hp.bikebharaui.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.hp.bikebharaui.R;
import com.example.hp.bikebharaui.view.Interface.IOnBackPressed;


public class DashbordFragment extends BaseFragment implements View.OnClickListener, IOnBackPressed {

    private Button btnUserManagement, btnRideHistory, btnDepositHistory, btnLogRide;


    private int countBackPress = 0;

    public DashbordFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_dashbord, container, false);
        Toolbar toolbar = view.findViewById(R.id.toolbar);


        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        if (((AppCompatActivity) getActivity()).getSupportActionBar() != null)
            ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        btnUserManagement = view.findViewById(R.id.btnUserManagement);
        btnRideHistory = view.findViewById(R.id.btnRideHistory);
        btnDepositHistory = view.findViewById(R.id.btnDepositHistory);
        btnLogRide = view.findViewById(R.id.btnLogRide);

        setListener();
        return view;
    }

    private void setListener() {
        btnUserManagement.setOnClickListener(this);
        btnRideHistory.setOnClickListener(this);
        btnDepositHistory.setOnClickListener(this);
        btnLogRide.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnUserManagement:
                userManagement();
                break;

            case R.id.btnRideHistory:
                rideHistory();
                break;

            case R.id.btnDepositHistory:
                depostiMoney();
                break;

            case R.id.btnLogRide:
                logRide();
                break;


        }
    }

    public void rideHistory() {
//        Intent intent = new Intent(getContext(), RideHistoryActivity.class);
//        startActivity(intent);

        loadFragment(new RideHistoryFragment(), DashbordFragment.class.getSimpleName());


    }

    public void userManagement() {
  /*      Intent intent = new Intent(getContext(), UserManagementActivity.class);
        startActivity(intent);*/

        loadFragment(new UserManagementFragment(), DashbordFragment.class.getSimpleName());

    }

    public void depostiMoney() {
//        Intent intent = new Intent(getContext(), DepositHistoryActivity.class);
//        startActivity(intent);

        loadFragment(new DepositHistoryFragment(), DashbordFragment.class.getSimpleName());


    }

    public void logRide() {
//        Intent intent = new Intent(getContext(), LogRideActivity.class);
//        startActivity(intent);

        loadFragment(new LogRideFragment(), DashbordFragment.class.getSimpleName());


    }

    @Override
    public boolean onBackPress() {
        countBackPress++;
        if (countBackPress != 2) {
            //action not popBackStack
            return true;
        } else {
            countBackPress = 0;
            return false;
        }
    }
}
