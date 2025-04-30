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

public class water extends AppCompatActivity {
    Date date = new Date();
    EditText water_amount;
    EditText transfer_amount;
    TextView internet_username_card;

    DBHelper dbHelper = new DBHelper(water.this);

    Button water_pay_button;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water);

        water_amount = findViewById(R.id.amount_water);

        transfer_amount = findViewById(R.id.amount_water);

        water_pay_button = findViewById(R.id.water_pay_button);

        water_pay_button = findViewById(R.id.water_pay_button);
        water_pay_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (water_amount.getText().toString().isEmpty()) {
                    Toast.makeText(water.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                } else {Toast.makeText(water.this, " The transaction was completed successfully", Toast.LENGTH_SHORT).show();
                    Login_Activity.mainBalance -= Integer.parseInt(water_amount.getText().toString());
                    dbHelper.update_balance(MainActivity.Entered_user_name, Login_Activity.mainBalance);

                    dbHelper.addtransactions(Login_Activity.enteredUsername, "Water", Integer.parseInt(water_amount.getText().toString()), date.toString());

                    finish();


                }
            }
        });

    }
}