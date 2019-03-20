package com.example.budget;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import static com.example.budget.MainActivity.db;
import static com.example.budget.MainActivity.getAppFirstInstallTime;
import static com.example.budget.MainActivity.getDate;

public class Total extends AppCompatActivity {
    Long date ;
    TextView t,dateview ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.total);
        t=findViewById(R.id.ftotal);
        t.setText(Float.toString(db.total()));
        date= getAppFirstInstallTime(this);
        String d = getDate(date, "dd/MM/yyyy");
        dateview=findViewById(R.id.fdate);
        dateview.setText(d);
    }
}
