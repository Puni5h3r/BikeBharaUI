package com.example.hp.bikebharaui.view.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.hp.bikebharaui.R;

public class BaseFragment extends Fragment {

    public void loadFragment(Fragment fragment, String backStack) {
        FragmentManager manager = getFragmentManager();

        if (manager != null){

           FragmentTransaction ft= manager.beginTransaction();

           ft.replace(R.id.container,fragment);

           ft.addToBackStack(backStack);

           ft.commit();
        }
    }
}
