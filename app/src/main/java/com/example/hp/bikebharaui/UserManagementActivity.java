package com.example.hp.bikebharaui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UserManagementActivity extends AppCompatActivity {
    private List<UserManagementList> userManagementListArrayList = new ArrayList<>();
    private RecyclerView recyclerView;
    private UserManagementAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_management);


        recyclerView = (RecyclerView) findViewById(R.id.user_management_recyclerview);

        mAdapter = new UserManagementAdapter(userManagementListArrayList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.VERTICAL, 19));
        recyclerView.setAdapter(mAdapter);

        prepareData();
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

