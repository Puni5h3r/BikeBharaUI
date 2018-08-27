package com.example.hp.bikebharaui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class UserManagementAdapter extends RecyclerView.Adapter<UserManagementAdapter.MyViewHolder> {

    private List<UserManagementList> userManagementList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, phone;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.textView_name);
            phone = (TextView) view.findViewById(R.id.textView_phone);

        }
    }


    public UserManagementAdapter(List<UserManagementList> x) {
        this.userManagementList = x;
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
