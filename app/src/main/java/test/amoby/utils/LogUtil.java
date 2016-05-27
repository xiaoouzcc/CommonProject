package test.amoby.utils;

import android.util.Log;

import test.amoby.basic.config.MyConfig;

public class LogUtil {
    public static void v(String tag, String msg) {
        if (MyConfig.DEBUG && MyConfig.LEVEL <= Log.VERBOSE) {
            Log.v(MyConfig.TAG, tag + "," + msg);
        }
    }
    public static void v(String msg) {
        if (MyConfig.DEBUG && MyConfig.LEVEL <= Log.VERBOSE) {
            Log.v(MyConfig.TAG, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (MyConfig.DEBUG && MyConfig.LEVEL <= Log.DEBUG) {
            Log.d(MyConfig.TAG, tag + "," + msg);
        }
    }

    public static void d(String msg) {
        if (MyConfig.DEBUG && MyConfig.LEVEL <= Log.DEBUG) {
            Log.d(MyConfig.TAG, msg);
        }
    }

    public static void i(String tag, String msg) {
        if (MyConfig.DEBUG && MyConfig.LEVEL <= Log.INFO) {
            Log.i(MyConfig.TAG, tag + "," + msg);
        }
    }

    public static void i(String msg) {
        if (MyConfig.DEBUG && MyConfig.LEVEL <= Log.INFO) {
            Log.i(MyConfig.TAG, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (MyConfig.DEBUG && MyConfig.LEVEL <= Log.WARN) {
            Log.w(MyConfig.TAG, tag + "," + msg);
        }
    }

    public static void w(String msg) {
        if (MyConfig.DEBUG && MyConfig.LEVEL <= Log.WARN) {
            Log.w(MyConfig.TAG, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (MyConfig.DEBUG && MyConfig.LEVEL <= Log.ERROR) {
            Log.e(MyConfig.TAG, tag + "," + msg);
        }
    }

    public static void e(String msg) {
        if (MyConfig.DEBUG && MyConfig.LEVEL <= Log.ERROR) {
            Log.e(MyConfig.TAG, msg);
        }
    }
}
