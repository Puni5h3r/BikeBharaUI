package com.example.hp.bikebharaui.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.hp.bikebharaui.R;
import com.example.hp.bikebharaui.view.activity.DashboardActivity;
import com.example.hp.bikebharaui.view.activity.DepositMoneyActivity;

public class DepositMoneyFrag extends BaseFragment implements AdapterView.OnItemSelectedListener {


    private Button btnSave;
    private Spinner spinner;
    private Toolbar toolbar;
    Context mContext;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.frag_deposit_money,container,false);

       mContext=getContext();

        btnSave = view.findViewById(R.id.button_deposit_save);
        spinner = view.findViewById(R.id.spinner1);


        // setting the spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.dummyforspinner, android.R.layout.simple_spinner_item);
        //Specify the layout to use when the list choice appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

//        toolbar = findViewById(R.id.toolbar_deposite_money);
//
//        toolbar.setTitle("Deposit Money");
//
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(DepositMoneyActivity.this,DashboardActivity.class);
//                startActivity(intent);
//            }
//        });
//
//
      return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (position==0){
            Toast.makeText(mContext,"please select something from the list",Toast.LENGTH_LONG).show();

        }
        else {
            String j = parent.getItemAtPosition(position).toString();
            Toast.makeText(mContext,j+" selected",Toast.LENGTH_LONG).show();

        }



    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(mContext,"you haven't selected anything, please select",Toast.LENGTH_LONG).show();

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
