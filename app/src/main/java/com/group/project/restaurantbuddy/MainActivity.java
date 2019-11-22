package com.group.project.restaurantbuddy;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.group.project.restaurantbuddy.ui.MakeReservation.MainReservation;
import com.group.project.restaurantbuddy.ui.food.MenuFragment;
import com.group.project.restaurantbuddy.ui.home.HomeFragment;

import com.group.project.restaurantbuddy.ui.food.MyAdapter;


import com.group.project.restaurantbuddy.ui.payment.PaymentFragment;

import com.group.project.restaurantbuddy.ui.request.RequestFragment;
import com.group.project.restaurantbuddy.ui.sign.SignInFragment;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Button;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class  MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    /////////////////Database Activity//////////////
    //Database userDb;


    /////////////////Database Activity//////////////

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.bringToFront();
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_open_menu, R.id.nav_talk, R.id.mainReservation,
                R.id.nav_pay, R.id.nav_share, R.id.nav_sign, R.id.nav_request, R.id.payment)
                .setDrawerLayout(drawer)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        loadDatabases();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        //NOTE: creating fragment object
        Fragment fragment = null;

        if (id == R.id.nav_home) {
            fragment = new HomeFragment();
        } else if (id == R.id.nav_open_menu) {
            fragment = new MenuFragment();
        } else if (id == R.id.nav_sign) {
            fragment = new SignInFragment();
        } else if (id == R.id.nav_home) {

            fragment = new HomeFragment();
        }
        else if(id == R.id.mainReservation){
            fragment = new MainReservation();
        }
         else if (id == R.id.nav_request)
         {
            fragment = new RequestFragment();
         }
        else if (id == R.id.payment)
        {
            fragment = new PaymentFragment();
        }
        //NOTE: Fragment changing code
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.nav_home, fragment);
            ft.commit();
        }

        //NOTE:  Closing the drawer after selecting
        DrawerLayout drawer = findViewById(R.id.drawer_layout); //Ya you can also globalize this variable :P
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void loadDatabases() {

        Context context = getApplicationContext();
        File DB_FILE = context.getDatabasePath("Restraurants.db");
        InputStream mInput = null;
        try {
            mInput = context.getAssets().open("Restaurants.db");
            OutputStream mOutput = new FileOutputStream(DB_FILE);
            byte[] mBuffer = new byte[1024];
            int mLength;
            while ((mLength = mInput.read(mBuffer)) > 0) {
                mOutput.write(mBuffer, 0, mLength);
            }
            mOutput.flush();
            mOutput.close();
            mInput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


//
//    public void signin() {
//        Intent intObj = new Intent(this, SignInFragment.class);
//        startActivity(intObj);
//
//
//    }
//    public void signup() {
//        Intent intObj2 = new Intent(this, SignUp.class);
//        startActivity(intObj2);
//
//
//    }
}
