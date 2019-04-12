package com.hcj.baseapplication.fragment;

import com.gyf.barlibrary.ImmersionBar;
import com.hcj.baseapplication.R;
import com.hcj.baseapplication.base.BaseFragment;

/**
 * @author geyifeng
 * @date 2017/5/12
 */
public class ServiceOneFragment extends BaseFragment {

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_one_service;
    }

    @Override
    public void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this)
                .navigationBarColor(R.color.btn13)
                .keyboardEnable(false)
                .init();
    }

    @Override
    protected boolean hasBindEventBus() {
        return false;
    }
}
