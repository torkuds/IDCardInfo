package com.torkuds.idcardinfo.api;

import com.torkuds.idcardinfo.bean.CardInfo;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by wangtianchao
 * on 2017/4/25.
 */

public interface ApiService {

    /**
     * 登录
     * @param
     * @return
     */
    @GET("idcard/index")
    Call<CardInfo> getIDcardInfo(@Query("cardno") String cardno, @Query("key") String key);

}
