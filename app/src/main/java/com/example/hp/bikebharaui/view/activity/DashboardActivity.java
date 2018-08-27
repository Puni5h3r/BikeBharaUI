package com.example.hp.bikebharaui.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hp.bikebharaui.R;

public class DashboardActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

    btn1 = findViewById(R.id.button1);
    btn2 = findViewById(R.id.button2);
    btn3 = findViewById(R.id.button3);
    btn4 = findViewById(R.id.button4);

    }


    public void rideHistory(View view) {
        Intent intent = new Intent(DashboardActivity.this, RideHistoryActivity.class);
        startActivity(intent);




    }

    public void userManagement(View view) {
        Intent intent = new Intent(DashboardActivity.this, UserManagementActivity.class);
        startActivity(intent);

    }

    public void depostiMoney(View view) {
        Intent intent = new Intent(DashboardActivity.this, DepositHistoryActivity.class);
        startActivity(intent);


    }

    public void logRide(View view) {
        Intent intent = new Intent(DashboardActivity.this, LogRideActivity.class);
        startActivity(intent);


    }
}
