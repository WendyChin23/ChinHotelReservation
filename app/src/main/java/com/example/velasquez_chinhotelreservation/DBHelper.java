
package com.example.velasquez_chinhotelreservation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String database_name = "database.db";
    public static final String table_name = "tblUser";
    //define table columns
    // public static final String col_id= "id";
    public static final String col_name = "name";
    //public static final String col_birthday = "birthday";
    public static final String col_email = "email";
    public static final String col_pass = "password";
  //  public static final String col_age = "age";
    // public static final String col_address = "address";


    public DBHelper(Context context) {
        super(context, database_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + table_name + "(email TEXT PRIMARY KEY, name TEXT, password TEXT, age INT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + table_name);
        onCreate(db);
    }

    public boolean createPerson(String email, String name, String password) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        //contentValues.put(col_id, id);
        contentValues.put(col_name, name);
        //contentValues.put(col_birthday, birthday);
        contentValues.put(col_email, email);
        contentValues.put(col_pass, password);
        //contentValues.put(col_number, number);
        //contentValues.put(col_address, address);

        long result = db.insert(table_name, null, contentValues);
        db.close();
        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+table_name,null);
        return res;
    }

    public boolean updateData(String email,String name,String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_email,email);
        contentValues.put(col_name,name);
        contentValues.put(col_pass,password);
       // contentValues.put(COL_4,roomtype);
        db.update(table_name, contentValues, "email = ?",new String[] { email });
        return true;
    }

    public Integer deleteData (String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(table_name, "email = ?",new String[] {email});
    }


    public boolean checkUser(String Email, String Password) {
        SQLiteDatabase db = this.getReadableDatabase();
        //      Person p = null;
//        String where = "email ='" + emailAdd + "'";
        Cursor cursor = db.rawQuery("Select * from tblUser where email = ? and password = ?", new String[]{Email, Password});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;

   /*     if(cursor.moveToNext()){
            p = new Person();
            p.setName(cursor.getString(1));
            p.setBirthday(cursor.getString(2));
            p.setEmail(cursor.getString(3));
            p.setPassword(cursor.getString(4));
            p.setNumber(cursor.getString(5));
            p.setAddress(cursor.getString(6));
        }
        db.close();
        return p;
    }*/
    }
}