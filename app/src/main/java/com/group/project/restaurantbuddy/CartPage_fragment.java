package com.group.project.restaurantbuddy;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.group.project.restaurantbuddy.MyApplication;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;

public class CartPage_fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_cart_page, container, false);
        TextView title =(TextView) view.findViewById(R.id.cart_title);
        String[] details;
        MyApplication app = (MyApplication) this.getActivity().getApplication();
        title.setText(app.getOrder());
        return view;
    }
}
