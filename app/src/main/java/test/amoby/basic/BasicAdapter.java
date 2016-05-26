/**
 * @projectName TestProject
 * @version V1.0
 * @address http://www.yingmob.com/
 * @copyright 本内容仅限于重庆阿莫比科技有限公司内部使用，禁止转发.
 */
package test.amoby.basic;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * @author 左成城
 * @desc
 * @date 2016/5/19 14:17
 */
public abstract class BasicAdapter<Data> extends RecyclerView.Adapter<BaseViewHolder> {

    private Context mContext;
    private List<Data> mData;
    private OnItemClickListener mItemClickListener;
    private OnItemLongClickListener mItemLongClickListener;
    private View mRootView;

    public interface OnItemClickListener {

        void onClickListener();

    }

    public interface OnItemLongClickListener {

        void onLongClickListener();
    }

    public void setOnItemClick(OnItemClickListener listener) {

        this.mItemClickListener = listener;
    }

    protected BasicAdapter(Context context, List<Data> data) {

        this.mContext = context;
        this.mData = data;
    }


    public void insertData(int position) {
        this.notifyItemInserted(0);

    }

    public void deleteData(int position) {
        this.notifyItemRemoved(position);
    }


    public void changeData(int position) {
        this.notifyItemChanged(position);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(setLayout(), null);
        BaseViewHolder holder = new BaseViewHolder(view);
        mRootView = view;
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mItemClickListener.onClickListener();
            }
        });
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mItemLongClickListener.onLongClickListener();
                return false;
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        getView(holder, position);
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }


    public abstract int setLayout();

    public abstract void getView(BaseViewHolder holder, int position);
}

