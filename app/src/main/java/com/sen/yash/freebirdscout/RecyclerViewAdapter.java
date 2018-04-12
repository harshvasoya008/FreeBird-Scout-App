package com.sen.yash.freebirdscout;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Harsh on 12-05-2016.
 */
class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>{

    String[] hotel_names, facility, prices, ratings;
    Context context;

    public  RecyclerAdapter(String[] _a,String[] _b,String[] _c, String[] _d, Context c){
        this.hotel_names = _a;
        this.facility = _b;
        this.prices = _c;
        this.ratings = _d;
        this.context=c;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotel_card,parent,false);
        RecyclerViewHolder holder = new RecyclerViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
        holder.card_heading.setText(hotel_names[position]);
        holder.card_subttitle.setText(facility[position]);
        holder.card_price.setText(prices[position]);
        holder.card_rating.setText(ratings[position]);

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, HotelRoom.class);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return hotel_names.length;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{

        TextView card_heading,card_subttitle,card_price,card_rating;
        CardView card;

        public RecyclerViewHolder(View v) {
            super(v);
            card = (CardView)v.findViewById(R.id.hotel_card_view);
            card_heading = v.findViewById(R.id.card_heading);
            card_subttitle = v.findViewById(R.id.card_subtitle);
            card_price = v.findViewById(R.id.card_price);
            card_rating = v.findViewById(R.id.card_rating);
        }
    }
}
