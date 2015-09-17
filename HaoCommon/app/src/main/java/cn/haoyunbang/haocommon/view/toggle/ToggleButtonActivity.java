package cn.haoyunbang.haocommon.view.toggle;

import android.os.Bundle;
import android.view.View;

import cn.haoyunbang.common.eventbus.HaoEvent;
import cn.haoyunbang.common.ui.BaseActivity;
import cn.haoyunbang.common.ui.BaseSwipeBackActivity;
import cn.haoyunbang.common.ui.base.BaseAppCompatActivity;
import cn.haoyunbang.haocommon.R;

/**
 * Created by fangxiao on 15/9/8.
 */
public class ToggleButtonActivity extends BaseSwipeBackActivity {

    @Override
    protected boolean isApplyKitKatTranslucency() {
        return true;
    }

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.togglebtn_layout;
    }

    @Override
    protected void onEventComming(HaoEvent haoEvent) {

    }

    @Override
    protected View getLoadingTargetView() {
        return null;
    }

    @Override
    protected void initViewsAndEvents() {

    }

    @Override
    protected boolean isBindEventBusHere() {
        return false;
    }

    @Override
    protected boolean toggleOverridePendingTransition() {
        return true;
    }

    @Override
    protected TransitionMode getOverridePendingTransitionMode() {
        return TransitionMode.RIGHT;
    }

    @Override
    protected boolean isApplyStatusBarTranslucency() {
        return true;
    }

    /**
     * 使用方法描述
     * 详细配置可看layout
     */
    private void use() {

//        ToggleButton toggleBtn = null;
//
//        //切换开关
//        toggleBtn.toggle();
//        //切换无动画
//        toggleBtn.toggle(false);
//        //开关切换事件
//        toggleBtn.setOnToggleChanged(new ToggleButton.OnToggleChanged() {
//            @Override
//            public void onToggle(boolean on) {
//            }
//        });
//
//        toggleBtn.setToggleOn();
//        toggleBtn.setToggleOff();
//        //无动画切换
//        toggleBtn.setToggleOn(false);
//        toggleBtn.setToggleOff(false);
//
//        //禁用动画
//        toggleBtn.setAnimate(false);

    }


}
