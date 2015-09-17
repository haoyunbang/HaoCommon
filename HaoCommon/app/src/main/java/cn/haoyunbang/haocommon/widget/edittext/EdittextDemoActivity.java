package cn.haoyunbang.haocommon.widget.edittext;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import cn.haoyunbang.common.widget.edittext.EditTextLayout;
import cn.haoyunbang.haocommon.R;

/**
 * Created by haoyunbang002 on 15/9/9.
 */
public class EdittextDemoActivity extends Activity implements EditTextLayout.RightImgOnclickLis {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.edit_demo);

        EditTextLayout my_edittext = (EditTextLayout) findViewById(R.id.my_edittext);
//        Bitmap drawable = BitmapFactory.decodeResource(getResources(), R.mipmap.ico_cha);
//        my_edittext.setRightImage(drawable);
        my_edittext.setNumber();
        my_edittext.setRightImgOnclickLis(this);

    }

    @Override
    public void rightImgOnclickLis() {
        Toast.makeText(this,"11111",Toast.LENGTH_SHORT).show();
    }
}
