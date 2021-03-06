package com.example.hp.bikebharaui.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.hp.bikebharaui.R;

public class BaseFragment extends Fragment {

    public void loadFragment(Fragment fragment) {
        FragmentManager manager = getFragmentManager();

        String backStack = fragment.getClass().getSimpleName();
        if (manager != null) {
            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(R.id.container, fragment);
            ft.addToBackStack(backStack);
            ft.commit();
        }
    }

    public void loadFragment(Fragment fragment, Bundle arg) {
        FragmentManager manager = getFragmentManager();
        fragment.setArguments(arg);
        String backStack = fragment.getClass().getSimpleName();
        if (manager != null) {
            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(R.id.container, fragment);
            ft.addToBackStack(backStack);
            ft.commit();
        }
    }

}
