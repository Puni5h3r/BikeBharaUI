package com.example.hp.bikebharaui.view.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.hp.bikebharaui.MyDividerItemDecoration;
import com.example.hp.bikebharaui.R;
import com.example.hp.bikebharaui.model.UserManagementList;
import com.example.hp.bikebharaui.view.adapter.UserManagementAdapter;

import java.util.ArrayList;
import java.util.List;

public class UserManagementActivity extends AppCompatActivity {
    private Toolbar toolbar;

    private List<UserManagementList> userManagementListArrayList = new ArrayList<>();
    private RecyclerView recyclerView;
    private UserManagementAdapter mAdapter;
private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_management);
        mContext=this;

        toolbar = findViewById(R.id.toolbar_user_management);
        toolbar.setTitle("User Management");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserManagementActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        });



        recyclerView = (RecyclerView) findViewById(R.id.user_management_recyclerview);

        mAdapter = new UserManagementAdapter(userManagementListArrayList, new UserManagementAdapter.TransactionHistoryClickListener() {
            @Override
            public void onClickListener(int position) {
                Intent intent = new Intent(mContext, TransactionHistoryActivity.class);
                mContext.startActivity(intent);
            }
        }, new UserManagementAdapter.NameClickListener() {
            @Override
            public void onClickListener(int position) {
                Intent intent = new Intent(mContext,AddEditUserActivity.class);
                mContext.startActivity(intent);
            }
        });
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.VERTICAL, 16));
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

