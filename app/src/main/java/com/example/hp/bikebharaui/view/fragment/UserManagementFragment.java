package com.example.hp.bikebharaui.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.hp.bikebharaui.MyDividerItemDecoration;
import com.example.hp.bikebharaui.R;
import com.example.hp.bikebharaui.model.UserManagementList;

import com.example.hp.bikebharaui.view.Interface.IOnBackPressed;
import com.example.hp.bikebharaui.view.Interface.IOnOptionsItemPress;
import com.example.hp.bikebharaui.view.adapter.UserManagementAdapter;

import java.util.ArrayList;
import java.util.List;

public class UserManagementFragment extends BaseFragment implements IOnOptionsItemPress {

    private Context mContext;

    private List<UserManagementList> userManagementListArrayList = new ArrayList<>();
    private RecyclerView recyclerView;
    private UserManagementAdapter mAdapter;
    private Toolbar toolbar;

    public UserManagementFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_user_management, container, false);

        mContext = getContext();


        if (getActivity() != null) {
            AppCompatActivity activity = (AppCompatActivity) getActivity();
            toolbar = view.findViewById(R.id.toolbar);
            activity.setSupportActionBar(toolbar);
            ActionBar actionBar = activity.getSupportActionBar();
            if (actionBar != null) {
                actionBar.setTitle("User Management");
                actionBar.setDisplayHomeAsUpEnabled(true);
            }
        }




        recyclerView = (RecyclerView) view.findViewById(R.id.user_management_recyclerview);

        mAdapter = new UserManagementAdapter(userManagementListArrayList, new UserManagementAdapter.TransactionHistoryClickListener() {
            @Override
            public void onClickListener(int position) {
//                Intent intent = new Intent(mContext, TransactionHistoryActivity.class);
//                mContext.startActivity(intent);

                loadFragment(new TransactionHistoryFragment());
            }
        }, new UserManagementAdapter.NameClickListener() {
            @Override
            public void onClickListener(int position) {
             /*   Intent intent = new Intent(mContext,AddEditUserActivity.class);
                mContext.startActivity(intent);*/

                loadFragment(new AddEditUserFragment());
            }
        });
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new MyDividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL, 16));
        recyclerView.setAdapter(mAdapter);

        prepareData();
        return view;
    }



    @Override
    public boolean onHomeOptionPress() {
        return false;
    }

    private void prepareData() {

        UserManagementList u = new UserManagementList("Asif Ahmed", "01675599357", "xyz");
        userManagementListArrayList.add(u);

        u = new UserManagementList("Asif Ahmed", "01675599357", "xyz");
        userManagementListArrayList.add(u);

        u = new UserManagementList("Asif Ahmed", "01675599357", "xyz");
        userManagementListArrayList.add(u);


        u = new UserManagementList("Asif Ahmed", "01675599357", "xyz");
        userManagementListArrayList.add(u);


        u = new UserManagementList("Asif Ahmed", "01675599357", "xyz");
        userManagementListArrayList.add(u);

        u = new UserManagementList("Asif Ahmed", "01675599357", "xyz");
        userManagementListArrayList.add(u);

        u = new UserManagementList("Asif Ahmed", "01675599357", "xyz");
        userManagementListArrayList.add(u);

        mAdapter.notifyDataSetChanged();

    }
}
