package test.amoby.recycleview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import test.amoby.com.testproject.R;

public class RecycleViewActivity extends AppCompatActivity {

    private List<NameBean> mListData = new ArrayList<NameBean>();
    private MyRecycleViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        initData();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.card_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new MyRecycleViewAdapter(getApplicationContext(), mListData);
        recyclerView.setAdapter(mAdapter);

    }

    private void initData() {

        for (int i = 0; i < 50; i++) {
            NameBean bean = new NameBean();
            bean.setName("第" + i + "行");
            mListData.add(bean);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.id_action_add:
                List<NameBean> listBean = new ArrayList<>();
                for (int i = 0; i < 50; i++) {
                    NameBean bean = new NameBean();
                    bean.setName("第" + i + "行");
                    listBean.add(bean);
                }

                mAdapter.insertData(listBean);
                break;
            case R.id.id_action_delete:
                mAdapter.deleteData(1);
                break;
        }
        return true;
    }
}
