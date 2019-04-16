package com.hcj.baseapplication.fragment;

import android.widget.TextView;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.gyf.barlibrary.ImmersionBar;
import com.hcj.baseapplication.R;
import com.hcj.baseapplication.activity.MainPageActivity;
import com.hcj.baseapplication.base.BaseFragment;
import com.hcj.baseapplication.base.BaseLazyFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author geyifeng
 * @date 2017/5/12
 */
public class CategoryOneFragment extends BaseLazyFragment {

    @BindView(R.id.tv_pay)
    TextView tvPay;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_one_category;
    }

    @Override
    public void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this)
                .statusBarDarkFont(true, 0.2f)
                .statusBarColor(R.color.Green)
                .navigationBarColor(R.color.Green)
                .init();
    }

    @Override
    protected boolean hasBindEventBus() {
        return false;
    }

    @OnClick(R.id.tv_pay)
    public void onViewClicked() {
        ActivityUtils.startActivity(MainPageActivity.class);
        ToastUtils.showShort(" 支付宝支付");
    }
}
