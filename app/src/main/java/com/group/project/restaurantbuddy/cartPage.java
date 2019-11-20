package com.group.project.restaurantbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.group.project.restaurantbuddy.ui.payment.PaymentFragment;

public class cartPage extends AppCompatActivity {
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_page);
        submit = (Button) findViewById(R.id.submit_button);
        if(getIntent().hasExtra("Add_cart")){
            String[] details = getIntent().getStringArrayExtra("Add_cart");
            TextView title = findViewById(R.id.cart_title);
            TextView description = findViewById(R.id.cart_description);
            TextView price = findViewById(R.id.cart_price);
            ImageView image = findViewById(R.id.details_image);

            title.setText(details[0]);
            description.setText(details[2]);
            price.setText("$" + details[1]);
            Glide.with(this).load(details[3]).into(image);
        }


        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getApplicationContext(),"Order Successful!", Toast.LENGTH_LONG).show();
            }

        });
    }
}
