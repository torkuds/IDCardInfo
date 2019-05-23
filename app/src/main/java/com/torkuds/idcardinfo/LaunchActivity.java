package com.torkuds.idcardinfo;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class LaunchActivity extends AppCompatActivity {

    private InterstitialAd mInterstitialAd;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏状态栏
        getSupportActionBar().hide();//隐藏标题栏
        setContentView(R.layout.activity_launch);

//        MobileAds.initialize(this, "ca-app-pub-4688735318347564~7899128054");

//        mInterstitialAd = new InterstitialAd(this);
////        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");  //测试
//        mInterstitialAd.setAdUnitId("ca-app-pub-4688735318347564/7151922164");  //正式
//        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        intent = new Intent(LaunchActivity.this, MainActivity.class);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                gotoMainActivity();
            }
        }, 2000);


//        mInterstitialAd.setAdListener(new AdListener() {
//            @Override
//            public void onAdLoaded() {
//                // Code to be executed when an ad finishes loading.
//                mInterstitialAd.show();
//                handler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        gotoMainActivity();
//                    }
//                }, 2000);
//            }
//
//            @Override
//            public void onAdFailedToLoad(int errorCode) {
//                // Code to be executed when an ad request fails.
//                gotoMainActivity();
//            }
//
//            @Override
//            public void onAdOpened() {
//                // Code to be executed when the ad is displayed.
//            }
//
//            @Override
//            public void onAdClicked() {
//                // Code to be executed when the user clicks on an ad.
//            }
//
//            @Override
//            public void onAdLeftApplication() {
//                // Code to be executed when the user has left the app.
//            }
//
//            @Override
//            public void onAdClosed() {
//                // Code to be executed when the interstitial ad is closed.
//                gotoMainActivity();
//            }
//        });
    }

    private void gotoMainActivity(){
        startActivity(intent);
        LaunchActivity.this.finish();
    }

}
