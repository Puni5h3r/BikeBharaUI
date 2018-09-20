package com.example.hp.bikebharaui.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class UserManagementFragment extends BaseFragment implements IOnOptionsItemPress, IOnBackPressed {

    private Context mContext;

    private List<UserManagementList> userManagementListArrayList = new ArrayList<>();
    private RecyclerView recyclerView;
    private UserManagementAdapter mAdapter;
    private Toolbar toolbar;
    private FloatingActionButton fab;
    private FirebaseDatabase firebaseDatabaseInstance;

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

            fab=view.findViewById(R.id.fab_user_management);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new AddEditUserFragment());
            }
        });



        recyclerView = (RecyclerView) view.findViewById(R.id.user_management_recyclerview);

        mAdapter = new UserManagementAdapter(userManagementListArrayList, new UserManagementAdapter.TransactionHistoryClickListener() {
            @Override
            public void onClickListener(int position) {

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

        firebaseDatabaseInstance = FirebaseDatabase.getInstance();
        DatabaseReference dbUserManagementRef = firebaseDatabaseInstance.getReference().child("DB").child("Ride History");
        getData(dbUserManagementRef);

        return view;
    }

    private void getData(DatabaseReference dbUserManagementRef) {
        dbUserManagementRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                userManagementListArrayList.clear();
                for(DataSnapshot data:dataSnapshot.getChildren()) {
                    String checker = (String)data.child("user type").getValue();
                    if (checker!=null&&checker.equals("Passenger")) {
                        String name = (String) data.child("name").getValue();
                        String phnNumber = (String) data.child("phone number").getValue();
                        String time = (String) data.child("time").getValue();
                        String id = (String) data.child("id").getValue();
                        UserManagementList userManagementList = new UserManagementList(name, phnNumber);
                        userManagementList.setUserManagementListID(id);
                        userManagementListArrayList.add(userManagementList);
                        Log.e("TAG", "onDataChange: " + name + "\t" + phnNumber + " " + time + "\t" + id);
                    }
                }

                mAdapter.notifyDataSetChanged();
                Log.e("TAG", "onDataChange: "+dataSnapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("TAG", "onDataChange: "+databaseError);
            }
        });
    }


    @Override
    public boolean onHomeOptionPress() {
        return false;
    }

    @Override
    public boolean onBackPress() {
        return true;
    }
}
