package jp.co.acesystems.callreceiver;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.telephony.PhoneStateListener;

public class MainActivity extends Activity{
    TelephonyManager manager;
    PhoneReceiver myPhoneStateListener;

    @Override
    public void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    myPhoneStateListener = new PhoneReceiver(this);
    
    //端末情報取得クラス:TelephonyManager生成
    manager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
    }


    @Override
    public void onResume(){
        super.onResume();
        manager.listen(myPhoneStateListener, PhoneStateListener.LISTEN_CALL_STATE);
    }

    @Override
    public void onPause(){
        super.onPause();
        manager.listen(myPhoneStateListener,PhoneStateListener.LISTEN_NONE);
    }


}

        /*
        //端末情報取得クラス:TelephonyManager生成
        TelephonyManager telMgr = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);

        //デヴァイスID
        String deviceid = telMgr.getDeviceId();
        //電話番号
        String phoneNumber = telMgr.getLine1Number();
        //SIM国別コード
        String simCountryIso = telMgr.getSimCountryIso();
        //SIMシリアルナンバー
        String simSerialNumber = telMgr.getSimSerialNumber();
        // 携帯端末固有ID
        String deviceId = telMgr.getDeviceId();

        //AndroiIDの取得
        String sAndroid = Settings.Secure.getString(this.getContentResolver(), Settings.System.ANDROID_ID);
        oLayout.addView(Make_TextView("Phone Number" + phoneNumber));
        oLayout.addView(Make_TextView("SIM国別コード" + simCountryIso));
        oLayout.addView(Make_TextView("SIMシリアルナンバー" + simSerialNumber));
        oLayout.addView(Make_TextView("携帯端末固有" + deviceId));
        oLayout.addView(Make_TextView("Android ID" + sAndroid));
    }
    private TextView Make_TextView(String sTitle){
        TextView oTv = new TextView(this);
        oTv.setText(sTitle);
        return oTv;
    }
}

・manifest.xml

<uses-permission android:name="android.permission.READ_PHONE_STATE"/>を追加

■実行結果




他にもたくさんの関数が用意されているので、詳しはリファレンスで！！

リファレンスはこちら
http://developer.android.com/intl/ja/reference/android/telephony/TelephonyManager.html


エミュレータだと携帯端末固有IDが0000のようになっています。
端末やSIMカードの有無によって、取得できる値が変わってくるので、注意が必要です。

また、今回はAndroidIDの取得をしていますが、AndroidIDはTelephonyManagerとは関係のない処理です。

AndroidIDとはすべてのAndroidの端末に設定されている数値で、端末を初期化すると、この値は変更されます。

端末を識別したいのか？
ユーザーを識別したいのか？

ちゃんと考えてからの実装をおすすめします
*/
