package com.example.dell.sixlive.View;

import com.example.dell.sixlive.Bean.ChoicenessBean;
import com.example.dell.sixlive.Bean.LoadurlBean;
import com.example.dell.sixlive.Bean.WelfareBean;

/**
 * Created by DELL on 2018/5/28.
 */

public interface IView extends BaseIView {
//    void chenggong(BeijingListBean bean);
//    void shibai(String msg);
    void getPecial(ChoicenessBean bean);
    void fail(String s);

    void chenggong(ChoicenessBean bean);

    void shibai(String msg);

    void chenggongurl(LoadurlBean bean);

    void shibaiurl(String msg);

    void chenggongwelf(WelfareBean bean);

    void shibaiwelf(String msg);
}
