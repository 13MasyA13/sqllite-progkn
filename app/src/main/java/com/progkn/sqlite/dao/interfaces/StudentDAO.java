package com.progkn.sqlite.dao.interfaces;

import com.progkn.sqlite.entities.Student;

import java.util.ArrayList;

public interface StudentDAO {

    public boolean insertData(String fName, String lName, String mark);

    public boolean deleteDataByID(int id);

    public Student getStudentByID(int id);

    public ArrayList<Student> getAllStudents();
}
