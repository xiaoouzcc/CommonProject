package test.amoby.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import test.amoby.com.testproject.R;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        initToolbar(savedInstanceState);
        initViews(savedInstanceState);
        initData();
        initListeners();
    }

    @Override
    protected void onDestroy() {
        clearDestory();
        super.onDestroy();
    }

    protected abstract void initViews(Bundle savedInstanceState);
    protected abstract void initToolbar(Bundle savedInstanceState);
    protected abstract void initListeners();
    protected abstract void initData();
    protected abstract void clearDestory();
}
