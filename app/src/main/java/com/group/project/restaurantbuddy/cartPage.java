package com.group.project.restaurantbuddy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bumptech.glide.Glide;
import com.group.project.restaurantbuddy.ui.ItemDetailsActivity;
import com.group.project.restaurantbuddy.ui.payment.PaymentFragment;

public class cartPage extends AppCompatActivity {
    Button submit;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_page);


      //  getIncomingIntent();
        submit = (Button) findViewById(R.id.btnPlaceOrder);



        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

            }

        });




    }


    private void getIncomingIntent(){
        if(getIntent().hasExtra("Add_Cart")){
            String details = getIntent().getStringExtra("Add_Cart");
            Toast.makeText(getApplicationContext(),details, Toast.LENGTH_LONG).show();
            //TextView title = findViewById(R.id.cart_title);
          //  TextView description = findViewById(R.id.cart_description);
            //TextView price = findViewById(R.id.cart_price);
            ImageView image = findViewById(R.id.details_image);

           // description.setText(details);

        }
    }



}
