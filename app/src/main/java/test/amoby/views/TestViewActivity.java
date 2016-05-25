package test.amoby.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class TestViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_test_view);
        MyTestView view = new MyTestView(this);
        setContentView(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        view.setText("60");
    }
}
