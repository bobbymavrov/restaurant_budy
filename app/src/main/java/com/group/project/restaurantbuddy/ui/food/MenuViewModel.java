package com.group.project.restaurantbuddy.ui.food;

import android.app.Application;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.group.project.restaurantbuddy.restaurants.DataBaseHelper;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuViewModel extends AndroidViewModel {

    public MenuViewModel(@NonNull Application application) {
        super(application);
    }

    public List<String[]> loadMenuData(String restaurantName) throws SQLException, IOException {

        List<String[]> items = new ArrayList<>();
        DataBaseHelper openHelper = new DataBaseHelper(this.getApplication().getApplicationContext());
        openHelper.openDataBase();
        SQLiteDatabase userDb = openHelper.getReadableDatabase();

        Cursor cursor = userDb.rawQuery("SELECT * FROM ihop", null);
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