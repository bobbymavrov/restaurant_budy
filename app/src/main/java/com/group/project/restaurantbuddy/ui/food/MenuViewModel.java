package com.group.project.restaurantbuddy.ui.food;

import android.database.Cursor;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.group.project.restaurantbuddy.restaurants.DatabaseConnector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuViewModel extends ViewModel {

    public List<String[]> loadMenuData(String restaurantName) throws SQLException {

        List<String[]> items = new ArrayList<>();
        DatabaseConnector connector = new DatabaseConnector();
        Cursor cursor = connector.getRestaurantTable("ihop");
        int columnsCount = cursor.getColumnCount();

        while(cursor.moveToNext()){
            String[] row = new String[columnsCount];
            for(int i = 0; i < cursor.getColumnCount(); i ++){
                row[i] = cursor.getString(i);
            }
           items.add(row);
        }

        return items;
    }
}