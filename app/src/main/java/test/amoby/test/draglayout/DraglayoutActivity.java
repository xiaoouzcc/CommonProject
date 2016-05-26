package test.amoby.test.draglayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import test.amoby.com.testproject.R;

public class DraglayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draglayout);
        TextView txtMenu = (TextView) findViewById(R.id.dragMenu);
        TextView txtContent = (TextView) findViewById(R.id.dragContent);
        txtMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "menu", Toast.LENGTH_SHORT).show();
            }
        });
        txtContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "content", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
