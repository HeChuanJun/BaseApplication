package com.hcj.baseapplication.fragment;

import com.gyf.barlibrary.ImmersionBar;
import com.hcj.baseapplication.R;
import com.hcj.baseapplication.base.BaseFragment;

/**
 * @author geyifeng
 * @date 2017/5/12
 */
public class MineOneFragment extends BaseFragment {

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_one_mine;
    }

    @Override
    public void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this)
                .statusBarDarkFont(true)
                .navigationBarColor(R.color.btn1)
                .navigationBarDarkIcon(true)
                .init();
    }

    @Override
    protected boolean hasBindEventBus() {
        return false;
    }
}
