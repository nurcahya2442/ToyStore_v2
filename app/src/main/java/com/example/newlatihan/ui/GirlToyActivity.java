package com.example.newlatihan.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.newlatihan.Adapter.ToyGirlAdapter;
import com.example.newlatihan.Model.Toys;
import com.example.newlatihan.R;

import java.util.ArrayList;

public class GirlToyActivity extends AppCompatActivity implements ToyGirlAdapter.OnItemClickListener {
    public static final int EXTRA_URL = 0;
    public static final String EXTRA_TITTLE = "toysName";
    public static final String EXTRA_DECS = "decsItem";
    public static final String EXTRA_PRICE = "priceItem";

    private RecyclerView recyclerView;
    private ArrayList<Toys> imgModelArrayList;
    private ToyGirlAdapter adapter;
    private TextView tvBoy_g;

    private int [] imgToyGirl = new int[]{R.drawable.bear,R.drawable.berbi,R.drawable.bear,R.drawable.berbi,R.drawable.bear};
    private String [] tvNamaMainan = new String[] {"Teddy Bear Fluffy Pink", "Barbie Blonde Hair", "Teddy Bear Fluffy Pink", "Barbie Blonde Hair","Teddy Bear Pink" };
    private String [] tvDeskripsi = new String[] {"Ini tu tedy bear warna pink ucul banget tiada tara", "Jangan dibeli, Bukan untuk dijual", "Ini tu tedy bear warna pink ucul banget tiada tara", "Barbie Kw gausa dibeli", "Ini tu tedy bear warna pink ucul banget tiada tara", "Barbienya bagus lucu kalo buat dimainin"};
    private String [] tvHarga = new String[] {"Rp. 150.000","Rp. 150.000","Rp. 250.000","Rp. 50.000", "Rp. 500.000" };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_girl_toys);

        recyclerView = (RecyclerView) findViewById(R.id.rvItemToys);
        tvBoy_g = (TextView) findViewById(R.id.tvBoyMenu_g);
//        findViewById(R.id.tvBoyMenu_g).setOnClickListener((View.OnClickListener) this);

        imgModelArrayList = playToys();
        adapter = new ToyGirlAdapter(this, imgModelArrayList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL,false));

        adapter.setOnItemClickListener(GirlToyActivity.this);

        eventListener();
    }

//    private void onClick(View view){
//        startActivity(new Intent(GirlToyActivity.this,BoyToysActivity.class));
//
//        switch (view.getId()){
//            case R.id.tvBoyMenu_g:
//                overridePendingTransition(
//                        android.R.anim.slide_in_left, android.R.anim.slide_out_right);
//                break;
//        }
//
//    }

    private void eventListener(){
        tvBoy_g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GirlToyActivity.this, BoyToysActivity.class));

                switch (v.getId()){
                    case R.id.tvBoyMenu_g:
                        overridePendingTransition(
                                android.R.anim.fade_in, android.R.anim.fade_out);
                        break;
                }
            }
        });
    }

    private ArrayList<Toys> playToys(){

        ArrayList<Toys> list = new ArrayList<>();

        for(int i = 0; i < 5; i++){
            Toys toys = new Toys();
            toys.setPic(imgToyGirl[i]);
            toys.setTvJudul(tvNamaMainan[i]);
            toys.setTvDeks(tvDeskripsi[i]);
            toys.setTvHarga(tvHarga[i]);
            list.add(toys);
        }
        return list;
    }

    @Override
    public void onItemClick(int position) {
        Intent detailIntent = new Intent(this, DetailToysActivity.class);
        Toys clickedItem = imgModelArrayList.get(position);

        detailIntent.putExtra(String.valueOf(DetailToysActivity.EXTRA_URL),clickedItem.getPic());
        detailIntent.putExtra(EXTRA_TITTLE, clickedItem.getTvJudul());
        detailIntent.putExtra(EXTRA_DECS, clickedItem.getTvDeks());
        detailIntent.putExtra(EXTRA_PRICE, clickedItem.getTvHarga());

        startActivity(detailIntent);
    }
}