package jp.co.acesystems.callreceiver;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;

public class MainActivity extends Activity{
　 TelephonyManager manager;
　 PhoneReceiver myPhoneStateListener;

　 @Override
　 public void onCreate(Bundle savedInstanceState){
　　 super.onCreate(savedInstanceState);
　　 setContentView(R.layout.activity_main);

　　 myPhoneStateListener = new PhoneReceiver(this);
　　 manager = ((TelephonyManager) getSystemService(Context,
　　　　　　　　　　　　 TELEPHONY_SERVICE));
　 }
}
