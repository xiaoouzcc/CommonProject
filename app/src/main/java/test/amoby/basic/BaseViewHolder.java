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
public class BaseViewHolder extends RecyclerView.ViewHolder{

    private SparseArray<View> mViews = new SparseArray<>();
    private View mView;
    public BaseViewHolder(View itemView) {
        super(itemView);
        this.mView = itemView;
    }

    public <T extends View> T obtainView(int resId) {
        View v = mViews.get(resId);
        if (null == v) {
            v = mView.findViewById(resId);
            mViews.put(resId, v);
        }
        return (T) v;
    }

}

