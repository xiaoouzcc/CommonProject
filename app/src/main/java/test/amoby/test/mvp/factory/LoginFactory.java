
package test.amoby.test.mvp.factory;

import test.amoby.basic.mvp.PresenterFactory;
import test.amoby.test.mvp.presenter.LoginPresenter;

/**
 * @author 左成城
 * @desc
 * @date 2016/5/25 20:31
 */
public class LoginFactory implements PresenterFactory<LoginPresenter>{

    @Override
    public LoginPresenter create() {
        return new LoginPresenter();
    }
}

