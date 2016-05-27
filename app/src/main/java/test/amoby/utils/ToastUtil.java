package test.amoby.utils;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

public class ToastUtil {
    /**
     * 显示提示
     *
     * @param context
     * @param msg
     * @author 左成城
     * @data 2015-6-3 上午10:41:15
     */
    public static void showToast(Context context, String msg) {
        if (context != null && !"".equals(msg)) {
            Toast toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }

    }

    /**
     * 显示提示
     *
     * @param context
     * @param msg
     * @author 左成城
     * @data 2015-6-3 上午10:41:15
     */
    public static void showToastBottom(Context context, String msg) {
        if (context != null) {
            Toast toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
            toast.show();
        }

    }
}
