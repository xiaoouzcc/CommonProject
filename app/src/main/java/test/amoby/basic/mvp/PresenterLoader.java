package test.amoby.basic.mvp;

import android.content.Context;
import android.content.Loader;

/**
 * @author 左成城
 * @desc
 * @date 2016/3/21 11:02
 */
public class PresenterLoader<T extends Presenter> extends Loader<T> {

    private PresenterFactory<T> mFactory;

    private T mPresenter;

    public PresenterLoader(Context context, PresenterFactory factory) {
        super(context);
        this.mFactory = factory;
    }

    /**
     * 在调用forceLoad()方法后自动调用，我们在这个方法中创建Presenter并返回它。
     */
    @Override
    protected void onStartLoading() {
        // 如果已经有Presenter实例那就直接返回
        if (mPresenter == null) {
            forceLoad();
        } else {
            deliverResult(mPresenter);//会将Presenter传递给Activity/Fragment。
        }
    }

    @Override
    protected void onForceLoad() {
        if (mFactory != null) {
            // 通过工厂来实例化Presenter
            mPresenter = mFactory.create();
            // 返回Presenter
            deliverResult(mPresenter);
        }
    }

    /**
     * 会在Loader被销毁之前调用，我们可以在这里告知Presenter以终止某些操作或进行清理工作。
     */
    @Override
    protected void onReset() {
        if (mPresenter != null) {
            mPresenter.onDestroyed();
            mPresenter = null;
        }
    }
}


