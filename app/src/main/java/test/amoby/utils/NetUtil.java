/**
 * @projectName ${O2OService}
 * @version V1.0
 * @address http://www.yingmob.com/
 * @copyright 本内容仅限于淮安爱赢互通科技有限公司内部使用，禁止转发.
 */
package test.amoby.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;

public class NetUtil {
	public static final int NETWORN_NONE = 0;  //无网络
	public static final int NETWORN_WIFI = 1; //wifi
	public static final int NETWORN_MOBILE = 2;  //3G等
	/**
	 * 判断是否联网
	 * @author 左成城 
	 * @data 2015-6-1 下午2:42:57
	 * @param context
	 * @return
	 */
	public static int getNetworkState(Context context) {
		ConnectivityManager connManager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);

		// Wifi
		State state = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
				.getState();
		if (state == State.CONNECTED || state == State.CONNECTING) {
			return NETWORN_WIFI;
		}

		// 3G
		state = connManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
				.getState();
		if (state == State.CONNECTED || state == State.CONNECTING) {
			return NETWORN_MOBILE;
		}
		return NETWORN_NONE;
	}

	/**
	 * 是否联网
	 * @author 左成城 
	 * @data 2015-6-1 下午2:47:29
	 * @param context
	 * @return  true 联网 false 无网
	 */
	public static boolean isNetWork(Context context) {

		boolean status = false;

		ConnectivityManager connMgr = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
		if (networkInfo != null) {
			status = networkInfo.isConnected();
		}

		return status;
	}

}
