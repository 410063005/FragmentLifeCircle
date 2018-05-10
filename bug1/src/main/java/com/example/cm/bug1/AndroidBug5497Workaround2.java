package com.example.cm.bug1;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.FrameLayout;

/**
 * Created by kingcmchen on 2018/5/9.
 */

public class AndroidBug5497Workaround2 {
    private static final String TAG = "AndroidBug5497Workaroun";

    public static void assistActivity(Activity activity, ChildIMEFragment.Callback runnable) {
        new AndroidBug5497Workaround2(activity, runnable);
    }
    private View mChildOfContent;
    private int usableHeightPrevious;
    private FrameLayout.LayoutParams frameLayoutParams;
    private int contentHeight;
    private   boolean isfirst = true;
    private   Activity activity;
    private  int statusBarHeight;
    private ChildIMEFragment.Callback callback;

    private AndroidBug5497Workaround2(Activity activity, ChildIMEFragment.Callback runnable) {
        callback = runnable;
        //获取状态栏的高度
        int resourceId = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        statusBarHeight = activity.getResources().getDimensionPixelSize(resourceId);
        // 获取导航栏的高度
        resourceId = activity.getResources().getIdentifier("navigation_bar_height", "dimen", "android");

        this.activity = activity;
        FrameLayout content = (FrameLayout)activity.findViewById(android.R.id.content);
        mChildOfContent = content.getChildAt(0);

        //界面出现变动都会调用这个监听事件
        mChildOfContent.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                if (isfirst) {
                    contentHeight = mChildOfContent.getHeight();//兼容华为等机型
                    isfirst = false;
                }
                possiblyResizeChildOfContent();
            }
        });

        frameLayoutParams = (FrameLayout.LayoutParams)
                mChildOfContent.getLayoutParams();

        activity.getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                if ((visibility & View.SYSTEM_UI_FLAG_HIDE_NAVIGATION) == 0) {
                    Log.d(TAG, "onSystemUiVisibilityChange() called with: visibility = [" + visibility + "] show");
                } else {
                    Log.d(TAG, "onSystemUiVisibilityChange() called with: visibility = [" + visibility + "] hide");
                }
            }
        });
    }

    //重新调整跟布局的高度
    private void possiblyResizeChildOfContent() {

        int usableHeightNow = computeUsableHeight();

        //当前可见高度和上一次可见高度不一致 布局变动
        if (usableHeightNow != usableHeightPrevious) {



            //int usableHeightSansKeyboard2 = mChildOfContent.getHeight();//兼容华为等机型
            int usableHeightSansKeyboard = getScreenHeight();// mChildOfContent.getRootView().getHeight();
            int heightDifference = usableHeightSansKeyboard - usableHeightNow;
            if (heightDifference > (usableHeightSansKeyboard / 4)) {
                // keyboard probably just became visible
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
                    //frameLayoutParams.height = usableHeightSansKeyboard - heightDifference;
                    // TODO: 2018/5/9
                    // frameLayoutParams.height = usableHeightSansKeyboard - heightDifference + statusBarHeight;
                    // if (callback != null) callback.run(usableHeightSansKeyboard - heightDifference + statusBarHeight);
                    if (callback != null) callback.run(heightDifference);
                } else {
                    // TODO: 2018/5/9
                    // frameLayoutParams.height = usableHeightSansKeyboard -heightDifference;
                    if (callback != null) callback.run(heightDifference);
                }
            } else {
                // TODO: 2018/5/9
                // frameLayoutParams.height = contentHeight;
                if (callback != null) callback.run(0);
            }

            mChildOfContent.requestLayout();
            usableHeightPrevious = usableHeightNow;
        }
    }
    /**     * 计算mChildOfContent可见高度     ** @return     */
    private int computeUsableHeight() {
        Rect r = new Rect();
//        mChildOfContent.getWindowVisibleDisplayFrame(r);
//        return (r.bottom - r.top);
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(r);
        int tmp = r.bottom;
        Log.d(TAG, "computeUsableHeight() called. tmp=" + tmp);
        return tmp;
    }

    private int getScreenHeight(){
        WindowManager manager = activity.getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        int tmp = outMetrics.heightPixels;
        // Log.d(TAG, "getScreenHeight() called. tmp=" + tmp);
        return tmp;
    }
}
