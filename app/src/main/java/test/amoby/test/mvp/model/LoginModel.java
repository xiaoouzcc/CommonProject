/**
 * @projectName TestProject
 * @version V1.0
 * @address http://www.yingmob.com/
 * @copyright 本内容仅限于重庆阿莫比科技有限公司内部使用，禁止转发.
 */
package test.amoby.test.mvp.model;

/**
 * @author 左成城
 * @desc
 * @date 2016/5/25 20:24
 */
public class LoginModel {

    private OnLoginListener mListener;

    public interface OnLoginListener {
        void loginSuccess(String message);

        void loginFail(String message);
    }

    public LoginModel(OnLoginListener listener) {
        this.mListener = listener;
    }

    public void login(String username, String password) {

        //这里连接网络请求
        if (username.equals("111111")) {
            mListener.loginSuccess("success");
        } else {
            mListener.loginFail("fail");
        }
    }
}

