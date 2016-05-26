/**
 * @projectName TestProject
 * @version V1.0
 * @address http://www.yingmob.com/
 * @copyright 本内容仅限于重庆阿莫比科技有限公司内部使用，禁止转发.
 */
package test.amoby.test.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * @author 左成城
 * @desc
 * @date 2016/5/23 11:46
 */
public class MyTestView extends View {

    private Paint mPaintCircle;
    private Paint mPaintText;
    private Paint mPaintFill;

    private int mCirclrColor = 0xFFFFFFFF;
    private int mFillColor = 0xFF000000;
    private int mTextColor = 0xFF999999;

    private int mFillColorPressed = 0xFFFF0000;
    private int mTextColorPressed = 0xFF343322;

    private int Radius = 80;
    private int mStrokeWidth = 10;
    private int mStrokeWidthPress = 15;

    private float mDrawX = 0;
    private float mDrawY = 0;
    private RectF mRectF;
    private float mSweepAngle = 0;

    private int mCountNum = 0;
    private String mTextCount;

    private MyAnimation mAnimation;

    public void setText(String textCount) {
        mTextCount = textCount;
        startAnimation(mAnimation);
    }

    public MyTestView(Context context) {
        super(context);
        initPaint();
    }

    public MyTestView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public MyTestView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        mDrawX = getMeasuredWidth() / 2;
        mDrawY = getMeasuredHeight() / 2;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private void initPaint() {
        mPaintCircle = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintCircle.setStyle(Paint.Style.STROKE);
        mPaintCircle.setStrokeWidth(mStrokeWidth);
        mPaintCircle.setColor(mCirclrColor);

        mPaintFill = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintFill.setColor(mFillColor);
        mPaintFill.setStyle(Paint.Style.STROKE);
        mPaintFill.setStrokeWidth(mStrokeWidth);

        mPaintText = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintText.setTextSize(24);
        mPaintText.setColor(mTextColor);

        mAnimation = new MyAnimation();
        mAnimation.setDuration(2000);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        mRectF = new RectF(mDrawX - Radius, mDrawY - Radius, mDrawX + Radius, mDrawY + Radius);
        String textStr = mCountNum + "";
        Rect bounds = new Rect();
        mPaintText.getTextBounds(textStr, 0, textStr.length(), bounds);
        canvas.drawText(
                textStr,
                (mDrawX
                        - (mPaintText.measureText(textStr) / 2)),
                mDrawY + bounds.height() / 2,
                mPaintText);

        mSweepAngle = (int) mCountNum * 360 / 100;
        canvas.drawArc(mRectF, 0, 360, false, mPaintCircle);
        canvas.drawArc(mRectF, 270, mSweepAngle, false, mPaintFill);

        super.onDraw(canvas);
    }

    @Override
    public void setPressed(boolean pressed) {
        if (pressed) {
            mPaintCircle = new Paint(Paint.ANTI_ALIAS_FLAG);
            mPaintCircle.setStyle(Paint.Style.STROKE);
            mPaintCircle.setStrokeWidth(mStrokeWidthPress);
            mPaintCircle.setColor(mCirclrColor);

            mPaintFill = new Paint(Paint.ANTI_ALIAS_FLAG);
            mPaintFill.setColor(mFillColorPressed);
            mPaintFill.setStyle(Paint.Style.STROKE);
            mPaintFill.setStrokeWidth(mStrokeWidthPress);

            mPaintText = new Paint(Paint.ANTI_ALIAS_FLAG);
            mPaintText.setTextSize(28);
            mPaintText.setColor(mTextColorPressed);
        } else {
            mPaintCircle = new Paint(Paint.ANTI_ALIAS_FLAG);
            mPaintCircle.setStyle(Paint.Style.STROKE);
            mPaintCircle.setStrokeWidth(mStrokeWidth);
            mPaintCircle.setColor(mCirclrColor);

            mPaintFill = new Paint(Paint.ANTI_ALIAS_FLAG);
            mPaintFill.setColor(mFillColor);
            mPaintFill.setStyle(Paint.Style.STROKE);
            mPaintFill.setStrokeWidth(mStrokeWidth);

            mPaintText = new Paint(Paint.ANTI_ALIAS_FLAG);
            mPaintText.setTextSize(24);
            mPaintText.setColor(mTextColor);
        }
        invalidate();
        super.setPressed(pressed);
    }

    private class MyAnimation extends Animation {

        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            super.applyTransformation(interpolatedTime, t);
            //interpolatedTime  从0渐变到1，参数为1的时候代表动画结束
            Log.e("applyTransformation()",interpolatedTime+"---");
            if (interpolatedTime < 1.0f) {//动画未结束
                mCountNum = (int)(interpolatedTime *Float.parseFloat(mTextCount));
            }else{
                mCountNum = Integer.parseInt(mTextCount);
            }

            postInvalidate();
        }
    }
}

