/**
 * @projectName TestProject
 * @version V1.0
 * @address http://www.yingmob.com/
 * @copyright 本内容仅限于重庆阿莫比科技有限公司内部使用，禁止转发.
 */
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

