package com.hcj.baseapplication.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;

import com.gyf.barlibrary.ImmersionBar;
import com.hcj.baseapplication.R;
import com.hcj.baseapplication.adapter.HomeFragmentAdapter;
import com.hcj.baseapplication.base.BaseActivity;
import com.hcj.baseapplication.fragment.CategoryOneFragment;
import com.hcj.baseapplication.fragment.HomeOneFragment;
import com.hcj.baseapplication.fragment.MineOneFragment;
import com.hcj.baseapplication.fragment.ServiceOneFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.viewPage)
    ViewPager viewPage;
    @BindView(R.id.navigation)
    BottomNavigationView navigation;

    private ArrayList<Fragment> mFragments;
    private HomeFragmentAdapter adapter;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    viewPage.setCurrentItem(0);
                    return true;
                case R.id.navigation_dashboard:
                    viewPage.setCurrentItem(1);
                    return true;
                case R.id.navigation_notifications:
                    viewPage.setCurrentItem(2);
                    return true;
                case R.id.navigation_my:
                    viewPage.setCurrentItem(3);
                    return true;
            }
            return false;
        }
    };

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
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        adapter = new HomeFragmentAdapter(getSupportFragmentManager(), mFragments);
        viewPage.setAdapter(adapter);
        viewPage.setOffscreenPageLimit(3);
        viewPage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        navigation.setSelectedItemId(R.id.navigation_home);
                        break;
                    case 1:
                        navigation.setSelectedItemId(R.id.navigation_dashboard);
                        break;
                    case 2:
                        navigation.setSelectedItemId(R.id.navigation_notifications);
                        break;
                    case 3:
                        navigation.setSelectedItemId(R.id.navigation_my);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    @Override
    protected boolean hasBindEventBus() {
        return false;
    }

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
}
