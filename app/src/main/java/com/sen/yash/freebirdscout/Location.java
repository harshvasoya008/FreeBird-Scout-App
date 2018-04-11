package com.sen.yash.freebirdscout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Location extends AppCompatActivity {

    EditText txt_location;
    Button btn_go;
    ImageView img_screen1, img_screen2, img_screen3;
    HorizontalScrollView horizontalScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        txt_location = findViewById(R.id.txt_location);
        btn_go = findViewById(R.id.btn_go);
        img_screen1 = findViewById(R.id.img_screen1);
        img_screen2 = findViewById(R.id.img_screen2);
        img_screen3 = findViewById(R.id.img_screen3);
        horizontalScrollView = findViewById(R.id.screen);

        btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fillTheScreen();
            }
        });

    }

    private void fillTheScreen(){
        String location_name = txt_location.getText().toString();
        if(location_name.equals("Gandhinagar")){
            horizontalScrollView.setVisibility(View.VISIBLE);
        }
        else{
            horizontalScrollView.setVisibility(View.INVISIBLE);
            Toast.makeText(this, "It seems you have lost somewhere!", Toast.LENGTH_SHORT).show();
        }
    }
}
