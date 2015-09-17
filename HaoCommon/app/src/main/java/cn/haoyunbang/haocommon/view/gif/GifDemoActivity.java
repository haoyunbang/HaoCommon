package cn.haoyunbang.haocommon.view.gif;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.haoyunbang.common.eventbus.HaoEvent;
import cn.haoyunbang.common.ui.BaseSwipeBackActivity;
import cn.haoyunbang.common.widget.imageload.utils.CustomProgressbarDrawable;
import cn.haoyunbang.common.widget.imageload.utils.ImageDownloadListener;
import cn.haoyunbang.haocommon.R;

/**
 * Created by fangxiao on 15/9/10.
 */
public class GifDemoActivity extends BaseSwipeBackActivity implements ImageDownloadListener {

    @Bind(R.id.gifview)
    SimpleDraweeView gifview;
    @Bind(R.id.progress_text)
    TextView progressText;
    private String url = "http://ww2.sinaimg.cn/large/dd412be4gw1esr6ijoebog208e0e1qv6.gif";


    @Override
    protected boolean isApplyKitKatTranslucency() {
        return true;
    }

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_gif;
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

        GenericDraweeHierarchyBuilder builder =
                new GenericDraweeHierarchyBuilder(getResources());
        GenericDraweeHierarchy hierarchy = builder
                .setFadeDuration(300)
                .setProgressBarImage(new CustomProgressbarDrawable(this))
                .build();
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(Uri.parse(url))
                .setAutoPlayAnimations(true)
                .build();
        gifview.setHierarchy(hierarchy);
        gifview.setController(controller);
    }

    @Override
    public void onUpdate(int progress) {
        progressText.setText(progress + "%");
        if (progress >= 100) {
            progressText.setVisibility(View.GONE);
        }
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
