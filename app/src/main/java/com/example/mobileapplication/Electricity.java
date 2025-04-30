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

public class Electricity extends AppCompatActivity {
    Date date = new Date();
    EditText electric_amount;
    EditText internet_amount;
    EditText serviecenumber;
    TextView electric_user_name_card;

    DBHelper dbHelper = new DBHelper(Electricity.this);

    Button pay_button_electric;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityelectricity);

        electric_amount = findViewById(R.id.electric_amount);
        serviecenumber=findViewById(R.id.servecnuber);
        pay_button_electric = findViewById(R.id.electric_pay_button);

        pay_button_electric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (electric_amount.getText().toString().isEmpty() ||serviecenumber.getText().toString().isEmpty()  ) {
                    Toast.makeText(Electricity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    Toast.makeText(Electricity.this, " The transaction was completed successfully", Toast.LENGTH_SHORT).show();




                    Login_Activity.mainBalance -=  Integer.parseInt(electric_amount.getText().toString());
                dbHelper.update_balance(MainActivity.Entered_user_name, Login_Activity.mainBalance);

                dbHelper.addtransactions(Login_Activity.enteredUsername, "Water", Integer.parseInt(electric_amount.getText().toString()),date.toString());

                finish();
            }
            }});

    }
}




