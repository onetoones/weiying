package com.example.dell.sixlive.Persenter;

import android.util.Log;

import com.example.dell.sixlive.Bean.ChoicenessBean;
import com.example.dell.sixlive.View.Fragment.Choiceness;
import com.example.dell.sixlive.View.IView;
import com.example.dell.sixlive.model.https.RetrofitUntils;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SpecialPresenter extends BasePresenter<IView>{
    private RetrofitUntils retrofitUntils;
    public SpecialPresenter(){
        //拿到单例
        retrofitUntils= RetrofitUntils.getInsatnce();
    }

    public void specials(){
        Observable<ChoicenessBean> specials = retrofitUntils.getApi().getchoiceness();
        specials.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ChoicenessBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ChoicenessBean choicenessBean) {
                        getView().getPecial(choicenessBean);

                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().fail(e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

}
