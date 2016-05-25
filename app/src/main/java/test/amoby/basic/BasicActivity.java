package test.amoby.basic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import test.amoby.com.testproject.DraglayoutActivity;
import test.amoby.com.testproject.R;
import test.amoby.recycleview.RecycleViewActivity;
import test.amoby.views.TestViewActivity;

public class BasicActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView mTxtRecycler;
    private TextView mTxtDraglayout;
    private TextView mTxtTestView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);
        mTxtDraglayout = (TextView) findViewById(R.id.txt_main_draglayout);
        mTxtRecycler = (TextView) findViewById(R.id.txt_main_recycleview);
        mTxtTestView = (TextView) findViewById(R.id.txt_main_mytextview);
        mTxtDraglayout.setOnClickListener(this);
        mTxtRecycler.setOnClickListener(this);
        mTxtTestView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()){
            case R.id.txt_main_draglayout :
                intent.setClass(getApplicationContext(), DraglayoutActivity.class);
                startActivity(intent);
            break;
            case R.id.txt_main_recycleview:
                intent.setClass(getApplicationContext(), RecycleViewActivity.class);
                startActivity(intent);
                break;
            case R.id.txt_main_mytextview :
                intent.setClass(getApplicationContext(), TestViewActivity.class);
                startActivity(intent);
                break;
        }
    }
}
