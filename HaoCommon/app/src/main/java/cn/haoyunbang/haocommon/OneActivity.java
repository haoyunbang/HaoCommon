package cn.haoyunbang.haocommon;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.haoyunbang.common.eventbus.HaoEvent;
import cn.haoyunbang.common.ui.BaseActivity;
import cn.haoyunbang.haocommon.bean.HomeBean;
import cn.haoyunbang.haocommon.feed.HomeFeed;
import cn.haoyunbang.haocommon.view.ToggleButtonActivity;
import cn.haoyunbang.haocommon.widget.dialog.DialogDemoActivity;
import cn.haoyunbang.haocommon.widget.log.LogUtilDemoActivity;
import cn.haoyunbang.haocommon.widget.progress.CirProBarActivity;

/**
 * Created by fangxiao on 15/9/9.
 */
public class OneActivity extends BaseActivity {

    @Bind(R.id.listview)
    ListView listview;

    @Override
    protected boolean isApplyKitKatTranslucency() {
        return true;
    }

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.list_layout;
    }

    @Override
    protected void onEventComming(HaoEvent haoEvent) {

    }

    @Override
    protected View getLoadingTargetView() {
        return listview;
    }

    List<String> strings = new ArrayList<>();

    public static final String ONE_PACKAGENAME = "one_packeagename";

    @Override
    protected void initViewsAndEvents() {

        strings = new ArrayList<>();

        BaseApplication application = (BaseApplication) getApplication();

        HomeFeed homeFeed = application.getHomeFeed();

        if(homeFeed != null){
            for(HomeBean homeBean : homeFeed.data){
                strings.add(homeBean.name);
            }
        }

        listview.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, strings));
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putString(ONE_PACKAGENAME, strings.get(position));
                readyGo(TwoActivity.class, bundle);
            }
        });

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
        return null;
    }

    @Override
    protected boolean isApplyStatusBarTranslucency() {
        return true;
    }

}
