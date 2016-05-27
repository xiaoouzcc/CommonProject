package test.amoby.basic.retrofit;

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import test.amoby.basic.config.MyConfig;

public class RetrofitUtils {
    private static Retrofit singleton;

    public static <T> T createApi(Class<T> clazz, Context context) {
        if (singleton == null) {
            synchronized (RetrofitUtils.class) {
                if (singleton == null) {
                    //配置
                    //   Context context = AppApplication.getInstance().getApplicationContext();
                    Retrofit.Builder builder = new Retrofit.Builder();
                    builder.baseUrl(MyConfig.base_url);//设置远程地址
                    builder.addConverterFactory(GsonConverterFactory.create());
                    //  builder.addCallAdapterFactory(new MyCallAdapterFactory());
                    builder.addCallAdapterFactory(RxJavaCallAdapterFactory.create());
                    builder.client(OkHttpUtils.getInstance(context));
                    singleton = builder.build();
                }
            }
        }
        return singleton.create(clazz);
    }
}
