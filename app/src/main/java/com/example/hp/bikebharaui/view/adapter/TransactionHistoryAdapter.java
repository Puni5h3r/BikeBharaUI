package com.example.hp.bikebharaui.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hp.bikebharaui.R;
import com.example.hp.bikebharaui.model.TransactionHistoryList;

import java.util.ArrayList;
import java.util.List;

public class TransactionHistoryAdapter extends RecyclerView.Adapter<TransactionHistoryAdapter.MyViewHolder> {
  private List<TransactionHistoryList> transactionHistoryListList;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, phone, date, amount, depositeride;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.textView_name4);
            phone = (TextView) view.findViewById(R.id.textView_phone4);
            date = (TextView) view.findViewById(R.id.textView_date4);
            depositeride = (TextView) view.findViewById(R.id.textView_ridedeposite);
            amount = (TextView) view.findViewById(R.id.textView_amount2);

        }
    }


    public TransactionHistoryAdapter(List<TransactionHistoryList> x) {
        this.transactionHistoryListList = x;
    }




    @NonNull
    @Override
    public TransactionHistoryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.transaction_history_list_row, parent, false);

        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull TransactionHistoryAdapter.MyViewHolder holder, int position) {

        TransactionHistoryList transactionHistoryList = transactionHistoryListList.get(position);
        holder.name.setText(transactionHistoryList.getName());
        holder.phone.setText(transactionHistoryList.getPhoneNumber());
        holder.date.setText(transactionHistoryList.getTimeDate());
        holder.amount.setText(transactionHistoryList.getAmount());
        holder.depositeride.setText(transactionHistoryList.getDepositeRide());
    }

    @Override
    public int getItemCount() {
        return transactionHistoryListList.size();
    }
}
