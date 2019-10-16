package com.group.project.restaurantbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class reservation extends AppCompatActivity {

    RadioButton radioButton;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reservation_page);

        textView = findViewById(R.id.text_view_selected);

        Button buttonReserve = findViewById(R.id.button_reserve);

        buttonReserve.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                // Is the button now checked?
                boolean checked = ((RadioButton) v).isChecked();

                // Check which radio button was clicked
                switch(v.getId()) {
                    case R.id.radio_one:
                        if (checked)
                            textView.setText("Table 1 has been reserved");
                        break;
                    case R.id.radio_two:
                        if (checked)
                            textView.setText("Table 2 has been reserved");
                        break;
                    case R.id.radio_three:
                        if (checked)
                            textView.setText("Table 3 has been reserved");
                        break;
                    case R.id.radio_four:
                        if (checked)
                            textView.setText("Table 4 has been reserved");
                        break;
                    case R.id.radio_five:
                        if (checked)
                            textView.setText("Table 5 has been reserved");
                        break;
                    case R.id.radio_six:
                        if (checked)
                            textView.setText("Table 6 has been reserved");
                        break;
                }
            }
        });
    }

    public void checkButton(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_one:
                if (checked)
                    Toast.makeText(this, "Selected table: Table 1", Toast.LENGTH_SHORT).show();
                    break;
            case R.id.radio_two:
                if (checked)
                    Toast.makeText(this, "Selected table: Table 2", Toast.LENGTH_SHORT).show();
                    break;
            case R.id.radio_three:
                if (checked)
                    Toast.makeText(this, "Selected table: Table 3", Toast.LENGTH_SHORT).show();
                    break;
            case R.id.radio_four:
                if (checked)
                    Toast.makeText(this, "Selected table: Table 4", Toast.LENGTH_SHORT).show();
                    break;
            case R.id.radio_five:
                if (checked)
                    Toast.makeText(this, "Selected table: Table 5", Toast.LENGTH_SHORT).show();
                    break;
            case R.id.radio_six:
                if (checked)
                    Toast.makeText(this, "Selected table: Table 6", Toast.LENGTH_SHORT).show();
                    break;
        }
    }
}
