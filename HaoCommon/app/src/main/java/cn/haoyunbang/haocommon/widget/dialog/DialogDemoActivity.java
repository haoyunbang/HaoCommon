package cn.haoyunbang.haocommon.widget.dialog;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;

import cn.haoyunbang.common.ui.BaseActivity;
import cn.haoyunbang.common.widget.anim.BounceEnter;
import cn.haoyunbang.common.widget.anim.FadeExit;
import cn.haoyunbang.common.widget.dialog.ActionSheetDialog;
import cn.haoyunbang.common.widget.dialog.MaterialDialog;
import cn.haoyunbang.common.widget.dialog.MaterialTipDialog;
import cn.haoyunbang.common.widget.dialog.NormalDialog;
import cn.haoyunbang.common.widget.dialog.NormalTipDialog;
import cn.haoyunbang.common.widget.dialog.callback.DialogItemClick;
import cn.haoyunbang.common.widget.dialog.callback.DialogOneBtnClick;
import cn.haoyunbang.common.widget.dialog.callback.DialogTwoBtnClick;
import cn.haoyunbang.common.widget.anim.BaseAnimatorSet;
import cn.haoyunbang.haocommon.R;
import cn.haoyunbang.haocommon.widget.dialog.util.HomeAdapter;
import cn.haoyunbang.haocommon.widget.dialog.util.T;
import cn.haoyunbang.haocommon.widget.dialog.util.ViewFindUtils;

/**
 * Created by fangxiao on 15/9/7.
 */
public class DialogDemoActivity extends Activity implements ExpandableListView.OnChildClickListener {
    private Context context = this;
    public static String[] groups = {"Default Inner Dialog", "Custom Dialog", "Default Inner Anim", "Custom Anim"};
    public static String[][] childs = {
            /**Default Inner Dialog*/
            {
                    "NormalDialog StyleOne", "NormalDialog StyleTwo", "NormalDialog Custom Attr",
                    "NormalTipDialog StyleOne", "NormalTipDialog StyleTwo",
                    "MaterialDialog", "MaterialDialog NoTitle", "MaterialTipDialog",
                    "ActionSheetDialog", "ActionSheetDialog NoTitle"
            },
            /**Custom Dialog*/
            {
                    "Custome Dialog extends BaseDialog", "Custome Dialog extends BottomBaseDialog", "Custome Dialog extends TopBaseDialog"
            },
            /**Default Inner Animation*/
            {
                    "Show Anim", "Dismiss Anim"
            },
            /**Custom Anim*/
            {
                    "Custom Anim like ios taobao"
            }
    };
    private BaseAnimatorSet bas_in;
    private BaseAnimatorSet bas_out;
    private ExpandableListView elv;


    public void setBasIn(BaseAnimatorSet bas_in) {
        this.bas_in = bas_in;
    }

    public void setBasOut(BaseAnimatorSet bas_out) {
        this.bas_out = bas_out;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.dialog_layout);

        bas_in = new BounceEnter();
        bas_out = new FadeExit();


        View decorView = getWindow().getDecorView();
        elv = ViewFindUtils.find(decorView, R.id.elv);
        HomeAdapter adapter = new HomeAdapter(context);
        elv.setAdapter(adapter);
        // extend all group
        for (int i = 0; i < groups.length; i++) {
            elv.expandGroup(i);
        }

