package com.example.dell.sixlive.View.Fragment;

import android.view.View;

import com.example.dell.sixlive.Bean.ChoicenessBean;
import com.example.dell.sixlive.Persenter.BeijingPersenter;
import com.example.dell.sixlive.R;
import com.example.dell.sixlive.View.IView;

/**
 * Created by DELL on 2018/7/6.
 */

public class Discover extends BaseHot<BeijingPersenter> implements IView {
    @Override
    protected void initView(View inflate) {

    }

    @Override
    protected int bindLayout() {
        return R.layout.discover;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void bindEvent() {

    }

    @Override
    protected BeijingPersenter setPresenter() {
        return new BeijingPersenter();
    }

    @Override
    public void getPecial(ChoicenessBean bean) {

    }

    @Override
    public void fail(String s) {

    }
}
