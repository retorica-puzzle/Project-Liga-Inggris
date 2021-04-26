package com.example.asus.ligainggris;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.asus.projectuas.R;

import java.util.ArrayList;

public class GridInggrisAdapter extends RecyclerView.Adapter<GridInggrisAdapter.GridViewHolder> {
    private Context context;
    private ArrayList<LigaInggris> listLigaInggris;

    private ArrayList<LigaInggris> getListLigaInggris() {
        return listLigaInggris;
    }

    void setListLigaInggris(ArrayList<LigaInggris> listLigaInggris) {
        this.listLigaInggris = listLigaInggris;
    }

    GridInggrisAdapter(Context context) {
        this.context = context;
    }

    @Override
    public GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_inggris, parent, false);
        return new GridViewHolder(view);}

    @Override
    public void onBindViewHolder(GridViewHolder holder, int position) {
        Glide.with(context)
                .load(getListLigaInggris().get(position).getPhoto())
                .override(350, 550)
                .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListLigaInggris().size();
    }

    class GridViewHolder extends RecyclerView.ViewHolder{
        ImageView imgPhoto;
        GridViewHolder(View itemView) {
            super(itemView);
            imgPhoto = (ImageView)itemView.findViewById(R.id.img_item_photo);
        }
    }
}