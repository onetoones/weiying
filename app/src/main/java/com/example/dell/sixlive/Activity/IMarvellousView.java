package com.example.dell.sixlive.Activity;

import com.example.dell.sixlive.Bean.ChannelBean;
import com.example.dell.sixlive.View.BaseIView;

public interface IMarvellousView extends BaseIView {
    void getMarvellous(ChannelBean bean);
    void fail(String s);
}
