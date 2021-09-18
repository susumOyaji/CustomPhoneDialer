package jp.co.acesystems.callreceiver;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;

public class MainActivity extends Activity{
    Context context;
    TelephonyManager manager;
    IncomingCall myPhoneStateListener;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        myPhoneStateListener = new IncomingCall(this);
        manager = ((TelephonyManager) getSystemService(Context, TELEPHONY_SERVICE));
    }
}
