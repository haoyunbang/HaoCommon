package cn.haoyunbang.haocommon;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.orhanobut.logger.LogLevel;

import java.util.ArrayList;
import java.util.List;

import cn.haoyunbang.common.widget.imageload.ImagePipelineConfigFactory;
import cn.haoyunbang.common.widget.log.LogUtil;
import cn.haoyunbang.haocommon.bean.HomeBean;
import cn.haoyunbang.haocommon.feed.HomeFeed;
import cn.haoyunbang.haocommon.view.toggle.ToggleButtonActivity;
import cn.haoyunbang.haocommon.widget.dialog.DialogDemoActivity;
import cn.haoyunbang.haocommon.widget.imageload.FrescoDemoActivity;
import cn.haoyunbang.haocommon.widget.log.LogUtilDemoActivity;
import cn.haoyunbang.haocommon.widget.progress.CirProBarActivity;
import cn.haoyunbang.haocommon.widget.qrcode.CaptureActivity;
import cn.haoyunbang.haocommon.view.gif.GifDemoActivity;
/**
 * Created by fangxiao on 15/9/7.
 */
public class BaseApplication extends Application {

    // 定义是否是强制显示log的模式
    protected static final boolean LOG = false;

    private HomeFeed homeFeed;

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this, ImagePipelineConfigFactory.getImagePipelineConfig(this));
        LogUtil.init()               // default PRETTYLOGGER or use just init()
                //.setMethodCount(2);            // default 2
                //.hideThreadInfo()             // default shown
                .setMethodOffset(1);           // default 0
        // 在debug下，才显示log
        LogUtil.init().setLogLevel(BuildConfig.DEBUG ? LogLevel.FULL : LogLevel.NONE);
        // 如果是强制显示log，那么无论在什么模式下都显示log
        if (BaseApplication.LOG) {
            LogUtil.init().setLogLevel(LogLevel.FULL);
        }

        initData();

    }


    private void initData() {
        homeFeed = new HomeFeed();
        List<HomeBean> homeBeans = new ArrayList<>();
        List<HomeBean> childBeans = new ArrayList<>();

        HomeBean homeBean = new HomeBean();
        HomeBean childBean = new HomeBean();
        homeBean.name = "view";
        childBean.name = "toggle";
        childBean.className = "ToggleButtonActivity";
        childBean.clazz = ToggleButtonActivity.class;
        childBeans = new ArrayList<>();
        childBeans.add(childBean);

        childBean = new HomeBean();
        childBean.name = "gif";
        childBean.className = "GifDemoActivity";
        childBean.clazz = GifDemoActivity.class;
        childBeans.add(childBean);

        homeBean.child = childBeans;
        homeBeans.add(homeBean);

        homeBean = new HomeBean();
        childBean = new HomeBean();
        homeBean.name = "widget";
        childBean.name = "dialog";
        childBean.className = "DialogDemoActivity";
        childBean.clazz = DialogDemoActivity.class;
        childBeans = new ArrayList<>();
        childBeans.add(childBean);

        childBean = new HomeBean();
        childBean.name = "log";
        childBean.className = "LogUtilDemoActivity";
        childBean.clazz = LogUtilDemoActivity.class;
        childBeans.add(childBean);

        childBean = new HomeBean();
        childBean.name = "progress";
        childBean.className = "CirProBarActivity";
        childBean.clazz = CirProBarActivity.class;
        childBeans.add(childBean);

        childBean = new HomeBean();
        childBean.name = "二维码";
        childBean.className = "CaptureActivity";
        childBean.clazz = CaptureActivity.class;
        childBeans.add(childBean);

        childBean = new HomeBean();
        childBean.name = "fresco图片加载";
        childBean.className = "FrescoDemoActivity";
        childBean.clazz = FrescoDemoActivity.class;
        childBeans.add(childBean);

        homeBean.child = childBeans;
        homeBeans.add(homeBean);

        homeFeed.data = homeBeans;

    }

    public HomeFeed getHomeFeed() {
        return homeFeed;
    }

}