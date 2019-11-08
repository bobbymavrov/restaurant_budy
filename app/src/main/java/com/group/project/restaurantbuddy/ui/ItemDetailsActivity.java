package com.group.project.restaurantbuddy.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.group.project.restaurantbuddy.R;

public class ItemDetailsActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_details_activity);

        getIncomingIntent();
    }

    private void getIncomingIntent(){
        if(getIntent().hasExtra("detailsArray")){
            String[] details = getIntent().getStringArrayExtra("detailsArray");
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
}
