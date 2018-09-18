package com.example.hp.bikebharaui.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hp.bikebharaui.R;
import com.example.hp.bikebharaui.model.RideHistoryList;

import java.util.ArrayList;
import java.util.List;

public class RideHistoryAdapter extends RecyclerView.Adapter<RideHistoryAdapter.MyViewHolder> {
    private List<RideHistoryList> rideHistoryLists;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, phone, date;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.textView_name1);
            phone = (TextView) view.findViewById(R.id.textView_phone1);
            date = (TextView) view.findViewById(R.id.textView_date1);

        }
    }


    public RideHistoryAdapter(List<RideHistoryList> x) {
        this.rideHistoryLists = x;
    }

    @Override
    public RideHistoryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ride_history_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RideHistoryAdapter.MyViewHolder holder, int position) {
        RideHistoryList rideHistoryList = rideHistoryLists.get(position);
        holder.name.setText(rideHistoryList.getName());
        holder.phone.setText(rideHistoryList.getPhoneNumber());
        holder.date.setText(rideHistoryList.getTimeDate());
    }

    @Override
    public int getItemCount() {
        return rideHistoryLists.size();
    }
    public void updateList(List<RideHistoryList> newList){
        rideHistoryLists = new ArrayList<>();
        rideHistoryLists.addAll(newList);
        notifyDataSetChanged();

    }


}
