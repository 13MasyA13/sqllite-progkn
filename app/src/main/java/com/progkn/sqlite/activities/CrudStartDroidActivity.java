package com.progkn.sqlite.activities;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.progkn.sqlite.dao.interfaces.ContactDAO;
import com.progkn.sqlite.dbhelpers.StartDroidDBHelper;
import com.progkn.sqlite.entities.Contact;
import com.progkn.sqllite.sqllite_progkn.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CrudStartDroidActivity extends AppCompatActivity implements ContactDAO {

    Button addButton, readButton, deleteButton;
    EditText nameText, emailText;
    ListView values;

    StartDroidDBHelper dbHelper;
    Cursor cursor;
    ContentValues contentValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.crud_startdroid_activity);

        addButton = (Button) findViewById(R.id.button_add);
        readButton = findViewById(R.id.button_read);
        deleteButton = findViewById(R.id.button_clear);

        nameText = findViewById(R.id.edit_name);
        emailText = findViewById(R.id.edit_email);

        values = findViewById(R.id.values);
        dbHelper = new StartDroidDBHelper(this);
    }

    /*
    public void onClick(View view){

        switch (view.getId()){

            case R.id.button_add:
                boolean b = insertData();

                if(b == true){
                    Toast.makeText(CrudStartDroidActivity.this, "INPUTED DATA HAS INSERTED TO DB", Toast.LENGTH_LONG).show();
                } else{
                    Toast.makeText(CrudStartDroidActivity.this, "INPUTED DATA HASN'T INSERTED TO DB", Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.button_read:
                ArrayList<Contact> listOfContacts = readData();
                ArrayAdapter<String> adapter = new ArrayAdapter(this, R.layout.my_list_item, listOfContacts);
                values.setAdapter(adapter);
                break;

            case R.id.button_clear:
                deleteData();
                break;
        }
    }
    */

    public void addOnClick(View view){
        boolean b = insertData();

        if(b == true){
            Toast.makeText(CrudStartDroidActivity.this, "INPUTED DATA HAS INSERTED TO DB", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(CrudStartDroidActivity.this, "INPUTED DATA HASN'T INSERTED TO DB", Toast.LENGTH_SHORT).show();
        }
    }

    public void readOnClick(View view){
        ArrayList<Contact> listOfContacts = readData();
        String [] arr = new String[]{"ABC", "DEF", "GHI"};
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listOfContacts);
        values.setAdapter(adapter);
        if(listOfContacts.isEmpty() || listOfContacts.size() == 0){
            Toast.makeText(CrudStartDroidActivity.this, "NO ITEMS IN ARRAY_LIST", Toast.LENGTH_SHORT).show();
        }
    }

    public void deleteOnClick(View view){
        deleteData();
        Toast.makeText(CrudStartDroidActivity.this, "ALL DATA IN DB HAS DELETED", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean insertData() {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        contentValues = new ContentValues();

        contentValues.put(StartDroidDBHelper.NAME, nameText.getText().toString());
        contentValues.put(StartDroidDBHelper.EMAIL, emailText.getText().toString());
        long res = database.insert(dbHelper.TABLE_NAME, null, contentValues);

        if(res > 0){
            return true;
        } else{
            return false;
        }
    }

    @Override
    public ArrayList<Contact> readData() {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        cursor = database.query(dbHelper.TABLE_NAME, null, null, null, null, null, null);

        int nameIndex = cursor.getColumnIndex(dbHelper.NAME);
        int emailIndex = cursor.getColumnIndex(dbHelper.EMAIL);

        ArrayList<Contact> listOfContacts = new ArrayList<>();

        if(cursor.moveToFirst()){
            while (cursor.moveToNext()){
                Contact contact = new Contact();
                contact.setName(cursor.getString(nameIndex));
                contact.setEmail(cursor.getString(emailIndex));
                listOfContacts.add(contact);
            }
        } else{
            Toast.makeText(CrudStartDroidActivity.this, "NO DATA IN DB", Toast.LENGTH_LONG).show();
        }
        return listOfContacts;
    }

    @Override
    public void deleteData() {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        database.delete(dbHelper.TABLE_NAME, null, null);
    }
}