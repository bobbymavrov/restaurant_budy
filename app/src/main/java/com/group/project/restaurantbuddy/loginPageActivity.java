package com.group.project.restaurantbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
public class loginPageActivity extends AppCompatActivity {
    private Button signinButton;
    private Button signupButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);

        signinButton = (Button) findViewById(R.id.button2);
        signinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             signin();

            }
        });

        signupButton = (Button) findViewById(R.id.button);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });


    }
    public void signin() {
        Intent intObj = new Intent(this, SignIn.class);
        startActivity(intObj);


    }


    public void signup(){
        Intent intObj2 = new Intent(this, SignUp.class);
        startActivity(intObj2);
    }
}
