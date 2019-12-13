

package com.group.project.restaurantbuddy.ui;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.group.project.restaurantbuddy.R;
import com.group.project.restaurantbuddy.cartPage;
import com.group.project.restaurantbuddy.ui.ItemDetailsActivity;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class OrderHistoryAdapter extends RecyclerView.Adapter<OrderHistoryAdapter.OrderViewHolder> {
    private List<String[]> mDataset;
    List<String[]> cart;
    private FragmentActivity activity;
    Button orderPlace;

    public static class OrderViewHolder extends RecyclerView.ViewHolder {
        public TextView txt_cart_name, txt_price, main_txt;
        public ImageView img_cart_count;
        public View parentView;

        public void setTxt_cart_name(TextView txt_cart_name) {
            this.txt_cart_name = txt_cart_name;
        }


        public OrderViewHolder(View itemView) {

            super(itemView);
            txt_cart_name = (TextView) itemView.findViewById(R.id.cart_item_name);
            txt_price = (TextView) itemView.findViewById(R.id.cart_item_Price);
            img_cart_count = (ImageView) itemView.findViewById(R.id.cart_item_count);

        }



    }

    public OrderHistoryAdapter(List<String[]> itemList, FragmentActivity _activity) {

        mDataset = itemList;
        activity = _activity;
    }

    @Override
    public OrderHistoryAdapter.OrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.cart_layout, parent, false);
        return new OrderViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(OrderViewHolder holder, final int position) {

        int quantity = getItemCount();
        holder.txt_cart_name.setText(mDataset.get(position)[0]);

        holder.txt_price.setText("$" + (mDataset.get(position)[1]));
        Glide.with(holder.img_cart_count).load(mDataset.get(position)[3]).into(holder.img_cart_count);







    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }


}