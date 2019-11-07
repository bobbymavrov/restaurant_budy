//Raul DB mod


package com.group.project.restaurantbuddy;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

    //variables to assign db names:
    public static final String DATABASE_NAME = "user.db";
    public static final String TABLE_NAME = "user_table";
    public static final String TABLE_NAME2 = "order_table";

    public static final String Col_1 = "ID";
    public static final String Col_2 = "name";
    public static final String Col_3 = "email";
    public static final String Col_4 = "phone";
    public static final String Col_5 = "password";


    public static final String Col_1_order_id = "ID";
    public static final String Col_2_order1 = "order1";
    public static final String Col_3_order2 = "order2";
    public static final String Col_4_order3 = "order3";
    public static final String Col_5_order4 = "order4";
    public static final String Col_6_order5 = "order5";

    String createOrderTable = "create table " + TABLE_NAME2 +
            "( ID INTEGER ," +
            " ORDER1 TEXT, " +
            " ORDER2 TEXT, " +
            " ORDER3 TEXT, " +
            " ORDER4 TEXT, " +
            " ORDER5 TEXT, " +
            "FOREIGN KEY(ID) REFERENCES TABLE_NAME(ID));";

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
        db.execSQL(createOrderTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME2);
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
    public boolean insertOrderData(String order1, String order2, String order3, String order4,String order5) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Col_2_order1, order1);
        contentValues.put(Col_3_order2, order2);
        contentValues.put(Col_4_order3, order3);
        contentValues.put(Col_5_order4, order4);
        contentValues.put(Col_6_order5, order5);

        long result = db.insert(TABLE_NAME2, null, contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
}