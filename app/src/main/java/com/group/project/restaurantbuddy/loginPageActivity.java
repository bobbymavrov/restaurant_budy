package com.group.project.restaurantbuddy;

import androidx.appcompat.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
public class loginPageActivity extends AppCompatActivity {
     Button signinButton;
     Button signupButton;
    LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);
        //View rootView = inflater.inflate(R.layout.fragment_home,container,false);
        signinButton = (Button) findViewById(R.id.SignIn_button);
        signinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             signin();

            }
        });

        signupButton = (Button) findViewById(R.id.SignUp_button);
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
