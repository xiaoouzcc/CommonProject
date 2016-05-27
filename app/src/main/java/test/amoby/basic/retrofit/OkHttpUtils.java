package test.amoby.basic.retrofit;

import android.content.Context;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import test.amoby.basic.config.MyConfig;

/**
 * OkHttpClient自定义工具类
 */
public class OkHttpUtils {

    private static OkHttpClient singleton;

    public static OkHttpClient getInstance(Context context) {
        if (singleton == null) {
            synchronized (OkHttpUtils.class) {
                if (singleton == null) {

                    //添加log
                    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                    File httpCacheDirectory = new File(context.getCacheDir(), MyConfig.RESPONSE_CACHE);//设置缓存10M
                    Cache cache = new Cache(httpCacheDirectory, 10 * 1024 * 1024);
                    ///添加参数
                    Interceptor interceptorParam = new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request request = chain.request();
                            HttpUrl url = request.url().newBuilder().addQueryParameter(
                                    "token", "---").build();
                            request = request.newBuilder().url(url).build();
                            return chain.proceed(request);
                        }
                    };
                    singleton = new OkHttpClient.Builder()
                            .addInterceptor(interceptor)
                            //  .addInterceptor(interceptorParam)
                            .retryOnConnectionFailure(true)
                            .connectTimeout(MyConfig.HTTP_CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
                            .connectTimeout(60, TimeUnit.SECONDS)
                            .cookieJar(new CookiesManager(context))
                           // .cache(cache)
                            .build();


                }
            }
        }
        return singleton;
    }
}