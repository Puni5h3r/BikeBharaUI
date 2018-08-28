package com.example.hp.bikebharaui.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hp.bikebharaui.R;
import com.example.hp.bikebharaui.view.fragment.DashbordFragment;

public class DashboardActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        loadFragment(new DashbordFragment(),DashboardActivity.class.getSimpleName());


    }


}
