package com.example.mobileapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class Internet extends AppCompatActivity {
    Date date = new Date();
    EditText inernet_amount;
    EditText internet_amount;

    TextView internet_username_card;

    DBHelper dbHelper = new DBHelper(Internet.this);

    Button pay_button_intentet;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internet);


        pay_button_intentet = findViewById(R.id.pay_internet_button);
        inernet_amount= findViewById(R.id.amountinternet);
        pay_button_intentet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inernet_amount.getText().toString().isEmpty()) {
                    Toast.makeText(Internet.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                } else {Toast.makeText(Internet.this, " The transaction was completed successfully", Toast.LENGTH_SHORT).show();
                Login_Activity.mainBalance -=  Integer.parseInt(inernet_amount.getText().toString());
                dbHelper.update_balance(MainActivity.Entered_user_name, Login_Activity.mainBalance);
                dbHelper.addtransactions(Login_Activity.enteredUsername, "Water", Integer.parseInt(inernet_amount.getText().toString()),date.toString());

                finish();
                }

            }});

    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        Bundle extras = getIntent().getExtras();
//        String user_name_value = extras.getString("internet_username");
//
//        internet_username_card = findViewById(R.id.internet_username_card);
//        internet_username_card.setText(user_name_value);
//    }

}