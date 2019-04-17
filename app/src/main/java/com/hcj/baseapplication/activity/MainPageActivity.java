package com.hcj.baseapplication.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.gyf.barlibrary.ImmersionBar;
import com.hcj.baseapplication.R;
import com.hcj.baseapplication.adapter.HomeFragmentAdapter;
import com.hcj.baseapplication.base.BaseActivity;
import com.hcj.baseapplication.fragment.CategoryOneFragment;
import com.hcj.baseapplication.fragment.HomeOneFragment;
import com.hcj.baseapplication.fragment.MineOneFragment;
import com.hcj.baseapplication.fragment.ServiceOneFragment;
import com.hcj.baseapplication.widget.NoTouchViewPager;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.PageNavigationView;
import me.majiajie.pagerbottomtabstrip.item.BaseTabItem;
import me.majiajie.pagerbottomtabstrip.item.NormalItemView;

public class MainPageActivity extends BaseActivity {

    @BindView(R.id.viewPager)
    ViewPager viewPage;
    @BindView(R.id.tab)
    PageNavigationView pageBottomTabLayout;

    private NavigationController mNavigationController;
    private ArrayList<Fragment> mFragments;
    private HomeFragmentAdapter adapter;

    @Override
    protected boolean hasBindEventBus() {
        return false;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_horizontal;
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this).titleBar(R.id.toolbar).init();
    }

    @Override
    protected void initData() {
        super.initData();
        mFragments = new ArrayList<>();
        HomeOneFragment homeOneFragment = new HomeOneFragment();
        CategoryOneFragment categoryOneFragment = new CategoryOneFragment();
        ServiceOneFragment serviceOneFragment = new ServiceOneFragment();
        MineOneFragment mineOneFragment = new MineOneFragment();
        mFragments.add(categoryOneFragment);
        mFragments.add(homeOneFragment);
        mFragments.add(serviceOneFragment);
        mFragments.add(mineOneFragment);
    }

    @Override
    protected void initView() {
        super.initView();

        mNavigationController = pageBottomTabLayout.material()
                .addItem(R.drawable.ic_home_black_24dp, "Recents")
                .addItem(R.drawable.ic_dashboard_black_24dp, "Favorites")
                .addItem(R.drawable.ic_notifications_black_24dp, "Nearby")
                .addItem(R.drawable.ic_notifications_black_24dp, "Nearby")
                .build();

        adapter = new HomeFragmentAdapter(getSupportFragmentManager(), mFragments);
        viewPage.setAdapter(adapter);
        viewPage.setOffscreenPageLimit(3);
        mNavigationController.setupWithViewPager(viewPage);

        //设置消息数
        mNavigationController.setMessageNumber(1, 199);

        //设置显示小圆点
        mNavigationController.setHasMessage(0, true);
    }

    //创建一个Item
    private BaseTabItem newItem(int drawable, int checkedDrawable, String text) {
        NormalItemView normalItemView = new NormalItemView(this);
        normalItemView.initialize(drawable, checkedDrawable, text);
        normalItemView.setTextDefaultColor(Color.GRAY);
        normalItemView.setTextCheckedColor(0xFF009688);
        return normalItemView;
    }
}
