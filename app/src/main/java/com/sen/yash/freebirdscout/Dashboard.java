package com.sen.yash.freebirdscout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ListView;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        CardView busses = (CardView) findViewById(R.id.bus);
        busses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this,Bus.class);
                startActivity(intent);
            }
        });
        CardView hotelsss = (CardView) findViewById(R.id.hotel);
        hotelsss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this,Hotel.class);
                startActivity(intent);
            }
        });
        CardView locationess = (CardView) findViewById(R.id.location);
        locationess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this,Location.class);
                startActivity(intent);
            }
        });
        CardView developeress = (CardView) findViewById(R.id.developer);
        developeress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this,Developer.class);
                startActivity(intent);
            }
        });
    }
}
