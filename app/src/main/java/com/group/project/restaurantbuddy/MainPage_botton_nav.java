package com.group.project.restaurantbuddy;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.group.project.restaurantbuddy.restaurants.DataBaseHelper;
import com.group.project.restaurantbuddy.ui.OrderHistoryAdapter;
import com.group.project.restaurantbuddy.ui.cart.CartAdapter;
import com.group.project.restaurantbuddy.ui.food.MenuFragment;
import com.group.project.restaurantbuddy.ui.cart.CartPage_fragment;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.group.project.restaurantbuddy.restaurants.DataBaseHelper;
import java.util.ArrayList;
import java.util.List;

public class MainPage_botton_nav extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener {
    List<String[]> cart = new ArrayList<String[]>();
    String orderHistory[] = new String[10];
    OrderHistoryAdapter adapter;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    SQLiteDatabase userDb;
    SQLiteOpenHelper openHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page_botton_nav);


        //Init
        recyclerView = (RecyclerView) findViewById(R.id.orderHistory);
        recyclerView.setHasFixedSize(true);


        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);



        BottomNavigationView navView = findViewById(R.id.nav_view);

       // loadListFood();



        navView.setOnNavigationItemSelectedListener(this);
        loadFragment(new MainPage_fragment());

        MyApplication app = (MyApplication) getApplication();
//        app.getId();
//        Intent intent1 = getIntent();


    }

    private boolean loadFragment(Fragment fragement) {
        if (fragement != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.f_container, fragement)
                    .commit();
            return true;
        }
        return false;

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.navigation_b_main:
                fragment = new MainPage_fragment();
                break;
            case R.id.navigation_b_menu:
                fragment = new MenuFragment();
                break;
            case R.id.navigation_b_cart:
                fragment = new CartPage_fragment();


        }
        return loadFragment(fragment);
    }


    private void loadListFood() {
        int i =0;
        List<String[]> items = new ArrayList<>();
        List<String[]> orders = new ArrayList<>();

        DataBaseHelper openHelper2 = new DataBaseHelper(this.getApplication().getApplicationContext());
        openHelper2.openDataBase();
        SQLiteDatabase userDb2 = openHelper2.getReadableDatabase();


        openHelper = new Database(this);
        userDb = openHelper.getReadableDatabase();

        Cursor cursor = userDb.rawQuery("SELECT * FROM " + Database.TABLE_NAME2, null);
        if(cursor.moveToFirst()){
            do{
                orderHistory[i] = cursor.getString(i+1);
                i++;
            }while(cursor.moveToNext());
        }

      Cursor  cursor2 = userDb2.rawQuery("SELECT * FROM ihop", null);
        int columnsCount = cursor2.getColumnCount();
        while(cursor2.moveToNext()){
            String[] row = new String[columnsCount];
            for(int j = 0; j < cursor2.getColumnCount(); j ++){
                row[j] = cursor2.getString(j);
            }
            items.add(row);
        }
        int n = 0;
        int check;
        for (int h = 0; h < columnsCount; h++){
            String _order = String.valueOf(orderHistory[n]);
            String _items = String.valueOf(items.get(h)[0]);
            check = _order.compareTo(_items);

            String[] row = new String[10];
           // Toast.makeText(getApplicationContext(), _order, Toast.LENGTH_LONG).show();
            //Toast.makeText(getApplicationContext(), _items, Toast.LENGTH_LONG).show();
            if(check == 0){
                for(int k= 0; k <items.get(h).length-1;k++){
                    row[k] = items.get(h)[k];
                    Toast.makeText(getApplicationContext(), "ok", Toast.LENGTH_LONG).show();

                }
                orders.add(row);
            }
            n++;
        }


         //Toast.makeText(getApplicationContext(),orderHistory[1], Toast.LENGTH_LONG).show();

        adapter = new OrderHistoryAdapter(orders, this);
        recyclerView.setAdapter(adapter);
    }
}
