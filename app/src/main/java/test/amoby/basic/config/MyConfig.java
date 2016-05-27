package test.amoby.basic.config;


import android.util.Log;

/**
 * Created by Administrator on 2015/10/23.
 */
public class MyConfig {

    public static String base_url = "";

    public static String RESPONSE_CACHE = "zcc";
    public static int RESPONSE_CACHE_SIZE = 10;
    public static int HTTP_CONNECT_TIMEOUT = 8000;
    public static int HTTP_READ_TIMEOUT = 8000;

    public static boolean DEBUG = true;
    /**
     * 设置应用日志打印输出等级 VERBOSE-2,DEBUG-3,INFO-4,WARN-5,ERROR-6,ASSERT-7
     */
    public static final int LEVEL = Log.VERBOSE;
    /**
     * 设置应用日志打印统一TAG
     */
    public static final String TAG = "AXT";


}
