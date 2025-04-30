package com.example.mobileapplication;

public class TransationsData {

  String date,type;
  int amount;


    public TransationsData(String type, int amount, String date) {
        this.date = date;
        this.type = type;
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }
}
