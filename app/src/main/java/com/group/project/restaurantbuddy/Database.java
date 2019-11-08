//Raul DB mod


package com.group.project.restaurantbuddy;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

    //variables to assign db names:
    public static final String DATABASE_NAME = "Xuser.db";
    public static final String TABLE_NAME = "user_table";
    public static final String Col_1 = "ID";
    public static final String Col_2 = "name";
    public static final String Col_3 = "email";
    public static final String Col_4 = "phone";
    public static final String Col_5 = "password";

    //Function to create Database table
    public Database(Context context) {
        super(context, DATABASE_NAME, null, 1);
        //Create DB and Table:
        //SQLiteDatabase db = this.getWritableDatabase();
    }

    //Executes quary
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,EMAIL TEXT,PHONE INTEGER,PASSWORD TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name, String email, String phone, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Col_2, name);
        contentValues.put(Col_3, email);
        contentValues.put(Col_4, phone);
        contentValues.put(Col_5, password);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
}