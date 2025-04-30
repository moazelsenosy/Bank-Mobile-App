package com.example.mobileapplication;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context) {
        super(context, "Banki.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users(username text primary key," +
                "password text,"+"balance integer);");
        db.execSQL("create table transactions (id integer primary key autoincrement , username text " +
                ", type text ," +
                " amount integer , " +
                "date text)");

        /*
        create table transactions(id integer primary key autoincrement," +
                "username text," +
                "type text" +
                "amount integer +
                "date text
         */

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists user");
        db.execSQL("drop table if exists transactions");
        onCreate(db);
    }

    public boolean adduser(String username,String password,int balance){
     SQLiteDatabase db =getReadableDatabase();
        ContentValues values =new ContentValues();
        values.put("username",username);
        values.put("password",password);
        values.put("balance",balance);
        long results =db.insert("users",null,values);

        return results !=-1;


    }
    public boolean addtransactions(String username,String type,int amount,String date){
        SQLiteDatabase db =getReadableDatabase();
        ContentValues values =new ContentValues();
        values.put("username",username);
        values.put("type",type);
        values.put("amount",amount);
        values.put("date",date);
        Long results =db.insert("transactions",null,values);

        return results !=-1;

        }
    public Cursor getuser(String username) {

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = null;
        if (db != null)
            cursor = db.rawQuery("Select * from users where username ='" + username + "'", null);
    return  cursor;
    }
    public Cursor gettransactions(String username) {

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = null;
        if (db != null)
            cursor = db.rawQuery("Select type,amount,date from transactions where username ='" + username + "'", null);
        return  cursor;
    }

    public Cursor getBalance(String username){
        SQLiteDatabase db=getReadableDatabase();
        Cursor cursor=null;
        if (db !=null){
            cursor= db.rawQuery("select balance from users where username= '" + username + "'" ,null);
        }
        return cursor;
    }

    @SuppressLint("Range")
    public void update_balance(String user_name , int amount){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("balance" , amount);
        db.update("users" , values , "username = '" + user_name + "'" , null);

    }

}
