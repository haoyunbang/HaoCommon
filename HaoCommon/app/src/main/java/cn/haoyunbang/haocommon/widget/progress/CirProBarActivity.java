package cn.haoyunbang.haocommon.widget.progress;

import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;
import cn.haoyunbang.common.eventbus.HaoEvent;
import cn.haoyunbang.common.ui.BaseActivity;
import cn.haoyunbang.common.ui.BaseSwipeBackActivity;
import cn.haoyunbang.common.ui.base.BaseAppCompatActivity;
import cn.haoyunbang.haocommon.R;

/**
 * Created by fangxiao on 15/9/9.
 */
public class CirProBarActivity extends BaseSwipeBackActivity {


    @Override
    protected boolean isApplyKitKatTranslucency() {
        return true;
    }

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.cirpro_layout;
    }

    @Override
    protected void onEventComming(HaoEvent haoEvent) {

    }

    @Override
    protected View getLoadingTargetView() {
        return ButterKnife.findById(this, R.id.cirpro_base_layout);
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
        return false;
    }

    @Override
    protected TransitionMode getOverridePendingTransitionMode() {
        return TransitionMode.RIGHT;
    }

    @Override
    protected boolean isApplyStatusBarTranslucency() {
        return true;
    }
}
