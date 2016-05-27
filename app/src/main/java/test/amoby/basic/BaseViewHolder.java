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

