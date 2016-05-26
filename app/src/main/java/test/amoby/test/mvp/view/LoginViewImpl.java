/**
 * @projectName TestProject
 * @version V1.0
 * @address http://www.yingmob.com/
 * @copyright 本内容仅限于重庆阿莫比科技有限公司内部使用，禁止转发.
 */
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

