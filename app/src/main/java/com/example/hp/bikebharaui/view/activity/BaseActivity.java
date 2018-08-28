package com.example.hp.bikebharaui.view.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.hp.bikebharaui.R;

public class BaseActivity extends AppCompatActivity {

    public void loadFragment(Fragment fragment, String backStack) {
        FragmentManager manager = getSupportFragmentManager();

        if (manager != null){

            FragmentTransaction ft= manager.beginTransaction();

            ft.replace(R.id.container,fragment);

            ft.addToBackStack(backStack);

            ft.commit();
        }
    }
}
