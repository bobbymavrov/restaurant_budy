package com.group.project.restaurantbuddy.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import com.bumptech.glide.Glide;
import com.group.project.restaurantbuddy.MyApplication;
import com.group.project.restaurantbuddy.R;
import com.group.project.restaurantbuddy.cartPage;

import android.content.Intent;
import android.widget.Toast;

public class ItemDetailsActivity extends AppCompatActivity {
    Button addCart;
    String[] details;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_details_activity);

        getIncomingIntent();
        addCart = (Button) findViewById(R.id.add_to_cart);
        addCart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

               // Intent intent = new Intent (ItemDetailsActivity.this, cartPage.class);
               // String _detail = details[0];
                MyApplication app =(MyApplication) getApplication();
                app.setOrder(details[0]);

                  //  intent.putExtra("Add_Cart", _detail);

                   // startActivity(intent);

            }

        });

    }

    private void getIncomingIntent(){
        if(getIntent().hasExtra("detailsArray")){
            details = getIntent().getStringArrayExtra("detailsArray");
            TextView title = findViewById(R.id.details_title);
            TextView description = findViewById(R.id.details_description);
            TextView price = findViewById(R.id.details_price);
            ImageView image = findViewById(R.id.details_image);

            title.setText(details[0]);
            description.setText(details[2]);
            price.setText("$" + details[1]);
            Glide.with(this).load(details[3]).into(image);
        }
    }

//Abby add button
    private void add_to_Cart(){

       Intent intent = new Intent (ItemDetailsActivity.this, cartPage.class);
       String[] de = getIntent().getStringArrayExtra("details");
        intent.putExtra("Add_Cart",de);

    }



}
