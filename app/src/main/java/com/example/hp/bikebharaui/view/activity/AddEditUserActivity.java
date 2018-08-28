package com.example.hp.bikebharaui.view.activity;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hp.bikebharaui.R;

public class AddEditUserActivity extends AppCompatActivity {

    private EditText inputName, inputMobile, inputPassword;
    private TextInputLayout inputLayoutName, inputLayoutMobile, inputLayoutPassword;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_edit_user);

        inputLayoutName = (TextInputLayout) findViewById(R.id.input_layout_name1);
        inputLayoutMobile = (TextInputLayout) findViewById(R.id.input_layout_phonenumber1);
        inputLayoutPassword = (TextInputLayout) findViewById(R.id.input_layout_password1);
        inputName = (EditText) findViewById(R.id.input_name1);
        inputMobile = (EditText) findViewById(R.id.input_phonenumber1);
        inputPassword = (EditText) findViewById(R.id.input_password1);
        btnSave = (Button) findViewById(R.id.btn_ssave);


        inputName.addTextChangedListener(new MyTextWatcher(inputName));
        inputMobile.addTextChangedListener(new MyTextWatcher(inputMobile));
        inputPassword.addTextChangedListener(new MyTextWatcher(inputPassword));

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm();
            }
        });




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

        Toast.makeText(getApplicationContext(), "Thank You!", Toast.LENGTH_SHORT).show();
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
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
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
