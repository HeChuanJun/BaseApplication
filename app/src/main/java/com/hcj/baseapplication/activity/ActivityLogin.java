package com.hcj.baseapplication.activity;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;

import com.hcj.baseapplication.R;
import com.hcj.baseapplication.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityLogin extends BaseActivity {
    @BindView(R.id.viewPage)
    ViewPager viewPage;
    @BindView(R.id.navigation)
    BottomNavigationView navigation;
    @BindView(R.id.container)
    ConstraintLayout container;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected void initView() {
        super.initView();

    }

    @Override
    protected boolean hasBindEventBus() {
        return false;
    }
}
