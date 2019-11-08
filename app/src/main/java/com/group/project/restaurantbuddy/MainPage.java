package com.group.project.restaurantbuddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.os.Bundle;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import android.view.View;
import android.os.Bundle;
import android.content.Intent;
import android.view.LayoutInflater;
import com.group.project.restaurantbuddy.R;
import com.group.project.restaurantbuddy.ui.food.MenuFragment;
import com.group.project.restaurantbuddy.restaurants.DataBaseHelper;

import android.content.Context;

import java.io.IOException;

public class MainPage extends AppCompatActivity {

    Cursor cursor;
    SQLiteDatabase userDb;
    String user_name;
    SQLiteOpenHelper openHelper;
    Button menu;
    Button request;
    Button order;

    Database insertDb;
    DataBaseHelper newDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_page);
        //Main PAGE BUTTON
        menu = (Button) findViewById(R.id.button_menu);
//        menu.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                Intent intent = new Intent (MainPage.this, MenuFragment.class);
//                startActivity(intent);
//            }
//
//        });
        request = (Button) findViewById(R.id.button_request);
        request.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent (MainPage.this, Request.class);
                startActivity(intent);
            }

        });
        order = (Button) findViewById(R.id.button_cart);
        order.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent (MainPage.this, cartPage.class);
                startActivity(intent);
            }

        });
        openHelper = new Database(this);
        userDb = openHelper.getReadableDatabase();


        //SHOW USER NAME
        Intent intent = getIntent();
        String _Id = intent.getStringExtra("ID");


        cursor = userDb.rawQuery("SELECT * FROM " + Database.TABLE_NAME
                + " WHERE " + Database.Col_1
                + " =? ", new String[]{_Id} );

        if(cursor != null) {
            cursor.moveToNext();
            if(cursor.getCount() > 0) {
                user_name = cursor.getString(1);


                TextView textView = findViewById(R.id.username);
                textView.setText(user_name);

            }
            else{
                Toast.makeText(getApplicationContext(),"Error", Toast.LENGTH_LONG).show();
            }
        }

       // cursor.close();


    //addData();

    }

    //will be MODIFIED later
    public void addData(){
        Intent intent1 = getIntent();
        String Id1 = intent1.getStringExtra("ID");

        newDb = new DataBaseHelper(this.getApplication().getApplicationContext());
        newDb.openDataBase();
       userDb = newDb.getReadableDatabase();

        cursor = userDb.rawQuery(" SELECT * FROM ihop ", null);

        if(cursor != null) {
            cursor.moveToNext();
            if(cursor.getCount() > 0) {
                String order1 = "HI";
                String order2 = cursor.getString(1);
                String order3 = cursor.getString(1);
                String order4 = cursor.getString(1);
                String order5 = cursor.getString(1);
                boolean isInserted = insertDb.insertOrderData(Id1,order1,order2,order3,order4,order5);
                if (isInserted = true)
                    Toast.makeText(MainPage.this, "Data Inserted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainPage.this, "Data not Inserted", Toast.LENGTH_LONG).show();

            }
        }


    }
}
