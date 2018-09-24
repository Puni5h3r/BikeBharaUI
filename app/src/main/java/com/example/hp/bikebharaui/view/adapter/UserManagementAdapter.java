package com.example.hp.bikebharaui.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hp.bikebharaui.R;
import com.example.hp.bikebharaui.model.UserManagementList;


import java.lang.ref.WeakReference;
import java.util.List;

public class UserManagementAdapter extends RecyclerView.Adapter<UserManagementAdapter.MyViewHolder> {

    private List<UserManagementList> userManagementList;
    Context mContext;
    public interface TransactionHistoryClickListener{
        public void onClickListener(int position);
    }


    TransactionHistoryClickListener mClickListener;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name, phone, transactionhistory;

        private WeakReference<TransactionHistoryClickListener> mReference;


        public MyViewHolder(View view) {
            super(view);
            mReference= new WeakReference<TransactionHistoryClickListener>(mClickListener);
            name = (TextView) view.findViewById(R.id.textView_name);
            phone = (TextView) view.findViewById(R.id.textView_phone);
            transactionhistory = (TextView) view.findViewById(R.id.trancationhistory_TV);

            transactionhistory.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mReference.get().onClickListener(getAdapterPosition());

                }
            });


        }
    }


    public UserManagementAdapter(List<UserManagementList> userManagementList,TransactionHistoryClickListener mClickListener ) {
        this.userManagementList = userManagementList;
        this.mClickListener = mClickListener;
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


    }

    @Override
    public int getItemCount() {
        return userManagementList.size();
    }



}
