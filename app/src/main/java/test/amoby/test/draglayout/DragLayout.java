package test.amoby.test.draglayout;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import test.amoby.com.testproject.R;

/**
 * Created by 左成城 on 2016/5/6.
 */
public class DragLayout extends ViewGroup {
    //定义控件状态
    private enum MenuState {
        CLOSE, OPEN, SLIDING
    }

    private Context mContext;
    //左边拉出的默认宽度
    private final int DEFAULT_LEFT_WIDTH = 300;

    //自定义的宽度，不设置就默认宽度
    private int menu_width = DEFAULT_LEFT_WIDTH;

    private View menuView;
    private View contentView;

    private float mLastTouchX = -1;

    private float mLastTouchY = -1;

    private int mActionPoint;

    private boolean isDragging = false;

    private MenuState mMenuState = MenuState.CLOSE;
    //平移的宽度
    private float mOffsetPixels = 0;

    public View getMenuView() {
        return menuView;
    }

    public void setMenuView(View menuView) {
        this.menuView = menuView;
        removeView(menuView);
        addView(menuView);
    }

    public View getContentView() {
        return contentView;
    }

    public void setContentView(View contentView) {
        this.contentView = contentView;
        removeView(contentView);
        addView(contentView);
    }

    public int getMenu_width() {
        return menu_width;
    }

    public void setMenu_width(int menu_width) {
        this.menu_width = menu_width;
    }

    public DragLayout(Context context) {
        super(context);
        this.mContext = context;
    }

    public DragLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
    }

    public DragLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
    }

    //
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        Log.e("onLayout", "onLayout");
        int width = r - l;
        int height = b - t;
        //菜单布局加入viewGroup
        menuView.layout(-menu_width, 0, 0, height);
        //内容布局加入viewGroup
        contentView.layout(0, 0, width, height);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int childCount = getChildCount();
        //设置大小
        if (childCount < 2) {
            throw new IllegalStateException("dragLayout xml must have two layout!");
        } else {
            for (int i = 0; i < childCount; i++) {
                if (i == 0) {
                    measureChild(menuView, widthMeasureSpec, heightMeasureSpec);

                } else {
                    measureChild(contentView, widthMeasureSpec, heightMeasureSpec);
                }
            }
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() < 2) {
            throw new IllegalStateException("dragLayout must have two layout!");
        } else {
            View menu = findViewById(R.id.dragMenu);
            if (menu != null) {
                setMenuView(menu);
            }

            View content = findViewById(R.id.dragContent);
            if (content != null) {
                setContentView(content);
            }
        }


    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        //滑动的时候，交给ontouch操作
        if (isDragging && action != MotionEvent.ACTION_DOWN) {

            return true;
        }
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                mLastTouchX = ev.getX();
                mLastTouchY = ev.getY();
                mActionPoint = ev.getPointerId(0);

                break;
            case MotionEvent.ACTION_MOVE:
                int point = ev.findPointerIndex(mActionPoint);
                float x = ev.getX(point);
                float y = ev.getY(point);
                float dx = x - mLastTouchX;
                float dy = y - mLastTouchY;

                //交给onTouchEvent
                if (Math.abs(dx) > 0 && Math.abs(dx) > Math.abs(dy)) {
                    isDragging = true;
                }else{
                    isDragging = false;
                }
                if (point == -1) {
                    mActionPoint = -1;
                }
                break;
            case MotionEvent.ACTION_UP:
                mActionPoint = -1;
                isDragging = false;
                break;
        }
        return isDragging;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        final int action = event.getAction() & MotionEvent.ACTION_MASK;

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                //按下点的坐标
                mLastTouchX = event.getX();
                mLastTouchY = event.getY();
                //存储按下的点
                //确保是第一个手指按下的位置
                mActionPoint = event.getPointerId(0);
                break;
            case MotionEvent.ACTION_MOVE:
                int moveIndex = event.findPointerIndex(mActionPoint);
                if (moveIndex == -1) {//下面的操作不需要执行了
                    mActionPoint = -1;
                    isDragging = false;
                    return false;
                }

                if (isDragging) {
                    float x = event.getX(moveIndex);
                    float y = event.getY(moveIndex);
                    float dx = x - mLastTouchX;
                    mLastTouchX = x;
                    mLastTouchY = y;
                    //计算平移量
                    float offsetPixels = dx + mOffsetPixels;
                    //大于0，避免左滑的时候内容界面滑出了屏幕
                    if (offsetPixels >= 0) {
                        if (offsetPixels <= menu_width) {
                            menuView.setTranslationX(offsetPixels);
                            contentView.setTranslationX(offsetPixels);
                            mOffsetPixels = offsetPixels;
                        } else {
                            menuView.setTranslationX(menu_width);
                            contentView.setTranslationX(menu_width);
                            mOffsetPixels = menu_width;
                        }
                    } else {
                        mOffsetPixels = 0;
                    }
                    if (mOffsetPixels == menu_width) {

                        mMenuState = MenuState.OPEN;

                    } else if (mOffsetPixels == 0) {

                        mMenuState = MenuState.CLOSE;

                    } else {

                        mMenuState = MenuState.SLIDING;
                    }
                    invalidate();
                }
                break;
            case MotionEvent.ACTION_UP:
                mActionPoint = -1;
                isDragging = false;
                //如果距离小于一半，则不改变状态
                if (Math.abs(mOffsetPixels) <= menu_width / 2) {
                    if (mOffsetPixels < 0) {//left
                        menuView.setTranslationX(menu_width);
                        contentView.setTranslationX(menu_width);
                        mOffsetPixels = menu_width;
                    } else {
                        menuView.setTranslationX(0);
                        contentView.setTranslationX(0);
                        mOffsetPixels = 0;
                    }

                } else {
                    if (mOffsetPixels < 0) {//left
                        menuView.setTranslationX(0);
                        contentView.setTranslationX(0);
                        mOffsetPixels = 0;
                    } else {
                        menuView.setTranslationX(menu_width);
                        contentView.setTranslationX(menu_width);
                        mOffsetPixels = menu_width;
                    }
                }
                break;

        }
        return true;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.e("onSizeChanged", "onSizeChanged" + menu_width);
        //不定义的话，就取默认高度
        //  menu_width = menuView.getMeasuredWidth();
    }
}
