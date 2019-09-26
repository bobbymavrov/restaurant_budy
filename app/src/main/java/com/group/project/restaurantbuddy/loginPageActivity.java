package com.group.project.restaurantbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class loginPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
    }

    public void signin(View view) {
        Intent intObj = new Intent(loginPageActivity.this, SignIn.class);
        startActivity(intObj);


    }
}
