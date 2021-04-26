package com.example.asus.ligainggris;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.asus.projectuas.R;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

    public Button but1;
    public  void init(){
        but1 = (Button)findViewById(R.id.but1);
        but1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent toy = new Intent(DetailActivity.this,MainActivity.class);
                startActivity(toy);
            }
        });
    }

// --------------------------------------------//
    private ImageView imagePhoto;
    private TextView textName;
    private TextView textKet;
    private Button btnDialPhone;
    String nama;
    String ket;
    String photo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        init();

        textName = findViewById(R.id.name);
        textKet = findViewById(R.id.ket);
        imagePhoto = findViewById(R.id.img_item_photo);
        Intent intent = getIntent();
        nama = getIntent().getExtras().getString("name");
        ket = getIntent().getExtras().getString("ket");
        photo = getIntent().getExtras().getString("photo");

        textName.setText(nama);
        textKet.setText(ket);

        Glide.with(DetailActivity.this)
                .load(photo)
                .override(350, 550)
                .into(imagePhoto);

        btnDialPhone = (Button)findViewById(R.id.btn_dial_number);
        btnDialPhone.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_dial_number:
                String phoneNumber = "083117744276";
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, android.net.Uri.parse("tel:"+phoneNumber));
                startActivity(dialPhoneIntent);
                break;
        }
    }
}
