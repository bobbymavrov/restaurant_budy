package com.group.project.restaurantbuddy;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    Database userDb;
    EditText editName, editEmail, editPhone;
    Button btnAddData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        userDb = new Database(this);
        setContentView(R.layout.fragment_signup);

        editName = (EditText) findViewById(R.id.editText_Name);
        editEmail = (EditText) findViewById(R.id.editText_Email);
        editPhone = (EditText) findViewById(R.id.editText_Phone);
        btnAddData = (Button) findViewById(R.id.button_add);

        AddData();
    }
        public void AddData() {
            btnAddData.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            boolean isInserted  = userDb.insertData(editName.getText().toString(),
                                    editEmail.getText().toString(),
                                    editPhone.getText().toString());
                            if(isInserted = true)
                                Toast.makeText(SignUp.this, "Data Inserted",Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(SignUp.this, "Data not Inserted",Toast.LENGTH_LONG).show();

                        }
                    }
            );


    }


}
