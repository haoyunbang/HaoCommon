package cn.haoyunbang.common.ui.base;

import android.os.Bundle;
import android.view.View;

import cn.haoyunbang.common.widget.swipeback.SwipeBackActivityBase;
import cn.haoyunbang.common.widget.swipeback.SwipeBackActivityHelper;
import cn.haoyunbang.common.widget.swipeback.SwipeBackLayout;
import cn.haoyunbang.common.widget.swipeback.Utils;

/**
 * Author:  Tau.Chen
 * Created by fangxiao on 15/9/9.
 * 滑动返回页面
 */
public abstract class BaseSwipeBackCompatActivity extends BaseAppCompatActivity implements SwipeBackActivityBase {
    private SwipeBackActivityHelper mHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHelper = new SwipeBackActivityHelper(this);
        mHelper.onActivityCreate();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mHelper.onPostCreate();
    }

    @Override
    public View findViewById(int id) {
        View v = super.findViewById(id);
        if (v == null && mHelper != null)
            return mHelper.findViewById(id);
        return v;
    }

    @Override
    public SwipeBackLayout getSwipeBackLayout() {
        return mHelper.getSwipeBackLayout();
    }

    @Override
    public void setSwipeBackEnable(boolean enable) {
        getSwipeBackLayout().setEnableGesture(enable);
    }

    @Override
    public void scrollToFinishActivity() {
        Utils.convertActivityToTranslucent(this);
        getSwipeBackLayout().scrollToFinishActivity();
    }
}
