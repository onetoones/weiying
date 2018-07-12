package com.example.dell.sixlive.Activity;

import android.app.Presentation;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.dell.sixlive.Adater.MarvellousAdapter;
import com.example.dell.sixlive.Bean.ChannelBean;
import com.example.dell.sixlive.Bean.ChoicenessBean;
import com.example.dell.sixlive.Persenter.BasePresenter;
import com.example.dell.sixlive.Persenter.MarvellousPresenter;
import com.example.dell.sixlive.R;
import com.example.dell.sixlive.rewrite.AGridSpacingItemDecoration;
import com.example.dell.sixlive.rewrite.GridSpacingItemDecoration;

import java.util.List;

public class MarvellousActivity extends BaseActivity<MarvellousPresenter> implements IMarvellousView {

    int spanCount = 3;
    int spacing = 20;
    boolean includeEdge = true;
    private String urls;
    private RecyclerView rc;
    private String[] split2;
    private TextView tv;
    private ImageView im;
    private SwipeRefreshLayout sw;
    private MarvellousAdapter adapter;
    private LinearLayout ll;
    private RelativeLayout ll1;

    @Override
    protected void initData() {
        BasePresenter.getMarvellous(split2[0], null);
    }

    @Override
    protected void initView() {

        rc = (RecyclerView) findViewById(R.id.marvellous_rec);
        tv = (TextView) findViewById(R.id.marvellous_tv);
        im = (ImageView) findViewById(R.id.marvellous_im);
        sw = findViewById(R.id.marvellous_swipe);
        ll = findViewById(R.id.marvellous_ll);
        ll1 = findViewById(R.id.marvellous_ll1);
        sw.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        BasePresenter.getMarvellous(split2[0], null);
                        adapter.notifyDataSetChanged();
                        sw.setRefreshing(false);
                    }
                }, 1200);
            }
        });

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        String names = intent.getStringExtra("names");
        tv.setText(names);
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //利用字符串分割和拼接
        String[] split = url.split("=");

        urls = split[1];
        split2 = urls.split("&");

    }

    @Override
    protected int setLayout() {
        return R.layout.activity_marvellous;
    }

    @Override
    protected MarvellousPresenter setPresenter() {
        return new MarvellousPresenter();
    }


    @Override
    public void getMarvellous(ChannelBean bean) {

        if (bean.getRet().getList().size()!=0) {
            ll.setVisibility(View.VISIBLE);
            ll1.setVisibility(View.GONE);
            List<ChannelBean.RetBean.ListBean> list = bean.getRet().getList();

            adapter = new MarvellousAdapter(this, list);
            rc.addItemDecoration(new AGridSpacingItemDecoration(spanCount, spacing, includeEdge));
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
            rc.setLayoutManager(gridLayoutManager);
            rc.setAdapter(adapter);
        } else {

            ll.setVisibility(View.GONE);
            ll1.setVisibility(View.VISIBLE);

        }
    }


    @Override
    public void fail(String s) {

    }
}
