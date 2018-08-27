package com.example.hp.bikebharaui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class UserManagementAdapter extends RecyclerView.Adapter<UserManagementAdapter.MyViewHolder> {

    private List<UserManagementList> userManagementList;
    Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, phone, transactionhistory;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.textView_name);
            phone = (TextView) view.findViewById(R.id.textView_phone);
            transactionhistory = (TextView) view.findViewById(R.id.trancationhistory_TV);


        }
    }


    public UserManagementAdapter(List<UserManagementList> x, Context mContext) {
        this.userManagementList = x;
        this.mContext = mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_management_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        UserManagementList userManagementList1 = userManagementList.get(position);
        holder.name.setText(userManagementList1.getName());
        holder.phone.setText(userManagementList1.getPhoneNumber());

        holder.transactionhistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, TransactionHistoryActivity.class);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return userManagementList.size();
    }



}
