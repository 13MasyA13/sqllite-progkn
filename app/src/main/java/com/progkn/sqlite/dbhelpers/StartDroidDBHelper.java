package com.progkn.sqlite.dbhelpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class StartDroidDBHelper extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "contactsDB";
    public static final String TABLE_NAME = "contacts";

    public static final String ID = "_id";
    public static final String NAME = "name";
    public static final String EMAIL = "email";

    public StartDroidDBHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" + " ID INTEGER PRIMARY KEY AUTOINCREMENT" + " , " +
        "NAME TEXT" + " , "  + "EMAIL TEXT " + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_NAME);
        onCreate(db);
    }
}
