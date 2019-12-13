package com.group.project.restaurantbuddy;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.group.project.restaurantbuddy.restaurants.DataBaseHelper;
import com.group.project.restaurantbuddy.ui.OrderHistoryAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainPage_fragment extends Fragment {
    List<String[]> cart = new ArrayList<String[]>();

    OrderHistoryAdapter adapter;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    SQLiteDatabase userDb;
    SQLiteOpenHelper openHelper;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main_page_botton_nav,null);
        //Init
        recyclerView = (RecyclerView) view.findViewById(R.id.orderHistory);
        recyclerView.setHasFixedSize(true);


        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        TextView textView = view.findViewById(R.id.Main_textview);
        textView.setText("Your recent Order");

        loadListFood();
        return view;
    }



    private void loadListFood() {
        int i =0;
        List<String[]> items = new ArrayList<>();
        List<String[]> orders = new ArrayList<>();
        String orderHistory[] = new String[100];
        DataBaseHelper openHelper2 = new DataBaseHelper(getActivity().getApplication().getApplicationContext());
        openHelper2.openDataBase();
        SQLiteDatabase userDb2 = openHelper2.getReadableDatabase();


        openHelper = new Database(getActivity());
        userDb = openHelper.getReadableDatabase();

        Cursor cursor = userDb.rawQuery("SELECT * FROM " + Database.TABLE_NAME2, null);


        while(cursor.moveToNext()){
            for(int a = 0; a < cursor.getColumnCount(); a++){
                orderHistory[a] = cursor.getString(a);
            }
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
        do {
            for (int h = 0; h < cursor2.getCount(); h++) {
                String _order = String.valueOf(orderHistory[n]);
                String _items = String.valueOf(items.get(h)[0]);
                check = _order.compareTo(_items);

                String[] row = new String[100];
                // Toast.makeText(getApplicationContext(), _order, Toast.LENGTH_LONG).show();
                //Toast.makeText(getApplicationContext(), _items, Toast.LENGTH_LONG).show();
                if (check == 0) {
                    for (int k = 0; k < items.get(h).length; k++) {
                        row[k] = items.get(h)[k];
                        //Toast.makeText(getApplicationContext(), "ok", Toast.LENGTH_LONG).show();

                    }
                    orders.add(row);
                }

            }
            n++;
        }while(n < orderHistory.length);


        //Toast.makeText(getApplicationContext(),orderHistory[1], Toast.LENGTH_LONG).show();

        adapter = new OrderHistoryAdapter(orders, getActivity());
        recyclerView.setAdapter(adapter);
    }
}