        elv.setOnChildClickListener(this);
        elv.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return true;
            }
        });
    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        /**Default Inner Dialog*/
        if (groupPosition == 0) {
            if (childPosition == 0) {
                NormalDialogStyleOne();
            } else if (childPosition == 1) {
                NormalDialogStyleTwo();
            } else if (childPosition == 2) {
                NormalDialogCustomAttr();
            } else if (childPosition == 3) {
                NormalTipDialogStyleOne();
            } else if (childPosition == 4) {
                NormalTipDialogStyleTwo();
            } else if (childPosition == 5) {
                MaterialDialog();
            } else if (childPosition == 6) {
                MaterialDialogNoTitle();
            } else if (childPosition == 7) {
                MaterialTipDialog();
            } else if (childPosition == 8) {
                ActionSheetDialog();
            } else if (childPosition == 9) {
                ActionSheetDialogNoTitle();
            }
        }

        return false;
    }

    private void NormalDialogStyleOne() {
        final NormalDialog dialog = new NormalDialog(context);
        dialog.content("是否确定退出程序?")//
                .showAnim(bas_in)//
                .dismissAnim(bas_out)//
                .show();

        dialog.setOnBtnClick(new DialogTwoBtnClick() {
            @Override
            public void leftBtnClick() {
                T.showShort(context, "onBtnLeftClick");
                dialog.dismiss();
            }

            @Override
            public void rightBtnClick() {
                T.showShort(context, "onBtnRightClick");
                dialog.dismiss();
            }
        });

    }

    private void NormalDialogStyleTwo() {
        final NormalDialog dialog = new NormalDialog(context);
        dialog.content("为保证咖啡豆的新鲜度和咖啡的香味，并配以特有的传统烘焙和手工冲。")//
                .style(NormalDialog.STYLE_TWO)//
                .titleTextSize(23)//
                .showAnim(bas_in)//
                .dismissAnim(bas_out)//
                .show();

        dialog.setOnBtnClick(new DialogTwoBtnClick() {
            @Override
            public void leftBtnClick() {
                T.showShort(context, "onBtnLeftClick");
                dialog.dismiss();
            }

            @Override
            public void rightBtnClick() {
                T.showShort(context, "onBtnRightClick");
                dialog.dismiss();
            }
        });
    }

    private void NormalDialogCustomAttr() {
        final NormalDialog dialog = new NormalDialog(context);
        dialog.isTitleShow(false)//
                .bgColor(Color.parseColor("#383838"))//
                .cornerRadius(5)//
                .content("是否确定退出程序?")//
                .contentGravity(Gravity.CENTER)//
                .contentTextColor(Color.parseColor("#ffffff"))//
                .dividerColor(Color.parseColor("#222222"))//
                .btnTextSize(15.5f, 15.5f)//
                .btnTextColor(Color.parseColor("#ffffff"), Color.parseColor("#ffffff"))//
                .btnColorPress(Color.parseColor("#2B2B2B"))//
                .widthScale(0.85f)//
                .showAnim(bas_in)//
                .dismissAnim(bas_out)//
                .show();

        dialog.setOnBtnClick(new DialogTwoBtnClick() {
            @Override
            public void leftBtnClick() {
                T.showShort(context, "onBtnLeftClick");
                dialog.dismiss();
            }

            @Override
            public void rightBtnClick() {
                T.showShort(context, "onBtnRightClick");
                dialog.dismiss();
            }
        });
    }

    private void NormalTipDialogStyleOne() {
        final NormalTipDialog dialog = new NormalTipDialog(context);
        dialog.content("你今天的抢购名额已用完~")//
                .btnText("继续逛逛")//
                .showAnim(bas_in)//
                .dismissAnim(bas_out)//
                .show();

        dialog.setOnBtnClickL(new DialogOneBtnClick() {
            @Override
            public void onBtnClick() {
                dialog.dismiss();
            }
        });
    }

    private void NormalTipDialogStyleTwo() {
        final NormalTipDialog dialog = new NormalTipDialog(context);
        dialog.content("你今天的抢购名额已用完~")//
                .style(NormalTipDialog.STYLE_TWO)//
                .btnText("继续逛逛")//
                .showAnim(bas_in)//
                .dismissAnim(bas_out)//
                .show();

        dialog.setOnBtnClickL(new DialogOneBtnClick() {
            @Override
            public void onBtnClick() {
                dialog.dismiss();
            }
        });

    }

    private void MaterialDialog() {
        final MaterialDialog dialog = new MaterialDialog(context);
        dialog.content(
                "嗨！这是一个 MaterialDialog. 它非常方便使用，你只需将它实例化，这个美观的对话框便会自动地显示出来。"
                        + "它简洁小巧，完全遵照 Google 2014 年发布的 Material Design 风格，希望你能喜欢它！^ ^")//
                .btnText("取消", "确定")//
                .showAnim(bas_in)//
                .dismissAnim(bas_out)//
                .show();

        dialog.setOnBtnClick(new DialogTwoBtnClick() {
            @Override
            public void leftBtnClick() {
                T.showShort(context, "onBtnLeftClick");
                dialog.dismiss();
            }

            @Override
            public void rightBtnClick() {
                T.showShort(context, "onBtnRightClick");
                dialog.dismiss();
            }
        });
    }


    private void MaterialDialogNoTitle() {
        final MaterialDialog dialog = new MaterialDialog(context);
        dialog.isTitleShow(false)//
                .content("为保证咖啡豆的新鲜度和咖啡的香味，并配以特有的传统烘焙和手工冲。")//
                .btnText("确定", "取消")//
                .showAnim(bas_in)//
                .dismissAnim(bas_out)//
                .show();

        dialog.setOnBtnClick(new DialogTwoBtnClick() {
            @Override
            public void leftBtnClick() {
                T.showShort(context, "onBtnLeftClick");
                dialog.dismiss();
            }

            @Override
            public void rightBtnClick() {
                T.showShort(context, "onBtnRightClick");
                dialog.dismiss();
            }
        });
    }

    private void MaterialTipDialog() {
        final MaterialTipDialog dialog = new MaterialTipDialog(context);
        dialog//
                // .isTitleShow(false)//
                .content("为保证咖啡豆的新鲜度和咖啡的香味，并配以特有的传统烘焙和手工冲。")//
                .btnText("确定")//
                .showAnim(bas_in)//
                .dismissAnim(bas_out)//
                .show();


        dialog.setOnBtnClickL(new DialogOneBtnClick() {
            @Override
            public void onBtnClick() {
                dialog.dismiss();
            }
        });

    }

    private void ActionSheetDialog() {
        final String[] stringItems = {"接收消息并提醒", "接收消息但不提醒", "收进群助手且不提醒", "屏蔽群消息"};
        final ActionSheetDialog dialog = new ActionSheetDialog(context, stringItems, null);
        dialog.title("选择群消息提醒方式\r\n(该群在电脑的设置:接收消息并提醒)")//
                .titleTextSize_SP(14.5f)//
                .show();
        dialog.setOnOperItemClickL(new DialogItemClick() {
            @Override
            public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {
                T.showShort(context, stringItems[position]);
                dialog.dismiss();
            }
        });
    }

    private void ActionSheetDialogNoTitle() {
        final String[] stringItems = {"版本更新", "帮助与反馈", "退出QQ"};
        final ActionSheetDialog dialog = new ActionSheetDialog(context, stringItems, elv);
        dialog.isTitleShow(false).show();


        dialog.setOnOperItemClickL(new DialogItemClick() {
            @Override
            public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {
                T.showShort(context, stringItems[position]);
                dialog.dismiss();
            }
        });
    }

    @Override
    public void onBackPressed() {
        final NormalDialog dialog = new NormalDialog(context);
        dialog.content("亲,真的要走吗?再看会儿吧~(●—●)")//
                .style(NormalDialog.STYLE_TWO)//
                .titleTextSize(23)//
                .btnText("继续逛逛", "残忍退出")//
                .btnTextColor(Color.parseColor("#383838"), Color.parseColor("#D4D4D4"))//
                .btnTextSize(16f, 16f)//
                .showAnim(bas_in)//
                .dismissAnim(bas_out)//
                .show();


        dialog.setOnBtnClick(new DialogTwoBtnClick() {
            @Override
            public void leftBtnClick() {
                dialog.dismiss();
            }

            @Override
            public void rightBtnClick() {
                dialog.superDismiss();
                finish();
            }
        });
    }
}