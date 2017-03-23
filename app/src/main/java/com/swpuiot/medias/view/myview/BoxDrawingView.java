package com.swpuiot.medias.view.myview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.swpuiot.medias.R;

/**
 * Created by 羊荣毅_L on 2017/3/15.
 * Z自定义的view
 */
public class BoxDrawingView extends RelativeLayout {
    private Button rightButton;
    private Button leftButton;
    private TextView titleTextView;

    private int leftTextColor;
    private Drawable leftBackground;
    private String leftText;

    private int rightTextColor;
    private Drawable rightBackground;
    private String rightText;

//    private float titleTextSize;
//    private int titleTextColor;
//    private String title;

    private LayoutParams leftParam, rightParam, titleParam;

    public BoxDrawingView(Context context) {
        super(context);
    }

    public BoxDrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TopBar);
        //初始化
        //获取左边button属性
        leftBackground = typedArray.getDrawable(R.styleable.TopBar_leftBackground);
        leftTextColor = typedArray.getColor(R.styleable.TopBar_leftTextColor, 0);
        leftText = typedArray.getString(R.styleable.TopBar_leftText);

        //获取右边button属性
        rightBackground = typedArray.getDrawable(R.styleable.TopBar_rightBackground);
        rightTextColor = typedArray.getColor(R.styleable.TopBar_rightTextColor, 0);
        rightText = typedArray.getString(R.styleable.TopBar_rightText);

        //获取title属性
//        titleTextSize = typedArray.getDimension(R.styleable.TopBar_titleTextSize,0);
//        titleTextColor = typedArray.getColor(R.styleable.TopBar_titleTextColor, 0);
//        title = typedArray.getString(R.styleable.TopBar_title);

        //释放资源,避免焕春带来的错误
        typedArray.recycle();
        setBackgroundColor(0xFFF59563);

        leftParam = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        leftParam.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);

        rightParam = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rightParam.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);

        titleParam = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        titleParam.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);

//        //实例化控件
        leftButton = new Button(context);
        rightButton = new Button(context);
        titleTextView = new TextView(context);

        leftButton.setTextColor(leftTextColor);
        leftButton.setText(leftText);
        leftButton.setBackground(leftBackground);

        rightButton.setTextColor(rightTextColor);
        rightButton.setText(rightText);
        rightButton.setBackground(rightBackground);

//        titleTextView.setTextSize(titleTextSize);
//        titleTextView.setText(title);
//        titleTextView.setTextColor(titleTextColor);
        titleTextView.setGravity(Gravity.CENTER);
        titleTextView.setText("组合式自定义View");

        addView(leftButton, leftParam);
        addView(titleTextView, titleParam);
        addView(rightButton, rightParam);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
