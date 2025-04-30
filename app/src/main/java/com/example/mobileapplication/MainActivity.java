package com.example.mobileapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



DBHelper dbHelper=new DBHelper(MainActivity.this);
    static int mainBalance;
    static String Entered_user_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//       boolean status= dbHelper.adduser("ahmed","123",2000);
//        if (status){
//            Toast.makeText(this, "Inserted Successfully", Toast.LENGTH_SHORT).show();
//
//        }else {
//            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
//
//        }

    }
}