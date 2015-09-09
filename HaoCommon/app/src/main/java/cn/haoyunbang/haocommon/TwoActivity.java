package cn.haoyunbang.haocommon;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.haoyunbang.common.eventbus.HaoEvent;
import cn.haoyunbang.common.ui.BaseActivity;
import cn.haoyunbang.common.ui.base.BaseAppCompatActivity;
import cn.haoyunbang.common.util.BaseUtils;
import cn.haoyunbang.haocommon.bean.HomeBean;
import cn.haoyunbang.haocommon.feed.HomeFeed;

/**
 * Created by fangxiao on 15/9/9.
 */
public class TwoActivity extends BaseActivity {

    @Bind(R.id.listview)
    ListView listview;

    //上一个页面传来的名称
    private String preName = "";

    @Override
    protected boolean isApplyKitKatTranslucency() {
        return true;
    }

    @Override
    protected void getBundleExtras(Bundle extras) {

        preName = extras.getString(OneActivity.ONE_PACKAGENAME);

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

    List<HomeBean> homeBeans = new ArrayList<>();

    @Override
    protected void initViewsAndEvents() {

        strings = new ArrayList<>();

        BaseApplication application = (BaseApplication) getApplication();

        HomeFeed homeFeed = application.getHomeFeed();

        if (homeFeed != null && !TextUtils.isEmpty(preName)) {
            for (HomeBean homeBean : homeFeed.data) {
                if (preName.equals(homeBean.name)) {

                    if (!BaseUtils.isEmpty(homeBean.child)) {
                        homeBeans = homeBean.child;
                        for (HomeBean homeBean1 : homeBean.child) {
                            strings.add(homeBean1.name);
                        }
                        break;
                    }

                } else {
                    continue;
                }
            }
        }
        ;

        listview.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, strings));

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (homeBeans.size() > position) {

                    readyGo(homeBeans.get(position).clazz);

                }

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