/**
 * @projectName TestProject
 * @version V1.0
 * @address http://www.yingmob.com/
 * @copyright 本内容仅限于重庆阿莫比科技有限公司内部使用，禁止转发.
 */
package test.amoby.basic;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

/**
 * @author 左成城
 * @desc
 * @date 2016/5/19 11:54
 */
public class ViewHolder extends RecyclerView.ViewHolder{

    private SparseArray<View> mViews = new SparseArray<>();

    public ViewHolder(View itemView) {
        super(itemView);
    }

    public <T extends View> T obtainView(View convertView, int viewId) {
        View v = mViews.get(viewId);
        if (v != null && convertView != null) {

            v = convertView.findViewById(viewId);
            mViews.put(viewId, v);
        }
        return (T) v;
    }

}

