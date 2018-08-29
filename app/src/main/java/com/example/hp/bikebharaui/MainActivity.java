package com.example.hp.bikebharaui;

import android.content.Intent;
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


import com.example.hp.bikebharaui.view.activity.DashboardActivity;

public class MainActivity extends AppCompatActivity {

    //this activity is made for the login screen

    private EditText inputUserName,inputPassword;
    private TextInputLayout inputLayoutUserName, inputLayoutPassword;
    private Button btnLogin;

    //all the views are set and defined
    //in this activity there is a login screen for user, for putting his user name and password...
    //the user name and password in EditText is checked beforehand, incase the user puts something unreasonable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        inputLayoutUserName = (TextInputLayout) findViewById(R.id.user_name_input_layout);
        inputLayoutPassword = (TextInputLayout) findViewById(R.id.password_input_layout);
        inputUserName = (EditText) findViewById(R.id.user_name);

        inputPassword = (EditText) findViewById(R.id.password);
        btnLogin = (Button) findViewById(R.id.btn_login);

        inputUserName.addTextChangedListener(new MyTextWatcher(inputUserName));
        inputPassword.addTextChangedListener(new MyTextWatcher(inputPassword));

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm(); // on click of the login button, the method checks whether the given user name and password is unreasonable


            }
        });



    }

    private void submitForm() {
        // inside this method, two other boolean methods are called, to check if name & password is valid or not, or else a text will show thankyou
        if (!validateName()) {
            return;
        }


        if (!validatePassword()) {
            return;
        }

        Toast.makeText(getApplicationContext(), "Thank You!", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(MainActivity.this,DashboardActivity.class);
        startActivity(intent);


    }


        // boolean method which checks the edit text of username and uses the Text inputlayout widget to show a pop when empty
    private boolean validateName() {
        if (inputUserName.getText().toString().trim().isEmpty()) {
            inputLayoutUserName.setError(getString(R.string.err_msg_userName));
            requestFocus(inputUserName);
            return false;
        } else {
            inputLayoutUserName.setErrorEnabled(false);
        }

        return true;
    }


    // boolean method which checks the edit text of password and uses the Text inputlayout widget to show a pop when empty
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
        //view class defined
        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        } // this login view is referred to the view class


        //these are base method for checking input from the user
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }
        //again checks for validation without the even pressing of the button
        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.user_name:
                    validateName();
                    break;

                case R.id.password:
                    validatePassword();
                    break;
            }
        }
    }


}
