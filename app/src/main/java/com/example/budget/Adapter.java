package com.example.budget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends ArrayAdapter<Model> {
    private ArrayList<Model> arrayList;
    private Context ctx;
    private int item ;
    public Adapter(@NonNull Context context, int resource, ArrayList<Model> myarraylist ) {
        super(context, resource, myarraylist);
        this.arrayList = myarraylist;
        this.ctx = context;
        this.item = resource; }
    @NonNull
    @Override
    public boolean isEnabled(int position)
    {
        return true;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        convertView= LayoutInflater.from(ctx).inflate(item,parent,false);

        TextView prix=convertView.findViewById(R.id.nprix);

        TextView  achat=convertView.findViewById(R.id.nachat);

        TextView date=convertView.findViewById(R.id.ndate);

        prix.setText(Float.toString(arrayList.get(position).getPrix()));
        achat.setText(arrayList.get(position).getAchat());
        date.setText(arrayList.get(position).getDate());

        return convertView; }}






