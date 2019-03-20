package com.example.budget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import static com.example.budget.MainActivity.db;

public class Ajouter extends AppCompatActivity {

    Button b;
    EditText addachat ,addprix ;
    ListView l ;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajouter);

        b=findViewById(R.id.aajouter);
        addachat=findViewById(R.id.aachat);
        addprix=findViewById(R.id.aprix);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String achats =addachat.getText().toString();
                Float prixx =Float.valueOf(addprix.getText().toString());
                Model nouveau = new Model(achats, prixx);

                db.ajouter(nouveau);


                Toast.makeText(Ajouter.this,"vous avez bien ajouté votre dépense !",Toast.LENGTH_SHORT);
            }

        });
    };

}
