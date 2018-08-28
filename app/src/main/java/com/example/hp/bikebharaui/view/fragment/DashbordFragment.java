package com.example.hp.bikebharaui.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toolbar;

import com.example.hp.bikebharaui.R;
import com.example.hp.bikebharaui.view.Interface.IOnBackPressed;
import com.example.hp.bikebharaui.view.activity.DepositHistoryActivity;
import com.example.hp.bikebharaui.view.activity.LogRideActivity;
import com.example.hp.bikebharaui.view.activity.RideHistoryActivity;


public class DashbordFragment extends BaseFragment implements View.OnClickListener, IOnBackPressed {

    private Button btnUserManagement, btn2, btn3, btn4;


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
        btnUserManagement = view.findViewById(R.id.btnUserManagement);
        btn2 = view.findViewById(R.id.button2);
        btn3 = view.findViewById(R.id.button3);
        btn4 = view.findViewById(R.id.button4);

        setListener();
        return view;
    }

    private void setListener() {
        btnUserManagement.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnUserManagement:
                userManagement();
                break;

            case R.id.button2:
                rideHistory();
                break;

            case R.id.button3:
                depostiMoney();
                break;

            case R.id.button4:
                logRide();
                break;


        }
    }

    public void rideHistory() {
        Intent intent = new Intent(getContext(), RideHistoryActivity.class);
        startActivity(intent);


    }

    public void userManagement() {
  /*      Intent intent = new Intent(getContext(), UserManagementActivity.class);
        startActivity(intent);*/

        loadFragment(new UserManagementFragment(), DashbordFragment.class.getSimpleName());

    }

    public void depostiMoney() {
        Intent intent = new Intent(getContext(), DepositHistoryActivity.class);
        startActivity(intent);


    }

    public void logRide() {
        Intent intent = new Intent(getContext(), LogRideActivity.class);
        startActivity(intent);


    }

    @Override
    public boolean onBackPress() {
        countBackPress++;
        if (countBackPress != 2) {
            //action not popBackStack
            return true;
        } else {
            countBackPress=0;
            return false;
        }
    }
}
