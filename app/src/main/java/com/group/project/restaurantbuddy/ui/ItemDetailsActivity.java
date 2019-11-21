package com.group.project.restaurantbuddy.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.group.project.restaurantbuddy.CardData;
import com.group.project.restaurantbuddy.R;

public class ItemDetailsActivity extends AppCompatActivity {

    String[] details;
    double totalPrice;
    int numItems = 1;
    Button button;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_details_activity);

        getIncomingIntent();
        button = findViewById(R.id.add_to_cart);
        handleItemsSpinner();
        updateAddToCard();
        handleAddToCard();
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
            totalPrice = numItems * Double.parseDouble(details[1]);
            Glide.with(this).load(details[3]).into(image);
        }
    }

    private void handleItemsSpinner(){

        Spinner spinner = findViewById(R.id.details_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.num_items, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                numItems = i + 1;
                totalPrice = numItems * Double.parseDouble(details[1]);
                updateAddToCard();
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });
    }

    private void handleAddToCard(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] cardData = new String[6];
                for(int i = 0; i < details.length; i++){
                    cardData[i] = details[i];
                }
                cardData[4] = Integer.toString(numItems);
                cardData[5] = Double.toString(totalPrice);
                CardData.addToCard(cardData);
            }
        });
    }

    private void updateAddToCard(){
        button.setText(String.format("Add %s to card · $%s", numItems, totalPrice));
    }
}
