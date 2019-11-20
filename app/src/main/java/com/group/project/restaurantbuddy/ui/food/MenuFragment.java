package com.group.project.restaurantbuddy.ui.food;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.group.project.restaurantbuddy.R;

import java.util.ArrayList;
import java.util.List;

public class MenuFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_menu, container, false);

        MenuViewModel menuViewModel = ViewModelProviders.of(this).get(MenuViewModel.class);
        List<String[]> itemsList = new ArrayList<>();

        try {
            itemsList = menuViewModel.loadMenuData("ihop");
        } catch (Exception e) {
            e.printStackTrace();
        }

        recyclerView = rootView.findViewById(R.id.my_recycler_view);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new MyAdapter(itemsList, getActivity());
        recyclerView.setAdapter(mAdapter);

        return rootView;
    }
}