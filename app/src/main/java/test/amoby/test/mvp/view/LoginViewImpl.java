package test.amoby.test.mvp.view;

import test.amoby.basic.mvp.MvpView;

/**
 * @author 左成城
 * @desc
 * @date 2016/5/25 20:20
 */
public interface LoginViewImpl extends MvpView {

    void loginSuccess(String message);
    void loginFail(String message);
}

