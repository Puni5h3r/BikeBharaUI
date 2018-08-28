package com.example.hp.bikebharaui.view.fragment;

import android.content.Intent;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hp.bikebharaui.R;



public class AddEditUserFragment extends BaseFragment {

//    private Toolbar toolbar;
    private EditText inputName, inputMobile, inputPassword;
    private TextInputLayout inputLayoutName, inputLayoutMobile, inputLayoutPassword;
    private Button btnSave;

    public AddEditUserFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.frag_add_edit_user,container,false);


        inputLayoutName = (TextInputLayout) view.findViewById(R.id.input_layout_name1);
        inputLayoutMobile = (TextInputLayout) view.findViewById(R.id.input_layout_phonenumber1);
        inputLayoutPassword = (TextInputLayout) view.findViewById(R.id.input_layout_password1);
        inputName = (EditText) view.findViewById(R.id.input_name1);
        inputMobile = (EditText) view.findViewById(R.id.input_phonenumber1);
        inputPassword = (EditText) view.findViewById(R.id.input_password1);
        btnSave = (Button) view.findViewById(R.id.btn_ssave);

    /*    toolbar = findViewById(R.id.toolbar_add_edit_user);

        toolbar.setTitle("User Management");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddEditUserActivity.this,DashboardActivity.class);
                startActivity(intent);
            }
        });*/


        inputName.addTextChangedListener(new MyTextWatcher(inputName));
        inputMobile.addTextChangedListener(new MyTextWatcher(inputMobile));
        inputPassword.addTextChangedListener(new MyTextWatcher(inputPassword));

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm();
            }
        });
        return view;
    }

    private void submitForm() {

        if (!validateName()) {
            return;
        }

        if (!validateMobileNo()) {
            return;
        }

        if (!validatePassword()) {
            return;
        }

        Toast.makeText(getContext(), "Thank You!", Toast.LENGTH_SHORT).show();
    }



    private boolean validateName() {
        if (inputName.getText().toString().trim().isEmpty()) {
            inputLayoutName.setError(getString(R.string.err_msg_userName));
            requestFocus(inputName);
            return false;
        } else {
            inputLayoutName.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateMobileNo() {
        String phoneNumber = inputMobile.getText().toString().trim();

        if (phoneNumber.isEmpty()) {
            inputLayoutMobile.setError(getString(R.string.err_msg_phonenumber));
            requestFocus(inputMobile);
            return false;
        } else {
            inputLayoutMobile.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validatePassword() {
        if (inputPassword.getText().toString().trim().isEmpty()) {
            inputLayoutPassword.setError(getString(R.string.err_msg_password));
            requestFocus(inputPassword);
            return false;
        } else {
            inputLayoutPassword.setErrorEnabled(false);
        }

        return true;
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
                case R.id.input_name1:
                    validateName();
                    break;
                case R.id.input_phonenumber1:
                    validateMobileNo();
                    break;
                case R.id.input_password1:
                    validatePassword();
                    break;
            }
        }
    }
}
