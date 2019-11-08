package com.group.project.restaurantbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
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

import com.group.project.restaurantbuddy.restaurants.DataBaseHelper;

import android.content.Context;

public class MainPage extends AppCompatActivity {

    Cursor cursor;
    SQLiteDatabase userDb;
    String user_name;
    SQLiteOpenHelper openHelper;
    Button menu;
    Button request;
    Button order;
    LayoutInflater inflater;
    ViewGroup container;
    Database insertDb;
    DataBaseHelper newDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_page);
        //Main PAGE BUTTON
        menu = (Button) findViewById(R.id.button_menu);
        menu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent (MainPage.this, MenuFragment.class);
                startActivity(intent);
            }

        });
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



    }

    //will be MODIFIED later
    public void addData(){
        Intent intent = getIntent();
        String _Id = intent.getStringExtra("ID");
        SQLiteDatabase _db =newDb.getReadableDatabase();


//        cursor = userDb.rawQuery("SELECT * FROM " + Database.TABLE_NAME
//                + " WHERE " + Database.Col_3
//                + " =? AND " + Database.Col_5 + " =? ", new String[]{_email,_pass} );
//       cursor =  _db.rawQuery("SELECT * FROM " + )
//
//        string _order1;
//        string _order2;
//        string _order3;
//        string _order4;
//        string _order5;
//        boolean isInserted = insertDb.insertOrderData(_Id,_order1,_order2,_order3,_order4,_order5);
    }
}
