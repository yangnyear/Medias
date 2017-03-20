package com.swpuiot.medias.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewGroup;
import android.widget.Scroller;

/**
 * Created by 羊荣毅_L on 2017/3/20.
 */
public class HorizontalScrollViewEX extends ViewGroup {
    private int mChildrenSize;
    private int mChildrenWiden;
    private int mChildendex;

    //分别记录上次滑动的坐标
    private int mLastX = 0;
    private int mLastY = 0;

    //分别记录上次滑动的坐标(OnInterceptTouchEvent)
    private int mLastXIntercept = 0;
    private int mLastYIntercept = 0;

    private Scroller mScanner;
    private VelocityTracker mVelocityTracker;

    public HorizontalScrollViewEX(Context context) {
        super(context);
        init();
    }

    public HorizontalScrollViewEX(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HorizontalScrollViewEX(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        if (mScanner == null) {
            mScanner = new Scroller(getContext());
            mVelocityTracker = VelocityTracker.obtain();
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean intercepted = false;
        int X = (int) ev.getX();
        int Y = (int) ev.getY();
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                intercepted = false;
                if (mScanner.isFinished()) {
                    mScanner.abortAnimation();
                    intercepted = true;
                }
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                int delteX = X - mLastXIntercept;
                int delteY = Y - mLastYIntercept;
                if (Math.abs(delteX) > Math.abs(delteY)) {
                    intercepted = true;
                } else {
                    intercepted = false;
                }
                break;
            }
            case MotionEvent.ACTION_UP: {
                intercepted = false;
                break;
            }
            default:
                break;
        }
        mLastX = X;
        mLastY = Y;
        mLastXIntercept = X;
        mLastYIntercept = Y;

        return intercepted;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mVelocityTracker.addMovement(event);
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                if (mScanner.isFinished()) {
                    mScanner.abortAnimation();
                }
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                int deltX = x - mLastX;
                int deltY = y - mLastY;
                scrollBy(-deltX, 0);
                break;
            }
            case MotionEvent.ACTION_UP: {
                int scrollX = getScrollX();
                mVelocityTracker.computeCurrentVelocity(1000);
                float xVeloCity = mVelocityTracker.getXVelocity();
                if (Math.abs(xVeloCity) >= 50) {
                    mChildendex = xVeloCity > 0 ? mChildendex - 1 : mChildendex + 1;
                } else {
                    mChildendex = (scrollX + mChildrenWiden / 2) / mChildrenWiden;
                }
                mChildendex = Math.max(0, Math.min(mChildendex, mChildrenSize - 1));
                int dX = mChildendex * mChildrenWiden - scrollX;
                smoothScrollBy(dX, 0);
                mVelocityTracker.clear();
                break;
            }
            default:
                break;
        }
        mLastX = x;
        mLastY = y;
        return true;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measureedWidth = 0;
        int measureedHeight = 0;
        final int childrenCount = getChildCount();
        measureChildren(widthMeasureSpec,heightMeasureSpec);
        
        int widthSpaceSize=MeasureSpec.getSize(widthMeasureSpec);
        // TODO: 2017/3/20  

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    private void smoothScrollBy(int dX, int dY) {
        mScanner.startScroll(getScrollX(), 0, dX, 0, 500);
        invalidate();
    }
}
