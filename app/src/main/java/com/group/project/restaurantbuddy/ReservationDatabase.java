package com.group.project.restaurantbuddy;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

//import androidx.annotation.Nullable;

public class ReservationDatabase extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "reservation.db";
    public static final String RESERVATION_TABLE = "reserve_table";
    public static final String COL_1 = "reservationID";
    public static final String COl_2 = "date";
    public static final String COL_3 = "time";
    public static final String COl_4 = "tableNum";
    public static final String COL_5 = "name";

    public ReservationDatabase(Context context) {
        super(context, DATABASE_NAME, null, 1);
        //SQLiteDatabase db = this.getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + RESERVATION_TABLE +"(RESERVATIONID INTEGER PRIMARY KEY AUTOINCREMENT, DATE INT, TIME TEXT, TABLENUM TEXT, NAME TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + RESERVATION_TABLE);
    }

    public boolean insertData(String date){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COl_2, date);
        //contentValues.put(COL_3, time);
        //contentValues.put(COl_4, tableNum);
        //contentValues.put(COL_5, name);
        long result = db.insert(RESERVATION_TABLE, null, contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
}
