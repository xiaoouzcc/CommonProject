/**
 * @projectName TestProject
 * @version V1.0
 * @address http://www.yingmob.com/
 * @copyright 本内容仅限于重庆阿莫比科技有限公司内部使用，禁止转发.
 */
package test.amoby.test.mvp.model;

import android.content.Context;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import test.amoby.bean.BaseBean;
import test.amoby.test.retrofit.api.LoginApi;

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

    public void login(Context context,String username, String password) {

       new LoginApi(context).loginIn(username,password)
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<BaseBean>() {
                    @Override
                    public void call(BaseBean nameBean) {
                        if (nameBean.getResult() == 1){
                            mListener.loginSuccess(nameBean.getMessage());
                        }else{
                            mListener.loginFail(nameBean.getMessage());
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mListener.loginFail("fail");
                    }
                });

    }
}

