package jp.co.acesystems.callreceiver;

import android.app.Activity;
import android.widget.TextView; 
//import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;

public class MainActivity extends Activity{
    Context context;
    TelephonyManager manager;
    IncomingCall myPhoneStateListener;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        //第2引数に遷移先のActivityを指定してIntentを作成
        //Intent intent = new Intent(MainActivity.this, IncomingCall.class);
        //startActivity(intent);

        IncomingCall myPhoneStateListener = new IncomingCall();
        //manager = ((TelephonyManager) getSystemService(Context, TELEPHONY_SERVICE));
    }

    

    


}
