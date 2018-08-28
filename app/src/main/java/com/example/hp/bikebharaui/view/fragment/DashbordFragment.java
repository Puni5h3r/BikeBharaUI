package com.example.hp.bikebharaui.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.hp.bikebharaui.R;
import com.example.hp.bikebharaui.view.activity.DepositHistoryActivity;
import com.example.hp.bikebharaui.view.activity.LogRideActivity;
import com.example.hp.bikebharaui.view.activity.RideHistoryActivity;
import com.example.hp.bikebharaui.view.activity.UserManagementActivity;

public class DashbordFragment extends BaseFragment implements View.OnClickListener{

    private Button btnUserManagement, btn2, btn3, btn4;
    public DashbordFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.frag_dashbord,container,false);
        btnUserManagement = view.findViewById(R.id.btnUserManagement);
        btn2 = view.findViewById(R.id.button2);
        btn3 = view.findViewById(R.id.button3);

        btn4 = view.findViewById(R.id.button4);

        setListener();
        return view;
    }

    private void setListener() {
        btnUserManagement.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnUserManagement:
                userManagement();
                break;
        }
    }

    public void rideHistory(View view) {
        Intent intent = new Intent(getContext(), RideHistoryActivity.class);
        startActivity(intent);




    }

    public void userManagement() {
        Intent intent = new Intent(getContext(), UserManagementActivity.class);
        startActivity(intent);

    }

    public void depostiMoney(View view) {
        Intent intent = new Intent(getContext(), DepositHistoryActivity.class);
        startActivity(intent);


    }

    public void logRide(View view) {
        Intent intent = new Intent(getContext(), LogRideActivity.class);
        startActivity(intent);


    }
}
