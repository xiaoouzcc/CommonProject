package test.amoby.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import test.amoby.com.testproject.R;
import test.amoby.utils.LogUtil;

public class MessageActivity extends AppCompatActivity {

    private Handler mHandler1;

    private Handler mHandler2;


    private MyHandler mMyHandler;

    private Handler mHandler3 = new Handler() {

        @Override
        public void handleMessage(Message msg) {

            switch (msg.what) {
                case 0x11:
                    LogUtil.e("---------main thread--!!!!--------");
                    break;
            }
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        new Thread(new MyThread1()).start();
        new Thread(new MyThread2()).start();
        Button btn = (Button) findViewById(R.id.btn_send);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Message msg1 = mHandler1.obtainMessage(0x11);
                msg1.arg1 = 1;
                msg1.sendToTarget();
            }
        });


    }


    public class MyThread1 implements Runnable {


        @Override
        public void run() {
            LogUtil.e("-!---");
            Looper.prepare();

            mHandler1 = new Handler(Looper.myLooper()) {
                @Override
                public void handleMessage(Message msg) {
                    switch (msg.what) {
                        case 0x11:
                            Message msg1 = mHandler2.obtainMessage(0x11);
                            msg1.arg1 = 1;
                            msg1.sendToTarget();
                            break;
                    }

                    super.handleMessage(msg);
                }
            };
            Looper.loop();

        }
    }

    public class MyThread2 implements Runnable {


        @Override
        public void run() {
            Looper.prepare();
            mHandler2 = new Handler(Looper.myLooper()) {
                @Override
                public void handleMessage(Message msg) {

                    switch (msg.what) {
                        case 0x11:
                            Message msg1 = mHandler3.obtainMessage(0x11);
                            msg1.arg1 = 1;
                            msg1.sendToTarget();

                            break;
                    }
                    super.handleMessage(msg);
                }
            };
            Looper.loop();

        }
    }

    private class MyHandler extends Handler{
        public MyHandler(Looper looper){
            super (looper);
        }
        @Override
        public void handleMessage(Message msg) { // 处理消息
            LogUtil.e("---"+msg.obj.toString());
        }
    }

    private class MyThread extends Thread{
        @Override
        public void run() {
            Looper.prepare();
            Looper curLooper = Looper.myLooper ();
            Looper mainLooper = Looper.getMainLooper ();
            String msg ;
            if (curLooper== null ){
                mMyHandler = new MyHandler(mainLooper);
                msg = "curLooper is null" ;
            } else {
                mMyHandler = new MyHandler(mainLooper);
                msg = "This is curLooper" ;
            }
            Looper.loop();
            mMyHandler .removeMessages(0);
            Message m = mMyHandler .obtainMessage(1, 1, 1, msg);
            mMyHandler .sendMessage(m);
        }
    }
}
