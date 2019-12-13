package com.group.project.restaurantbuddy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.database.Cursor;
import android.widget.Toast;
import android.app.Application;

import com.group.project.restaurantbuddy.ui.food.MenuFragment;

public class SignIn extends AppCompatActivity {


    SQLiteDatabase userDb;
    SQLiteOpenHelper openHelper;
    EditText email, password;
    Cursor cursor;
    Button signin;
    Fragment fragment = null;
    CheckBox showpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_sign);
        openHelper = new Database(this);
        userDb = openHelper.getReadableDatabase();

        signin = (Button) findViewById(R.id.login_button);
        email = (EditText) findViewById(R.id.sign_Email);
        password = (EditText) findViewById(R.id.sign_password);
        showpassword = (CheckBox) findViewById(R.id.showpassword);
        showpassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String _email = email.getText().toString();
                String _pass = password.getText().toString();

                cursor = userDb.rawQuery("SELECT * FROM " + Database.TABLE_NAME
                        + " WHERE " + Database.Col_3
                        + " =? AND " + Database.Col_5 + " =? ", new String[]{_email, _pass});
                // String username = cursor.getString(cursor.getColumnIndex("name"));
                if (cursor != null) {

                    cursor.moveToNext();

                    if (cursor.getCount() > 0) {
                        String Id = cursor.getString(0);

                        Intent intent = new Intent(SignIn.this, MainPage_botton_nav.class);

                        Toast.makeText(getApplicationContext(), "Log in succesfully", Toast.LENGTH_LONG).show();


                        intent.putExtra("ID", Id);
                        MyApplication app = (MyApplication) getApplication();

                        app.setId(Id);

                         startActivity(intent);

//                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//                        fragment = new MainPage_fragment();
//                        ft.replace(R.id.nav_sign, fragment);
//                        ft.commit();


                    } else {
                        Toast.makeText(getApplicationContext(), "Incorrect username or password.", Toast.LENGTH_LONG).show();
                    }
                }
                cursor.close();
            }
        });


    }



}
