package cn.haoyunbang.haocommon.widget.log;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.haoyunbang.common.eventbus.HaoEvent;
import cn.haoyunbang.common.ui.BaseActivity;
import cn.haoyunbang.common.ui.BaseSwipeBackActivity;
import cn.haoyunbang.common.ui.base.BaseAppCompatActivity;
import cn.haoyunbang.common.widget.log.LogUtil;
import cn.haoyunbang.haocommon.R;

/**
 * Created by fangxiao on 15/9/7.
 */
public class LogUtilDemoActivity extends BaseSwipeBackActivity {
    @Override
    protected boolean isApplyKitKatTranslucency() {
        return true;
    }

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.logutil_layout;
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

        init();


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


    //    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.logutil_layout);
//        ButterKnife.bind(this);
//        init();
//    }
//
//
    private void init() {

        // string
        String str = "test log";
        LogUtil.d(str != null ? str : "hello world");

        // json
        LogUtil.json("[{\"CityId\":18,\"CityName\":\"西安\",\"ProvinceId\":27,\"CityOrder\":1},{\"CityId\":53,\"CityName\":\"广州\",\"ProvinceId\":27,\"CityOrder\":1}]'");

        // arrays
        double[][] doubles = {
                {1.2, 1.6, 1.7, 30, 33},
                {1.2, 1.6, 1.7, 30, 33},
                {1.2, 1.6, 1.7, 30, 33},
                {1.2, 1.6, 1.7, 30, 33}
        };
        LogUtil.Object(doubles);


        // object
        LogUtil.Object(new User("jack", "f"));


        // sub class
        new User("name", "sex").log();

    }


    private class User {

        private String name;

        private String sex;

        User(String name, String sex) {
            this.name = name;
            this.sex = sex;
        }

        public void log() {
            show();
        }

        private void show() {
            LogUtil.d("user");
        }
    }


}
