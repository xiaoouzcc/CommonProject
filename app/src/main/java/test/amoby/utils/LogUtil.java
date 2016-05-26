/**
 * @projectName ${O2OService}
 * @version V1.0
 * @address http://www.yingmob.com/
 * @copyright 本内容仅限于淮安爱赢互通科技有限公司内部使用，禁止转发.
 */
package test.amoby.utils;

import android.util.Log;

import test.amoby.basic.config.MyConfig;


/**
 * 
 * @desc <p>
 * 日志打印输出工具类
 * </p>
 * @author shuwanli
 * @date 2015年10月26日下午5:19:48
 */
public class LogUtil {

    /**
     *
     * @param tag
     * Used to identify the source of a log message. It usually
     * identifies the class or activity where the log call occurs.
     * @param msg
     * The message you would like logged.
     */
    public static void v(String tag, String msg) {
        if (MyConfig.DEBUG && MyConfig.LEVEL <= Log.VERBOSE) {
            Log.v(MyConfig.TAG, tag + "," + msg);
        }
    }

    /**
     *
     * @param msg
     * The message you would like logged.
     */
    public static void v(String msg) {
        if (MyConfig.DEBUG && MyConfig.LEVEL <= Log.VERBOSE) {
            Log.v(MyConfig.TAG, msg);
        }
    }

    /**
     *
     * @param tag
     * Used to identify the source of a log message. It usually
     * identifies the class or activity where the log call occurs.
     * @param msg
     * The message you would like logged.
     */
    public static void d(String tag, String msg) {
        if (MyConfig.DEBUG && MyConfig.LEVEL <= Log.DEBUG) {
            Log.d(MyConfig.TAG, tag + "," + msg);
        }
    }

    /**
     *
     * @param msg
     * The message you would like logged.
     */
    public static void d(String msg) {
        if (MyConfig.DEBUG && MyConfig.LEVEL <= Log.DEBUG) {
            Log.d(MyConfig.TAG, msg);
        }
    }

    /**
     *
     * @param tag
     * Used to identify the source of a log message. It usually
     * identifies the class or activity where the log call occurs.
     * @param msg
     * The message you would like logged.
     */
    public static void i(String tag, String msg) {
        if (MyConfig.DEBUG && MyConfig.LEVEL <= Log.INFO) {
            Log.i(MyConfig.TAG, tag + "," + msg);
        }
    }

    /**
     *
     * @param msg
     * The message you would like logged.
     */
    public static void i(String msg) {
        if (MyConfig.DEBUG && MyConfig.LEVEL <= Log.INFO) {
            Log.i(MyConfig.TAG, msg);
        }
    }

    /**
     *
     * @param tag
     * Used to identify the source of a log message. It usually
     * identifies the class or activity where the log call occurs.
     * @param msg
     * The message you would like logged.
     */
    public static void w(String tag, String msg) {
        if (MyConfig.DEBUG && MyConfig.LEVEL <= Log.WARN) {
            Log.w(MyConfig.TAG, tag + "," + msg);
        }
    }

    /**
     *
     * @param msg
     * The message you would like logged.
     */
    public static void w(String msg) {
        if (MyConfig.DEBUG && MyConfig.LEVEL <= Log.WARN) {
            Log.w(MyConfig.TAG, msg);
        }
    }

    /**
     *
     * @param tag
     * Used to identify the source of a log message. It usually
     * identifies the class or activity where the log call occurs.
     * @param msg
     * The message you would like logged.
     */
    public static void e(String tag, String msg) {
        if (MyConfig.DEBUG && MyConfig.LEVEL <= Log.ERROR) {
            Log.e(MyConfig.TAG, tag + "," + msg);
        }
    }

    /**
     *
     * @param msg
     * The message you would like logged.
     */
    public static void e(String msg) {
        if (MyConfig.DEBUG && MyConfig.LEVEL <= Log.ERROR) {
            Log.e(MyConfig.TAG, msg);
        }
    }
}
