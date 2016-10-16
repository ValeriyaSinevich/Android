package com.example.valeriyasin.technotracksimple;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


public class SecondActivity extends AppCompatActivity {

    boolean launched = false;
    TextView tv;
    TextView st;
    int savedValue = 0;
    CountingRunner countingRunner;
    Button launchButton;
    Thread countingThread;
    Handler uiHandler;

    Handler.Callback hc = new Handler.Callback() {
        public boolean handleMessage(Message msg) {
            tv.setText(msg.obj.toString());
            st.setText(String.valueOf(msg.arg1));
            return true;
        }
    };

    public class CountingRunner extends Thread implements Runnable {

        @Override
        public void run() {
            int i = savedValue;
            Counter counter = new Counter();
            while (!this.isInterrupted()) {
//                System.out.println(this.isInterrupted());
                i++;
//            tv.post(new Runnable() {
//                @Override
//                public void run() {
//                    tv.setText(String.valueOf());
//                }
//            });
                Message msg = Message.obtain();
                msg.arg1 = i;
                msg.obj = counter.parse(i).trim();
                uiHandler.sendMessage(msg);
//            tv.setText(String.valueOf(i));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        launchButton = (Button) findViewById(R.id.Launch_button);
        tv = (TextView) findViewById(R.id.textView);
        st = (TextView) findViewById(R.id.stateText);
        uiHandler = new Handler(hc);

        launchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!launched) {
                    launchButton.setText("Stop");
//                    mHandler.post(countingThread);
//                    countingRunner = new CountingRunner(tv);
//                    countingThread = new Thread(countingRunner);
                    countingThread = new CountingRunner();
                    countingThread.start();
//                    tv.post(countingThread);
//                    mHandler.post(countingThread);
                    launched = !launched;
                } else {
                    countingThread.interrupt();
                    launchButton.setText("Launch");
                    tv.setText("");
                    st.setText(String.valueOf(0));
                    launched = !launched;
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String stateToSave = st.getText().toString();
        outState.putString("saved_state", stateToSave);
        outState.putString("saved_value", tv.getText().toString());
        outState.putBoolean("launched", launched);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onRestoreInstanceState(savedInstanceState);

        //To Retrieve data from "saved_state"
        launched = savedInstanceState.getBoolean("launched");
        if (launched) {
            launchButton.setText("stop");
            st.setText(savedInstanceState.getString("saved_state"));
            tv.setText(savedInstanceState.getString("saved_value"));
            savedValue = Integer.parseInt(savedInstanceState.getString("saved_state"));
            countingThread = new CountingRunner();
            countingThread.start();
        }
        else {
            launchButton.setText("launch");
            tv.setText("");
        }
    }

}

