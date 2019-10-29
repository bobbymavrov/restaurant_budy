package com.group.project.restaurantbuddy.restaurants;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnector {

    private Cursor cursor = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    public DatabaseConnector(){}

    public Cursor getRestaurantTable(String tableName) throws SQLException {

        try {

            SQLiteDatabase db = SQLiteDatabase.openDatabase("database/Restaurants.db", null, 0);
            String query = String.format("SELECT * FROM %s", tableName);
            cursor = db.rawQuery(query, null);

            String temp = "pause";

            /*db.execSQL(query);
            connection = DriverManager.getConnection("jdbc:sqlite:database/Restaurants.db");
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);*/

        }catch (Exception e){
            e.printStackTrace();
          //  closeDbConnection();
        }

        return cursor;
    }

   /* private void closeDbConnection(){

        if (statement != null) try { statement.close(); } catch(Exception e) {}
        if (connection != null) try { connection.close(); } catch(Exception e) {}
        if (resultSet != null) try { resultSet.close(); } catch(Exception e) {}
    }*/
}
