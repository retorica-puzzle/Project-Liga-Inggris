package com.example.asus.ligainggris;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.asus.projectuas.R;

import java.util.ArrayList;

public class CardViewInggrisAdapter extends RecyclerView.Adapter<CardViewInggrisAdapter.CardViewViewHolder>{
    private ArrayList<LigaInggris> listLigaInggris;
    private Context context;

    CardViewInggrisAdapter(Context context) {
        this.context = context;
    }

    private ArrayList<LigaInggris> getListLigaInggris() {
        return listLigaInggris;
    }

    void setListLigaInggris(ArrayList<LigaInggris> listLigaInggris) {
        this.listLigaInggris = listLigaInggris;
    }

    @Override
    public CardViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_inggris, parent, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder( final CardViewViewHolder holder, int position) {

        LigaInggris p = getListLigaInggris().get(position);
        final CardViewViewHolder itemHolder = holder;
        Glide.with(context)
                .load(p.getPhoto())
                .override(350, 550)
                .into(holder.imgPhoto);

        holder.tvName.setText(p.getName());
        holder.tvRemarks.setText(p.getRemarks());

        holder.btnFavorite.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Details "+ getListLigaInggris().get(position).getName(),
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("photo", getListLigaInggris().get(position).getPhoto());
                intent.putExtra("name", getListLigaInggris().get(position).getName());
                intent.putExtra("ket", getListLigaInggris().get(position).getRemarks());

                context.startActivity(intent);
            }
        }));

        holder.btnShare.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Comment "+ getListLigaInggris().get(position).getName(),
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, CrudActivity.class);
                context.startActivity(intent);
            }
        }));
    }

    @Override
    public int getItemCount() {
        return getListLigaInggris().size();
    }

    class CardViewViewHolder extends RecyclerView.ViewHolder{
        ImageView imgPhoto;
        TextView tvName, tvRemarks;
        Button btnFavorite, btnShare;

        CardViewViewHolder(View itemView) {
            super(itemView);
            imgPhoto = (ImageView)itemView.findViewById(R.id.img_item_photo);
            tvName = (TextView)itemView.findViewById(R.id.tv_item_name);
            tvRemarks = (TextView)itemView.findViewById(R.id.tv_item_remarks);
            btnFavorite = (Button)itemView.findViewById(R.id.btn_set_favorite);
            btnShare = (Button)itemView.findViewById(R.id.btn_set_share);
        }
    }

}
