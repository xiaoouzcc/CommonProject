/**
 * @projectName TestProject
 * @version V1.0
 * @address http://www.yingmob.com/
 * @copyright 本内容仅限于重庆阿莫比科技有限公司内部使用，禁止转发.
 */
package test.amoby.recycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import test.amoby.com.testproject.R;

/**
 * @author 左成城
 * @desc
 * @date 2016/5/18 15:17
 */
public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.MyViewHolder> {

    List<String> mListData;
    private Context mContext;

    MyRecycleViewAdapter(Context context,List<String> list) {
        this.mContext = context;
        this.mListData = list;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_recyclerview_list,null);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tv.setText(mListData.get(position));
    }

    @Override
    public int getItemCount() {
        return mListData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv;

        public MyViewHolder(View view) {
            super(view);
            tv = (TextView) view.findViewById(R.id.title);
        }
    }

    public void addData(int position) {
        mListData.add(position, "Insert One");
        notifyItemInserted(position);
    }

    public void removeData(int position) {
        mListData.remove(position);
        notifyItemRemoved(position);
    }
}

