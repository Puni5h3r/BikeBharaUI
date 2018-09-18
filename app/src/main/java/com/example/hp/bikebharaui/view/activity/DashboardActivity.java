package com.example.hp.bikebharaui.view.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.hp.bikebharaui.R;
import com.example.hp.bikebharaui.view.Interface.IOnBackPressed;
import com.example.hp.bikebharaui.view.Interface.IOnOptionsItemPress;
import com.example.hp.bikebharaui.view.fragment.DashbordFragment;

public class DashboardActivity extends BaseActivity {

    private int countBackPress = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        loadFragment(new DashbordFragment());



    }

    @Override
    public void onBackPressed() {

        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.container);

        // stop application exit from the application
        if (!(fragment instanceof IOnBackPressed) || !((IOnBackPressed) fragment).onBackPress()) {
            ++countBackPress;
            if(countBackPress==1){
                Toast.makeText(this, "press back again if you want to exit", Toast.LENGTH_SHORT).show();
            }
           else if(countBackPress==2) {
                countBackPress=0;
                Intent homeIntent = new Intent(Intent.ACTION_MAIN);
                homeIntent.addCategory(Intent.CATEGORY_HOME);
                homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
            }
        } else {
            getSupportFragmentManager().popBackStack();
            //  Toast.makeText(this, "press back again if you want to exit", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // getActivity().onBackPressed();
//                onBackPress();


                Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.container);
                if (!(fragment instanceof IOnOptionsItemPress) || !(((IOnOptionsItemPress) fragment).onHomeOptionPress())) {
                    getSupportFragmentManager().popBackStack();
                }
//                    Toast.makeText(DashboardActivity.this, "Dim press", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(DashboardActivity.this, "back press button press", Toast.LENGTH_SHORT).show();
//                return true;
        }


        return true;
    }
}
