package test.amoby.test.mvp.presenter;

import android.content.Context;

import test.amoby.basic.mvp.BasePresenter;
import test.amoby.test.mvp.model.LoginModel;
import test.amoby.test.mvp.view.LoginViewImpl;

/**
 * @author 左成城
 * @desc
 * @date 2016/5/25 20:23
 */
public class LoginPresenter extends BasePresenter<LoginViewImpl> implements LoginModel.OnLoginListener {

    private LoginModel mLoginModel;

    public LoginPresenter() {
        mLoginModel = new LoginModel(this);

    }

    @Override
    public void loginSuccess(String message) {
        LoginPresenter.this.getMvpView().loginSuccess(message);
    }

    @Override
    public void loginFail(String message) {
        LoginPresenter.this.getMvpView().loginFail(message);
    }

    public void login(Context context,String username, String password) {
        mLoginModel.login(context,username, password);
    }
}

