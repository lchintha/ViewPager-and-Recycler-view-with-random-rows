package com.example.chint.viewpagerwithrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chint on 6/22/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    private String dates;
    private String descriptions;
    private int p;

    Context c;
    private MyData dataa = new MyData(dates, descriptions, p);

    public static final int zero = 1;
    public static final int one = 2;

    public MyAdapter(MyData dataa,Context c) {
        this.dataa = dataa;
        this.c = c;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case zero:View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_list, null);
                return new MyHolder(v);
            case one:View v1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_list2, null);
                return new MyHolder(v1);
            }
        return null;
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, final int position) {

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                //Snackbar.make(v,dates[position]+" : "+descriptions[position],Snackbar.LENGTH_SHORT).show();

                Intent i=new Intent(c, Detailed.class);
                /*i.putExtra("title", dates[position]);
                i.putExtra("title", descriptions[position]);

                i.putExtra("title", dates[position]);*/
                c.startActivity(i);
            }
        });

        if(holder.getItemViewType() == zero) {

            holder.title.setText(MyData.newData[position].getTitlesm());
            holder.description.setText(MyData.newData[position].getDescriptionsm());
            holder.image.setImageResource(MyData.newData[position].getImagesm());
        }
        else if(holder.getItemViewType() == one) {
            holder.title.setText(MyData.newData[position].getTitlesm());
            holder.description.setText(MyData.newData[position].getDescriptionsm());
            holder.image.setImageResource(MyData.newData[position].getImagesm());

        }
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    @Override
    public int getItemViewType(int position) {
        return (position % 2 ==  0 ? zero : one);
    }

    /*public class viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView title,description;
        public ImageView image;
        ItemClickListener itemClickListener;

        public viewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            title = (TextView) itemView.findViewById(R.id.text1);
            description = (TextView) itemView.findViewById(R.id.text2);
            image = (ImageView) itemView.findViewById(R.id.image);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            this.itemClickListener.onItemClick(v, getLayoutPosition());
        }
        public void setItemClickListener(ItemClickListener ic){
            this.itemClickListener=ic;
        }
    }*/
}
