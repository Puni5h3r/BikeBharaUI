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
import com.example.hp.bikebharaui.view.activity.DashboardActivity;
import com.example.hp.bikebharaui.view.activity.DepositHistoryActivity;
import com.example.hp.bikebharaui.view.activity.LogRideActivity;
import com.example.hp.bikebharaui.view.activity.RideHistoryActivity;
import com.example.hp.bikebharaui.view.activity.UserManagementActivity;

public class DashbordFragment extends BaseFragment{

    private Button btn1, btn2, btn3, btn4;
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
        btn1 = view.findViewById(R.id.button1);
        btn2 = view.findViewById(R.id.button2);
        btn3 = view.findViewById(R.id.button3);

        btn4 = view.findViewById(R.id.button4);
        return view;
    }


    public void rideHistory(View view) {
        Intent intent = new Intent(getContext(), RideHistoryActivity.class);
        startActivity(intent);




    }

    public void userManagement(View view) {
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
