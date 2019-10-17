package com.group.project.restaurantbuddy.ui.food;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.group.project.restaurantbuddy.R;
import com.group.project.restaurantbuddy.ui.menu.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class MenuFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_menu, container, false);

        //========Manage Recycler View - Bobby=========
        recyclerView = rootView.findViewById(R.id.my_recycler_view);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)

        List<Integer> imageList = new ArrayList<>();
        addImagesToList(imageList);

        mAdapter = new MyAdapter(imageList);
        recyclerView.setAdapter(mAdapter);

        return rootView;
    }

    private void addImagesToList(List<Integer> imageList){

        imageList.add(R.drawable.menu1_01);
        imageList.add(R.drawable.menu1_03);
        imageList.add(R.drawable.menu1_04);
        imageList.add(R.drawable.menu1_06);
        imageList.add(R.drawable.menu2_01);
        imageList.add(R.drawable.menu2_02);
        imageList.add(R.drawable.menu2_05);
        imageList.add(R.drawable.menu2_08);
        imageList.add(R.drawable.menu3_01);
        imageList.add(R.drawable.menu3_03);
        imageList.add(R.drawable.menu3_06);
        imageList.add(R.drawable.menu3_07);
        imageList.add(R.drawable.menu4_01);
        imageList.add(R.drawable.menu4_04);
        imageList.add(R.drawable.menu4_06);
        imageList.add(R.drawable.menu4_08);

    }
}