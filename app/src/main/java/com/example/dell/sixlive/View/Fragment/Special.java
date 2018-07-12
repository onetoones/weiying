package com.example.dell.sixlive.View.Fragment;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.dell.sixlive.Adater.SpecialAdapter;
import com.example.dell.sixlive.Bean.ChoicenessBean;
import com.example.dell.sixlive.Persenter.SpecialPresenter;
import com.example.dell.sixlive.R;
import com.example.dell.sixlive.View.IView;
import com.example.dell.sixlive.rewrite.GridSpacingItemDecoration;

import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by DELL on 2018/7/6.
 */

public class Special extends BaseHot<SpecialPresenter> implements IView {
    Unbinder unbinder;
    private RecyclerView rc;
    int spanCount = 2;
    int spacing = 15;
    boolean includeEdge = true;
    private SwipeRefreshLayout sw;
    private SpecialAdapter specialAdapter;


    @Override
    protected void initView(View inflate) {
        rc = inflate.findViewById(R.id.special_rec);
        sw = inflate.findViewById(R.id.special_swipe);
        //下拉加载
        sw.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onRefresh() {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        presenter.specials();
                        specialAdapter.notifyDataSetChanged();
                        sw.setRefreshing(false);
                    }
                },1200);

            }
        });

    }

    @Override
    protected int bindLayout() {

        return R.layout.special;
    }

    @SuppressLint("NewApi")
    @Override
    protected void initData() {
        //P层交互
        presenter.specials();
    }

    @Override
    protected void bindEvent() {

    }

    @Override
    protected SpecialPresenter setPresenter() {
        return new SpecialPresenter();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void getPecial(ChoicenessBean bean) {
        List<ChoicenessBean.RetBean.ListBean> list = bean.getRet().getList();

        specialAdapter = new SpecialAdapter(list, getActivity());
        rc.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        rc.setLayoutManager(gridLayoutManager);

        rc.setAdapter(specialAdapter);

    }

    @Override
    public void fail(String s) {

    }


}
