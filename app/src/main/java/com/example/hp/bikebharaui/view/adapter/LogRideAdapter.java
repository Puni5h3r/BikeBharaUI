package com.example.hp.bikebharaui.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hp.bikebharaui.model.LogRideList;
import com.example.hp.bikebharaui.R;

import java.util.List;

public class LogRideAdapter extends RecyclerView.Adapter<LogRideAdapter.MyViewHolder> {


    private List<LogRideList> logRideLists;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, phone, date;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.textView_name3);
            phone = (TextView) view.findViewById(R.id.textView_phone3);
            date = (TextView) view.findViewById(R.id.textView_date3);

        }
    }


    public LogRideAdapter(List<LogRideList> x) {
        this.logRideLists = x;
    }

    @NonNull
    @Override
    public LogRideAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.log_ride_list_row, parent, false);

        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull LogRideAdapter.MyViewHolder holder, int position) {

        LogRideList rideHistoryList = logRideLists.get(position);
        holder.name.setText(rideHistoryList.getName());
        holder.phone.setText(rideHistoryList.getPhoneNumber());
        holder.date.setText(rideHistoryList.getTimeDate());

    }

    @Override
    public int getItemCount() {
        return logRideLists.size();
    }
}
