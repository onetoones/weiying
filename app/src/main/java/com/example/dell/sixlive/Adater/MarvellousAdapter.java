package com.example.dell.sixlive.Adater;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dell.sixlive.Activity.ParticularsActivity;
import com.example.dell.sixlive.Bean.ChannelBean;
import com.example.dell.sixlive.R;

import java.util.List;

public class MarvellousAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<ChannelBean.RetBean.ListBean> list;
    private String a;
    private String information;
    public MarvellousAdapter(Context context, List<ChannelBean.RetBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.maradapter_layout, null);

        return new MyView(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyView view = (MyView) holder;
        Glide.with(context).load(list.get(position).getPic()).into(view.iv);
        String title = list.get(position).getTitle();
        if (title.length() > 8) {
            String s = title.substring(0, 8) + "...";
            view.tv.setText(s);
        } else {
            view.tv.setText(title);
        }
      view.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ParticularsActivity.class);
                String loadURL = list.get(position).getLoadURL();
                String[] split = loadURL.split("=");
                a = split[1];
                intent.putExtra("loadURL",a);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size() == 0 ? null : list.size();
    }

    class MyView extends RecyclerView.ViewHolder {

        private final ImageView iv;
        private final TextView tv;
        private final LinearLayout ll;

        public MyView(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.mar_im);
            tv = itemView.findViewById(R.id.mar_tv);
            ll = itemView.findViewById(R.id.mar_ll);
        }
    }
}
