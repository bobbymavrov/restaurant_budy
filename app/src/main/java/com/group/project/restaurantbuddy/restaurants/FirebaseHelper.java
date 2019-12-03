package com.group.project.restaurantbuddy.restaurants;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FirebaseHelper {

    public List<String[]> menuItems = new ArrayList<>();

    public void loadMenuData(String restaurantName){

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("restaurants/ihop");


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<Map<String, Object>> helper = (List<Map<String, Object>>) dataSnapshot.getValue();
                for(Map<String, Object> eachItem : helper){
                    String[] items = new String[4];
                    items[0] = eachItem.get("ItemPrice").toString();
                    items[1] = eachItem.get("ImageUrl").toString();
                    items[2] = eachItem.get("ItemName").toString();
                    items[3] = eachItem.get("ItemDescription").toString();
                    menuItems.add(items);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
