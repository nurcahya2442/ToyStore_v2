package com.example.newlatihan.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.newlatihan.Adapter.ToyBoyAdapter;
import com.example.newlatihan.Model.BoyToys;
import com.example.newlatihan.R;

import java.util.ArrayList;

public class BoyToysActivity extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView recyclerViewBoyItem;
    private ArrayList<BoyToys> imgModelBoyArrayList;
    private ToyBoyAdapter Boyadapter;
    private TextView tvGirlMenu_b;
    private TextView tvBoyMenu_b;

    private int [] img_b = new int[]{R.drawable.lego,R.drawable.lego,R.drawable.lego,R.drawable.berbi,R.drawable.bear};
    private String [] tvName_b = new String[] {"Lego Colorful Set", "Robocop Hikari v.20", "Pedang ultramen", "Berbi ken", "Teddy bear"};
    private String [] tvDecs_b = new String[] {"Lego warna warni bongkar pasang","Robot ultramen hikayi bagus sekali pokonya si", "Lego warna warni bongkar pasang", "lorem ipsum dolor sit amet", "seharusnya cowo disarankan tidak beli ini"};
    private String [] tvPrice_b = new String[] {"Rp.500.000", "Rp.250.000", "Rp.150.000", "Rp.332.000", "Rp.400.000"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boy_toys);

        recyclerViewBoyItem = (RecyclerView) findViewById(R.id.recycler_ItemBoy);
//        tvBoyMenu_b = (TextView) findViewById(R.id.tvBoyMenu);
        findViewById(R.id.tvGirlMenu).setOnClickListener(this);
//        findViewById(R.id.tvBoyMenu).setOnClickListener(this);

        imgModelBoyArrayList = playToysForBoy();
        Boyadapter = new ToyBoyAdapter(this, imgModelBoyArrayList);
        recyclerViewBoyItem.setAdapter(Boyadapter);
        recyclerViewBoyItem.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

//        eventListener();

    }

    public void onClick(View view){
        startActivity(new Intent(BoyToysActivity.this, GirlToyActivity.class));

        switch (view.getId()){
            case R.id.tvGirlMenu:
                overridePendingTransition(
                        android.R.anim.fade_in, android.R.anim.fade_out);
                break;
//            case R.id.tvBoyMenu:
//                overridePendingTransition(
//                        android.R.anim.slide_in_left, android.R.anim.slide_out_right);
//                break;
        }
    }

//    private void eventListener(){
//        tvGirlMenu_b.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(BoyToysActivity.this, GirlToyActivity.class));
//            }
//        });
//    }

    private ArrayList<BoyToys> playToysForBoy(){

        ArrayList<BoyToys> list = new ArrayList<>();

        for(int i = 0; i < 5; i++){
            BoyToys boyToys = new BoyToys();
            boyToys.setImgBoy(img_b[i]);
            boyToys.setTvName_Boy(tvName_b[i]);
            boyToys.setTvDecs_Boy(tvDecs_b[i]);
            boyToys.setTvPrice_Boy(tvPrice_b[i]);
            list.add(boyToys);
        }
        return list;
    }

}