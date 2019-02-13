package com.example.imagejson;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;


import java.util.List;


public class RecAdapter extends RecyclerView.Adapter<RecAdapter.Holder> {
    Second mainActivity;
    List<poso> images;

    public RecAdapter(Second mainActivity, List images) {
        this.mainActivity = mainActivity;
        this.images = images;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row, viewGroup, false);

        Holder hold = new Holder(view);

        return hold;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {

        poso position;

        position = images.get(i);

        String imguri = position.getImgurl();

        // holder.imageView.setImageResource(Integer.parseInt(""+position.getImgurl()));

//holder.imageView.setImageResource(""+position.getImgurl()+"");
        //  Picasso.with(F.context).load(position.getImgurl()).into(Holder.);

        //Picasso.with(mainActivity).load(imguri).resize(50, 50).

        //Picasso.get().load(imguri).into(holder.imageView);
        //  centerCrop().into(holder.imageView);

        //  Picasso.with().load(imguri).into(holder.imageView);

        //Toast.makeText(mainActivity, "" + imguri, Toast.LENGTH_SHORT).show();

        //  Picasso.with(mainActivity).load(""+position.getImgurl()).into(holder.imageView);
        Glide.with(mainActivity).load(imguri).into(holder.imageView);
        holder.textView.setText("Downloads:" + position.getDownls());


    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public Holder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img1);

            textView = itemView.findViewById(R.id.tv1);

        }
    }
}
