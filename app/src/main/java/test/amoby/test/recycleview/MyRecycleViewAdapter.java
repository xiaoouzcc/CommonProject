/**
 * @projectName TestProject
 * @version V1.0
 * @address http://www.yingmob.com/
 * @copyright 本内容仅限于重庆阿莫比科技有限公司内部使用，禁止转发.
 */
package test.amoby.test.recycleview;

import android.content.Context;
import android.widget.TextView;

import java.util.List;

import test.amoby.basic.BasicAdapter;
import test.amoby.basic.BaseViewHolder;
import test.amoby.bean.NameBean;
import test.amoby.com.testproject.R;

/**
 * @author 左成城
 * @desc
 * @date 2016/5/18 15:17
 */
public class MyRecycleViewAdapter extends BasicAdapter<NameBean>{

    List<NameBean> mListData;
    private Context mContext;

    protected MyRecycleViewAdapter(Context context,List<NameBean> data) {
        super(context, data);
        this.mContext = context;
        this.mListData = data;
    }

    @Override
    public int setLayout() {
        return R.layout.item_recyclerview_list;
    }

    @Override
    public void getView(BaseViewHolder holder, int position) {
        TextView txt = holder.obtainView(R.id.title);
        txt.setText(mListData.get(position).getName());
    }
}

