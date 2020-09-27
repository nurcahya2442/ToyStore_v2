package com.example.newlatihan.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.newlatihan.R;

import static com.example.newlatihan.ui.GirlToyActivity.EXTRA_DECS;
import static com.example.newlatihan.ui.GirlToyActivity.EXTRA_PRICE;
import static com.example.newlatihan.ui.GirlToyActivity.EXTRA_TITTLE;


public class DetailToysActivity extends AppCompatActivity  {
    public static final int EXTRA_URL = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_toys);


        Intent intent = getIntent();
        int imageUrl = getIntent().getIntExtra(String.valueOf(EXTRA_URL),0);
        String tittleToys = intent.getStringExtra(EXTRA_TITTLE);
        String descToys = intent.getStringExtra(EXTRA_DECS);
        String priceToys = intent.getStringExtra(EXTRA_PRICE);

        ImageView imageView = findViewById(R.id.imgDetail_toys);
        TextView tvToysName = findViewById(R.id.tvDetail_ToyName);
        TextView tvDecs     = findViewById(R.id.tvDetail_Decs) ;
        TextView tvPrice    = findViewById(R.id.tvDetail_price);

        imageView.setImageResource(imageUrl);
        tvToysName.setText(tittleToys);
        tvDecs.setText(descToys);
        tvPrice.setText(priceToys);



    }

}