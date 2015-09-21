package cn.haoyunbang.haocommon.widget.keyboard;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.haoyunbang.common.eventbus.HaoEvent;
import cn.haoyunbang.common.ui.BaseSwipeBackActivity;
import cn.haoyunbang.common.widget.keyboard.KeyboardVisibilityEvent;
import cn.haoyunbang.common.widget.keyboard.KeyboardVisibilityEventListener;
import cn.haoyunbang.haocommon.R;

/**
 * Created by fangxiao on 15/9/21.
 */
public class KeyboardActivity extends BaseSwipeBackActivity {

    @Bind(R.id.keyboard_status)
    TextView keyboardStatus;
    @Bind(R.id.text_field)
    EditText textField;

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.keyboard_layout;
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

        KeyboardVisibilityEvent.setEventListener(this,
                new KeyboardVisibilityEventListener() {
                    @Override
                    public void onVisibilityChanged(boolean isOpen) {
                        updateKeyboardStatusText(isOpen);
                    }
                });

        updateKeyboardStatusText(KeyboardVisibilityEvent.isKeyboardVisible(this));


    }

    private void updateKeyboardStatusText(boolean isOpen) {
        keyboardStatus.setText(
                String.format("键盘 %s", (isOpen ? "显示" : "隐藏")));
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
        return TransitionMode.RIGHT_DEFAULT;
    }

    @Override
    protected boolean isApplyKitKatTranslucency() {
        return true;
    }

    @Override
    protected boolean isApplyStatusBarTranslucency() {
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
