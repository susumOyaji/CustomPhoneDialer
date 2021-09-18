package jp.co.acesystems.callreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;


// * 着信イベントを受け取る
// * Created by uramotomasaki on 15/06/03.
// * Copyright (c) 2015 Storyboard All Right Reserved.
class IncomingCall extends BroadcastReceiver {
    @SuppressWarnings("unused")
    private final String TAG = getClass().getSimpleName();

    private Context ctx;
    public void onReceive(Context context, Intent intent) {
        ctx = context;
        try {
            //TelephonyManagerの生成
            TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            //リスナーの登録
            MyPhoneStateListener PhoneListener = new MyPhoneStateListener();
            tm.listen(PhoneListener, PhoneStateListener.LISTEN_CALL_STATE);

        } catch (Exception e) {
            Log.e(TAG, ":" + e);
        }

    }

    /**
     * カスタムリスナーの登録
     * 着信〜終了 CALL_STATE_RINGING > CALL_STATE_OFFHOOK > CALL_STATE_IDLE
     * 不在着信 CALL_STATE_RINGING > CALL_STATE_IDLE
     */
    private class MyPhoneStateListener extends PhoneStateListener {
        @SuppressWarnings("unused")
        private final String TAG = getClass().getSimpleName();
        public void onCallStateChanged(int state, String callNumber) {
            Log.d(TAG, ":" + state+"-PhoneNumber:"+callNumber);
            switch(state){
                case TelephonyManager.CALL_STATE_IDLE:      //待ち受け（終了時）
                    Toast.makeText(ctx, "CALL_STATE_IDLE", Toast.LENGTH_LONG).show();
                    break;
                case TelephonyManager.CALL_STATE_RINGING:   //着信
                    Toast.makeText(ctx, "CALL_STATE_RINGING: " + callNumber, Toast.LENGTH_LONG).show();
                    break;
                case TelephonyManager.CALL_STATE_OFFHOOK:   //通話
                    Toast.makeText(ctx, "CALL_STATE_OFFHOOK", Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }
}