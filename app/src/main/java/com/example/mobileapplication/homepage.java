package com.example.mobileapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class homepage extends AppCompatActivity {


ImageView elect;

ImageView transfer;
TextView user_name_card;

ImageView internet;

ImageView gas_card;

ImageView water;
TextView balance;

TextView user_name;

    ImageView transactions;
DBHelper dbHelper = new DBHelper(homepage.this);



    @SuppressLint({"MissingInflatedId", "CutPasteId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        balance = findViewById(R.id.balance_card);


        elect = findViewById(R.id.elect);
        elect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(homepage.this , Electricity.class);
                startActivity(intent);
            }
        });

        transfer = findViewById(R.id.transfer_image);
        transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homepage.this , Transfer.class);
                startActivity(intent);
            }
        });

        water = findViewById(R.id.water_card);
        water.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homepage.this , water.class);
                startActivity(intent);
            }
        });



        gas_card = findViewById(R.id.gas_card);
        gas_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homepage.this , Gas.class);
                startActivity(intent);
            }
        });

        transactions = findViewById(R.id.transaction);
        transactions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homepage.this , Transaction.class);
                startActivity(intent);
            }
        });


         internet= findViewById(R.id.interne);
        internet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homepage.this , Internet.class);
                startActivity(intent);
            }
        });



    }



    @Override
    protected void onResume() {
        super.onResume();
        balance = findViewById(R.id.balance_card);
        user_name_card = findViewById(R.id.username_card);
        user_name_card.setText(Login_Activity.enteredUsername);
        balance.setText(String.valueOf(Login_Activity.mainBalance) + " LE");
    }

}