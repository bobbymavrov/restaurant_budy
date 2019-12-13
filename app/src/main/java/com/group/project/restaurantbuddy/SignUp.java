package com.group.project.restaurantbuddy;

import android.os.Bundle;
import android.util.Patterns;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity {
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[0-9])" +         //at least 1 digit
                    "(?=.*[a-z])" +         //at least 1 lower case letter
                    "(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{6,}" +               //at least 4 characters
                    "$");
    Database userDb;
    EditText editName, editEmail, editPhone, editPassword;
    Button btnAddData;
    private TextInputLayout textInputEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        userDb = new Database(this);
        setContentView(R.layout.fragment_signup);
        editName = (EditText) findViewById(R.id.editText_Name);
        editEmail = (EditText) findViewById(R.id.editText_Email);
        editPhone = (EditText) findViewById(R.id.editText_Phone);
        editPassword = (EditText) findViewById(R.id.editText_Password);
        //textInputEmail = findViewById(R.id.editText_Email);
        btnAddData = (Button) findViewById(R.id.button_add);
     confirmInput();
        AddData();

    }



    public void AddData(){
        btnAddData.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){

                        boolean isInserted = userDb.insertData(editName.getText().toString(),
                                editEmail.getText().toString(),
                                editPhone.getText().toString(),
                                editPassword.getText().toString());
                        if (isInserted = true)
                            Toast.makeText(SignUp.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(SignUp.this, "Data not Inserted", Toast.LENGTH_LONG).show();

                    }
                }

        );
    }

    private boolean validateEmail() {
        String _email = editEmail.getText().toString().trim();

        if (_email.isEmpty()) {
            editEmail.setError("Field can't be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(_email).matches()) {
            editEmail.setError("Please enter a valid email address");
            Toast.makeText(this, "Please enter a valid email address", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            editEmail.setError(null);
            return true;
        }

    }
    private boolean validatePassword() {
        String _password = editPassword.getText().toString().trim();

        if (_password.isEmpty()) {
            editPassword.setError("Field can't be empty");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(_password).matches()) {
            editPassword.setError("Password too weak");
            return false;
        } else {
            editEmail.setError(null);
            return true;
        }

    }

    public void confirmInput(){
        if (!validateEmail()| !validatePassword()) {
            return;
        }

    }

    }
