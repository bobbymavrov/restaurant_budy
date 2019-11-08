package com.group.project.restaurantbuddy;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class FindTable extends AppCompatActivity {

    ReservationDatabase reserveDB;
    Button btnAddData;

    private static final String TAG = "FindTable";

    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        reserveDB = new ReservationDatabase( this);
        setContentView(R.layout.fragment_choose_date_time);
        mDisplayDate = (TextView) findViewById(R.id.textViewDate);

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        FindTable.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                Log.d(TAG, "onDateSet: date: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                mDisplayDate.setText(date);
            }
        };

        btnAddData = (Button) findViewById(R.id.submitBtn);
        AddData();
    }

    public void AddData(){
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        boolean isInserted = reserveDB.insertData(mDisplayDate.getText().toString());
                        if (isInserted = true)
                            Toast.makeText(FindTable.this, "DATA INSERTED", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(FindTable.this, "ERROR", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
    //SELECT DATE AND TIME:
    /*
    Show Available table platform (IMAGE)
     Select table to reserve
    Access ReservationDB
    Reserve Table/Table taken already
    Set Reservation DATE TIME NAME
    Go Back
    */

}
