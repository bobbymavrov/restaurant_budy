package com.group.project.restaurantbuddy.ui.cart;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.group.project.restaurantbuddy.CardData;
//import com.group.project.restaurantbuddy.MainPage;
import com.group.project.restaurantbuddy.Database;
import com.group.project.restaurantbuddy.MainPage_botton_nav;
import com.group.project.restaurantbuddy.MyApplication;
import com.group.project.restaurantbuddy.R;
import com.group.project.restaurantbuddy.Request;
import com.group.project.restaurantbuddy.ui.home.HomeFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CartPage_fragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    private List<String[]> mDataset;
    Bundle bundle;
    //FirebaseDatabase database;
    //DatabaseReference request;
    TextView txtTotalPrice;
    Button btnPlace;
    private List<String[]> cart;
    CartAdapter adapter;
    Database userDb;
    String orders[] = new String[10];
    int j = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_cart_page, container, false);

        userDb = new Database(getActivity());
        cart = CardData.getCardData();

     //Init
        recyclerView = (RecyclerView) view.findViewById(R.id.listCart);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        txtTotalPrice = (TextView) view.findViewById(R.id.cart_total);


        MyApplication app = (MyApplication) getActivity().getApplication();
        final int userid = Integer.valueOf(app.getId());



        double total = 0;

      for(int i = 0; i < cart.size(); i++){
          total += Double.valueOf(cart.get(i)[1]);

              orders[i] = String.valueOf(cart.get(i)[0]);


      }

       // Toast.makeText(getContext(),"hi", Toast.LENGTH_LONG).show();
        txtTotalPrice.setText("$" +  String.valueOf(total));

        //txtTotalPrice.setText(total);

        loadListFood();



        Button submit;

        submit = (Button) view.findViewById(R.id.btnPlaceOrder);
        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
//                Intent intent = new Intent(v.getContext(), MainPage_botton_nav.class);
//                intent.putExtra("ordersArray",orders);


                //  Toast.makeText(v.getContext(), "Order Successful!", Toast.LENGTH_LONG).show();
                boolean isInserted = userDb.insertOrderData(userid, orders[0],orders[1],orders[2],orders[3],orders[4]);
                if(isInserted == true) {
                    Toast.makeText(v.getContext(), "Order Successful!", Toast.LENGTH_LONG).show();
                    CardData.emptyCard();
                }
            }


        });









        return view;
    }


    private void loadListFood(){


       final int position;
        adapter = new CartAdapter(cart,getActivity());
       recyclerView.setAdapter(adapter);


    }
}
