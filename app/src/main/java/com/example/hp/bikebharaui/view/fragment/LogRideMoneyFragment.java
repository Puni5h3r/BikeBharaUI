package com.example.hp.bikebharaui.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
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

import com.example.hp.bikebharaui.R;

public class LogRideMoneyFragment extends BaseFragment implements AdapterView.OnItemSelectedListener {

    private Button btnSave;
    private Spinner spUserId;
    private Toolbar toolbar;
    private Context mContext;
    private EditText edtAmount;
    private TextInputLayout inputLayoutAmount;

    public LogRideMoneyFragment() {


    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_log_ride_money, container, false);

        btnSave = view.findViewById(R.id.button_log_ride_money_save);
        spUserId = view.findViewById(R.id.spUser);
        edtAmount = view.findViewById(R.id.edtMoneyAmount);
        inputLayoutAmount = view.findViewById(R.id.input_layout_moneyamount);

        mContext = getContext();

//        toolbar=findViewById(R.id.toolbar_log_ride_money);
//
//        toolbar.setTitle("Log Ride");
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(LogRideMoneyActivity.this, DashboardActivity.class);
//                startActivity(intent);
//            }
//        });


        // setting the spUserId
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.dummyforspinner, android.R.layout.simple_spinner_item);
        //Specify the layout to use when the list choice appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Apply the adapter to the spUserId
        spUserId.setAdapter(adapter);
        spUserId.setOnItemSelectedListener(this);

        edtAmount.addTextChangedListener(new MyTextWatcher(edtAmount));

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm();
            }
        });


        return view;

    }

    private void submitForm() {
        if (!validateAmount()) {
            return;
        }

        Toast.makeText(mContext, "Thank You!", Toast.LENGTH_SHORT).show();
    }

    private boolean validateAmount() {
        if (edtAmount.getText().toString().trim().isEmpty()) {
            inputLayoutAmount.setError(getString(R.string.err_msg_amount));
            requestFocus(edtAmount);
            return false;
        } else {
            inputLayoutAmount.setErrorEnabled(false);
        }

        return true;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0) {
            Toast.makeText(mContext, "please select something from the list", Toast.LENGTH_LONG).show();

        } else {
            String j = parent.getItemAtPosition(position).toString();
            Toast.makeText(mContext, j + " selected", Toast.LENGTH_LONG).show();

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

        Toast.makeText(mContext, "you haven't selected anything, please select", Toast.LENGTH_LONG).show();

    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
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
                case R.id.edtMoneyAmount:
                    validateAmount();
                    break;

            }
        }
    }
}