package com.hcj.baseapplication.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.gyf.barlibrary.ImmersionBar;
import com.hcj.baseapplication.R;
import com.hcj.baseapplication.utils.AppManager;

import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

/**
 * @author geyifeng
 * @date 2017/5/8
 */
public class BackActivity extends SwipeBackActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_back);
        ImmersionBar.with(this)
                .titleBar(R.id.toolbar)
                .navigationBarColor(R.color.colorPrimary)
                .init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        AppManager.getAppManager().addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy();
        AppManager.getAppManager().addActivity(this);
    }
}
