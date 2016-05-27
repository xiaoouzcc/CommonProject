package test.amoby.test.retrofit.api;

import android.content.Context;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;
import test.amoby.basic.retrofit.RetrofitUtils;
import test.amoby.bean.BaseBean;

/**
 * @author 左成城
 * @desc
 * @date 2016/5/27 17:33
 */
public class LoginApi {

    public interface LoginImpl {
        @FormUrlEncoded
        @POST("login")
        Observable<BaseBean> loginIn(@Field("phone") String phone, @Field("password") String password);
    }


    public final LoginImpl service;

    public LoginApi(Context context) {
        service = RetrofitUtils.createApi(LoginImpl.class, context);
    }

    public Observable<BaseBean> loginIn(String phone, String password) {
        return service.loginIn(phone, password);
    }
}

