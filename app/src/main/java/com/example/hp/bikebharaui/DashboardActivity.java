package com.example.hp.bikebharaui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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



    }

    public void userManagement(View view) {
        Intent intent = new Intent(DashboardActivity.this, UserManagement.class);
        startActivity(intent);

    }

    public void depostiMoney(View view) {


    }

    public void logRide(View view) {


    }
}
