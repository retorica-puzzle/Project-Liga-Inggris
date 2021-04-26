package com.example.asus.ligainggris;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.asus.projectuas.R;

import java.util.ArrayList;

public class MainActivityAdmin extends AppCompatActivity {
    private RecyclerView rvCategory;
    private ArrayList<LigaInggris>list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin);

        rvCategory = (RecyclerView)findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list = new ArrayList<>();
        list.addAll(LigaInggrisData.getListData());

        showRecyclerList();
    }

    private void showRecyclerList(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        LigaInggrisAdapter listSembakoAdapter = new LigaInggrisAdapter(this);
        listSembakoAdapter.setListLigaInggris(list);
        rvCategory.setAdapter(listSembakoAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedSembako(list.get(position));
            }
        });
    }
    private void showRecyclerGrid(){
        rvCategory.setLayoutManager(new GridLayoutManager(this, 2));
        GridInggrisAdapter gridInggrisAdapter = new GridInggrisAdapter(this);
        gridInggrisAdapter.setListLigaInggris(list);
        rvCategory.setAdapter(gridInggrisAdapter);


        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedSembako(list.get(position));
            }
        });
    }
    private void showRecyclerCardView(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        CardViewInggrisAdapter cardViewInggrisAdapter = new CardViewInggrisAdapter(this);
        cardViewInggrisAdapter.setListLigaInggris(list);
        rvCategory.setAdapter(cardViewInggrisAdapter);
    }

    private void showLogout(){
        Toast.makeText(getApplicationContext(), "Keluar",
                Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivityAdmin.this, LoginActivity.class);
        MainActivityAdmin.this.startActivity(intent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_admin, menu);
        return super.onCreateOptionsMenu(menu);
    }
    private void setActionBarTitle(String title){
      getSupportActionBar().setTitle(title);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String title = null;
        switch (item.getItemId()){
            case R.id.action_list:
               title = "Mode List";
               showRecyclerList();
                break;

            case R.id.action_grid:
                title = "Mode Grid";
                showRecyclerGrid();
                break;

            case R.id.action_cardview:
                title = "Mode CardView";
                showRecyclerCardView();
                break;

            case R.id.action_logout:
                title = "Logout";
                showLogout();
                break;
        }
        setActionBarTitle(title);
        return super.onOptionsItemSelected(item);
    }

    private void showSelectedSembako(LigaInggris ligaInggris){
        Toast.makeText(this, "Kamu memilih "+ ligaInggris.getName(), Toast.LENGTH_SHORT).show();
    }
}
