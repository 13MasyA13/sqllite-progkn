package com.progkn.sqlite.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.*;
import android.widget.Toast;

import com.progkn.sqlite.dbhelpers.ProgKnDBHelper;
import com.progkn.sqllite.sqllite_progkn.R;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ProgKnDBHelper db;
    EditText firstName, lastName, mark;
    Button insertDataButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new ProgKnDBHelper(this);

        firstName = (EditText) findViewById(R.id.et_firstName);
        lastName = (EditText) findViewById(R.id.et_lastName);
        mark = (EditText) findViewById(R.id.et_Mark);

        insertDataButton = (Button) findViewById(R.id.b_insertData);

        addData();
    }

    public void addData(){
        insertDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted =
                        db.insertData(firstName.getText().toString(),
                                lastName.getText().toString(),
                                mark.getText().toString());
                if(isInserted == true){
                    Toast.makeText(MainActivity.this, "DATA IS INSERTED", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "DATA IS'T INSERTED", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void showDBName(View view){
        textView = findViewById(R.id.textView);
        textView.setText(new String(db.getDatabaseName()));
    }

    public void goToTheStartDroid(View view){
        Intent startDroid = new Intent("startdroid.crud");
        startActivity(startDroid);
    }
}
