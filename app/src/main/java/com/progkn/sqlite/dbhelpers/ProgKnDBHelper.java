package com.progkn.sqlite.dbhelpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.progkn.sqlite.dao.interfaces.StudentDAO;
import com.progkn.sqlite.entities.Student;

import java.util.ArrayList;
import java.util.List;

public class ProgKnDBHelper extends SQLiteOpenHelper implements StudentDAO {

    public static final String DATABASE_NAME = "Student.db";
    public static final String TABLE_NAME = "student_table";

    public static final String ID = "id";
    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String MARK = "mark";

    public ProgKnDBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "first_name TEXT, last_name TEXT, mark INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME);
        onCreate(db);
    }

    @Override
    public boolean insertData(String firstName, String lastName, String mark) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(FIRST_NAME, firstName);
        contentValues.put(LAST_NAME, firstName);
        contentValues.put(MARK, mark);
        long i = db.insert(TABLE_NAME, null, contentValues);

        if(i > 0){
            return true;
        } else{
            return false;
        }
    }

    @Override
    public boolean deleteDataByID(int id) {
        return false;
    }

    @Override
    public Student getStudentByID(int id) {
        return null;
    }

    @Override
    public ArrayList<Student> getAllStudents() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Student> allUsers = new ArrayList<>();
        //Cursor cursor
        return null;

    }
}