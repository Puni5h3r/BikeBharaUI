package com.example.hp.bikebharaui.view.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBar;


import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.hp.bikebharaui.InsertData;
import com.example.hp.bikebharaui.R;
import com.example.hp.bikebharaui.Session;
import com.example.hp.bikebharaui.model.RideHistoryList;
import com.example.hp.bikebharaui.view.Interface.IOnBackPressed;
import com.example.hp.bikebharaui.view.Interface.IOnOptionsItemPress;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class DepositMoneyFrag extends BaseFragment implements AdapterView.OnItemSelectedListener, IOnOptionsItemPress, IOnBackPressed {

    private ArrayList<String> userNames = new ArrayList<>();
    private Button btnSave;
    private Spinner spUserId;
    private Toolbar toolbar;
    private EditText edtDepositAmount;
    Context mContext;
    private TextInputLayout inputLayoutAmount;
    private List<RideHistoryList> rideHistoryLists = new ArrayList<>();
    private RideHistoryList rideHistoryList;


    private FirebaseDatabase firebaseDatabaseInstance = FirebaseDatabase.getInstance();

    ArrayAdapter<String> adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.frag_deposit_money,container,false);

       mContext=getContext();

        btnSave = view.findViewById(R.id.button_deposit_save);
        spUserId = view.findViewById(R.id.spUserDeposity);

        // setting the spUserId
        adapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_spinner_dropdown_item,userNames);

        inputLayoutAmount = view.findViewById(R.id.input_layout_depositamount);
        edtDepositAmount = view.findViewById(R.id.edtDepositAmount);
        DatabaseReference rideHistoryRef = firebaseDatabaseInstance.getReference().child("DB").child("User");
        boolean Passenger = true;
        if(Session.getUserType()==Passenger){
            String name = Session.getName();
            String id = Session.getId();
            String phnNumber = Session.getPhnNumber();
            if (name!=null && id!=null && phnNumber!=null) {
                rideHistoryList = new RideHistoryList();
                userNames.add(name);
                rideHistoryList.setName(name);
                rideHistoryList.setRideHistoryId(id);
                rideHistoryList.setPhoneNumber(phnNumber);
            }
        }else {
            getData(rideHistoryRef);
        }

            //Specify the layout to use when the list choice appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            //Apply the adapter to the spUserId
            spUserId.setAdapter(adapter);
             spUserId.setOnItemSelectedListener(this);



        AppCompatActivity activity = (AppCompatActivity)getActivity();
        if(activity!=null){
            toolbar=(Toolbar) view.findViewById(R.id.toolbar);
            activity.setSupportActionBar(toolbar);
            ActionBar actionBar = activity.getSupportActionBar();
            if(actionBar!=null){
                actionBar.setTitle("Deposit Money");
                actionBar.setDisplayHomeAsUpEnabled(true);
            }



        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm();
            }
        });


        edtDepositAmount.addTextChangedListener(new MyTextWatcher(edtDepositAmount));
//
//
      return view;
    }

    private void getData(DatabaseReference rideHistoryRef) {
        rideHistoryRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String checker = "Passenger";
                userNames.clear();
                rideHistoryLists.clear();
                for(DataSnapshot data: dataSnapshot.getChildren()){
                    String userType = (String) data.child("user type").getValue();
                    if( userType!=null && userType.equals(checker)) {
                        String names = (String) data.child("user name").getValue();
                        String phnNumber = (String) data.child("phone number").getValue();
                        String id = (String) data.child("id").getValue();
                        userNames.add(names);
                        RideHistoryList rideHistoryListModel = new RideHistoryList(names, phnNumber);
                        rideHistoryListModel.setRideHistoryId(id);
                        rideHistoryLists.add(rideHistoryListModel);

                    }
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void submitForm() {
        if (!validateAmount()) {
            return;
        }
       if(rideHistoryList==null){
            Toast.makeText(getContext(),"you have selected anything from the list",Toast.LENGTH_SHORT).show();
       }
       btnSaved();
    }

    private void btnSaved() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                getContext());
        alertDialogBuilder
                .setTitle("Are you sure you want to save this?")
                .setCancelable(false)
                .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        String name = rideHistoryList.getName();
                        String phoneNumber = rideHistoryList.getPhoneNumber();
                        String userId = rideHistoryList.getRideHistoryId();
                        String currentDateTimeString = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"
                                , Locale.ENGLISH).format(Calendar.getInstance().getTime());
                        String amount = edtDepositAmount.getText().toString();
                        String transferType = "Deposit";
                        DatabaseReference rideHistoryReff = firebaseDatabaseInstance.getReference().child("DB").child("Ride History");
                        InsertData insertData = new InsertData();
                        insertData.depositMoneyInsertData(rideHistoryReff, name, phoneNumber,currentDateTimeString,userId,amount,transferType);
                        loadFragment(new DepositHistoryFragment());
                    }
                })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();

                            }
                        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }


    private boolean validateAmount() {
        if (edtDepositAmount.getText().toString().trim().isEmpty()) {
            inputLayoutAmount.setError(getString(R.string.err_msg_amount));
            requestFocus(edtDepositAmount);
            return false;
        } else {
            inputLayoutAmount.setErrorEnabled(false);
        }

        return true;
    }


    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    @Override
    public boolean onHomeOptionPress() {
        return false;
    }

    @Override
    public boolean onBackPress() {
        return true;
    }

    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.edtDepositAmount:
                    validateAmount();
                    break;

            }
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if(Session.getUserType()==true){}
            else {
                rideHistoryList = rideHistoryLists.get(position);
                Toast.makeText(mContext, rideHistoryList.getName() + " selected", Toast.LENGTH_LONG).show();
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
