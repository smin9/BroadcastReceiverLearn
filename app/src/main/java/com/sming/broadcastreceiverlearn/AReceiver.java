package com.sming.broadcastreceiverlearn;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by sming on 2017/7/18.
 */

public class AReceiver extends BroadcastReceiver {
    private static final String TAG = "AReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = intent.getStringExtra("msg");
        Toast.makeText(context,msg,Toast.LENGTH_LONG).show();
    }
}
