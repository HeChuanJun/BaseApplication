package com.hcj.baseapplication.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.blankj.utilcode.util.ActivityUtils;
import com.hcj.baseapplication.activity.ActivityLogin;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by Administrator on 2017/11/30 0030.
 */

public class AppManager {
    private static Stack<Activity> activityStack;
    private static AppManager mInstance;

    private AppManager() {
    }

    public static AppManager getAppManager() {
        if (mInstance == null) {
            synchronized (AppManager.class) {
                if (mInstance == null) {
                    mInstance = new AppManager();
                }
            }
        }
        return mInstance;
    }

    /**
     * 添加Activity到堆栈
     */
    public void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<>();
        }
        activityStack.add(activity);
    }

    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    public Activity currentActivity() {
        Activity activity = null;
        if (activityStack != null && !activityStack.isEmpty()) {
            activity = activityStack.lastElement();

        }
        return activity;
    }

    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */

    public void finishActivity() {
        Activity activity = activityStack.lastElement();
        finishActivity(activity);
    }

    /**
     * 结束指定的Activity
     */
    public void finishActivity(Activity activity) {
        if (activity != null) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
        if (activityStack.contains(activity))
            activityStack.remove(activity);
    }

    /**
     * 结束指定类名的Activity
     */
    public void clearActivity(Class<?> cls) {
        Iterator<Activity> iter = activityStack.iterator();
        while (iter.hasNext()) {
            Activity activity = iter.next();
            if (activity != null && activity.getClass().equals(cls)) {
                iter.remove();
            }
        }
    }

    /**
     * 结束指定类名的Activity
     */
    public void finishActivity(Class<?> cls) {
        if (activityStack == null) return;
        for (Activity activity : activityStack) {
            if (activity.getClass().equals(cls)) {
                finishActivity(activity);
                break;
            }
        }
    }

    /**
     * 结束所有Activity
     */
    public void finishAllActivity() {
        Iterator<Activity> iter = activityStack.iterator();
        while (iter.hasNext()) {
            Activity activity = iter.next();
            if (activity != null && !activity.isFinishing()) {
                activity.finish();
                activity = null;
            }
            iter.remove();
        }
    }

    /**
     * 结束所有Activity
     */
    public void finishAllExclByActivity(String activityName) {
        Iterator<Activity> iter = activityStack.iterator();
        while (iter.hasNext()) {
            Activity activity = iter.next();
            if (!activity.getClass().getName().equals(activityName)) {
                if (activity != null && !activity.isFinishing()) {
                    activity.finish();
                    activity = null;
                }
                iter.remove();
            }
        }
    }

    public static Activity getActivity(Class<?> cls) {
        if (activityStack != null) {
            for (Activity activity : activityStack) {
                if (activity.getClass().equals(cls)) {
                    return activity;
                }
            }
        }
        return null;
    }

    /**
     * 退出应用程序
     */
    public void exit(Context context) {
        try {
            //CacheManage.getInstance().clear();
            finishAllActivity();
            Intent intent = new Intent();
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setClass(context, ActivityLogin.class);
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 退出应用程序
     */
    public void exits(Context context) {
        try {
            //CacheManage.getInstance().clear();
            AppManager.getAppManager().finishAllActivity();
            ActivityUtils.startActivity(ActivityLogin.class);

        } catch (Exception e) {
        }
    }
}
