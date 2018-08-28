package com.example.hp.bikebharaui.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.hp.bikebharaui.R;

public class DepositMoneyActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

   private Button btnSave;
   private Spinner spinner;
   private Toolbar toolbar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit_money);

        btnSave = findViewById(R.id.button_deposit_save);
        spinner = findViewById(R.id.spinner1);


        // setting the spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.dummyforspinner, android.R.layout.simple_spinner_item);
        //Specify the layout to use when the list choice appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        toolbar = findViewById(R.id.toolbar_deposite_money);

        toolbar.setTitle("Deposit Money");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DepositMoneyActivity.this,DashboardActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (position==0){Toast.makeText(this,"please select something from the list",Toast.LENGTH_LONG).show();

        }
        else {
            String j = parent.getItemAtPosition(position).toString();
            Toast.makeText(this,j+" selected",Toast.LENGTH_LONG).show();

        }



    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this,"you haven't selected anything, please select",Toast.LENGTH_LONG).show();

    }


}
