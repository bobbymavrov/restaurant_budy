package com.group.project.restaurantbuddy.ui.food;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.AndroidViewModel;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.PlaceLikelihood;
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest;
import com.google.android.libraries.places.api.net.FindCurrentPlaceResponse;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.group.project.restaurantbuddy.restaurants.DataBaseHelper;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class MenuViewModel extends AndroidViewModel {

    public MenuViewModel(@NonNull Application application) {
        super(application);
    }

    private String closestPlace = "IHOP";

    public List<String[]> loadMenuData(String restaurantName) throws SQLException, IOException {

        getNearbyPlace(this.getApplication().getApplicationContext());

        if(closestPlace.equals("IHOP")) {
            List<String[]> items = new ArrayList<>();
            DataBaseHelper openHelper = new DataBaseHelper(this.getApplication().getApplicationContext());
            openHelper.openDataBase();
            SQLiteDatabase userDb = openHelper.getReadableDatabase();

            Cursor cursor = userDb.rawQuery("SELECT * FROM ihop", null);
            int columnsCount = cursor.getColumnCount();

            while (cursor.moveToNext()) {
                String[] row = new String[columnsCount];
                for (int i = 0; i < cursor.getColumnCount(); i++) {
                    row[i] = cursor.getString(i);
                }
                items.add(row);
            }
            return items;
        }else {return null;}
    }

    private void getNearbyPlace(Context context){

        // Initialize the SDK
        Places.initialize(context, "AIzaSyBXm3YJyAKmY_QBGV3Ss7wVq_WYsdMtKUo");
        PlacesClient placesClient = Places.createClient(context);

        // Use fields to define the data types to return.
        List<Place.Field> placeFields = Collections.singletonList(Place.Field.NAME);

// Use the builder to create a FindCurrentPlaceRequest.
        FindCurrentPlaceRequest request =
                FindCurrentPlaceRequest.newInstance(placeFields);

// Call findCurrentPlace and handle the response (first check that the user has granted permission).
        try {
            if (ContextCompat.checkSelfPermission(context, ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                Task<FindCurrentPlaceResponse> placeResponse = placesClient.findCurrentPlace(request);
                placeResponse.addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        FindCurrentPlaceResponse response = task.getResult();
                        for (PlaceLikelihood placeLikelihood : response.getPlaceLikelihoods()) {
                            Log.i("Places API: ", String.format("Place '%s' has likelihood: %f",
                                    placeLikelihood.getPlace().getName(), placeLikelihood.getLikelihood()));
                        }
                    } else {
                        Exception exception = task.getException();
                        if (exception instanceof ApiException) {
                            ApiException apiException = (ApiException) exception;
                            Log.e("Places API: ", "Place not found: " + apiException.getStatusCode());
                        }
                    }
                });
            } else {
                Log.e("Places API: ", "Missing Permissions");
                // A local method to request required permissions;
                // See https://developer.android.com/training/permissions/requesting
                // getLocationPermission();
            }
        }catch (Exception e){
            Log.e("Error", e.getMessage());
        }
    }
}