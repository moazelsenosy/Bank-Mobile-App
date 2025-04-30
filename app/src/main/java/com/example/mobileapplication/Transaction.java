package com.example.mobileapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.security.PrivateKey;
import java.util.ArrayList;

public class Transaction extends AppCompatActivity {
DBHelper dbHelper =new DBHelper(this);
ArrayList<TransationsData>transations =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);
        if (setUpData()) {
            RecyclerView recyclerView = findViewById(R.id.recyclerview);
            TransactionsAdapter adapter = new TransactionsAdapter(Transaction.this, transations);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(Transaction.this));
        }
    }
   private boolean setUpData(){
     Cursor cursor =dbHelper.gettransactions("mostafa");
    if (cursor.getCount()==0){
        Toast.makeText(this, "no Transactions", Toast.LENGTH_SHORT).show();
        return false;

    }else {

        while (cursor.moveToNext()){
          transations.add(new TransationsData(cursor.getString(0),cursor.getInt(1),cursor.getString(2)));

        }
        return true;
    }


   }
}
