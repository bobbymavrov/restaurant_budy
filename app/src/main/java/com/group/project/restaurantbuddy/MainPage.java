package com.group.project.restaurantbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
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
import com.group.project.restaurantbuddy.ui.menu.MenuLoader;
import com.group.project.restaurantbuddy.ui.payment.PaymentFragment;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        menu = (Button) findViewById(R.id.button_menu);
        menu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent (MainPage.this, PaymentFragment.class);
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
}
