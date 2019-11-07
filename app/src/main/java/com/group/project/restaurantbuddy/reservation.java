package com.group.project.restaurantbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class reservation extends AppCompatActivity {

    TextView textView;
    String tableReservation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reservation_page);

        textView = findViewById(R.id.text_view_selected);

        Button buttonReserve = findViewById(R.id.button_reserve);

        buttonReserve.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                textView.setText(tableReservation);
            }
        });
    }

    public void checkButton(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        RadioButton rb1 = (RadioButton) findViewById(R.id.radio_one);
        RadioButton rb2 = (RadioButton) findViewById(R.id.radio_two);
        RadioButton rb3 = (RadioButton) findViewById(R.id.radio_three);
        RadioButton rb4 = (RadioButton) findViewById(R.id.radio_four);
        RadioButton rb5 = (RadioButton) findViewById(R.id.radio_five);
        RadioButton rb6 = (RadioButton) findViewById(R.id.radio_six);

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_one:
                if (checked)
                    Toast.makeText(this, "Selected table: Table 1", Toast.LENGTH_SHORT).show();
                    tableReservation = "Table 1 has been reserved";
                    rb2.setChecked(false);
                    rb3.setChecked(false);
                    rb4.setChecked(false);
                    rb5.setChecked(false);
                    rb6.setChecked(false);
                    break;
            case R.id.radio_two:
                if (checked)
                    Toast.makeText(this, "Selected table: Table 2", Toast.LENGTH_SHORT).show();
                    tableReservation = "Table 2 has been reserved";
                    rb1.setChecked(false);
                    rb3.setChecked(false);
                    rb4.setChecked(false);
                    rb5.setChecked(false);
                    rb6.setChecked(false);
                    break;
            case R.id.radio_three:
                if (checked)
                    Toast.makeText(this, "Selected table: Table 3", Toast.LENGTH_SHORT).show();
                    tableReservation = "Table 3 has been reserved";
                        rb2.setChecked(false);
                        rb1.setChecked(false);
                        rb4.setChecked(false);
                        rb5.setChecked(false);
                        rb6.setChecked(false);
                    break;
            case R.id.radio_four:
                if (checked)
                    Toast.makeText(this, "Selected table: Table 4", Toast.LENGTH_SHORT).show();
                    tableReservation = "Table 4 has been reserved";
                    rb2.setChecked(false);
                    rb3.setChecked(false);
                    rb1.setChecked(false);
                    rb5.setChecked(false);
                    rb6.setChecked(false);
                    break;
            case R.id.radio_five:
                if (checked)
                    Toast.makeText(this, "Selected table: Table 5", Toast.LENGTH_SHORT).show();
                    tableReservation = "Table 5 has been reserved";
                    rb2.setChecked(false);
                    rb3.setChecked(false);
                    rb4.setChecked(false);
                    rb1.setChecked(false);
                    rb6.setChecked(false);
                    break;
            case R.id.radio_six:
                if (checked)
                    Toast.makeText(this, "Selected table: Table 6", Toast.LENGTH_SHORT).show();
                    tableReservation = "Table 6 has been reserved";
                    rb2.setChecked(false);
                    rb3.setChecked(false);
                    rb4.setChecked(false);
                    rb5.setChecked(false);
                    rb1.setChecked(false);
                    break;
        }
    }
}
