package com.example.dell.sixlive.Persenter;

import android.util.Log;

import com.example.dell.sixlive.Activity.IMarvellousView;
import com.example.dell.sixlive.Bean.ChannelBean;
import com.example.dell.sixlive.model.https.RetrofitUntils;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MarvellousPresenter extends BasePresenter<IMarvellousView> {
    private RetrofitUntils retrofitUntils;

    public MarvellousPresenter() {
        //拿到单例
        retrofitUntils = RetrofitUntils.getInsatnce();
    }

    public void getMarvellous(String urls,String infor) {

        Observable<ChannelBean> channel = retrofitUntils.getApi().channel(urls,infor);
        channel.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ChannelBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ChannelBean bean) {
                        getView().getMarvellous(bean);
                        Log.e("OnNext", "成功");
                        Log.e("bean",bean.getMsg());
                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().fail(e.getMessage());
                        Log.e("onError", "失败");
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

}
