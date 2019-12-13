package com.group.project.restaurantbuddy;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.group.project.restaurantbuddy.CardData;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class OrderS extends AppCompatActivity{
    Button orderButton;
    Database userDb;
    List<String[]> cart = new ArrayList<String[]>();

    @Override

    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_cart_page);
       orderButton = (Button) findViewById(R.id.btnPlaceOrder);
    }

    public void addData(){
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // boolean isInserted = userDb.insertOrderData();
            }
        });
    }

    }

