package com.group.project.restaurantbuddy.ui;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.group.project.restaurantbuddy.Database;
import com.group.project.restaurantbuddy.MainPage;
import com.group.project.restaurantbuddy.R;
import com.group.project.restaurantbuddy.Request;

public class ItemDetailsActivity extends AppCompatActivity {
    Button add_cart;
    Cursor cursor;
    Database userDb;
    SQLiteOpenHelper openHelper;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_details_activity);

        getIncomingIntent();
    }

    private void getIncomingIntent(){
        if(getIntent().hasExtra("detailsArray")){
            final String[] details = getIntent().getStringArrayExtra("detailsArray");
            TextView title = findViewById(R.id.details_title);
            final TextView description = findViewById(R.id.details_description);
            TextView price = findViewById(R.id.details_price);
            ImageView image = findViewById(R.id.details_image);

//            //add_cart button
//            add_cart = (Button) findViewById(R.id.add_to_cart);
//            add_cart.setOnClickListener(new View.OnClickListener(){
//                @Override
//
//                public void onClick(View v){
//                    boolean isInserted = userDb.insertOrderData(details[0],details[0],details[0],details[0],details[0],details[0]);
//                }
//
//            });
//

            title.setText(details[0]);
            description.setText(details[2]);
            price.setText("$" + details[1]);
            Glide.with(this).load(details[3]).into(image);
        }
    }
}
