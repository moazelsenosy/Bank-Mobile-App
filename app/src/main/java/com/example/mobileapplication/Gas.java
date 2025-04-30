package com.example.mobileapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class Gas extends AppCompatActivity {
    Date date = new Date();

    EditText gas_amount;

    DBHelper dbHelper = new DBHelper(Gas.this);

    Button pay_button_gas;

    TextView gas_user_name_card;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gas);

        gas_amount = findViewById(R.id.amount_edit_text);

        pay_button_gas = findViewById(R.id.gas_pay_button);

        pay_button_gas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (gas_amount.getText().toString().isEmpty()) {
                    Toast.makeText(Gas.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                } else {Toast.makeText(Gas.this, " The transaction was completed successfully", Toast.LENGTH_SHORT).show();
                Login_Activity.mainBalance -=  Integer.parseInt(gas_amount.getText().toString());
                dbHelper.update_balance(MainActivity.Entered_user_name, Login_Activity.mainBalance);

                dbHelper.addtransactions(Login_Activity.enteredUsername, "Gas", Integer.parseInt(gas_amount.getText().toString()),date.toString());

                finish();
                }

            }});

    }
}