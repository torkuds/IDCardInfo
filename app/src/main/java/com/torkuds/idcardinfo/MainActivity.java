package com.torkuds.idcardinfo;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.torkuds.idcardinfo.api.Api;
import com.torkuds.idcardinfo.bean.CardInfo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    AdView mAdView;
    private TextView tvBirth;
    private TextView tvGender;
    private TextView tvArea;
    private EditText etNo;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        MobileAds.initialize(this, "ca-app-pub-4688735318347564~7899128054");

//        mAdView = findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);

        tvBirth = findViewById(R.id.tv_birth);
        tvGender = findViewById(R.id.tv_gender);
        tvArea = findViewById(R.id.tv_area);
        etNo = findViewById(R.id.et_no);

        progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(true);
        progressDialog.setMessage("查询中。。。");

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(etNo.getText())){
                    progressDialog.show();
                    load();
                } else {
                    Toast.makeText(MainActivity.this, "请输入身份证号码", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void load(){
        Api.getDefault().getIDcardInfo(etNo.getText().toString(), "a834eae4b17637f193707fd00a063456").enqueue(new Callback<CardInfo>() {
            @Override
            public void onResponse(Call<CardInfo> call, Response<CardInfo> response) {
                progressDialog.dismiss();
                if (!response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "请求出错", Toast.LENGTH_SHORT).show();
                    return;
                }
                CardInfo body = response.body();
                if (body != null && "200".equals(body.getResultcode())){
                    tvBirth.setText("出生日期：" + body.getResult().getBirthday());
                    tvGender.setText("性别：" + body.getResult().getSex());
                    tvArea.setText("户籍地址：" + body.getResult().getArea());
                }
            }

            @Override
            public void onFailure(Call<CardInfo> call, Throwable t) {
                progressDialog.dismiss();
            }
        });
    }
}
