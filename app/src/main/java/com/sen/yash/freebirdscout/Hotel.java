package com.sen.yash.freebirdscout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class Hotel extends AppCompatActivity {

    RecyclerView.LayoutManager layoutManager;
    LinearLayoutManager linearLayoutManager;

    RecyclerAdapter recyclerAdapter1;
    RecyclerView recyclerView;

//    String[] hotelnames, facilities, price, rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);

        String[] hotelnames = {"Lords", "Temptation", "Bizz", "The Fern Hotel", "Addition Blue"};
        String[] facilities = {"WiFi,pool,restaurant", "Breakfast,restaurant", "Restaurant,bar", "WiFi,breakfast",
                "Restaurant,WiFi,cab"};
        String[] price = {"₹1499","₹1149","₹999","₹1799","₹1999"};
        String[] rating = {"4.6","4.2","4.1","3.9","3.5"};

        recyclerAdapter1 = new RecyclerAdapter(hotelnames,facilities,price,rating,this);
        linearLayoutManager = new LinearLayoutManager(null);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(recyclerAdapter1);
    }
}
