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

public class Transfer extends AppCompatActivity {

    EditText internet_amount , acountnumber,reason;
    TextView transfer_user_name_card;

    DBHelper dbHelper = new DBHelper(Transfer.this);

    Button transfer_pay_button;
    Date date = new Date();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);
        internet_amount = findViewById(R.id.amount_trasnfer);
        acountnumber=findViewById(R.id.amount_trasnfer);
        reason=findViewById(R.id.reason_trasnfer);
        transfer_pay_button = findViewById(R.id.transfer_pay_button);
        transfer_pay_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (internet_amount.getText().toString().isEmpty() ) {
                    Toast.makeText(Transfer.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    Toast.makeText(Transfer.this, " The transaction was completed successfully", Toast.LENGTH_SHORT).show();

                Login_Activity.mainBalance -=  Integer.parseInt(internet_amount.getText().toString());
                dbHelper.update_balance(MainActivity.Entered_user_name, Login_Activity.mainBalance);

                dbHelper.addtransactions(Login_Activity.enteredUsername, "Transfer", Integer.parseInt(internet_amount.getText().toString()),date.toString());

                finish();

            }

        }});









}
}