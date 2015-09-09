package cn.haoyunbang.common.edittext;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import cn.haoyunbang.common.R;


/**
 * Created by haoyunbang002 on 15/6/24.
 */
public class EditTextLayout extends LinearLayout {

    private Context context;
    private View view;
    private EditText input_edit;
    private ImageView right_image;
    private String edit_hint = "";
    private Drawable background;
    private RelativeLayout father_layout;
    private int color;
    private float textSize;
    private Drawable rightImage;

    /**
     * 控制点击右侧图片是否清楚Edit内容
     */
    public boolean isClearEdit = true;

    /**
     * 控制右侧图片是否根据内容显隐
     */
    public boolean isFollowTextVisable = true;

    public EditTextLayout(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public EditTextLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.EditTextHint);
        edit_hint = array.getString(R.styleable.EditTextHint_edit_hint);
        color = array.getInt(R.styleable.EditTextHint_edit_textColor, -1);
        textSize = array.getDimension(R.styleable.EditTextHint_edit_textSize, -1);
        background = array.getDrawable(R.styleable.EditTextHint_edit_background);
        rightImage = array.getDrawable(R.styleable.EditTextHint_edit_rightImage);
        array.recycle();
        init();
    }

    private void init() {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.edit_text_layout, null);
        input_edit = (EditText) view.findViewById(R.id.input_edit);
        right_image = (ImageView) view.findViewById(R.id.right_image);
        father_layout = (RelativeLayout) view.findViewById(R.id.father_layout);

        input_edit.setHint(edit_hint);
        input_edit.setTextColor(color);
        input_edit.setTextSize(textSize);
        father_layout.setBackgroundDrawable(background);
        right_image.setBackgroundDrawable(rightImage);
        input_edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!isFollowTextVisable)
                    return;

                if (s.length() > 0) {
                    right_image.setVisibility(View.VISIBLE);
                } else {
                    right_image.setVisibility(View.GONE);
                }
            }
        });

        right_image.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                if (rightImgOnclickLis != null)
                    rightImgOnclickLis.rightImgOnclickLis();

                if (isClearEdit)
                    input_edit.setText("");

            }
        });

        addView(view);
    }

    /**
     * 设置文本显示为密码
     */
    public void setPassWord(){
        input_edit.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
    }

    /**
     * 设置文本输入数字
     */
    public void setNumber(){
        input_edit.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_CLASS_PHONE);
    }

    /**
     * 右侧图片
     * @param bitmap
     */
    public void setRightImage(Bitmap bitmap) {

        right_image.setImageBitmap(bitmap);

    }
    /**
     * 右侧图片
     * 默认是否显示
     * @param bitmap
     * @param isVisibility
     */
    public void setRightImage(Bitmap bitmap,boolean isVisibility) {

        right_image.setImageBitmap(bitmap);

        if(isVisibility)
            right_image.setVisibility(VISIBLE);

    }

    /**
     * 获取EditText内的文本
     * @return
     */
    public String getText() {
        return input_edit.getText().toString();
    }

    /**
     * 设置EditText内的文本
     * @return
     */
    public void setText(String content) {
        input_edit.setText(content);
    }

    /**
     * 获取EditText
     * @return
     */
    public EditText getEditText() {
        return input_edit;
    }


    public void setRightImgOnclickLis(RightImgOnclickLis rightImgOnclickLis) {

        this.rightImgOnclickLis = rightImgOnclickLis;

    }

    /**
     * 右侧图片点击回调
     * @return
     */
    RightImgOnclickLis rightImgOnclickLis;

    public interface RightImgOnclickLis {

        void rightImgOnclickLis();

    }

}