package com.group.project.restaurantbuddy.ui.food;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.group.project.restaurantbuddy.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<String[]> mDataset;
    private FragmentActivity activity;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView titleTextView;
        public TextView descriptionTextView;
        public TextView priceTextView;
        public ImageView imageView;

        public MyViewHolder(View view) {

            super(view);
            titleTextView = view.findViewById(R.id.menu_item_title);
            descriptionTextView = view.findViewById(R.id.menu_item_description);
            priceTextView = view.findViewById(R.id.menu_item_price);
            imageView = view.findViewById(R.id.menu_item_image);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<String[]> itemsList, FragmentActivity _activity)
    {
        mDataset = itemsList;
        activity = _activity;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        View contactView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_item, parent, false);

        MyViewHolder vh = new MyViewHolder(contactView);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.titleTextView.setText(mDataset.get(position)[0]);
        holder.descriptionTextView.setText(mDataset.get(position)[2]);
        holder.priceTextView.setText(mDataset.get(position)[1]);
        Glide.with(holder.imageView).load(mDataset.get(position)[3]).into(holder.imageView);
       // Picasso.get().load("https://square.github.io/picasso/static/sample.png").into(holder.imageView);
        //holder.imageView.setImageURI(Uri.parse(mDataset.get(position)[3]));
      //  holder.imageView.setImageResource(R.drawable.hotel_chef_icons_83240);
       // int temp = holder.imageView.getMaxHeight();
       // holder.imageView(mDataset.get(position));

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}


