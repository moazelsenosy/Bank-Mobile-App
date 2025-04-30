package com.example.mobileapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TransactionsAdapter extends RecyclerView.Adapter<TransactionsAdapter.ViewHoler> {
     Context context;
     ArrayList<TransationsData>transactions;

    public TransactionsAdapter(Context context, ArrayList<TransationsData> transactions) {
        this.context = context;
        this.transactions = transactions;
    }

    @NonNull
    @Override
    public TransactionsAdapter.ViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.custom_row,parent,false);
        return new TransactionsAdapter.ViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionsAdapter.ViewHoler holder, int position) {
        holder.dateTextView.setText(transactions.get(position).getDate());
        holder.amountTextView.setText(String.valueOf(transactions.get(position).getAmount()));
        holder.typeTextView.setText(transactions.get(position).getType());

    }

    @Override
    public int getItemCount() {
        return transactions.size();
    }

    public class ViewHoler extends RecyclerView.ViewHolder{
        TextView dateTextView,amountTextView,typeTextView;

        public ViewHoler(@NonNull View itemView) {
            super(itemView);
            dateTextView=itemView.findViewById(R.id.dateTextview);
            amountTextView=itemView.findViewById(R.id.amountTextview);
            typeTextView=itemView.findViewById(R.id.amountTextview);



        }
    }
}
