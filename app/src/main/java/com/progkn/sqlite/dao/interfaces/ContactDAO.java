package com.progkn.sqlite.dao.interfaces;

import com.progkn.sqlite.entities.Contact;

import java.util.ArrayList;

public interface ContactDAO {

    public boolean insertData();

    public ArrayList<Contact> readData();

    public void deleteData();
}
