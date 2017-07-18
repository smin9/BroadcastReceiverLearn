package com.sming.broadcastreceiverlearn;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    AReceiver aReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.start_btn);
        button.setOnClickListener(this);
        registerBroadcastReceiver();
    }

    private void registerBroadcastReceiver() {
        aReceiver = new AReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.AReceiver");
        registerReceiver(aReceiver,filter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.start_btn:
                /**
                 * 使用广播前需要先注册广播，
                 *
                 * 静态注册如下(在文件清单注册)常驻型
                 *<receiver android:name=".AReceiver">
                 *  <intent-filter>
                 *      <action android:name="android.intent.action.AReceiver"/>
                 *      <category android:name="android.intent.category.DEFAULT"/>
                 *  </intent-filter>
                 *</receiver>
                 *
                 *动态注册如下
                 * registerBroadcastReceiver(),使用静态注册的话，需要在Activity销毁前，注销广播
                 */


                /**
                 * 开启一个普通广播
                 */
//                Intent intent = new Intent(this,AReceiver.class);  //静态注册启动
                Intent intent = new Intent("android.intent.action.AReceiver"); //动态注册启动
                intent.putExtra("msg","广播数据");
                sendBroadcast(intent);
                break;
            case R.id.start_btn1:

                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(aReceiver);
    }
}
