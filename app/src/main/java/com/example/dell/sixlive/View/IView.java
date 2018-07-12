package com.example.dell.sixlive.View;

import com.example.dell.sixlive.Bean.ChoicenessBean;

/**
 * Created by DELL on 2018/5/28.
 */

public interface IView extends BaseIView {
//    void chenggong(BeijingListBean bean);
//    void shibai(String msg);
    void getPecial(ChoicenessBean bean);
    void fail(String s);

}
