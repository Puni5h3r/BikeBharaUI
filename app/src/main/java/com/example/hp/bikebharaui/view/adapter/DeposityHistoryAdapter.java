package com.example.hp.bikebharaui.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hp.bikebharaui.model.DepositeHistoryList;
import com.example.hp.bikebharaui.R;

import java.util.List;

public class DeposityHistoryAdapter extends RecyclerView.Adapter<DeposityHistoryAdapter.MyViewHolder> {

    private List<DepositeHistoryList> diposityHistoryLists;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, phone, date, amount;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.textView_name2);
            phone = (TextView) view.findViewById(R.id.textView_phone2);
            date = (TextView) view.findViewById(R.id.textView_date2);
            amount = (TextView) view.findViewById(R.id.textView_amount);

        }
    }

    public DeposityHistoryAdapter(List<DepositeHistoryList> x) {
        this.diposityHistoryLists = x;
    }



    @NonNull
    @Override
    public DeposityHistoryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.deposite_history_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DeposityHistoryAdapter.MyViewHolder holder, int position) {

        DepositeHistoryList diposityHistoryList = diposityHistoryLists.get(position);
        holder.name.setText(diposityHistoryList.getName());
        holder.phone.setText(diposityHistoryList.getPhoneNumber());
        holder.date.setText(diposityHistoryList.getTimeDate());
        holder.amount.setText(diposityHistoryList.getAmount());

    }

    @Override
    public int getItemCount() {
        return diposityHistoryLists.size();
    }
}
