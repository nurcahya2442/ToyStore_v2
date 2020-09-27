package com.example.newlatihan.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.daimajia.androidanimations.library.Techniques;
import com.example.newlatihan.Intro.IntroActivity;
import com.example.newlatihan.R;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;

public class SplashScreenActivity extends AwesomeSplash {


    @Override
    public void initSplash(ConfigSplash configSplash) {

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Background Animation
        configSplash.setBackgroundColor(R.color.bgColorApk);
        configSplash.setAnimCircularRevealDuration(1000);
        configSplash.setRevealFlagX(Flags.REVEAL_RIGHT);
        configSplash.setRevealFlagY(Flags.REVEAL_BOTTOM);

        //Logo

        configSplash.setLogoSplash(R.drawable.last_logo_rubik);
        configSplash.setAnimLogoSplashDuration(2000);
        configSplash.setAnimLogoSplashTechnique(Techniques.RotateIn);

        //Tittle
        configSplash.setTitleSplash("Toys Shop");
        configSplash.setTitleTextColor(R.color.txtColor);
        configSplash.setTitleFont("fonts/nunito_bold.ttf");
        configSplash.setTitleTextSize(40f);
        configSplash.setAnimTitleDuration(1000);
        configSplash.setAnimTitleTechnique(Techniques.Wave);


    }

    @Override
    public void animationsFinished() {
        startActivity(new Intent(SplashScreenActivity.this, IntroActivity.class));

    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_splash_screen);
//    }
}