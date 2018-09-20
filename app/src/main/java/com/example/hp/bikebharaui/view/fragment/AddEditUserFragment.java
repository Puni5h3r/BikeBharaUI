package com.example.hp.bikebharaui.view.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hp.bikebharaui.InsertData;
import com.example.hp.bikebharaui.R;
import com.example.hp.bikebharaui.view.Interface.IOnBackPressed;
import com.example.hp.bikebharaui.view.Interface.IOnOptionsItemPress;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class AddEditUserFragment extends BaseFragment implements IOnOptionsItemPress,IOnBackPressed {

  private Toolbar toolbar;
    private EditText edtInputName, edtInputMobile, edtInputPassword;
    private TextInputLayout inputLayoutName, inputLayoutMobile, inputLayoutPassword;
    private Button btnSave;
    private FirebaseDatabase firebaseDatabaseInstance;

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
        edtInputName = (EditText) view.findViewById(R.id.edtUserName);
        edtInputMobile = (EditText) view.findViewById(R.id.edtPhone);
        edtInputPassword = (EditText) view.findViewById(R.id.edtPassword);
        btnSave = (Button) view.findViewById(R.id.btnSave);

        firebaseDatabaseInstance = FirebaseDatabase.getInstance();
        final DatabaseReference userHistoryRef = firebaseDatabaseInstance.getReference().child("DB").child("User");
        AppCompatActivity activity =(AppCompatActivity) getActivity();
        if(activity!=null){
            toolbar=view.findViewById(R.id.toolbar);
            activity.setSupportActionBar(toolbar);
            ActionBar actionBar = activity.getSupportActionBar();
            if(actionBar!=null){
                actionBar.setTitle("Add User");
                actionBar.setDisplayHomeAsUpEnabled(true);

            }

        }


        edtInputName.addTextChangedListener(new MyTextWatcher(edtInputName));
        edtInputMobile.addTextChangedListener(new MyTextWatcher(edtInputMobile));
        edtInputPassword.addTextChangedListener(new MyTextWatcher(edtInputPassword));

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm(userHistoryRef);
            }
        });
        return view;
    }


    private void submitForm(final DatabaseReference userHistoryRef) {

        if (!validateName()) {
            return;
        }

        if (!validateMobileNo()) {
            return;
        }

        if (!validatePassword()) {
            return;
        }

       // Toast.makeText(getContext(), "Thank You!", Toast.LENGTH_SHORT).show();
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                getContext());
        alertDialogBuilder
                .setTitle("Are you sure you want to save this?")
                .setCancelable(false)
                .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        String passwordInput = edtInputPassword.getText().toString();

                            String name = edtInputName.getText().toString();
                            String phoneNumber = edtInputMobile.getText().toString();
                            InsertData insertData = new InsertData();
                            insertData.addUser(userHistoryRef, name, phoneNumber,passwordInput);
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




    private boolean validateName() {
        if (edtInputName.getText().toString().trim().isEmpty()) {
            inputLayoutName.setError(getString(R.string.err_msg_userName));
            requestFocus(edtInputName);
            return false;
        } else {
            inputLayoutName.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateMobileNo() {
        String phoneNumber = edtInputMobile.getText().toString().trim();

        if (phoneNumber.isEmpty()) {
            inputLayoutMobile.setError(getString(R.string.err_msg_phonenumber));
            requestFocus(edtInputMobile);
            return false;
        } else {
            inputLayoutMobile.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validatePassword() {
        if (edtInputPassword.getText().toString().trim().isEmpty()) {
            inputLayoutPassword.setError(getString(R.string.err_msg_password));
            requestFocus(edtInputPassword);
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
                case R.id.edtUserName:
                    validateName();
                    break;
                case R.id.edtPhone:
                    validateMobileNo();
                    break;
                case R.id.edtPassword:
                    validatePassword();
                    break;
            }
        }
    }
}
