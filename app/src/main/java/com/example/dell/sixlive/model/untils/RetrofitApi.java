package com.example.dell.sixlive.model.untils;

import com.example.dell.sixlive.Bean.ChannelBean;
import com.example.dell.sixlive.Bean.ChoicenessBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by nyj on 2018/5/26.
 */

public interface RetrofitApi {

    //首页
    @GET("front/homePageApi/homePage.do")
    Observable<ChoicenessBean> getchoiceness();
    //频道
    @POST("front/columns/getVideoList.do")
    @FormUrlEncoded
    Observable<ChannelBean> channel(@Field("catalogId") String catalogId,@Field("information") String information);
}
