package com.example.dell.sixlive.Adater;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dell.sixlive.Activity.MarvellousActivity;
import com.example.dell.sixlive.Bean.ChoicenessBean;
import com.example.dell.sixlive.R;

import java.util.List;


public class SpecialAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<ChoicenessBean.RetBean.ListBean> list;
    private Context context;

    public SpecialAdapter(List<ChoicenessBean.RetBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.special_layout, null);

        return new MyView(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyView view = (MyView) holder;
      view.tv.setText(list.get(position).getTitle());
        String pic = list.get(position).getChildList().get(0).getPic();
        Glide.with(context).load(pic).into(view.iv);
        view.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MarvellousActivity.class);
                intent.putExtra("url",list.get(position).getMoreURL());
                intent.putExtra("names",list.get(position).getTitle());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        //遍历集合，判断集合里的URL为空就删除掉
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMoreURL().equals("")) {
                list.remove(i);
            }
        }
        return list.size() == 0 ? null : list.size();
    }

    class MyView extends RecyclerView.ViewHolder {

        private final ImageView iv;
      private final TextView tv;
        private final RelativeLayout ll;

        public MyView(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.splay_im);
            tv = itemView.findViewById(R.id.splay_tv);
            ll = itemView.findViewById(R.id.splay_ll);
        }
    }

}
