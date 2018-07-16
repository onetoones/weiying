package com.example.dell.sixlive.View.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.dell.sixlive.Activity.ParticularsActivity;
import com.example.dell.sixlive.Adater.ChoicenessAdater;
import com.example.dell.sixlive.Bean.ChoicenessBean;
import com.example.dell.sixlive.Bean.LoadurlBean;
import com.example.dell.sixlive.Bean.WelfareBean;
import com.example.dell.sixlive.Persenter.ChoicenessPersenter;
import com.example.dell.sixlive.R;
import com.example.dell.sixlive.View.IView;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 2018/7/6.
 */

public class Choiceness extends  BaseHot<ChoicenessPersenter> implements IView, XBanner.XBannerAdapter {
    private XBanner banner;
    private List<String> list;
    private RecyclerView rec;
    private String a;
    private List<ChoicenessBean.RetBean.ListBean> data;
    private String loadURL1;
    @Override
    protected void initView(View inflate) {
        banner = inflate.findViewById(R.id.banner);
        rec = inflate.findViewById(R.id.choiceness_rec);
    }

    @Override
    protected int bindLayout() {
        return R.layout.choiceness;
    }

    @SuppressLint("NewApi")
    @Override
    protected void initData() {
        presenter.loadchoiceness();
    }

    @Override
    protected void bindEvent() {

    }

    @Override
    protected ChoicenessPersenter setPresenter() {
        return new ChoicenessPersenter();
    }

    @Override
    public void getPecial(ChoicenessBean bean) {

    }

    @Override
    public void fail(String s) {

    }

    @Override
    public void chenggong(ChoicenessBean bean) {
        data = bean.getRet().getList();

        list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            String icon = data.get(0).getChildList().get(i).getPic();

            if (icon == null) {
                list.remove(i);
            }
            this.list.add(icon);


        }
        banner.setData(list, null);
        banner.setPageTransformer(Transformer.Default);
        banner.setPageChangeDuration(2000);
        banner.setmAdapter(this);
        banner.setOnItemClickListener(new XBanner.OnItemClickListener() {
            @Override
            public void onItemClick(XBanner banner, int position) {
                loadURL1 = data.get(0).getChildList().get(position).getLoadURL();
                Intent intent = new Intent(getActivity(), ParticularsActivity.class);
                String[] split = loadURL1.split("=");
                a = split[1];
                intent.putExtra("loadURL", a);

                startActivity(intent);
            }
        });

        ChoicenessAdater choicenessAdater = new ChoicenessAdater(data, getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rec.setLayoutManager(linearLayoutManager);
        rec.setAdapter(choicenessAdater);
        choicenessAdater.setSetOnLisenner(new ChoicenessAdater.setOn() {
            @Override
            public void setOnitem(int i, View view, String loadURL) {
                Intent intent = new Intent(getActivity(), ParticularsActivity.class);
                String[] split = loadURL.split("=");
                a = split[1];
                intent.putExtra("loadURL", a);
                startActivity(intent);
            }
        });
    }

    @Override
    public void shibai(String msg) {

    }

    @Override
    public void chenggongurl(LoadurlBean bean) {

    }

    @Override
    public void shibaiurl(String msg) {

    }

    @Override
    public void chenggongwelf(WelfareBean bean) {

    }

    @Override
    public void shibaiwelf(String msg) {

    }
    @Override
    public void loadBanner(XBanner banner, View view, int position) {
        Glide.with(this).load(list.get(position)).into((ImageView) view);
    }
}
